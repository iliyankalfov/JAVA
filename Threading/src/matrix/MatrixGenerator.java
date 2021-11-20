package matrix;

import java.util.Random;

/*
 * A class which generates a matrix and prints a matrix
 */
public class MatrixGenerator {

	/*
	 * Generates a matrix with given dimensions
	 */
	public static int[][] generateMatrix(int rows, int columns) {
		Random rand = new Random();
		int upperBound = 10;
		int[][] matrix = new int[rows][columns];

		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < columns; j++) {
				// Every entry of the matrix is a number from 0 to 9(inclusive)
				int randInt = rand.nextInt(upperBound);
				matrix[i][j] = randInt;
			}
		}
		return matrix;

	}

	/*
	 * Prints the matrix
	 */
	public static void printMatrix(int[][] matrix) {
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[i].length; j++) {
				System.out.print(matrix[i][j] + " ");
			}
			System.out.println();
		}
	}

}
