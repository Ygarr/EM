package net.kldov.employeemanager.web;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.kldov.employeemanager.domain.Employee;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;
 
/**
 * Класс валидации данных формы сотрудник
 * @author kldov
 */
public class EmployeeFormValidator implements Validator {

    public boolean supports(Class<?> aClass) {
        return aClass.equals(Employee.class);
    }

    /**
     * Поле Имя firstname — Не может быть пустым, состоять из пробелов
     * Поле Фамилия lastname— Не может быть пустым, состоять из пробелов
     * Поле зарплата — Оклад сотрудника должен быть положительным вещественным 
     * 		числом не равным‭ ‬0.‭ ‬Это число должно удовлетворять формату‭ ‬%15.2f‭ 
     * Поле Дата Рождения Birthdate ‬не может быть меньше‭ 
     * ‬		1900‭ ‬и больше текущего календарного года(2011)
     * 
     * @param Employee
     * 
     */
     public void validate(Object object, Errors errors) {
        Employee employeeObject = (Employee) object;
        
         ValidationUtils.rejectIfEmpty(errors, "firstname", "firstname" , "Имя сотрудника должно быть задано");
         ValidationUtils.rejectIfEmpty(errors, "lastname", "lastname" , "Фамилия сотрудника должна быть задана");
         if (!isValidString(employeeObject.getFirstname().trim())) errors.rejectValue("firstname", "firstname", "Имя должно состоять только из букв и не содержать пробелы");
         if (!isValidString(employeeObject.getLastname().trim())) errors.rejectValue("lastname", "lastname", "Фамилия должна состоять только из букв и не содержать пробелы");
              
         if (!isValidBirthday(employeeObject.getBirthday().toString())) errors.rejectValue("birthday", "birthday", "Значение года рождения  не может быть меньше 1900 или больше текущего года");    
        
         if  (!isPositiveSalary(employeeObject.getSalary())) errors.rejectValue("salary", "salary", "Оклад сотрудника должен быть положительным числом не равным 0 формата %15.2f ");
         if (!isValidSalaryString(employeeObject.getSalary().toString())) errors.rejectValue("salary", "salary", "Оклад должен содержать всего 15 знаков, 2 десятичных знака после запятой");
     }
         

    	/**
    	 * Функция isValidBirthday
    	 * Только удовлетворяющие шаблону даты будут возвращать TRUE.
    	 * Шаблон: 1900 — 2011
     	 * @param birhday
    	 * @return boolean
    	 */
     public boolean isValidBirthday(String birthday){ 
     		 String DATE_PATTERN = "((19[0-9][0-9]| 200[0-9] | 201[0-1]))-(0?[1-9]|1[012])-(0?[1-9]|[12][0-9]|3[01])";
     		    /**
     		     * ((19[0-9][0-9]| 200[0-9] | 201[01])) — Первая группа. Год начинается с 19--, 200-, 201-
     		     * 19[0-9][0-9] — 1900-1999 
     		     * 200[0-9] — 2000-2009
     		     * 201[01] — 2010 либо 2011
     		     * 
     		     * (0?[1-9]|1[012]) — Вторая группа. Шаблон месяца.
     		     * 0?[1-9] — 01-09 либо 1-9
     		     * 1[012] — 10,11 либо 12
     		     * 
     		     * (0?[1-9]|[12][0-9]|3[01]) — Третья группа. Шаблон дня.
     		     * День может быть лишь между 
     		     * 0?[1-9] — 01-09
     		     *  или 
     		     * [12][0-9] — 10-29 
     		     * 	или 
     		     * 3[01] — 30-31. 
       		     */
     		 
     		 	Pattern pattern = Pattern.compile(DATE_PATTERN);
     		    Matcher matcher = pattern.matcher(birthday); 
     		  return matcher.matches();
     	  }
     	  
     	  /**
     	   * Функция isValidString
     	   * Проверяем строку. Должны быть только буквы алфавита
     	   * 
     	   * @param str
     	   * @return matches() boolean
     	   */
      public boolean isValidString(String str){
     		String STR_PATTERN = "^[a-zA-Zа-яА-Я]+$";
	     		
     		Pattern pattern = Pattern.compile(STR_PATTERN);
 		    Matcher matcher = pattern.matcher(str); 
 		  return matcher.matches();
     	 }
     	 
     	  /**
     	   * Проверка корректности введенной зарплаты
     	   * @param salary
     	   * @return matches() boolean
     	   */
      public boolean isValidSalaryString(String salary){
     		 
      		String STR_PATTERN = "^([0-9]{1,15}).([0-9]?[0-9]?)";
     		 	     		
      		Pattern pattern = Pattern.compile(STR_PATTERN);
  		    Matcher matcher = pattern.matcher(salary); 
  		  return matcher.matches();
      	 }
     	 
     	 /**
     	  * Зарплата должна быть больше нуля
     	  * @param salary
     	  * @return matches() true or false
     	  */
      public boolean isPositiveSalary(Double salary){
     		if (salary<=0)
     		{return false;}
     		else 
     		{return true;}
     	 } 
 } 