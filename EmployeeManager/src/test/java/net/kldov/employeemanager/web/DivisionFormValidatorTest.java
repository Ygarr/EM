package net.kldov.employeemanager.web;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.springframework.validation.BeanPropertyBindingResult;
import org.springframework.validation.Errors;

import net.kldov.employeemanager.domain.Division;




public class DivisionFormValidatorTest {
	private Division division;
	private DivisionFormValidator formValidator;
	
	/**
	 * Первоначальная инициализация для последующих тестов
	 * @throws Exception
	 */
	@Before
	public void setUp() throws Exception {
		formValidator = new DivisionFormValidator(); 
		division = new Division();
	}

	/**
	 * Тест валидации названия отдела
	 */
	@Test
	public void testIsValidString() {
		String divisionname = "Бухгалтерия";
		boolean actualResult=formValidator.isValidString(divisionname);
		System.out.println("Validation  Name Of Division : " + divisionname + " , " + actualResult);
		assertEquals(true, actualResult);
		
		String divisionname2="IT-Отдел";
		boolean result=formValidator.isValidString(divisionname2);
		System.out.println("Validation Name Of second Division : " + divisionname2 + " , " + result);
		assertEquals(true, result);	
	}
	
	
	
	
	/**
	 * Тест валидации названия отдела с некорректными данными
	 */
	@Test
	public void testIsInvalidString() {
		String divisionname3 = "Отдел_снабжения";
		boolean actualResult=formValidator.isValidString(divisionname3);
		System.out.println("Validation  Name Of third Division : " + divisionname3 + " , " + actualResult);
		assertEquals(false, actualResult);
		
		String divisionname4="АСУ-3";
		boolean result=formValidator.isValidString(divisionname4);
		System.out.println("Validation Name Of fourth Division : " + divisionname4 + " , " + result);
		assertEquals(false, result);	
	}

	/**
	 * Проверяет возвращает ли функция Validate данные(errors)
	 */
	@Test
	public void testValidate() {
		String divisionsetname = "Assurance";
		division = new Division();
		division.setNAME(divisionsetname);
		
		Errors errors = new BeanPropertyBindingResult(division, "division");
		formValidator.validate(division, errors);
		assertFalse(errors.hasErrors());
	}
	
}
