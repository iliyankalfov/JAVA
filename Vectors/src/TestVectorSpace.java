public class TestVectorSpace {

	public static void main(String[] args) {
		Vector3D v = new Vector3D2Norm(0, 0, 0);

		// A block throwing an exception if the vector is consisted only of zeros
		try {
			v.normalize();
		} catch (Exception e) {
			System.out.println("Division by zero not allowed");
			e.printStackTrace();
		}

	}

}
