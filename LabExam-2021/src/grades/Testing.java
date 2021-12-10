package grades;

import java.util.ArrayList;
import java.util.List;

public class Testing {

	public static void main(String[] args) {
		Course course1 = new Course("Psych", 3);
		Course course2 = new Course("CompSci", 3);
		Course course3 = new Course("Maths", 4);
		//Course course4 = new Course("Maths", -1);
		
		StudentRecord sr1 = new StudentRecord("12345");
		StudentRecord sr2 = new StudentRecord("54321");
		StudentRecord sr3 = new StudentRecord("11111");
		
		sr1.setGrade(course1, Grade.A);
		sr1.setGrade(course2, Grade.C);
		sr2.setGrade(course1, Grade.B);
		sr3.setGrade(course2, Grade.F);
		sr3.setGrade(course3, Grade.A);
		List<StudentRecord> l = new ArrayList<StudentRecord>();
		l.add(sr1);
		l.add(sr2);
		l.add(sr3);
		
		CampusRecords.printCourseAverages(l);
		
		
	}

}
