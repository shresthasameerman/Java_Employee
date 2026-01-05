package staff_members;

/**
 * A type of {@link StaffMember} which is a director of the company
 * 
 * Edit this file to pass the PART2 tests.
 * 
 */
public class CompanyDirector extends StaffMember {

	/**
	 * The number of shares owned by a director
	 */
	private int shares;

	/**
	 * Flag indicating whether the director works full-time.
	 */
	private boolean isFullTime;

	/**
	 * Flag indicating whether the director also owns part of the company.
	 */
	private boolean isOwner = true;

	////////////////////////////////////////////////////////////

	@Override
	public float getBonus() {
		// Bonus is three times the salary for a director
		return salary * 3;
	}

	@Override
	public boolean isFullTime() {
		return isFullTime;
	}

	/**
	 * 
	 * @return flag indicating whether the director also owns part of the company.
	 */
	public boolean isOwner() {
		return isOwner;
	}

	/**
	 * @param isOwner a flag indicating whether the director also owns part of the company.
	 */
	public void setOwnership(boolean isOwner) {
		this.isOwner = isOwner;
	}

	/**
	 * Sets the director to be full-time
	 */
	public void setFullTime() {
		this.isFullTime = true;
	}

	/**
	 * Sets the director to be part-time
	 */
	public void setPartTime() {
		this.isFullTime = false;
	}

	/**
	 * @return the number of shares owned by a director
	 */
	public int getShares() {
		return shares;
	}

	/**
	 * Doubles the amount of share owned by the director
	 * 
	 * @return the number of shares owned by a director (once doubled)
	 */
	public int doubleShares() {
		shares = shares * 2;
		return shares;
	}

	/**
	 * Halves the amount of share owned by the director
	 * 
	 * If the director is an owner, then the number of shares should NOT be changed.
	 * 
	 * @return the number of shares owned by a director (once updated as required)
	 */
	public int halfShares() {
		// Only halve if NOT an owner
		if (!isOwner) {
			shares = shares / 2;
		}
		return shares;
	}

	/**
	 * Constructor
	 *
	 * A director has an initial salary of 100000
	 * 
	 * A director initially owns 20 shares.
	 * 
	 * A director is initially set on as a full-time employee.
	 * 
	 * A director is initially set to NOT be an owner.
	 * 
	 * @param name    the name of the director
	 * @param address the address of the director
	 * @param staffNo the unique staff member number
	 */
	public CompanyDirector(String name, String address, int staffNo) {
		// Pass name, address, staffNo, and salary (100000) to parent
		super(name, address, staffNo, 100000);
		
		// Set shares to 20
		this.shares = 20;
		
		// Set full-time to true
		this.isFullTime = true;
		
		// Set owner to false
		this.isOwner = false;
	}
}