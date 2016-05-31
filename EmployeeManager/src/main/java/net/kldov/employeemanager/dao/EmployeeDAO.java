package net.kldov.employeemanager.dao;

/**
 * Слой доступа к данным.
 * В нём будем размещать Data Access Objects – объекты доступа к данным.
 */

import java.util.List;

import net.kldov.employeemanager.domain.Division;
import net.kldov.employeemanager.domain.Employee;

public interface EmployeeDAO {
	
	/**
	 * Добавление нового сотрудника
	 * @param employee
	 */
	public void addEmployee(Employee employee);
	
	/**
	 * Редактирование данных сотрудника 
	 * 
	 * @param employee
	 */
	public void updateEmployee(Object employee);
	
	/**
	 * Построение списка сотрудников
	 * 
	 * @return List Employee 
	 */
	public List<Employee> listEmployee();
	
	/**
	 * Построение списка отделов
	 * 
	 * @return List Division
	 */
	public List<Division> listDivision();
	
	/**
	 * Поиск с использованием метасимволов по имени, 
	 * фамилии и вывод сотрудников списком 
	 *  
	 * @param Parameter
	 * @return List
	 */
	public List<Employee> GetEmployeeByParam(String FirstName);
	
	/**
	 * Просмотр детальной информации о сотруднике,
	 * получаемой по идентификатору сотрудника
	 * 
	 * @param id
	 * @return Employee
	 */
	public Employee GetEmployeeById(Integer id);
	
	/**
	 * Получение отдела по его идентификатору
	 * 
	 * @param id
	 * @return Division
	 */
	public Division GetDivisionById(Integer id);
	
	/**
	 * Получение списка отделов с одинаковыми названиями
	 * 
	 * @param name
	 * @return List<Division>
	 */
	public List<Division> GetDoubleDivisionName(String name);
	
	/**
	 * Добавление отдела 
	 * 
	 * @param division
	 */
	public void addDivision(Division division);
	
	/**
	 * Редактирование отдела
	 * 
	 * @param division
	 */
	public void updateDivision(Object division);

	
	/**
	 * Удаление сотрудника по его идентификатору		 
	 *  
	 * @param id
	 */
	public void removeEmployee(Integer id);
	
	
	
	
}