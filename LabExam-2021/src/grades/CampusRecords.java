package grades;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 * Represents all of the students' records
 */
public class CampusRecords {

	/*
	 * Returns the average grade for every taken course
	 */
	public static void printCourseAverages(List<StudentRecord> studentRecords) {
		/*
		 * Both of the maps are used to store the taken courses
		 * and how many times they are taken.
		 */
		Map<Course, Integer> records = new HashMap<Course, Integer>();
		Map<Course, Integer> courseFrequence = new HashMap<Course, Integer>();
		for (StudentRecord sr: studentRecords) {
			for (Course course: sr.getGrades().keySet()) {
				Grade grade = sr.getGrade(course);
				if (records.containsKey(course)) {
					int existingGradeWeight = records.get(course);
					records.put(course, existingGradeWeight + Grade.getTable().get(grade));
					int frequence = courseFrequence.get(course);
					courseFrequence.put(course, frequence + 1);
				}
				else {
					records.put(course, Grade.getTable().get(grade));
					courseFrequence.put(course, 1);
				}
			}
		}
		
		//Prints the average grade for every taken course
		for (Course course: records.keySet()) {
			double grade = records.get(course);
			double frequence = courseFrequence.get(course);
			double averageGrade = grade / frequence;
			System.out.println(course.getName() + ": " + averageGrade);
		}
	}


}
