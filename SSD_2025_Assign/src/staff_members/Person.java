package staff_members;

/**
 * An abstract person class.
 * 
 * @author mdixon
 */
abstract class Person {

	/**
	 * The name of the person.
	 */
	final private String name;

	/**
	 * The address of the person.
	 */
	final private String address;

	///////////////////////////////////////////////////////////////////////

	/**
	 * @return the name of the person
	 */
	public String getName() {

		return name;
	}

	/**
	 * @return the address of the person
	 */
	public String getAddress() {

		return address;
	}

	///////////////////////////////////////////////////////////////////////

	/**
	 * Constructor
	 * 
	 * @param name    the name of the person
	 * @param address the address of the person
	 */
	Person(String name, String address) {

		this.name = name;
		this.address = address;
	}
}
