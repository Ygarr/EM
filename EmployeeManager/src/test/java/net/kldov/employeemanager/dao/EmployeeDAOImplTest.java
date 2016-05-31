package net.kldov.employeemanager.dao;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.sql.Date;
import java.util.List;

import net.kldov.employeemanager.domain.Division;
import net.kldov.employeemanager.domain.Employee;

import org.hibernate.SessionFactory;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations ={"classpath:data.xml"}) 
@Transactional
public class EmployeeDAOImplTest {
			
	@Autowired
    @Qualifier("sessionFactory")
    private SessionFactory sessionFactory;
	
	@Autowired
	private EmployeeDAO employeeDAO; 
	
	private Employee employee;
	private Division division;
	


	/**
	 * Имя Отдела для теста
	 */
	private static String DivisionName = "Testdivision";
	private static String ChangedDivisionName = "Changedtestdivision";
	private static String SameDivisionName = "tEstDIVIsioN";
	
	/**
	 * Имя cотрудника для теста
	 */
	private static String FirstName = "John";
	private static String LastName = "Walker";
	private static Date Birthday = new Date(24L*60L*60L*1000);
	private static Double Salary = 1000.00;
	private static Boolean Active = true;
	private static String ChangedFirstName = "Joseph";
	
	@Before
	public void onSetUp(){
		division = new Division();
		division.setNAME(DivisionName);
		
		employee= new Employee();
		employee.setFirstname(FirstName);
	    employee.setLastname(LastName);
	    employee.setBirthday(Birthday);
	    employee.setSalary(Salary);
	    employee.setActive(Active);
	    employee.setDivision(division);
	}
	
	
	/**
	 * Тест добавление Отдела
	 */
	@Test
	public void testAddDivision() {
		
		sessionFactory.getCurrentSession().save(division);
		assertEquals("Testdivision",division.getNAME()); 
	}
	
	/**
	 * Тест добавления сотрудника
	 */
	@Test
	public void testAddEmployee() {

		sessionFactory.getCurrentSession().save(division);


	sessionFactory.getCurrentSession().save(employee);
	    assertEquals("John",employee.getFirstname()); 
		assertEquals("Walker",employee.getLastname()); 
	sessionFactory.getCurrentSession().flush();
	}

	/**
	 * Тест построения списка сотрудников
	 */
	@Test
	public void testListEmployee() {
	 @SuppressWarnings("unchecked")
	 List<Employee> employees = sessionFactory.getCurrentSession().createQuery("from Employee").setMaxResults(600).list();
	
	 List<Employee> employeestest =  employeeDAO.listEmployee();
	 assertNotNull(employees.size());
	 assertEquals(employees,employeestest);
		  sessionFactory.getCurrentSession().flush();
		 
	}
	
	/**
	 * Тест построения списка отделов
	 */
	@Test
	public void testListDivision() {
		 @SuppressWarnings("unchecked")
		 List<Division> division = sessionFactory.getCurrentSession().createQuery("from Division").list();
		 
		 List<Division> divisiontest =  employeeDAO.listDivision();
			  assertNotNull(division.size());
			  assertEquals(division,divisiontest);
			  sessionFactory.getCurrentSession().flush();
	}

	
	
	
	/**
	 * Тест поиска по сотрудникам с использованием метасимволов 
	 */
	@Test
	@Transactional
	public void testGetEmployeeByParam() {
		String Parameter0 ="John Walker";
		String Parameter1 ="wa*";
		String Parameter2 ="??lker*";
		String Parameter3 ="*ohn";
			
	    employeeDAO.addDivision(division);
		employeeDAO.addEmployee(employee);
	List<Employee> employee0 =	employeeDAO.GetEmployeeByParam(Parameter0);
	assertTrue(employee0.contains(employee)); 
	List<Employee> employee1 =	employeeDAO.GetEmployeeByParam(Parameter1);
	assertTrue(employee1.contains(employee)); 
	List<Employee> employee2 =	employeeDAO.GetEmployeeByParam(Parameter2);
	assertTrue(employee2.contains(employee)); 
	List<Employee> employee3 =	employeeDAO.GetEmployeeByParam(Parameter3);
	assertTrue(employee3.contains(employee)); 
	}

	/**
	 * Тест получение сотрудника по его идентификатору
 	 */
	@Test
	public void testGetEmployeeById() {
		employeeDAO.addDivision(division);
		employeeDAO.addEmployee(employee);
		
		String lastname = employee.getLastname();
		Integer employeeid = employee.getId();
		
		Employee employeeTest = employeeDAO.GetEmployeeById(employeeid);
		assertEquals(lastname,employeeTest.getLastname());
		
	}
	/**
	 * Тест получения отдела по его идентификатору
	 */
	@Test
	public void testGetDivisionById() {
		employeeDAO.addDivision(division);
		
		String divisionname = division.getNAME();
		Integer divisionid = division.getId();
		
		Division divisionTest = employeeDAO.GetDivisionById(divisionid);
		assertEquals(divisionname,divisionTest.getNAME());
	}
	
	/**
	 * Тест удаления сотрудника
	 */
	@Test
	public void testRemoveEmployee() {
		employeeDAO.addDivision(division);
		employeeDAO.addEmployee(employee);
		Integer preCountEmployee = sessionFactory.getCurrentSession().createQuery("from Employee").list().size();
	
		Integer employeeid = employee.getId();
		employeeDAO.removeEmployee(employeeid);
		
		Integer postCountEmployee = sessionFactory.getCurrentSession().createQuery("from Employee").list().size();
		Integer expectedCountEmployee =preCountEmployee-1;
		assertNotNull(employeeid-employee.getId());
		assertEquals(expectedCountEmployee,postCountEmployee);
		 
		sessionFactory.getCurrentSession().flush();
	}
	
	/**
	 * Тест редактирования сотрудника
	 */
	@Test
	public void testUpdateEmployee() {
		employeeDAO.addDivision(division);
		employeeDAO.addEmployee(employee);
		
		employee.setFirstname(ChangedFirstName);
		employeeDAO.updateEmployee(employee);
		assertEquals(ChangedFirstName,employee.getFirstname());
	}

	@Test
	public void testUpdateDivision() {
		employeeDAO.addDivision(division);
		division.setNAME(ChangedDivisionName);
		employeeDAO.updateDivision(division);
		assertEquals(ChangedDivisionName,division.getNAME());
	}
	
	@Test
	public void testGetDoubleDivisionName() {
		employeeDAO.addDivision(division);
		String divisionName = division.getNAME();
		Division doubledDivision = employeeDAO.GetDoubleDivisionName(SameDivisionName).get(0);
		assertEquals(divisionName,doubledDivision.getNAME());
		assertTrue(employeeDAO.GetDoubleDivisionName("notSameDivisionName").isEmpty());
	}

}
