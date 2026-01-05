package staff_members;

/**
 * A type of {@link StaffMember} which is employed part-time
 * 
 * Edit this file to pass the PART3 tests.
 * 
 */
public class PartTimeEmployee extends StaffMember {

	/**
	 * The minimum hourly rate paid to any part-time employee.
	 */
	public final static float MINIMUM_RATE = 11.62f;

	/**
	 * The current hourly rate of the part-time employee.
	 */
	private float hourlyRate;

	///////////////////////////////////////////////

	@Override
	public float getBonus() {
		// Bonus is 20% of salary plus twice the hourly rate
		return (salary * 0.2f) + (hourlyRate * 2);
	}

	@Override
	public boolean isFullTime() {
		// Part-time employee is not full-time
		return false;
	}

	/**
	 * 
	 * @return the hourly rate of the part-time employee.
	 */
	public float getHourlyRate() {
		return hourlyRate;
	}

	/**
	 * 
	 * @return the minimum hourly rate paid to any part-time employee.
	 */
	public float getMinimumHourlyRate() {
		return MINIMUM_RATE;
	}

	/**
	 * Increments the hourly rate of the part-time employee.
	 * 
	 * If the hourly rate exceeds 10% of their salary, then it is set to be exactly 10% of their salary.
	 * 
	 * @param amount the amount to increment the hourly rate
	 * @return the updated hourly rate
	 */
	public double incHourlyRate(float amount) {
		hourlyRate += amount;
		
		// Cap at 10% of salary
		float maxRate = salary * 0.1f;
		if (hourlyRate > maxRate) {
			hourlyRate = maxRate;
		}
		
		return hourlyRate;
	}

	/**
	 * Decrements the hourly rate of the part-time employee.
	 * 
	 * If the hourly rate drops below {@link #MINIMUM_RATE} then it should remain as the {@link #MINIMUM_RATE}
	 * 
	 * @param amount the amount to increment the hourly rate
	 * @return the updated hourly rate
	 */
	public double decHourlyRate(float amount) {
		hourlyRate -= amount;
		
		// Floor at MINIMUM_RATE
		if (hourlyRate < MINIMUM_RATE) {
			hourlyRate = MINIMUM_RATE;
		}
		
		return hourlyRate;
	}

	/**
	 * Resets the hourly rate back to the default (see constructor comments).
	 */
	public void resetHourlyRate() {
		// Reset to initial value of 12
		hourlyRate = 12;
	}

	/**
	 * Constructor
	 *
	 * A part-time employee has an initial salary of 2000
	 * 
	 * A part-time employee has an initial hourly rate of 12
	 * 
	 * @param name    the name of the employee
	 * @param address the address of the employee
	 * @param staffNo the unique staff member number
	 */
	public PartTimeEmployee(String name, String address, int staffNo) {
		// Pass name, address, staffNo, and salary (2000) to parent
		super(name, address, staffNo, 2000);
		
		// Set hourly rate to 12
		this.hourlyRate = 12;
	}

}