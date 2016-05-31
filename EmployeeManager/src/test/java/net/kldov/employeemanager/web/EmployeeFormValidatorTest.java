package net.kldov.employeemanager.web;

/**
 * Тест валидации при добавлении, редактировании сотрудника
 */

import static org.junit.Assert.*;

import java.sql.Date;

import net.kldov.employeemanager.domain.Division;
import net.kldov.employeemanager.domain.Employee;
import org.junit.Before;
import org.junit.Test;
import org.springframework.validation.Errors;
import org.springframework.validation.BeanPropertyBindingResult;

public class EmployeeFormValidatorTest {
	private Employee employee;
	private EmployeeFormValidator formValidator;
	
	private static String FirstName = "Иван";
	private static String LastName = "Иванов";
	private static Date Birthday = new Date(24L*60L*60L*1000);
	private static Double Salary = 1000.00;
	private static Boolean Active = true;
	private static Division division = new Division();
	
	@Before
	public void setUp() throws Exception {
		formValidator = new EmployeeFormValidator(); 
		employee = new Employee();
	}
	
	/**
	 * Проверяем корректно введенную дату
	 */
	@Test
	public void testIsValidBirthday() {
		String birhday = "1985-02-02";
		boolean ResultValid = formValidator.isValidBirthday(birhday);
		System.out.println("Validation birthday : " + birhday + " , " + ResultValid);
		assertEquals(true, ResultValid);
		
		String birhdaySecond = "1901-01-01";
		boolean validSecond = formValidator.isValidBirthday(birhdaySecond);
		System.out.println("Validation birthday : " + birhdaySecond + " , " + validSecond);
		assertEquals(true, validSecond);
	}
	
	/**
	 * Проверяем некорректно введенную дату
	 */
	@Test
	public void testIsInvalidBirthday() {
		String birhday = "1885-02-02";
		boolean ResultValid = formValidator.isValidBirthday(birhday);
		System.out.println("Validation birthday : " + birhday + " , " + ResultValid);
		assertEquals(false, ResultValid);
		
		String birhdaySecond = "2025-02-02";
		boolean validSecond = formValidator.isValidBirthday(birhdaySecond);
		System.out.println("Validation birthday : " + birhdaySecond + " , " + validSecond);
		assertEquals(false, validSecond);
	}
	
	/**
	 * Проверяем корректно введенные имя и фамилию
	 */
	@Test
	public void testIsValidString() {
		String FirstName="Вася";
		boolean actualResult=formValidator.isValidString(FirstName);
		System.out.println("Validation FirstName : " + FirstName + " , " + actualResult);
		assertEquals(true, actualResult);
		
		String LastName="Пупкин";
		boolean result=formValidator.isValidString(LastName);
		System.out.println("Validation LastName : " + LastName + " , " + result);
		assertEquals(true, result);
	}
	
	/**
	 * Проверяем некорректно введенные имя и фамилию 
	 */
	@Test
	public void testIsInvalidString() {
		String FirstName="Вася@12";
		boolean actualResult=formValidator.isValidString(FirstName);
		System.out.println("Validation FirstName : " + FirstName + " , " + actualResult);
		assertEquals(false, actualResult);
		
		String LastName="Пу пкин_1";
		boolean result=formValidator.isValidString(LastName);
		System.out.println("Validation LastName : " + LastName + " , " + result);
		assertEquals(false, result);
		
		String FirstNameWithNumber="112_12";
		boolean actualResultSecond=formValidator.isValidString(FirstNameWithNumber);
		System.out.println("Validation FirstName : " + FirstNameWithNumber + " , " + actualResultSecond);
		assertEquals(false, actualResultSecond);
	}

	/**
	 * Проверяем корректно введенный оклад
	 */
	@Test
	public void testIsValidSalary() {
		String salary = "100.00";
		boolean actualResult = formValidator.isValidSalaryString(salary);
		System.out.println("Validation Salary : " + salary + " , " + actualResult);
		assertEquals(true, actualResult);
		
		
		String salarySecond = "1250002896453.50";
		boolean actualResultSecond = formValidator.isValidSalaryString(salarySecond);
		System.out.println("Validation Salary : " + salarySecond + " , " + actualResultSecond);
		assertEquals(true, actualResultSecond);
	}
	
	/**
	 * Проверяем  некорректно введенный оклад
	 */
	@Test
	public void testIsInvalidSalary() {
		String salary = "100.45454";
		boolean actualResult=formValidator.isValidSalaryString(salary);
		System.out.println("Validation Salary : " + salary + " , " + actualResult);
		assertEquals(false, actualResult);
		
		String salaryBig = "45454545454545445100.45";
		boolean actualResultBig=formValidator.isValidSalaryString(salaryBig);
		System.out.println("Validation Salary : " + salaryBig + " , " + actualResultBig);
		assertEquals(false, actualResultBig);
	}
	
	/**
	 * Вводим отрицательную оклад 
	 */
	@Test
	public void testIsPositiveSalary() {
		Double salary=-7896.90;
		boolean actualResult=formValidator.isPositiveSalary(salary);
		assertEquals(false, actualResult);
	}
	
	
	/**
	 * Проверяет возвращает ли функция Validate данные(errors)
	 */
	@Test
	public void testValidate() {
		employee = new Employee();
		employee.setFirstname(FirstName);
		employee.setLastname(LastName);
		employee.setBirthday(Birthday);
		employee.setActive(Active);
		employee.setSalary(Salary);
		employee.setDivision(division);
		
		Errors errors = new BeanPropertyBindingResult(employee, "employee");
		
		formValidator.validate(employee, errors);
		assertFalse(errors.hasErrors());
	}
}
