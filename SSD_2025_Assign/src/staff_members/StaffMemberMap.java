package staff_members;

import java.util.HashMap;
import java.util.Map;

/**
 * Implements the {@link StaffMemberCollection} interface using an underlying map allowing the number of occurrences of each added staff member to be counted.
 * 
 * If the same staff member is added more than once, then it is not re-added, but its occurrence count is increased.
 * 
 * Edit this file to pass the PART5 tests.
 * 
 * @author mdixon
 */
public class StaffMemberMap implements StaffMemberCollection {

	/**
	 * A collection which maps contained staff members to an occurrence count.
	 */
	private Map<StaffMember, Integer> staffMembers = new HashMap<>();

	///////////////////////////////////////////////////////////////////////

	@Override
	public int addStaffMember(StaffMember staffMember) {
		if (staffMembers.containsKey(staffMember)) {
			// Staff member already exists, increment count
			staffMembers.put(staffMember, staffMembers.get(staffMember) + 1);
		} else {
			// New staff member, set count to 1
			staffMembers.put(staffMember, 1);
		}
		
		return staffMembers.size();
	}

	@Override
	public boolean removeStaffMember(StaffMember staffMember) {
		if (staffMembers.containsKey(staffMember)) {
			staffMembers.remove(staffMember);
			return true;
		}
		return false;
	}

	@Override
	public boolean containsStaffMember(StaffMember staffMember) {
		return staffMembers.containsKey(staffMember);
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
		throw new UnsupportedOperationException();
	}

	@Override
	public StaffMember getHighestSalary() {
		if (staffMembers.isEmpty()) {
			return null;
		}
		
		float highestSalary = Float.NEGATIVE_INFINITY;
		StaffMember highest = null;
		
		for (StaffMember sm : staffMembers.keySet()) {
			if (sm.getSalary() > highestSalary) {
				highestSalary = sm.getSalary();
				highest = sm;
			}
		}
		
		return highest;
	}

	@Override
	public StaffMember getLowestSalary() {
		if (staffMembers.isEmpty()) {
			return null;
		}
		
		float lowestSalary = Float.POSITIVE_INFINITY;
		StaffMember lowest = null;
		
		for (StaffMember sm : staffMembers.keySet()) {
			if (sm.getSalary() < lowestSalary) {
				lowestSalary = sm.getSalary();
				lowest = sm;
			}
		}
		
		return lowest;
	}

	@Override
	public float getTotalBonus() {
		float totalBonus = 0;
		
		for (StaffMember sm : staffMembers.keySet()) {
			totalBonus += sm.getBonus();
		}
		
		return totalBonus;
	}

	/**
	 * Gets the staff member which has the highest occurrence count (i.e. has been added to the collection the most number of times).
	 * 
	 * @return the staff member which has been added to the collection the most number of times, null if no staff members exist within the collection.
	 */
	public StaffMember getMostCommonStaffMember() {
		if (staffMembers.isEmpty()) {
			return null;
		}
		
		StaffMember mostCommon = null;
		int maxCount = 0;

		for (Map.Entry<StaffMember, Integer> entry : staffMembers.entrySet()) {
			if (entry.getValue() > maxCount) {
				maxCount = entry.getValue();
				mostCommon = entry.getKey();
			}
		}

		return mostCommon;
	}

	/**
	 * Gets the occurrence count of the most common staff member.
	 * 
	 * @return the occurrence count of the most common staff member, 0 if no staff members exist within the collection.
	 */
	public int getMostCommonStaffMemberCount() {
		StaffMember mostCommon = getMostCommonStaffMember();
		
		if (mostCommon == null) {
			return 0;
		}
		
		return staffMembers.get(mostCommon);
	}

	///////////////////////////////////////////////////////////////////////

}