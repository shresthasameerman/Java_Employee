package staff_members;

/**
 * A type of {@link StaffMember} which is employed full-time
 * 
 * Edit this file to pass the PART1 tests.
 * 
 */
public class FullTimeEmployee extends StaffMember {

	/**
	 * The department in which the full-time employee works.
	 */
	private String department;

	////////////////////////////////////////////

	@Override
	public float getBonus() {
		// Bonus is half their salary
		return salary / 2;
	}

	@Override
	public boolean isFullTime() {
		// Full-time employee always returns true
		return true;
	}

	/**
	 * Gets the department in which the full-time employee works.
	 * 
	 * @return the department in which the full-time employee works.
	 */
	public String getDepartment() {
		return department;
	}

	/**
	 * Sets the department in which the full-time employee works.
	 * 
	 * @param department the department in which the full-time employee works.
	 */
	public void setDepartment(String department) {
		this.department = department;
	}

	/**
	 * Clears the name of the department in which the employee works to be an empty string.
	 */
	public void clearDepartment() {
		this.department = "";
	}

	/**
	 * Constructor
	 *
	 * A full-time employee has an initial salary of 14000
	 * 
	 * The {@link #department} attribute should initially be set to "tbc"
	 * 
	 * @param name    the name of the employee
	 * @param address the address of the employee
	 * @param staffNo the unique staff member number
	 */
	public FullTimeEmployee(String name, String address, int staffNo) {
		// Pass name, address, staffNo, and salary (14000) to parent
		super(name, address, staffNo, 14000);
		
		// Set department to "tbc"
		this.department = "tbc";
	}

}