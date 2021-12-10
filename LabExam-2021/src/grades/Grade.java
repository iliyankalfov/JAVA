package grades;

import java.util.HashMap;
import java.util.Map;

/*
 * Enum class Grade, which provides grades and creates a grade table
 * with the weight of every single grade
 */
public enum Grade {
	A, B, C, D, F;
	
	// Static property for the grade table
	private static Map<Grade, Integer> gpaTable = new HashMap<Grade, Integer>();
	
	// Creates the grade table
	private static void produceGPATable() {
		Grade.gpaTable.put(Grade.A, 4);
		Grade.gpaTable.put(Grade.B, 3);
		Grade.gpaTable.put(Grade.C, 2);
		Grade.gpaTable.put(Grade.D, 1);
		Grade.gpaTable.put(Grade.F, 0);
	}
	
	// Returns the grade table
	public static Map<Grade, Integer> getTable() {
		Grade.produceGPATable();
		return Grade.gpaTable;
	}
}
