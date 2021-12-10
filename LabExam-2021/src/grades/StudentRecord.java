package grades;

import java.util.HashMap;
import java.util.Map;

/*
 * Represents a record with the grades for a single student
 */
public class StudentRecord {

	private String studentID;
	
	// A property which keeps the course and their grades
	private Map<Course, Grade> grades;
	
	public StudentRecord(String studentID) {
		this.studentID = studentID;
		this.grades = new HashMap<Course, Grade>();
	}

	// Returns the id of the student
	public String getStudentId() {
		return this.studentID;
	}
	
	// Sets the grade for a new course
	public void setGrade(Course course, Grade grade) {
		this.grades.put(course,grade);
	}
	
	// Returns the grade for a course
	public Grade getGrade (Course course) {
		Grade grade = this.grades.getOrDefault(course, null);
		return grade;
	}
	
	// Returns the courses and their grades. This method is used only for printing the
	// average course grades.
	public Map<Course, Grade> getGrades() {
		return this.grades;
	}
	
	// Removes a course and its grade if it exists
	public void removeGrade (Course course) {
		if (this.grades.containsKey(course)) {
			this.grades.remove(course);
		}
	}
	
	// Computes the GPA for the student
	public double computeGPA() {
		double GPA = 0;
		int creditWeight = 0;
		
		if (this.grades.size() == 0) {
			return 0.0;
		}
		
		for (Course course: this.grades.keySet()) {
			Grade grade = getGrade(course);
			
			// Gets the weight of the grade
			int gradeCredits = Grade.getTable().get(grade);
			GPA += course.getCredits() * gradeCredits;
			creditWeight += course.getCredits();
		}
		return GPA/creditWeight;
	}
	
	/*
	 *  Updates the grade of a course if it exists.
	 *  Only stored grades which are less than C and the new grade can be changed
	 */
	public void updateGrade (Course course, Grade grade) {
		if (!this.grades.containsKey(course)) {
			setGrade(course, grade);
		}
		else {
			Grade storedGrade = getGrade(course);
			int storedGradeWeight = Grade.getTable().get(storedGrade);
			int gradeWeight = Grade.getTable().get(grade);
			int gradeCWeight = Grade.getTable().get(Grade.C);
			
			if ((storedGradeWeight < gradeCWeight) && 
				(gradeWeight > storedGradeWeight)) {
				
				setGrade(course, Grade.C);
			}
		}
	}
}
