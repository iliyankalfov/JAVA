public interface VectorSpace {

	/*
	 * A method which adds two vectors
	 */
	Vector3D add(Vector3D v1, Vector3D v2);

	/*
	 * A method which returns the scalar product of two vectors
	 */
	double scalarProduct(Vector3D v1, Vector3D v2);

	/*
	 * A method which returns the distance between two vectors
	 */
	double distance(Vector3D v1, Vector3D v2);

}
