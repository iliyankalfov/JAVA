package matrix;

/*
 * A class which executes the matrix multiplication
 */
public class MatrixMultiplication {

	/*
	 * Single-threaded matrix multiplication
	 */
	public static int[][] matrixMultiply(int[][] matrix1, int[][] matrix2) {

		int[][] matrixToReturn = new int[matrix1.length][matrix2[0].length];

		// If the matrices are not well-defined, the program exits with failure
		if (matrix1[0].length != matrix2.length) {
			System.out.println("The matrices are not well defined and cannot be multiplied!");
			System.exit(1);
		}

		for (int i = 0; i < matrixToReturn.length; i++) {
			for (int j = 0; j < matrixToReturn[i].length; j++) {
				matrixToReturn[i][j] = MatrixCellMultiplier(matrix1[i], matrix2, j);
			}
		}

		return matrixToReturn;
	}

	/*
	 * A method used for cell calculation which receives a given row of the first
	 * matrix, the whole second matrix and the index of the column to be multiplied
	 * from the second matrix
	 */
	private static int MatrixCellMultiplier(int[] matrix1, int[][] matrix2, int indexOfColumn) {
		int sum = 0;
		for (int i = 0; i < matrix1.length; i++) {
			sum += matrix1[i] * matrix2[i][indexOfColumn];
		}
		return sum;
	}

	/*
	 * Matrix multiplication with multiple threads
	 */
	public static int[][] parallelMatrixMultiply(int[][] matrix1, int[][] matrix2) {
		// A thread array instantiated with thread objects
		Thread[] threads = new Thread[matrix1.length];

		int[][] matrixToReturn = new int[matrix1.length][matrix2[0].length];
		MatrixRowMultiplier[] mm = new MatrixRowMultiplier[matrix1.length];

		for (int i = 0; i < matrix1.length; i++) {
			MatrixRowMultiplier m = new MatrixRowMultiplier(matrix1[i], matrix2);
			threads[i] = new Thread(m);
			// Running the thread
			threads[i].start();

			mm[i] = m;
		}

		for (int k = 0; k < threads.length; k++) {
			// joining all of the threads and returning the result from every thread
			try {
				threads[k].join();
			} catch (InterruptedException ex) {
				ex.printStackTrace();
			}
			matrixToReturn[k] = mm[k].getResult();
		}
		return matrixToReturn;
	}

}
