package matrix;

/*
 * A class used only for multiplying one row of a matrix
 * with another matrix. It overrides run() method of class Thread
 * and is used only with multithreading.
 */
public class MatrixRowMultiplier extends Thread {

	private int[] row;
	private int[][] matrix;

	// The resulting row after the multiplication
	private int[] resultRow;

	public MatrixRowMultiplier(int[] row, int[][] matrix) {
		this.row = row;
		this.matrix = matrix;
	}

	/*
	 * A method calculating the final result
	 */
	public void multiplyByRow() {
		this.resultRow = new int[matrix[0].length];
		for (int i = 0; i < matrix[0].length; i++) {
			this.resultRow[i] = MatrixCellMultiplier(this.row, this.matrix, i);
		}
	}

	/*
	 * A method returning the final result
	 */
	public int[] getResult() {
		return this.resultRow;
	}

	/*
	 * A method used for cell calculation
	 */
	private static int MatrixCellMultiplier(int[] matrix1, int[][] matrix2, int indexOfColumn) {
		int sum = 0;
		for (int i = 0; i < matrix1.length; i++) {
			sum += matrix1[i] * matrix2[i][indexOfColumn];
		}
		return sum;
	}

	/*
	 * Overriding run() method of class Thread to calculate only one row of the
	 * result matrix per thread
	 */
	@Override
	public void run() {
		multiplyByRow();
	}

}
