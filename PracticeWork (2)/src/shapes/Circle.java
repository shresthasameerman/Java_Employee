package shapes;

/**
 * A kind of shape that represents a circle.
 * 
 * For calculations, this uses the constant {@link Math#PI} as an approximation of the value for π
 * 
 * @author mdixon
 */
public class Circle extends Shape {

	/**
	 * The radius of the circle.
	 */
	private int radius;
	

	///////////////////////////////////////////////////////////////////////

	@Override
	public double getArea() {
		
		// TODO PART2 : calculate and return the area using Area = π x r²
		// hint: Use Math.PI in the calculation
		double area= Math.PI*radius*radius;
		
		
		return area;
	}
	
	@Override
	public double getPerimeter() {
		
		// TODO PART2 : calculate and return the perimeter using Perimeter = 2 x π x r
		double perimeter = 2*Math.PI*radius;
		return perimeter;
	}
		
	/**
	 * Gets the volume of the circle as if it was a spherical shape with the same radius.
	 * 
	 * @return the volume of a sphere with the same radius as the circle.
	 */
	public double getVolume() {
		
		// TODO PART2 : calculate and return the volume using Volume = 4/3 x π x r³
		double volume = (4.0/3.0) * Math.PI * Math.pow(radius, 3);

		return volume;
	}
	
	/**
	 * @return the radius
	 */
	public int getRadius() {
		
		// TODO PART2 : return the radius
		
		return radius;
	}

	/**
	 * @param radius the radius to set
	 */
	public void setRadius(int radius) {
		
		// TODO PART2 : set the radius
		this.radius=radius;
	}
	
	/**
	 * Tests if the circle has an area larger than the one provided.
	 * 
	 * @param area the area to compare against the circle's area
	 * @return true if the circle has an area that is greater than the given area, else false.
	 */
	public boolean hasLargerArea(int area) {
		
		// TODO PART2 : return true if the circle's area is larger than the one provided
		return getArea()>area;
	}
	
	/**
	 * Tests if the circle has an area smaller than the one provided.
	 * 
	 * @param area the area to compare against the circle's area
	 * @return true if the circle has an area that is less than the given area, else false.
	 */
	public boolean hasSmallerArea(int area) {
		
		// TODO PART2 : return true if the circle's area is smaller than the one provided
		return getArea()<area;
	}
	
	///////////////////////////////////////////////////////////////////////
	// Constructors should always set the shape name to "Circle"
	
	/**
	 * Constructor
	 * 
	 * @param colour the colour of the circle
	 * @param radius the radius of the circle
	 */
	public Circle(String colour, int radius) {
		
		// TODO PART2 : pass the correct number of sides, and shape name to the super() type constructor.
		super(1, "Circle", colour);
		
		// TODO PART2 : set the radius attribute to the given value
		this.radius =radius;
	}

	/**
	 * Constructor
	 * 
	 * Creates a circle with a default radius of 10.
	 *  
	 * @param colour the colour of the circle
	 */
	public Circle(String colour) {
		
		// TODO PART2 : pass the correct number of sides, and shape name to the super() type constructor.
		super(1, "Circle", colour);
		this.radius=10;
		// TODO PART2 : set the radius attribute to the default value specified in the javadoc comment of the method.
	}
	
	/**
	 * Default Constructor
	 * 
	 * Creates a "RED" circle with a default radius of 1.  
	 */
	public Circle() {
		
		// TODO PART2 : pass the correct number of sides, shape name and default colour (see above javadoc comment) to the super() type constructor.
		super(1, "Circle", "RED");
		
		this.radius=1;
		// TODO PART2 : set the radius attribute to the default value specified in the javadoc comment of the method.
	}
	
}
