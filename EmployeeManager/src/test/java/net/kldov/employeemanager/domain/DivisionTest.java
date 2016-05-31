package net.kldov.employeemanager.domain;

/**
 * Тест Employee.class
 */

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class DivisionTest {
	
	private Division division;
	private static String testDivisionname = "Сталелитейный";
	
	/**
	 * employee (New Employee() )
	 * @throws Exception
	 */
    @Before
    public void setUp() throws Exception {
        division = new Division();
    }
	
    /**
     * Testing Getter NAME
     */
	@Test
	public void testGetNAME() {
		assertNull(division.getNAME());
	}
	
	/**
	 * Testing Setter NAME
	 */
	@Test
	public void testSetNAME() {
		 division.setNAME(testDivisionname);
         assertEquals(testDivisionname, division.getNAME());
	}

}
