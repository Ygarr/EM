package net.kldov.employeemanager.service;
 
/**
 * Сервис-слой
 */

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
 
import net.kldov.employeemanager.dao.EmployeeDAO;
import net.kldov.employeemanager.domain.Division;
import net.kldov.employeemanager.domain.Employee;
 
@Service
public class EmployeeServiceImpl implements EmployeeService {
 
	 @Autowired
     private EmployeeDAO employeeDAO;
 
     /**
      * @see net.kldov.employeemanager.service.EmployeeService#addEmployee(Employee)
      */
    @Transactional
    public void addEmployee(Employee employee) {
        employeeDAO.addEmployee(employee);
    }
    
    /**
     * @see net.kldov.employeemanager.service.EmployeeService#updateEmployee(Object)
     */
   @Transactional
   public void updateEmployee(Object employee) {
       employeeDAO.updateEmployee(employee);
   }
 
    /**
     * @see net.kldov.employeemanager.service.EmployeeService#listEmployee()
     */
    @Transactional
    public List<Employee> listEmployee() {
         return employeeDAO.listEmployee();
    }
 
    /**
     * @see net.kldov.employeemanager.service.EmployeeService#removeEmployee(Integer)
     */
    @Transactional
    public void removeEmployee(Integer id) {
        employeeDAO.removeEmployee(id);
    }
    
    /**
     * @see net.kldov.employeemanager.service.EmployeeService#GetEmployeeByParam(String)
     */
    @Transactional
    public List<Employee> GetEmployeeByParam(String Parameter){
    	return employeeDAO.GetEmployeeByParam(Parameter);
    }
    
    /**
     * @see net.kldov.employeemanager.service.EmployeeService#GetEmployeeById(Integer)
     */
    @Transactional
    public Employee GetEmployeeById(Integer id){
    	return employeeDAO.GetEmployeeById(id);
    }

    /**
     * @see net.kldov.employeemanager.service.EmployeeService#listDivision()
     */
    @Transactional
    public List<Division> listDivision() {
         return employeeDAO.listDivision();
    }
 
    /**
     * @see net.kldov.employeemanager.service.EmployeeService#GetDivisionById(Integer)
     */
    @Transactional
    public Division GetDivisionById(Integer id){
    	return employeeDAO.GetDivisionById(id);
    }
    
    /**
     * @see net.kldov.employeemanager.service.EmployeeService#GetDoubleDivisionName(String)
     */
    @Transactional
    public List <Division> GetDoubleDivisionName(String name){
    	return employeeDAO.GetDoubleDivisionName(name);
    }
    
    
    /**
     * @see net.kldov.employeemanager.service.EmployeeService#updateDivision(Object)
     */
   @Transactional
   public void updateDivision(Object division) {
       employeeDAO.updateEmployee(division);
   }
   
   /**
    *@see net.kldov.employeemanager.service.EmployeeService#addDivision(Division)
    */
  @Transactional
  public void addDivision(Division division) {
      employeeDAO.addDivision(division);
  }

}
