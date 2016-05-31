package net.kldov.employeemanager.web;

/**
 * Класс-контроллер. 
 * Взаимодействие системы через 
 * Веб с пользователем
 */

import java.util.Map;

import javax.validation.Valid;

import net.kldov.employeemanager.domain.Division;
import net.kldov.employeemanager.domain.Employee;
import net.kldov.employeemanager.service.EmployeeService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
public class EmployeeEditController {
	 
	@Autowired
	private EmployeeService employeeService;
	@Autowired
	private EmployeeFormValidator employeeFormValidator;
	
	
	/**
	 *  Просмотр деталей Сотрудника с целью редактирования (показ c полями для редактирования)
	 *
	 * @param employeeId
	 * @param map
	 * @return "employeeedit"
	 */
	@RequestMapping("/edit/{employeeId}")
	public String showDetail(@PathVariable("employeeId") Integer employeeId,Map<String, Object> map)
	{
			Employee employee = employeeService.GetEmployeeById(employeeId);
			map.put("employee", employee);
		return "employeeedit";
	}
	
	
	/**
	 *Редактирование Сотрудника с валидацией
	 * 
	 * @param employee
	 * @param result
	 * @param map
	 * @return "redirect:/index" 		with validation error notification
	 */
	@RequestMapping(value = "/updated",method = RequestMethod.POST)
	public String updatingEmployee(@Valid Employee employee,final BindingResult result,Map<String, Object> map) {
		
		employeeFormValidator.validate(employee, result);
		if (result.hasErrors()) {
			map.put("employee",	employee);
			return "employeeedit";
		}
		employeeService.updateEmployee(employee);
		return "redirect:/index";
	}
	
	/**
	 * Просмотр деталей Отделов с целью редактирования (показ c полями для редактирования)
	 *
	 * @param divisionId
	 * @param map
	 * @return "divisionedit"
	 */
	@RequestMapping("division/dedit/{divisionId}")
	public String showDetail1(@PathVariable("divisionId") Integer divisionId,Map<String, Object> map){
			Division division = employeeService.GetDivisionById(divisionId);//Object
			map.put("division", division);
		return "divisionedit";
	}
	
	/**
	 * Редактирование Отдела с валидацией
	 * 
	 * @param division
	 * @param result
	 * @param map
	 * @return form 	(with validation error notification)
	 */
	@RequestMapping(value = "/divisionupdated",method = RequestMethod.POST)
	public String updatingDivision(@Valid Division division, final BindingResult result,Map<String, Object> map) {
		
		if (result.hasErrors()) {
			map.put("divison",	division);
			return "divisionedit";
		}
		employeeService.updateDivision(division);
		return "redirect:/division/";
	}
	
	
}
	
	


