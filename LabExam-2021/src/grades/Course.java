package grades;

import java.util.Objects;

/*
 * Represents a single course with a name and a number of credits.
 */
public class Course {
	private String name;
	private int credits;
	
	// If the number of credits is negative, it throws an exception
	public Course(String name, int credits) {
		this.name = name;
		this.credits = credits;
		if (this.credits < 0) {
			throw new IllegalArgumentException("The credits must be a positive integer!");
		}
	}

	public String getName() {
		return name;
	}

	public int getCredits() {
		return credits;
	}

	@Override
	public int hashCode() {
		return Objects.hash(credits, name);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Course other = (Course) obj;
		return credits == other.credits && Objects.equals(name, other.name);
	}

	public String toString() {
		return this.name + " is " + this.credits + " credits";
	}
	
	

}
