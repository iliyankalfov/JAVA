package matrix;

import java.lang.*;

/*
 * A class used for testing the efficiency of using multiple threads
 */
public class TestMatrixMultiply {

	public static void main(String[] args) {

		// Setting the start time of the program
		long start = System.currentTimeMillis();

		MatrixGenerator mGenerator = new MatrixGenerator();
		int[][] matrix1 = mGenerator.generateMatrix(1000, 1020);
		int[][] matrix2 = mGenerator.generateMatrix(1020, 1000);

		MatrixMultiplication matrixMultiplicator = new MatrixMultiplication();

		int[][] matrixResult = matrixMultiplicator.matrixMultiply(matrix1, matrix2);

		System.out.println("Time taken with a single thread: " + (System.currentTimeMillis() - start));

		// Setting the time after the first matrix calculation is done.
		long currentStart = System.currentTimeMillis();

		int[][] matrixResult2 = matrixMultiplicator.parallelMatrixMultiply(matrix1, matrix2);

		System.out.println("Time taken with multiple threads: " + (System.currentTimeMillis() - currentStart));
	}

}
