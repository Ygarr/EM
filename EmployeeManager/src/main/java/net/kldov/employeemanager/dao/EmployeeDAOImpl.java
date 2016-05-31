package net.kldov.employeemanager.dao;

/**
 * Слой доступа к данным 
 */


import java.util.List;

import net.kldov.employeemanager.domain.Division;
import net.kldov.employeemanager.domain.Employee;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class EmployeeDAOImpl implements EmployeeDAO {

	@Autowired
	private SessionFactory sessionFactory;
	

	/**
	 * @see net.kldov.employeemanager.dao.EmployeeDAO#addEmployee(Employee)
	 */
	public void addEmployee(Employee employee) {
		sessionFactory.getCurrentSession().save(employee);
	}
	
	/**
	 * @see net.kldov.employeemanager.dao.EmployeeDAO#listEmployee()
	 */
	@SuppressWarnings("unchecked")
	public List<Employee> listEmployee() {
	return  sessionFactory.getCurrentSession().createQuery("from Employee").setMaxResults(600).list();
	}

	/**
	 * @see net.kldov.employeemanager.dao.EmployeeDAO#listDivision()
	 */
	@SuppressWarnings("unchecked")
	public List<Division> listDivision() {
		return sessionFactory.getCurrentSession().createQuery("from Division ").list();
	}
	
	/**
	 * @see net.kldov.employeemanager.dao.EmployeeDAO#GetEmployeeByParam(String)
	 */
	@SuppressWarnings("unchecked")
	public List<Employee> GetEmployeeByParam(String Parameter) {
    			
		 String param1 = Parameter.replace("?", "_");//заменяем символ ? на понятный базе данных
		 String param2 = param1.replace("*", "%");//заменяем символ * на понятный базе данных
		 if (param2.contains("%") || param2.contains("_")){ 
		 return sessionFactory.getCurrentSession().createQuery("from Employee where concat(firstname,lastname) like  :parameter OR  concat(lastname,firstname) like  :parameter")
			.setParameter("parameter",param2)
		    .list();
		 }
		 else {
		
		 return sessionFactory.getCurrentSession().createQuery("from Employee where concat(firstname,lastname) like  '%' || :parameter OR concat(firstname,lastname) like :parameter || '%' OR concat(firstname,lastname) like '%'|| :parameter || '%'")
		 .setParameter("parameter",Parameter.replace(" ", ""))//Убираем пробелы внутри строки параметра
	     .list();
		 }
	}
	
	/**
	 * @see net.kldov.employeemanager.dao.EmployeeDAO#GetEmployeeById(Integer)
	 */
	public Employee GetEmployeeById(Integer id)	{
		
		return  (Employee) sessionFactory.getCurrentSession().get("net.kldov.employeemanager.domain.Employee", id);	
		
	}
	
	/**
	 * @see net.kldov.employeemanager.dao.EmployeeDAO#GetDivisionById(Integer)
	 */
	public Division GetDivisionById(Integer id)	{
	
		return  (Division) sessionFactory.getCurrentSession().get("net.kldov.employeemanager.domain.Division", id);	
		
	}
	
		
	/**
	 * @see net.kldov.employeemanager.dao.EmployeeDAO#removeEmployee(Integer)
	 */
	public void removeEmployee(Integer id) {
		Employee employee = (Employee) sessionFactory.getCurrentSession().load(
				Employee.class, id);
		if (null != employee) {
			sessionFactory.getCurrentSession().delete(employee);
		}
	}
	
	
	/**
	 * @see net.kldov.employeemanager.dao.EmployeeDAO#updateEmployee(Object)
	 */
	public void updateEmployee(Object employee) {
			
			sessionFactory.getCurrentSession().merge(employee);
	}
	
	/**
	 * @see net.kldov.employeemanager.dao.EmployeeDAO#updateDivision(Object)
	 */
	public void updateDivision(Object division) {

			sessionFactory.getCurrentSession().merge(division);
	}
	
	/**
	 * @see net.kldov.employeemanager.dao.EmployeeDAO#addDivision(Division)
	 */
	public void addDivision(Division division) {
				
			sessionFactory.getCurrentSession().save(division);
	}
	
	
	/**
	 * @see net.kldov.employeemanager.dao.EmployeeDAO#GetDoubleDivisionName(String)
	 */
	@SuppressWarnings("unchecked")	
	public List <Division> GetDoubleDivisionName(String name){
		
			return (List<Division>) sessionFactory.getCurrentSession().createQuery("from Division where name = :name ").setParameter("name", name).list();
	}
	

}
