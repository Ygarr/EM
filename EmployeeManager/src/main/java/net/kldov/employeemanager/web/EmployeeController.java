package net.kldov.employeemanager.web;

/**
 * Класс-контроллер. Взаимодействие 
 * пользователя с системой через Веб
 * @author kldov
 */

import java.util.List;
import java.util.Map;

import net.kldov.employeemanager.domain.Division;
import net.kldov.employeemanager.domain.Employee;
import net.kldov.employeemanager.service.EmployeeService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
public class EmployeeController {
	
	@Autowired
	private EmployeeService employeeService;
	@Autowired
	private EmployeeFormValidator employeeFormValidator;
	@Autowired
	private DivisionFormValidator divisionFormValidator;
	
	
	/**
	 * К пути /index привязывается employee.ftl.
	 * А также функция построения списка сотрудников listEmployee()
	 * 
	 * @param map
	 * @return "employee"
	 */
	@RequestMapping("/index")
	public String listEmployees(Map<String, Object> map) {

		map.put("employee", new Employee());
		map.put("employeeList", employeeService.listEmployee());

		return "employee";
	}
	
	/**
	 * Корневой каталог делаем index-ом/перенаправляем на индекс
	 * 
	 * @return "redirect:/index"
	 */
	@RequestMapping("/")
	public String home() {
		return "redirect:/index";
	}
	
	/**
	 * Форма добавления нового сотрудника
	 * 
	 * @param employee
	 * @param result
	 * @param map
	 * @return "addnewemployee"
	 */
	@RequestMapping(value = "/addnewemployee")
	public String addnewEmployee(@ModelAttribute("employee") Employee employee,BindingResult result,Map<String, Object> map) {
		map.put("employee", employee);
		return "addnewemployee";
	}
	
	
	
	/**
	 * Добавление нового сотрудника после валидации. Перенаправление на индекс.
	 * 
	 * @param employee
	 * @param result
	 * @return /index
	 */
	@RequestMapping(value = "/addnewemployee/add", method = RequestMethod.POST)
	public String addEmployee(@ModelAttribute("employee") Employee employee,
			BindingResult result,Map<String, Object> map) {
		
		employeeFormValidator.validate(employee, result);//Валидация
		 if (result.hasErrors()) {
			 map.put("employee", employee);
	         return "addnewemployee";
	        }
		
		employeeService.addEmployee(employee);
		 return "redirect:/index";
	}

	
	/**
	 * Контроллер удаления сотрудника по его идентификатору 
	 * 
	 * @param employeeId
	 * @return /index
	 */
	@RequestMapping("/delete/{employeeId}")
	public String deleteEmployee(@PathVariable("employeeId") Integer employeeId) {

		employeeService.removeEmployee(employeeId);

		return "redirect:/index";
	}

	
	/**
	 * Форма со списком Отделов
	 * 
	 * @param map
	 * @return "division"
	 */
	@RequestMapping("/division")
	public String list(Map<String, Object> map) {
		 map.put("division", new Division());
		 map.put("divisionList", employeeService.listDivision());
		return "division";
	}

	
	/**
	 * Форма добавления нового отдела
	 * 
	 * @param division
	 * @param result
	 * @param map
	 * @return "addnewdivision"
	 */
	@RequestMapping(value = "/division/addnewdivision",method = RequestMethod.POST)
	public String addnewDivision(@ModelAttribute("division") Division division,BindingResult result,Map<String, Object> map) {
		map.put("division", division);
		return "addnewdivision";//
	}

	
	/**
	 *Добавление Отдела после проверки на повтор имени и валидации. При успешном завершении перенаправление к списку отделов. 
	 * 
	 * 
	 * @param division
	 * @param result
	 * @param map
	 * @return "division"
	 */
	@RequestMapping(value = "/division/addnewdivision/add")
	public String addDivision(@ModelAttribute("division") Division division,BindingResult result,Map<String, Object> map) {
		
	
	  List<Division> ssname=employeeService.GetDoubleDivisionName(division.getNAME());//Проверка повторяющегося названия
	        	        System.out.println(ssname);
	        	        	        	        
	  if ( !ssname.isEmpty() ) result.rejectValue("NAME", "NAME", "Отдел с таким именем уже есть");
	
		divisionFormValidator.validate(division, result);//Валидирование
		 if (result.hasErrors()) {
			 map.put("division", division);
	         return "addnewdivision";
	        }
				 
   		employeeService.addDivision(division);
		return "redirect:/division/";
	}
}
