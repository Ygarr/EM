package net.kldov.employeemanager.web;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.Map;

import net.kldov.employeemanager.domain.Employee;
import net.kldov.employeemanager.service.EmployeeService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import javax.servlet.http.*;

@Controller
public class EmployeeFoundController {
 
	@Autowired
	private EmployeeService employeeService;
	
	
	/**
	 * Просмотр детальной информации о сотруднике 
	 * при нажатии на ссылку имени в списке
	 * 
	 * @param employeeId
	 * @param map
	 * @return "employeefound" шаблон
	 */
	@RequestMapping("/detail/{employeeId}")
	public String showDetail(@PathVariable("employeeId") Integer employeeId,Map<String, Object> map)
	{
		Object employee = employeeService.GetEmployeeById(employeeId);
		map.put("employeefound", employee);
		 return "employeefound";
	}
	
	
	
	
	/**
	 * Поиск на заглавной странице по имени или фамилии
	 * @param req
	 * @param map
	 * @return "employee"
	 */
	@RequestMapping("/find")
	public String find(HttpServletRequest httpRequest, Map<String, Object> map) {
        /**
		 * Получаем строку запроса из формы поиска
		 *
		 * @param FirtsName 
		 * @return employee
		 */
		String FirstName = httpRequest.getParameter("firstname");
		
		   map.put("employee",  new Employee());
		   map.put("employeeList", employeeService.GetEmployeeByParam(FirstName));
		   
		   return "employee";
		}
		
		/**
		 * Сброс результатов поиска
		 * @return "redirect:/index"
		 */
		@RequestMapping("/reset")
		public String Reset() {
		return "redirect:/index";
		}
	
}