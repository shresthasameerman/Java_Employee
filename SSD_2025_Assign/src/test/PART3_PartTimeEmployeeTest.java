package test;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import staff_members.PartTimeEmployee;

/**
 * Tests the {@link PartTimeEmployee} class.
 * 
 * 
 * NOTE: DO NOT CHANGE THE CONTENTS OF THIS FILE.
 * 
 * @author mdixon
 */
class PART3_PartTimeEmployeeTest {

	@Test
	void testPTEmpSalary() {

		PartTimeEmployee e1 = new PartTimeEmployee("", "", 0);
		assertEquals(2000, e1.getSalary(), "PartTimeEmployee salary should be set to 2000");
	}

	@Test
	void testPTEmpHourlyRate() {

		PartTimeEmployee e1 = new PartTimeEmployee("", "", 0);
		assertEquals(12, e1.getHourlyRate(), "PartTimeEmployee hourly rate should be set to 12");
		
		assertEquals(PartTimeEmployee.MINIMUM_RATE, e1.getMinimumHourlyRate(), "PartTimeEmployee min hourly rate should be set to " + PartTimeEmployee.MINIMUM_RATE);
	}

	
	@Test
	void testPTEmpDefaultBonus() {

		PartTimeEmployee e1 = new PartTimeEmployee("", "", 0);
		assertEquals(424, e1.getBonus(), "PartTimeEmployee employee default bonus should be 424");
	}
		
	
	@Test
	void testPTEmpBonus() {

		PartTimeEmployee e1 = new PartTimeEmployee("", "", 0);
		assertEquals(424, e1.getBonus(), "PartTimeEmployee employee default bonus should be 424");
		
		e1.setSalary(4000);
		assertEquals(824, e1.getBonus(), "PartTimeEmployee employee default bonus should be 824");
		
		e1.incHourlyRate(3);
		assertEquals(830, e1.getBonus(), "PartTimeEmployee employee default bonus should be 830");
	}
	
	@Test
	void testPTEmpIncHourlyRate() {

		PartTimeEmployee e1 = new PartTimeEmployee("", "", 0);
		
		assertEquals(12, e1.getHourlyRate(), "PartTimeEmployee hourly rate should be set to 12");
		
		e1.incHourlyRate(0);
		assertEquals(12, e1.getHourlyRate(), "PartTimeEmployee hourly rate should be still set to 12");
		
		e1.incHourlyRate(2);
		assertEquals(14, e1.getHourlyRate(), "PartTimeEmployee hourly rate should be set to 14");
	}
	
	@Test
	void testPTEmpIncHourlyRateCapped() {

		PartTimeEmployee e1 = new PartTimeEmployee("", "", 0);
		
		assertEquals(12, e1.getHourlyRate(), "PartTimeEmployee hourly rate should be set to 12");
			
		assertEquals(13, e1.incHourlyRate(1), "PartTimeEmployee hourly rate should be set to 13, and returned from the method");
		
		e1.incHourlyRate(188);
		assertEquals(200, e1.getHourlyRate(), "PartTimeEmployee hourly rate should be limited to 10% of salary");
		
		assertEquals(200, e1.incHourlyRate(1), "PartTimeEmployee hourly rate should be limited to 10% of salary, and returned from the method");
	}
	
	@Test
	void testPTEmpDecHourlyRate() {

		PartTimeEmployee e1 = new PartTimeEmployee("", "", 0);
		
		assertEquals(12, e1.getHourlyRate(), "PartTimeEmployee hourly rate should be set to 12");
		
		e1.decHourlyRate(0);
		assertEquals(12, e1.getHourlyRate(), "PartTimeEmployee hourly rate should be still set to 12");
		
		e1.decHourlyRate(0.1f);
		assertEquals(12-0.1f, e1.getHourlyRate(), "PartTimeEmployee hourly rate should be set to 11.9");
	}
	
	@Test
	void testPTEmpDecHourlyRateCapped() {

		PartTimeEmployee e1 = new PartTimeEmployee("", "", 0);
		
		assertEquals(12, e1.getHourlyRate(), "PartTimeEmployee hourly rate should be set to 12");
			
		assertEquals(12-0.2f, e1.decHourlyRate(0.2f), "PartTimeEmployee hourly rate should be set to 11.8, and returned from the method");
		
		e1.decHourlyRate(2);
		assertEquals(PartTimeEmployee.MINIMUM_RATE, e1.getHourlyRate(), "PartTimeEmployee hourly rate should be as least " + PartTimeEmployee.MINIMUM_RATE );
		
		assertEquals(PartTimeEmployee.MINIMUM_RATE, e1.decHourlyRate(4), "PartTimeEmployee hourly rate should be as least " + PartTimeEmployee.MINIMUM_RATE + " and returned from the method");
	}
	
	@Test
	void testPTEmpFulltime() {

		PartTimeEmployee e1 = new PartTimeEmployee("", "", 0);

		assertFalse(e1.isFullTime(), "The employee should be flagged as working part-time");
	}

	@Test
	void testPTEmpCombined() {

		PartTimeEmployee e1 = new PartTimeEmployee("Miles Henderson III", "9 Simpleton Road", 689);
		
		assertTrue("Miles Henderson III".equals(e1.getName()), "The name of employee e1 should be \"Miles Henderson III\"");
		assertTrue("9 Simpleton Road".equals(e1.getAddress()), "The address of employee e1 should be \"9 Simpleton Road\"");
		assertEquals(689, e1.getStaffNo(), "PartTimeEmployee employee (e1) number should be set to 689");
		assertEquals(2000, e1.getSalary(), "PartTimeEmployee salary should be set to 2000");
		
		assertEquals(424, e1.getBonus(), "PartTimeEmployee employee bonus should be 424");
		e1.setSalary(4000);
		e1.incHourlyRate(6);
		assertEquals(836, e1.getBonus(), "PartTimeEmployee employee bonus should be 836");
			
		assertFalse(e1.isFullTime(), "The employee should be flagged as working part-time");
		
		e1.incHourlyRate(-6);
		assertEquals(12, e1.getHourlyRate(), "PartTimeEmployee hourly rate should be set to 12");
				
		e1.setSalary(1000);
		e1.incHourlyRate(1000);
		assertEquals(100, e1.getHourlyRate(), "PartTimeEmployee hourly rate should be limited to 10% of salary");
		
		e1.setSalary(2000);
		assertEquals(110, e1.incHourlyRate(10), "PartTimeEmployee hourly rate should 110");
		
		assertEquals(PartTimeEmployee.MINIMUM_RATE, e1.decHourlyRate(1000), "PartTimeEmployee hourly rate should be as least " + PartTimeEmployee.MINIMUM_RATE + " and returned from the method");
	}

}
