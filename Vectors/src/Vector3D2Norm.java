/*
 * A class which creates three-dimensional vectors
 */
public class Vector3D2Norm extends Vector3D {

	/*
	 * A constructor inintialising a three-dimensional vector by calling the
	 * constructor of the superclass
	 */
	public Vector3D2Norm(double x, double y, double z) {
		super(x, y, z);
	}

	/*
	 * An implementation of the abstract method magnitude()
	 */
	public double magnitude() {
		return Math.sqrt(this.x * this.x + this.y * this.y + this.z * this.z);
	}
}
