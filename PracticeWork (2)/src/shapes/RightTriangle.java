package shapes;

/**
 * A kind of shape that represents a right angle triangle (orthogonal triangle) 
 * in which two sides are perpendicular, and one angle is always 90 degrees.
 * 
 * The length of the third side (Hypotenuse) is not stored, since this can be 
 * calculated using Pythagoras' theorem. i.e. sideC² = (sideA² + sideB²)
 * 
 * @author mdixon
 */
public class RightTriangle extends Shape {

    /**
     * Length of side A, always positive.
     */
    private int sideA;

    /**
     * Length of side B, always positive.
     */
    private int sideB;

    ///////////////////////////////////////////////////////////////////////

    @Override
    public double getArea() {
        // Area of a right triangle = 1/2 * base * height
        return 0.5 * sideA * sideB;
    }

    @Override
    public double getPerimeter() {
        // Perimeter = sideA + sideB + hypotenuse
        return sideA + sideB + getSideC();
    }

    /**
     * Gets the length of side A
     * 
     * @return the length of side A
     */
    public int getSideA() {
        return sideA;
    }

    /**
     * Gets the length of side B
     * 
     * @return the length of side B
     */
    public int getSideB() {
        return sideB;
    }

    /**
     * Gets the length of the Hypotenuse (as an integer) using √(sideA² + sideB²).
     * 
     * @return the length of side C (the Hypotenuse) as an integer
     */
    public int getSideC() {
        return (int) Math.sqrt(sideA * sideA + sideB * sideB);
    }

    /**
     * Tests if the triangle is isosceles (has two equal length sides)
     * 
     * @return true if the triangle is isosceles, else false.
     */
    public boolean isIsosceles() {
        return sideA == sideB || sideA == getSideC() || sideB == getSideC();
    }

    /**
     * Scales the size of the triangle by multiplying each side by the given value.
     * 
     * @param multiplier the value to be used to scale the sides of the triangle.
     */
    public void expand(int multiplier) {
        sideA *= multiplier;
        sideB *= multiplier;
    }

    /**
     * Scales the size of the triangle by dividing each side by the given value.
     * 
     * @param divisor the value to be used to scale the sides of the triangle.
     */
    public void contract(int divisor) {
        if (divisor != 0) {
            sideA /= divisor;
            sideB /= divisor;
        }
    }

    ///////////////////////////////////////////////////////////////////////

    /**
     * Constructor that creates a right angle triangle with sides equal to 3, 4 and 5.
     * 
     * @param colour the colour of the triangle
     */
    public RightTriangle(String colour) {
        super(3, "Triangle", colour); // 3 sides, name, colour
        this.sideA = 3;
        this.sideB = 4;
    }

    /**
     * Constructor that creates a right angle triangle with each side set to a given value.
     * 
     * note: Any negative values are converted to be absolute positive values.
     *
     * @param colour the colour of the triangle.
     * @param a      length of side A
     * @param b      length of side B
     */
    public RightTriangle(String colour, int a, int b) {
        super(3, "Triangle", colour);
        this.sideA = Math.abs(a);
        this.sideB = Math.abs(b);
    }
}