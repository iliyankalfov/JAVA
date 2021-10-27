import java.util.*;

public abstract class Vector3D {

	/* Coordinates of the vector */
	protected double x;
	protected double y;
	protected double z;

	/*
	 * Constructor initialising a vector with given coordinates
	 */
	public Vector3D(double x, double y, double z) {
		this.x = x;
		this.y = y;
		this.z = z;
	}

	/*
	 * An abstract method returning the magnitude of the vector
	 */
	public abstract double magnitude();

	/*
	 * Multiplying a vector by a scalar
	 */
	public void multiply(double scalar) {
		this.x *= scalar;
		this.y *= scalar;
		this.z *= scalar;
	}

	/*
	 * A method which normalizes a vector by checking if it is a zero vector and
	 * then dividing every coordinate by the magnitude
	 */
	public void normalize() {
		if (this.isZero()) {
			throw new ArithmeticException();
		}

		double mag = this.magnitude();

		this.x /= mag;
		this.y /= mag;
		this.z /= mag;
	}

	/*
	 * A method returning the vector as an array with the coordinates
	 */
	public double[] getVector() {
		double[] coordinates = new double[] { this.x, this.y, this.z };
		return coordinates;
	}

	/*
	 * A method which returns true if all of the coordinates of a vector are zeros
	 * and false otherwise
	 */
	public boolean isZero() {

		if ((this.x == 0) && (this.y == 0) && (this.z == 0)) {
			return true;
		} else {
			return false;
		}
	}

	/*
	 * A method which transforms the vector to an array and then returns the array
	 * as a string
	 */
	public String toString() {
		return Arrays.toString(this.getVector());
	}

}
