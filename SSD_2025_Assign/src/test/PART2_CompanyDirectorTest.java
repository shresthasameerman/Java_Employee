package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import staff_members.CompanyDirector;

/**
 * Tests the {@link CompanyDirector} class.
 * 
 * 
 * NOTE: DO NOT CHANGE THE CONTENTS OF THIS FILE.
 * 
 * @author mdixon
 */
class PART2_CompanyDirectorTest {

	@Test
	void testDirectorSalary() {

		CompanyDirector e1 = new CompanyDirector("", "", 0);
		assertEquals(100000, e1.getSalary(), "Director salary should be set to 100000");
	}

	@Test
	void testDirectorBonus() {

		CompanyDirector e1 = new CompanyDirector("", "", 0);
		assertEquals(300000, e1.getBonus(), "Director bonus should be 300000");
	}

	@Test
	void testDirectorDefaultFulltime() {

		CompanyDirector e1 = new CompanyDirector("", "", 0);

		assertTrue(e1.isFullTime(), "The Director should be flagged as working full-time");
	}

	@Test
	void testDirectorSetFullAndPartTime() {

		CompanyDirector e1 = new CompanyDirector("", "", 0);

		assertTrue(e1.isFullTime(), "The Director should be flagged as working full-time");
		
		e1.setPartTime();
		assertFalse(e1.isFullTime(), "The Director should be flagged as working part-time");
		
		e1.setFullTime();
		assertTrue(e1.isFullTime(), "The Director should be flagged as working full-time");
	}
	
	@Test
	void testDirectorOwnership() {

		CompanyDirector e1 = new CompanyDirector("", "", 0);

		assertFalse(e1.isOwner(), "The Director should not be an owner by default");
		
		e1.setOwnership(true);
		assertTrue(e1.isOwner(), "The Director should be an owner");
		
		e1.setOwnership(false);
		assertFalse(e1.isOwner(), "The Director should not be an owner");
	}
	
	@Test
	void testDefaultShares() {

		CompanyDirector e1 = new CompanyDirector("", "", 0);

		assertEquals(20, e1.getShares(), "Director should have 20 shares by default");
	}
	
	@Test
	void testDoubleShares() {

		CompanyDirector e1 = new CompanyDirector("", "", 0);

		assertEquals(20, e1.getShares(), "Director should have 20 shares by default");
		e1.doubleShares();
		assertEquals(40, e1.getShares(), "Director should have 40 shares once doubled");
	}
	
	@Test
	void testHalfShares() {

		CompanyDirector e1 = new CompanyDirector("", "", 0);

		assertEquals(20, e1.getShares(), "Director should have 20 shares by default");
		
		e1.halfShares();
		assertEquals(10, e1.getShares(), "Director should have 10 shares once halved");
		assertFalse(e1.isOwner(), "The Director should not be an owner by default");
		
		e1.setOwnership(true);
		e1.halfShares();
		assertEquals(10, e1.getShares(), "Director should not have shares halved when they are an owner");
	}
	
	@Test
	void testShareChangeResults() {

		CompanyDirector e1 = new CompanyDirector("", "", 0);

		assertEquals(10, e1.halfShares(), "Director should have 10 shares once halved, and this should be returned from the method");
		assertEquals(20, e1.doubleShares(), "Director should have 20 shares once doubled, and this should be returned from the method");
		
		e1.setOwnership(true);
		assertEquals(20, e1.halfShares(), "Director should not have shares halved, and an unchanged value should be returned from the method");
	}
	
	@Test
	void testDirectorCombined() {

		CompanyDirector e1 = new CompanyDirector("Mark Jefferson", "12 Bobble Green", 169);
		
		assertTrue("Mark Jefferson".equals(e1.getName()), "The name of employee e1 should be \"Mark Jefferson\"");
		assertTrue("12 Bobble Green".equals(e1.getAddress()), "The address of employee e1 should be \"12 Bobble Green\"");
		assertEquals(169, e1.getStaffNo(), "Director (e1) number should be set to 169");
		assertEquals(100000, e1.getSalary(), "Director salary should be set to 100000");
		assertEquals(20, e1.getShares(), "Director should have 20 shares by default");
		
		assertEquals(300000, e1.getBonus(), "Director bonus should be 300000");
		e1.setSalary(200000);
		assertEquals(600000, e1.getBonus(), "Director bonus should be 600000");
			
		assertTrue(e1.isFullTime(), "The Director should be flagged as working full-time");
		e1.setPartTime();
		assertFalse(e1.isFullTime(), "The Director should be flagged as working part-time");
		
		assertEquals(10, e1.halfShares(), "Director should have 10 shares once halved, and this should be returned from the method");
		assertEquals(20, e1.doubleShares(), "Director should have 20 shares once doubled, and this should be returned from the method");
		
		assertFalse(e1.isOwner(), "The Director should not be an owner by default");
		e1.setOwnership(true);
		assertTrue(e1.isOwner(), "The Director should be an owner");
		assertEquals(20, e1.halfShares(), "Director should not have shares halved, and an unchanged value should be returned from the method");
	}
	
}
