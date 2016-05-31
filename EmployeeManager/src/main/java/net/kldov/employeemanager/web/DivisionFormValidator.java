package net.kldov.employeemanager.web;

/**
 * Класс валидации данных формы Отдела
 * @author kldov
 */

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.kldov.employeemanager.domain.Division;
import net.kldov.employeemanager.domain.Employee;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
 
public class DivisionFormValidator implements Validator {
	
	public boolean supports(Class<?> aClass) {
        return aClass.equals(Employee.class);
    }

    /**
     * Функция валидирования
     * @param object
     * @param errors
     */
    public void validate(Object object, Errors errors) {
    	Division divisionObject = (Division) object;
    	
    	/**
    	 * Проверка корректности введенных данных
    	 */
        if (!isValidString(divisionObject.getNAME().trim())) 
        				errors.rejectValue("NAME", "NAME", "Отдел введен не корректно");
       }
         /**
          * Функция: соотвествует ли параметр типа "строка" шаблону
          * Строка должна содержать только 
          * буквы латинского, русского алфавита и тире
          * 	  
          * @param str
          * @return true or false
          */
     	 public boolean isValidString(String str){
     		String STR_PATTERN = "^[a-zA-Zа-яА-Я-]+$";
	     	
     		Pattern pattern = Pattern.compile(STR_PATTERN);
 		    Matcher matcher = pattern.matcher(str.toUpperCase()); 
 		  return matcher.matches();
     	}
       	  
 } 