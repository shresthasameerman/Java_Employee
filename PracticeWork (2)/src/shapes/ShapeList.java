package shapes;

import java.util.ArrayList;
import java.util.List;

public class ShapeList implements ShapeCollection {

	private List<Shape> shapes = new ArrayList<>();

	@Override
	public int addShape(Shape shape) {
		shapes.add(shape);
		return shapes.size();
	}

	@Override
	public boolean removeShape(Shape shape) {
		return shapes.remove(shape);
	}

	@Override
	public boolean containsShape(Shape shape) {
		return shapes.contains(shape);
	}

	@Override
	public int shapeCount() {
		return shapes.size();
	}

	@Override
	public void clearAllShapes() {
		shapes.clear();
	}

	@Override
	public int indexOfShape(Shape shape) {
		return shapes.indexOf(shape);
	}

	@Override
	public Shape getLargestShape() {

		if (shapes.isEmpty()) {
			return null;
		}

		Shape largest = shapes.get(0);
		double maxArea = largest.getArea();

		for (Shape s : shapes) {
			if (s.getArea() > maxArea) {
				maxArea = s.getArea();
				largest = s;
			}
		}
		return largest;
	}

	@Override
	public Shape getSmallestShape() {

		if (shapes.isEmpty()) {
			return null;
		}

		Shape smallest = shapes.get(0);
		double minArea = smallest.getArea();

		for (Shape s : shapes) {
			if (s.getArea() < minArea) {
				minArea = s.getArea();
				smallest = s;
			}
		}
		return smallest;
	}

	@Override
	public int countShapeOfName(String name) {
	    if (name == null || name.isEmpty()) return 0;

	    int count = 0;
	    for (Shape s : shapes) {
	        if (s.getName().equalsIgnoreCase(name)) {
	            count++;
	        }
	    }
	    return count;
	}

}
