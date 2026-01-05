package staff_members;

/**
 * An interface that defines methods to be implemented by staff member collection classes.
 * 
 * @author mdixon
 */
public interface StaffMemberCollection {

	/**
	 * Adds a staff member to the collection.
	 * 
	 * @param staffMember the staff member to be added
	 * @return the total number of staff members added to the collection
	 */
	int addStaffMember(StaffMember staffMember);

	/**
	 * Removes staff member from the collection.
	 * 
	 * @param staffMember the staff member to be removed
	 * @return true if the staff member was found and removed, else false
	 */
	boolean removeStaffMember(StaffMember staffMember);

	/**
	 * Checks if the collection contains a given staff member.
	 * 
	 * @param staffMember the staff member to be found
	 * @return true if the collection contains the staff member, else false
	 */
	boolean containsStaffMember(StaffMember staffMember);

	/**
	 * Gets the total number of staff members in the collection.
	 * 
	 * @return the total number of staff members in the collection
	 */
	int countStaffMembers();

	/**
	 * Removes all staff members from the collection
	 */
	void clearAllStaffMembers();

	/**
	 * Gets index position of a staff member within the collection (assuming the collection supports indexed type storage).
	 * 
	 * @param staffMember the staff member for which the index is required
	 * @return the index of the staff member, < 0 if the staff member is not in the collection
	 * @throws UnsupportedOperationException if the collection does not support index based storage, e.g. if unordered map/set type collections
	 */
	int indexOfStaffMember(StaffMember staffMember) throws UnsupportedOperationException;

	/**
	 * Gets the staff member with the highest salary.
	 * 
	 * @return the staff members with the highest salary, null if no staff members exist within the collection.
	 */
	StaffMember getHighestSalary();

	/**
	 * Gets the staff member with the lowest salary.
	 * 
	 * @return the staff member with the lowest salary, null if no staff members exist within the collection.
	 */
	StaffMember getLowestSalary();

	/**
	 * Gets the total bonus awarded to all staff members within the collection.
	 * 
	 * If the collection is empty, then 0 is always returned.
	 * 
	 * @return the total bonus awarded to all staff members within the collection
	 */
	float getTotalBonus();

}
