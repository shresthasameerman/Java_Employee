package staff_members;

/**
 * An abstract class, representing a member of staff, which is a sub-type of {@link Person}
 * 
 * @author mdixon
 */
abstract public class StaffMember extends Person {

	/**
	 * The unique staff number
	 */
	private final int staffNo;

	/**
	 * The salary of the staff member
	 */
	protected float salary;

	///////////////////////////////////////////////

	/**
	 * @return the unique staff number
	 */
	public int getStaffNo() {

		return staffNo;
	}

	/**
	 * Sets the salary of a staff member
	 * 
	 * @param salary the salary of the staff member
	 */
	public void setSalary(float salary) {

		this.salary = salary;
	}

	/**
	 * @return the salary of the staff member
	 */
	public float getSalary() {

		return salary;
	}

	/**
	 * @return the bonus to be awarded to the staff member
	 */
	abstract public float getBonus();

	/**
	 * @return a flag indicating whether the staff member works full-time.
	 */
	abstract public boolean isFullTime();

	/**
	 * Constructor
	 *
	 * @param name    the name of the staff member
	 * @param address the address of the staff member
	 * @param staffNo the unique staff member number
	 * @param salary  the salary of the staff member
	 */
	StaffMember(String name, String address, int staffNo, float salary) {

		super(name, address);

		this.staffNo = staffNo;
		this.salary = salary;
	}
}
