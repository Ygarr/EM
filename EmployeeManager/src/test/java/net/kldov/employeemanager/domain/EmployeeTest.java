package net.kldov.employeemanager.domain;

/**
 * Тест Employee.class
 */

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import java.sql.Date;
import org.junit.Before;
import org.junit.Test;

public class EmployeeTest {
    
    private Employee employee;
    private static String testFirstname = "Виктор";
    private static String testLastname = "Кузнецов";
    private static Double  testSalary = 100.00;
    private static Date birthday = new Date(24L*60L*60L*1000L);
    private static Boolean activeTrue = true;
    private static Division  testDivision = new Division();
    	
    	/**
    	 * employee (New Employee() )
    	 * @throws Exception
    	 */
        @Before
        public void setUp() throws Exception {
            employee = new Employee();
        }
        
        /**
         * Testing Getter firstname
         */
        @Test
        public void testGetFirstname() {
          assertNull(employee.getFirstname());
        }
        
        /**
         * Testing Setter firstname
         */
        @Test
        public void testSetFirstname() {
            employee.setFirstname(testFirstname);
            assertEquals(testFirstname, employee.getFirstname()); 
        }
        
        /**
         * Testing Getter lastname
         */
        @Test
        public void testGetLastname() {
            assertNull(employee.getLastname());
        }
        
        /**
         * Testing Setter lastname
         */
        @Test
        public void testSetLastname() {
            employee.setLastname(testLastname);
            assertEquals(testLastname, employee.getLastname());
        }
        
        /**
         * Testing Getter salary
         */
        @Test
        public void testGetSalary() {
            assertNull(employee.getSalary());
        }
        
        /**
         * Testing Setter salary
         */
        @Test
        public void testSetSalary() {
            employee.setSalary(testSalary);
            assertEquals(testSalary, employee.getSalary());
        }
        
        /**
         * Testing Getter birthday
         */
        @Test
        public void testGetBirthday() {
            assertNull(employee.getBirthday());
        }
        
        /**
         * Testing Setter birthday
         */
        @Test
        public void testSetBirthday() {
            employee.setBirthday(birthday);
        }
        
        /**
         * Testing Getter active
         */
        @Test
        public void testGetActive() {
            assertTrue(employee.getActive());
        }
        
        /**
         * Testing Setter active
         */
        @Test
        public void testSetActive() {
            employee.setActive(activeTrue);
            assertEquals(activeTrue, employee.getActive());
        }
        
        /**
         * Testing Getter Division
         */
        @Test
        public void testGetDivision() {
              assertNull(employee.getDivision());
        }
        
        /**
         * Testing Setter division
         */
        @Test
        public void testSetDivision() {
            
                employee.setDivision(testDivision);
                assertEquals(testDivision, employee.getDivision());
        }

}