public class VectorSpace3D2Norm implements VectorSpace {

	public VectorSpace3D2Norm() {
	}

	/*
	 * A method adding two vectors by returning a new vector
	 */
	public Vector3D add(Vector3D v1, Vector3D v2) {
		double[] v1Array = v1.getVector();
		double[] v2Array = v2.getVector();

		double[] resultArray = new double[v1Array.length];

		for (int i = 0; i < resultArray.length; i++) {
			resultArray[i] = v1Array[i] + v2Array[i];
		}

		double x = resultArray[0];
		double y = resultArray[1];
		double z = resultArray[2];

		return new Vector3D2Norm(x, y, z);
	}

	/*
	 * A method which returns the scalar product of two vectors
	 */
	public double scalarProduct(Vector3D v1, Vector3D v2) {
		double[] v1Array = v1.getVector();
		double[] v2Array = v2.getVector();

		double sum = 0;

		for (int i = 0; i < v1Array.length; i++) {
			sum += v1Array[i] * v2Array[i];
		}

		return sum;
	}

	/*
	 * A method which returns the distance between two vectors
	 */
	public double distance(Vector3D v1, Vector3D v2) {
		double[] v1Array = v1.getVector();
		double[] v2Array = v2.getVector();

		double[] resultArray = new double[v1Array.length];

		for (int i = 0; i < resultArray.length; i++) {
			resultArray[i] = v2Array[i] - v1Array[i];
		}

		double x = resultArray[0];
		double y = resultArray[1];
		double z = resultArray[2];

		Vector3D2Norm resultVector = new Vector3D2Norm(x, y, z);

		return resultVector.magnitude();

	}
}
