package staff_members;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * Implements the {@link StaffMemberCollection} interface using an underlying ordered list.
 * 
 * Edit this file to pass the PART4 tests.
 * 
 * @author mdixon
 */
public class StaffMemberList implements StaffMemberCollection {

	/**
	 * The list of staff members
	 */
	private List<StaffMember> staffMembers = new ArrayList<StaffMember>();

	///////////////////////////////////////////////////////////////////////

	@Override
	public int addStaffMember(StaffMember staffMember) {
		staffMembers.add(staffMember);
		return staffMembers.size();
	}

	@Override
	public boolean removeStaffMember(StaffMember staffMember) {
		return staffMembers.remove(staffMember);
	}

	@Override
	public boolean containsStaffMember(StaffMember staffMember) {
		return staffMembers.contains(staffMember);
	}

	@Override
	public int countStaffMembers() {
		return staffMembers.size();
	}

	@Override
	public void clearAllStaffMembers() {
		staffMembers.clear();
	}

	@Override
	public int indexOfStaffMember(StaffMember staffMember) {
		return staffMembers.indexOf(staffMember);
	}

	@Override
	public StaffMember getHighestSalary() {
		float salary = 0;
		StaffMember largest = null;

		for (StaffMember sm : staffMembers) {
			// Compare salary of current staff member against highest so far
			if (sm.getSalary() > salary) {
				salary = sm.getSalary();
				largest = sm;
			}
		}

		return largest;
	}

	@Override
	public StaffMember getLowestSalary() {
		if (staffMembers.isEmpty()) {
			return null;
		}
		
		float salary = Float.MAX_VALUE;
		StaffMember smallest = null;

		for (StaffMember sm : staffMembers) {
			if (sm.getSalary() < salary) {
				salary = sm.getSalary();
				smallest = sm;
			}
		}

		return smallest;
	}

	@Override
	public float getTotalBonus() {
		float bonus = 0;

		for (StaffMember sm : staffMembers) {
			bonus += sm.getBonus();
		}

		return bonus;
	}

	/**
	 * Sorts the list of staff members based on their salary (lowest to highest)
	 */
	public void sortOnSalary() {
		staffMembers.sort(Comparator.comparing(StaffMember::getSalary));
	}
}