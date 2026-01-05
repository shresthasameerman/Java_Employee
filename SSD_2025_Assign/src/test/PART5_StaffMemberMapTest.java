package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import staff_members.CompanyDirector;
import staff_members.FullTimeEmployee;
import staff_members.PartTimeEmployee;
import staff_members.StaffMember;
import staff_members.StaffMemberMap;

/**
 * Tests the {@link StaffMemberMap} class.
 * 
 * 
 * NOTE: DO NOT CHANGE THE CONTENTS OF THIS FILE.
 * 
 * @author mdixon
 */
class PART5_StaffMemberMapTest {

	/**
	 * The {@link StaffMemberMap} instance created prior to each test.
	 */
	private StaffMemberMap map;

	@BeforeEach
	void setUpBeforeEach() throws Exception {

		map = new StaffMemberMap();
	}

	@Test
	void testStaffMemberMapCount() {

		assertEquals(0, map.countStaffMembers(), "StaffMemberMap should be empty when first created, StaffMemberMap.countStaffMembers() not working correctly?");
	}

	@Test
	void testStaffMemberMapAdd() {

		StaffMember e1 = new FullTimeEmployee("", "", 99);

		assertEquals(1, map.addStaffMember(new CompanyDirector("", "", 100)), "StaffMemberMap.addStaffMember() not working correctly? Not returning total staff member count");
		assertEquals(2, map.addStaffMember(new CompanyDirector("", "", 101)), "StaffMemberMap.addStaffMember() not working correctly? Not returning total staff member count");

		// check 2 staff members reported
		assertEquals(2, map.countStaffMembers(), "StaffMemberMap.countStaffMembers() not working correctly?");

		// add a third staff member
		assertEquals(3, map.addStaffMember(new PartTimeEmployee("", "", 102)), "StaffMemberMap.addStaffMember() not working correctly? Not returning total staff member count");
		assertEquals(3, map.countStaffMembers(), "StaffMemberMap.countStaffMembers() not working correctly?");

		// add same staff member twice, should not be re-added since a map (not a list).
		assertEquals(4, map.addStaffMember(e1));
		assertEquals(4, map.addStaffMember(e1), "StaffMemberMap.addStaffMember() not working correctly? Adding same staff member more than once?");
		assertEquals(4, map.countStaffMembers(), "StaffMemberMap.countStaffMembers() not working correctly?");
	}

	@Test
	void testStaffMemberMapRemove() {

		StaffMember e1 = new FullTimeEmployee("", "", 99);
		StaffMember e2 = new CompanyDirector("", "", 100);

		assertEquals(1, map.addStaffMember(e1), "StaffMemberMap.addStaffMember() not working correctly? Not returning total staff member count");
		assertEquals(1, map.countStaffMembers(), "StaffMemberMap.countStaffMembers() not working correctly?");

		assertTrue(map.removeStaffMember(e1), "StaffMemberMap.removeStaffMember() not working correctly?, Should return true if staff member removed");
		assertEquals(0, map.countStaffMembers(), "StaffMemberMap.removeStaffMember() not working correctly? staff member not actually removed?");

		assertEquals(1, map.addStaffMember(new PartTimeEmployee("", "", 102)), "StaffMemberMap.addStaffMember() not working correctly?");
		assertEquals(2, map.addStaffMember(new CompanyDirector("", "", 101)), "StaffMemberMap.addStaffMember() not working correctly?");
		assertEquals(3, map.addStaffMember(e1), "StaffMemberMap.addStaffMember() not working correctly?");
		assertEquals(4, map.addStaffMember(new PartTimeEmployee("", "", 104)), "StaffMemberMap.addStaffMember() not working correctly?");
		assertEquals(4, map.countStaffMembers(), "StaffMemberMap.countStaffMembers() not working correctly?");

		// try to remove staff member not yet added.
		assertFalse(map.removeStaffMember(e2), "StaffMemberMap.removeStaffMember() not working correctly?, Should return false if staff member not present");
		assertEquals(4, map.countStaffMembers(), "StaffMemberMap.removeStaffMember() not working correctly? staff member actually removed?");

		// now remove e1 again
		assertTrue(map.removeStaffMember(e1), "StaffMemberMap.removeStaffMember() not working correctly?, Should return true if staff member removed");
		assertEquals(3, map.countStaffMembers(), "StaffMemberMap.removeStaffMember() not working correctly? staff member not actually removed?");

		// try to remove e1 again, even though just removed
		assertFalse(map.removeStaffMember(e1), "StaffMemberMap.removeStaffMember() not working correctly?, Should return false if staff member not present");
		assertEquals(3, map.countStaffMembers(), "StaffMemberMap.removeStaffMember() not working correctly? staff member removed twice?");
	}

	@Test
	void testStaffMemberMapContains() {

		StaffMember e1 = new CompanyDirector("", "", 99);
		StaffMember e2 = new PartTimeEmployee("", "", 100);

		assertFalse(map.containsStaffMember(e1), "StaffMemberMap.containsStaffMember() not working correctly?, Should return false if staff member not present");
		assertFalse(map.containsStaffMember(e2), "StaffMemberMap.containsStaffMember() not working correctly?, Should return false if staff member not present");

		assertEquals(1, map.addStaffMember(e2), "StaffMemberMap.addStaffMember() not working correctly? Not returning total staff member count");
		assertTrue(map.containsStaffMember(e2), "StaffMemberMap.containsStaffMember() not working correctly?, Should return true if staff member present");
		assertFalse(map.containsStaffMember(e1), "StaffMemberMap.containsStaffMember() not working correctly?, Should return false if staff member not present");
		assertEquals(1, map.countStaffMembers(), "StaffMemberMap.countStaffMembers() not working correctly?");

		assertEquals(2, map.addStaffMember(e1));
		assertTrue(map.containsStaffMember(e1), "StaffMemberMap.containsStaffMember() not working correctly?, Should return true if staff member present");
	}

	@Test
	void testStaffMemberMapClear() {

		assertEquals(1, map.addStaffMember(new CompanyDirector("", "", 99)), "StaffMemberMap.addStaffMember() not working correctly? Not returning total staff member count");
		assertEquals(2, map.addStaffMember(new CompanyDirector("", "", 199)), "StaffMemberMap.addStaffMember() not working correctly? Not returning total staff member count");
		assertEquals(3, map.addStaffMember(new PartTimeEmployee("", "", 103)), "StaffMemberMap.addStaffMember() not working correctly? Not returning total staff member count");
		assertEquals(4, map.addStaffMember(new PartTimeEmployee("", "", 102)), "StaffMemberMap.addStaffMember() not working correctly? Not returning total staff member count");

		assertEquals(4, map.countStaffMembers(), "StaffMemberMap.countStaffMembers() not working correctly?");

		map.clearAllStaffMembers();
		assertEquals(0, map.countStaffMembers(), "StaffMemberMap.clearAllStaffMembers() not working correctly? map should be empty");
	}

	@Test
	void testStaffMemberMapIndex() {

		// Ensure StaffMemberMap throws exception for unsupported operation
		assertThrows(UnsupportedOperationException.class, () -> {
			map.indexOfStaffMember(new PartTimeEmployee("", "", 103));
		}, "StaffMemberMap.indexOfStaffMember() not working correctly? Should throw UnsupportedOperationException()");

	}

	@Test
	void testStaffMemberMapTotalBonus() {

		StaffMember e1 = new FullTimeEmployee("", "", 99);
		StaffMember e2 = new CompanyDirector("", "", 100);
		StaffMember e3 = new CompanyDirector("", "", 100);

		assertEquals(0, map.getTotalBonus(), "StaffMemberMap.getTotalBonus() should be 0 when list is empty");

		assertEquals(1, map.addStaffMember(e1), "StaffMemberMap.addStaffMember() not working correctly?");
		e1.setSalary(10000);
		assertEquals(5000, map.getTotalBonus(), "StaffMemberMap.getTotalBonus() not working correctly?");

		assertEquals(2, map.addStaffMember(e2), "StaffMemberMap.addStaffMember() not working correctly?");
		assertEquals(305000, map.getTotalBonus(), "StaffMemberMap.getTotalBonus() not working correctly?");

		e3.setSalary(100);
		assertEquals(3, map.addStaffMember(e3), "StaffMemberMap.addStaffMember() not working correctly?");
		assertEquals(305300, map.getTotalBonus(), "StaffMemberMap.getTotalBonus() not working correctly?");
	}

	@Test
	void testStaffMemberMapGetHighestSalary() {

		StaffMember e1 = new FullTimeEmployee("", "", 99);
		StaffMember e2 = new CompanyDirector("", "", 100);
		StaffMember e3 = new PartTimeEmployee("", "", 100);

		assertNull(map.getHighestSalary(), "StaffMemberMap.getHighestSalary() should return null when the list is empty");

		assertEquals(1, map.addStaffMember(e1), "StaffMemberMap.addStaffMember() not working correctly?");
		assertEquals(2, map.addStaffMember(e2), "StaffMemberMap.addStaffMember() not working correctly?");
		assertEquals(3, map.addStaffMember(e3), "StaffMemberMap.addStaffMember() not working correctly?");

		assertSame(e2, map.getHighestSalary(), "StaffMemberMap.getHighestSalary() not working correctly?");

		StaffMember e4 = new FullTimeEmployee("", "", 99);

		// add staff member before it is set to the largest
		assertEquals(4, map.addStaffMember(e4));

		assertSame(e2, map.getHighestSalary(), "StaffMemberMap.getHighestSalary() not working correctly? Not checking updated salary?");

		// update e4 to be the largest salary
		e4.setSalary(200000);

		assertSame(e4, map.getHighestSalary(), "StaffMemberMap.getHighestSalary() not working correctly? Not checking updated salary?");

		// update e1 to be the largest salary
		e1.setSalary(200001);

		assertSame(e1, map.getHighestSalary(), "StaffMemberMap.getHighestSalary() not working correctly? Not checking updated salary?");
	}

	@Test
	void testStaffMemberMapGetLowestSalary() {

		StaffMember e1 = new FullTimeEmployee("", "", 99);
		StaffMember e2 = new CompanyDirector("", "", 100);
		StaffMember e3 = new PartTimeEmployee("", "", 100);

		assertNull(map.getLowestSalary(), "StaffMemberMap.getLowestSalary() should return null when the list is empty");

		assertEquals(1, map.addStaffMember(e1), "StaffMemberMap.addStaffMember() not working correctly?");
		assertEquals(2, map.addStaffMember(e2), "StaffMemberMap.addStaffMember() not working correctly?");
		assertEquals(3, map.addStaffMember(e3), "StaffMemberMap.addStaffMember() not working correctly?");

		assertSame(e3, map.getLowestSalary(), "StaffMemberMap.getLowestSalary() not working correctly?");

		// update e1 to be the smallest salary
		e1.setSalary(100);

		assertSame(e1, map.getLowestSalary(), "StaffMemberMap.getLowestSalary() not working correctly? Not checking updated salary?");

		// update e2 to be the smallest salary
		e2.setSalary(99);
		assertSame(e2, map.getLowestSalary(), "StaffMemberMap.getLowestSalary() not working correctly? Not checking updated salary?");
	}

	@Test
	void testStaffMemberMapMostCommonEmployee() {

		StaffMember e1 = new FullTimeEmployee("", "", 90);
		StaffMember e2 = new FullTimeEmployee("", "", 91);
		StaffMember e3 = new FullTimeEmployee("", "", 92);
		StaffMember e4 = new FullTimeEmployee("", "", 93);

		assertNull(map.getMostCommonStaffMember(), "StaffMemberMap.getMostCommonStaffMember() should return null when the map is empty");
		assertEquals(0, map.getMostCommonStaffMemberCount(), "StaffMemberMap.getMostCommonStaffMemberCount() should return 0 when the map is empty");

		assertEquals(1, map.addStaffMember(e1));
		assertEquals(2, map.addStaffMember(e2));
		assertEquals(3, map.addStaffMember(e3));
		assertEquals(4, map.addStaffMember(e4));

		assertEquals(4, map.addStaffMember(e2));

		// check e2 is the most common staff member (with an occurrence count of 2)
		assertSame(e2, map.getMostCommonStaffMember(), "StaffMemberMap.getMostCommonStaffMember() not working correctly?");
		assertEquals(2, map.getMostCommonStaffMemberCount(), "StaffMemberMap.getMostCommonStaffMemberCount()  not working correctly?");

		// add e1 twice more, making it the most common staff member (with an occurrence count of 3)
		assertEquals(4, map.addStaffMember(e1));
		assertEquals(4, map.addStaffMember(e1));
		assertSame(e1, map.getMostCommonStaffMember(), "StaffMemberMap.getMostCommonStaffMember() not working correctly?");
		assertEquals(3, map.getMostCommonStaffMemberCount(), "StaffMemberMap.getMostCommonStaffMemberCount() not working correctly?");

	}
}
