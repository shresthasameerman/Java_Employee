package shapes;

/**
 * An interface that defines methods to be implemented by shape collection classes.
 * 
 * @author mdixon
 */
public interface ShapeCollection {

	/**
	 * Adds a shape to the collection.
	 * 
	 * @param shape the shape to be added
	 * @return the total number of shapes added to the collection
	 */
	int addShape(Shape shape);

	/**
	 * Removes a shape from the collection.
	 * 
	 * @param shape the shape to be removed
	 * @return true if the shape was found and removed, else false
	 */
	boolean removeShape(Shape shape);

	/**
	 * Checks if the collection contains a given shape.
	 * 
	 * @param shape the shape to be found
	 * @return true if the collection contains the shape, else false
	 */
	boolean containsShape(Shape shape);

	/**
	 * Gets the total number of shapes in the collection.
	 * 
	 * @return the total number of shapes in the collection
	 */
	int shapeCount();

	/**
	 * Removes all shapes from the collection
	 */
	void clearAllShapes();

	/**
	 * Gets index position of a shape within the collection (assuming the collection supports indexed type storage).
	 * 
	 * @param shape the shape for which the index is required
	 * @return the index of the shape, < 0 if the shape is not in the collection
	 * @throws UnsupportedOperationException if the collection does not support index based storage, e.g. if unordered map/set type collections
	 */
	int indexOfShape(Shape shape) throws UnsupportedOperationException;
	
	/**
	 * Gets the shape with the largest area within the collection.
	 * 
	 * Even if a shape's area changes after it is added to the collection, the shape with the largest area should always be returned.
	 * 
	 * @return the shapes with the largest area, null if no shapes exist within the collection.
	 */
	Shape getLargestShape();
	
	/**
	 * Gets the shape with the smallest area within the collection.
	 * 
	 * Even if a shape's area changes after it is added to the collection, the shape with the smallest area should always be returned.
	 * 
	 * @return the shapes with the smallest area, null if no shapes exist within the collection.
	 */
	Shape getSmallestShape();
	
	/**
	 * Counts the number of shapes which have the specified name.
	 * 
	 * If a null value is given for the name, then 0 is always returned.
	 * 
	 * The case of the given name is ignored, e.g. "circle", "CIRCLE" and "Circle" are treated as the same name.
	 * 
	 * @param name the name of the shapes to be counted.
	 * @return the number of shapes within the collection which have the given name.
	 */
	int countShapeOfName(String name);
}
