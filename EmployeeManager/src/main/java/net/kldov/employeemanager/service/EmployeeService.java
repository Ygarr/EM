package net.kldov.employeemanager.service;


/**
 * Сервис-слой
 */
import java.util.List;

import net.kldov.employeemanager.domain.Division;
import net.kldov.employeemanager.domain.Employee;

public interface EmployeeService {
	
	/**
	 * Добавление cотрудника
	 * @param employee
	 */
	public void addEmployee(Employee employee);
	
	/**
	 * Редактирование cотрудника
	 * @param employee
	 */
	public void updateEmployee(Object employee);
	
	/**
	 * Добавление отдела
	 * @param Division
	 */
	public void addDivision(Division Division);
	
	/**
	 * Редактирование отдела
	 * @param division
	 */
	public void updateDivision(Object division);
	
	/**
	 * Получение списка сотрудников
	 * @return listEmployee()
	 */
	public List<Employee> listEmployee();
	
	/**
	 * Получение списка отделов
	 * @return listDivision()
	 */
	public List<Division> listDivision();
	
	/**
	 * Удаление cотрудника
	 * @param id
	 */
	public void removeEmployee(Integer id);
	
	/**
	 * Поиск сотрудника по заданному критерию с использованием метасимволов
	 */
	public List<Employee> GetEmployeeByParam(String Parameter);
	
	/**
	 * Получение деталей данных сотрудника по его идентификатору
	 * @param id
	 * @return Employee
	 */
	public Employee GetEmployeeById(Integer id);
	
	/**
	 * Получение отдела по его идентификатору
	 * @param id
	 * @return Division
	 */
	public Division GetDivisionById(Integer id);
	
	/**
	 * Проверка существования вводимого отдела в базе данных.
	 * Проверка на дублирование перед добавлением.
	 * @param name
	 * @return List<Division>
	 */
	public List<Division> GetDoubleDivisionName(String name);
	
	
}
