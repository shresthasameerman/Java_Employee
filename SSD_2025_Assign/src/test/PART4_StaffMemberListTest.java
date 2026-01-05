package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import staff_members.CompanyDirector;
import staff_members.FullTimeEmployee;
import staff_members.PartTimeEmployee;
import staff_members.StaffMember;
import staff_members.StaffMemberList;



/**
 * Tests the {@link StaffMemberList} class.
 * 
 * 
 * NOTE: DO NOT CHANGE THE CONTENTS OF THIS FILE.
 * 
 * @author mdixon
 */
class PART4_StaffMemberListTest {

	/**
	 * The {@link StaffMemberList} instance created prior to each test.
	 */
	private StaffMemberList list;

	@BeforeEach
	void setUpBeforeEach() throws Exception {

		list = new StaffMemberList();
	}

	@Test
	void testStaffMemberListCount() {

		assertEquals(0, list.countStaffMembers(),
				"StaffMemberList should be empty when first created, StaffMemberList.countStaffMembers() not working correctly?");
	}

	@Test
	void testStaffMemberListAdd() {

		StaffMember e1 = new FullTimeEmployee("","",0);

		assertEquals(1, list.addStaffMember(new PartTimeEmployee("","",1)),
				"StaffMemberList.addStaffMember() not working correctly? Not returning total staff member count");
		assertEquals(2, list.addStaffMember(new PartTimeEmployee("","",2)),
				"StaffMemberList.addStaffMember() not working correctly? Not returning total staff member count");

		// check 2 staff member reported
		assertEquals(2, list.countStaffMembers(), "StaffMemberList.countStaffMembers() not working correctly?");

		// add a third staff member
		assertEquals(3, list.addStaffMember(new FullTimeEmployee("","",0)),
				"StaffMemberList.addStaffMember() not working correctly? Not returning total staff member count");
		assertEquals(3, list.countStaffMembers(), "StaffMemberList.countStaffMembers() not working correctly?");

		// add same staff member twice, should be added okay since a list (not a set).
		assertEquals(4, list.addStaffMember(e1));
		assertEquals(5, list.addStaffMember(e1));
		assertEquals(5, list.countStaffMembers(), "StaffMemberList.countStaffMembers() not working correctly?");
	}

	@Test
	void testStaffMemberListRemove() {

		StaffMember e1 = new FullTimeEmployee("","",99);
		StaffMember e2 = new PartTimeEmployee("","",100);

		assertEquals(1, list.addStaffMember(e1),
				"StaffMemberList.addStaffMember() not working correctly? Not returning total staff member count");
		assertEquals(1, list.countStaffMembers(), "StaffMemberList.countStaffMembers() not working correctly?");

		assertTrue(list.removeStaffMember(e1),
				"StaffMemberList.removeStaffMember() not working correctly?, Should return true if staff member removed");
		assertEquals(0, list.countStaffMembers(),
				"StaffMemberList.removeStaffMember() not working correctly? staff member not actually removed?");

		assertEquals(1, list.addStaffMember(new PartTimeEmployee("","",1)), "StaffMemberList.addStaffMember() not working correctly?");
		assertEquals(2, list.addStaffMember(new PartTimeEmployee("","",2)), "StaffMemberList.addStaffMember() not working correctly?");
		assertEquals(3, list.addStaffMember(e1), "StaffMemberList.addStaffMember() not working correctly?");
		assertEquals(4, list.addStaffMember(new CompanyDirector("","",3)), "StaffMemberList.addStaffMember() not working correctly?");
		assertEquals(4, list.countStaffMembers(), "StaffMemberList.countStaffMembers() not working correctly?");

		// try to remove emp not yet added.
		assertFalse(list.removeStaffMember(e2),
				"StaffMemberList.removeStaffMember() not working correctly?, Should return false if staff member not present");
		assertEquals(4, list.countStaffMembers(), "StaffMemberList.removeStaffMember() not working correctly? staff member actually removed?");

		// now remove e1 again
		assertTrue(list.removeStaffMember(e1),
				"StaffMemberList.removeStaffMember() not working correctly?, Should return true if staff member removed");
		assertEquals(3, list.countStaffMembers(),
				"StaffMemberList.removeStaffMember() not working correctly? staff member not actually removed?");

		// try to remove e1 again, even though just removed
		assertFalse(list.removeStaffMember(e1),
				"StaffMemberList.removeStaffMember() not working correctly?, Should return false if staff member not present");
		assertEquals(3, list.countStaffMembers(), "StaffMemberList.removeStaffMember() not working correctly? staff member removed twice?");
	}

	@Test
	void testStaffMemberListContains() {

		StaffMember e1 = new FullTimeEmployee("","",99);
		StaffMember e2 = new PartTimeEmployee("","",100);

		assertFalse(list.containsStaffMember(e1),
				"StaffMemberList.containsStaffMember() not working correctly?, Should return false if staff member not present");
		assertFalse(list.containsStaffMember(e2),
				"StaffMemberList.containsStaffMember() not working correctly?, Should return false if staff member not present");

		assertEquals(1, list.addStaffMember(e2),
				"StaffMemberList.addStaffMember() not working correctly? Not returning total staff member count");
		assertTrue(list.containsStaffMember(e2),
				"StaffMemberList.containsStaffMember() not working correctly?, Should return true if staff member present");
		assertFalse(list.containsStaffMember(e1),
				"StaffMemberList.containsStaffMember() not working correctly?, Should return false if staff member not present");
		assertEquals(1, list.countStaffMembers(), "StaffMemberList.countStaffMembers() not working correctly?");

		assertEquals(2, list.addStaffMember(e1));
		assertTrue(list.containsStaffMember(e1),
				"StaffMemberList.containsStaffMember() not working correctly?, Should return true if staff member present");
	}

	@Test
	void testStaffMemberListClear() {

		assertEquals(1, list.addStaffMember(new FullTimeEmployee("","",99)),
				"StaffMemberList.addStaffMember() not working correctly? Not returning total staff member count");
		assertEquals(2, list.addStaffMember(new FullTimeEmployee("","",991)),
				"StaffMemberList.addStaffMember() not working correctly? Not returning total staff member count");
		assertEquals(3, list.addStaffMember(new FullTimeEmployee("","",992)),
				"StaffMemberList.addStaffMember() not working correctly? Not returning total staff member count");
		assertEquals(4, list.addStaffMember(new FullTimeEmployee("","",993)),
				"StaffMemberList.addStaffMember() not working correctly? Not returning total staff member count");

		assertEquals(4, list.countStaffMembers(), "StaffMemberList.countStaffMembers() not working correctly?");

		list.clearAllStaffMembers();
		assertEquals(0, list.countStaffMembers(), "StaffMemberList.clearAllStaffMembers() not working correctly? List should be empty");
	}

	@Test
	void testStaffMemberListIndex() {

		StaffMember e1 = new FullTimeEmployee("","",99);
		StaffMember e2 = new PartTimeEmployee("","",100);

		try {
			assertTrue(list.indexOfStaffMember(e1) < 0,
					"StaffMemberList.indexOfStaffMember() not working correctly? Should return <0 when staff member not present");
			assertTrue(list.indexOfStaffMember(e2) < 0,
					"StaffMemberList.indexOfStaffMember() not working correctly? Should return <0 when staff member not present");

			assertEquals(1, list.addStaffMember(e1),
					"StaffMemberList.addStaffMember() not working correctly? Not returning total staff member count");
			assertEquals(2, list.addStaffMember(new PartTimeEmployee("","",2)),
					"StaffMemberList.addStaffMember() not working correctly? Not returning total staff member count");
			assertEquals(3, list.addStaffMember(new PartTimeEmployee("","",3)),
					"StaffMemberList.addStaffMember() not working correctly? Not returning total staff member count");
			assertEquals(4, list.addStaffMember(new PartTimeEmployee("","",4)),
					"StaffMemberList.addStaffMember() not working correctly? Not returning total staff member count");

			assertEquals(0, list.indexOfStaffMember(e1),
					"StaffMemberList.indexOfStaffMember() not working correctly? Should return index when present");
			assertTrue(list.indexOfStaffMember(e2) < 0,
					"StaffMemberList.indexOfStaffMember() not working correctly? Should return <0 when staff member not present");

			assertEquals(5, list.addStaffMember(e2),
					"StaffMemberList.addStaffMember() not working correctly? Not returning total staff member count");
			assertEquals(6, list.addStaffMember(new CompanyDirector("","",5)),
					"StaffMemberList.addStaffMember() not working correctly? Not returning total staff member count");

			assertEquals(4, list.indexOfStaffMember(e2),
					"StaffMemberList.indexOfStaffMember() not working correctly? Should return index when present");

		} catch (UnsupportedOperationException e) {

			fail("StaffMemberList.indexOfStaffMember() not working correctly? Should not throw UnsupportedOperationException() when implemented");
		}
	}

	@Test
	void testStaffMemberListGetHighestSalary() {

		StaffMember e1 = new FullTimeEmployee("","",99);
		StaffMember e2 = new CompanyDirector("","",100);
		StaffMember e3 = new PartTimeEmployee("","",100);

		assertNull(list.getHighestSalary(), "StaffMemberList.getHighestSalary() should return null when the list is empty");

		assertEquals(1, list.addStaffMember(e1), "StaffMemberList.addStaffMember() not working correctly?");
		assertEquals(2, list.addStaffMember(e2), "StaffMemberList.addStaffMember() not working correctly?");
		assertEquals(3, list.addStaffMember(e3), "StaffMemberList.addStaffMember() not working correctly?");

		assertSame(e2, list.getHighestSalary(), "StaffMemberList.getHighestSalary() not working correctly?");

		StaffMember e4 = new FullTimeEmployee("","",99);

		// add staff member before it is set to the largest
		assertEquals(4, list.addStaffMember(e4));

		assertSame(e2, list.getHighestSalary(),
				"StaffMemberList.getHighestSalary() not working correctly? Not checking updated salary?");

		// update e4 to be the largest salary
		e4.setSalary(200000);
		
		assertSame(e4, list.getHighestSalary(),
				"StaffMemberList.getHighestSalary() not working correctly? Not checking updated salary?");
		
		// update e1 to be the largest salary
		e1.setSalary(200001);
		
		assertSame(e1, list.getHighestSalary(),
				"StaffMemberList.getHighestSalary() not working correctly? Not checking updated salary?");
	}

	@Test
	void testStaffMemberListGetLowestSalary() {

		StaffMember e1 = new FullTimeEmployee("","",99);
		StaffMember e2 = new CompanyDirector("","",100);
		StaffMember e3 = new PartTimeEmployee("","",100);

		assertNull(list.getLowestSalary(), "StaffMemberList.getLowestSalary() should return null when the list is empty");

		assertEquals(1, list.addStaffMember(e1), "StaffMemberList.addStaffMember() not working correctly?");
		assertEquals(2, list.addStaffMember(e2), "StaffMemberList.addStaffMember() not working correctly?");
		assertEquals(3, list.addStaffMember(e3), "StaffMemberList.addStaffMember() not working correctly?");

		assertSame(e3, list.getLowestSalary(), "StaffMemberList.getLowestSalary() not working correctly?");

		// update e1 to be the smallest salary
		e1.setSalary(100);

		assertSame(e1, list.getLowestSalary(),
				"StaffMemberList.getLowestSalary() not working correctly? Not checking updated salary?");

		// update e2 to be the smallest salary
		e2.setSalary(99);
		assertSame(e2, list.getLowestSalary(),
				"StaffMemberList.getLowestSalary() not working correctly? Not checking updated salary?");
	}

	@Test
	void testStaffMemberListTotalBonus() {

		StaffMember e1 = new FullTimeEmployee("","",99);
		StaffMember e2 = new CompanyDirector("","",100);
		StaffMember e3 = new CompanyDirector("","",100);
		
		assertEquals(0, list.getTotalBonus(), "StaffMemberList.getTotalBonus() should be 0 when list is empty");
		
		assertEquals(1, list.addStaffMember(e1), "StaffMemberList.addStaffMember() not working correctly?");
		e1.setSalary(10000);
		assertEquals(5000, list.getTotalBonus(), "StaffMemberList.getTotalBonus() not working correctly?");
		
		assertEquals(2, list.addStaffMember(e2), "StaffMemberList.addStaffMember() not working correctly?");
		assertEquals(305000, list.getTotalBonus(), "StaffMemberList.getTotalBonus() not working correctly?");
		
		e3.setSalary(100);
		assertEquals(3, list.addStaffMember(e3), "StaffMemberList.addStaffMember() not working correctly?");
		assertEquals(305300, list.getTotalBonus(), "StaffMemberList.getTotalBonus() not working correctly?");
	}

	@Test
	void testStaffMemberListSortOnSalary() {

		StaffMember e1 = new FullTimeEmployee("","",99);
		StaffMember e2 = new CompanyDirector("","",100);	// highest salary
		StaffMember e3 = new PartTimeEmployee("","",100); // lowest salary
		
		assertEquals(1, list.addStaffMember(e1), "StaffMemberList.addStaffMember() not working correctly?");
		assertEquals(2, list.addStaffMember(e2), "StaffMemberList.addStaffMember() not working correctly?");
		assertEquals(3, list.addStaffMember(e3), "StaffMemberList.addStaffMember() not working correctly?");
		
		assertEquals(0, list.indexOfStaffMember(e1), "StaffMemberList.addStaffMember() or indexOfStaffMember() not working correctly?");
		assertEquals(1, list.indexOfStaffMember(e2), "StaffMemberList.addStaffMember() or indexOfStaffMember() not working correctly?");
		assertEquals(2, list.indexOfStaffMember(e3), "StaffMemberList.addStaffMember() or indexOfStaffMember() not working correctly?");
		
		list.sortOnSalary();
		
		assertEquals(0, list.indexOfStaffMember(e3), "StaffMemberList.sortOnSalary() or indexOfStaffMember() not working correctly?");
		assertEquals(1, list.indexOfStaffMember(e1), "StaffMemberList.sortOnSalary() or indexOfStaffMember() not working correctly?");
		assertEquals(2, list.indexOfStaffMember(e2), "StaffMemberList.sortOnSalary() or indexOfStaffMember() not working correctly?");		
	}
	
}
