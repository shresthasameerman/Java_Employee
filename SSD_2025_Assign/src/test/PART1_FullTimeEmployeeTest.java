package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import staff_members.FullTimeEmployee;

/**
 * Tests the {@link FullTimeEmployee} class.
 * 
 * 
 * NOTE: DO NOT CHANGE THE CONTENTS OF THIS FILE.
 * 
 * @author mdixon
 */
class PART1_FullTimeEmployeeTest {

	@Test
	void testFTEmpSalary() {

		FullTimeEmployee e1 = new FullTimeEmployee("", "", 0);
		assertEquals(14000, e1.getSalary(), "FullTimeEmployee salary should be set to 14000");
	}

	@Test
	void testFTEmpName() {

		FullTimeEmployee e1 = new FullTimeEmployee("Pete Johnson", "", 0);
		assertTrue("Pete Johnson".equals(e1.getName()), "The name of employee e1 should be \"Pete Johnson\"");
		
		FullTimeEmployee e2 = new FullTimeEmployee("Jo Smith", "", 0);
		assertTrue("Jo Smith".equals(e2.getName()), "The name of employee e2 should be \"Jo Smith\"");
	}

	@Test
	void testFTEmpAddr() {

		FullTimeEmployee e1 = new FullTimeEmployee("Pete Johnson", "123 Java Way", 0);
		assertTrue("123 Java Way".equals(e1.getAddress()), "The address of employee e1 should be \"123 Java Way\"");
	}

	@Test
	void testFTEmpID() {

		FullTimeEmployee e1 = new FullTimeEmployee("", "", 999);
		assertEquals(999, e1.getStaffNo(), "FullTimeEmployee employee (e1) number should be set to 999");
		
		FullTimeEmployee e2 = new FullTimeEmployee("", "", 777);
		assertEquals(777, e2.getStaffNo(), "FullTimeEmployee employee (e2) number should be set to 777");
	}

	@Test
	void testFTEmpBonus() {

		FullTimeEmployee e1 = new FullTimeEmployee("", "", 0);
		assertEquals(7000, e1.getBonus(), "FullTimeEmployee employee bonus should be 7000");
	}

	@Test
	void testFTEmpDefaultDepartment() {

		FullTimeEmployee e1 = new FullTimeEmployee("", "", 0);
		assertTrue("tbc".equals(e1.getDepartment()), "The default department of employee e1 should be \"tbc\"");
	}

	@Test
	void testFTEmpClearDepartment() {

		FullTimeEmployee e1 = new FullTimeEmployee("", "", 0);
		e1.clearDepartment();
		assertTrue("".equals(e1.getDepartment()), "The department of employee e1 should be cleared to \"\"");
	}
	
	@Test
	void testFTEmpSetDepartment() {

		FullTimeEmployee e1 = new FullTimeEmployee("", "", 0);
		e1.setDepartment("sales");
		assertTrue("sales".equals(e1.getDepartment()), "The department of employee e1 should be \"sales\"");

		e1.setDepartment("research");
		assertTrue("research".equals(e1.getDepartment()), "The department of employee e1 should be \"research\"");
	}

	@Test
	void testFTEmpFulltime() {

		FullTimeEmployee e1 = new FullTimeEmployee("", "", 0);

		assertTrue(e1.isFullTime(), "The employee should be flagged as working full-time");
	}

	@Test
	void testFTEmpCombined() {

		FullTimeEmployee e1 = new FullTimeEmployee("Miles Henderson", "99 Simpleton Lane", 69);
		
		assertTrue("Miles Henderson".equals(e1.getName()), "The name of employee e1 should be \"Miles Henderson\"");
		assertTrue("99 Simpleton Lane".equals(e1.getAddress()), "The address of employee e1 should be \"99 Simpleton Lane\"");
		assertEquals(69, e1.getStaffNo(), "FullTimeEmployee employee (e1) number should be set to 69");
		assertEquals(14000, e1.getSalary(), "FullTimeEmployee salary should be set to 14000");
		
		assertEquals(7000, e1.getBonus(), "FullTimeEmployee employee bonus should be 7000");
		e1.setSalary(16000);
		assertEquals(8000, e1.getBonus(), "FullTimeEmployee employee bonus should be 8000");
		e1.setSalary(20000);
		assertEquals(10000, e1.getBonus(), "FullTimeEmployee employee bonus should be 10000");
		
		assertTrue(e1.isFullTime(), "The employee should be flagged as working full-time");
		
		e1.setDepartment("development");
		assertTrue("development".equals(e1.getDepartment()), "The department of employee e1 should be \"development\"");
		e1.clearDepartment();
		assertTrue("".equals(e1.getDepartment()), "The department of employee e1 should be cleared to \"\"");
	}
	
}
