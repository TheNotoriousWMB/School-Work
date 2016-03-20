public class Student implements Comparable {
	private String firstName;
	private String lastName;
	private int grade;

	public Student(String firstName, String lastName, int grade) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.grade = grade;
	}

	public String toString() {
		return (grade + "\t" + lastName + ", " + firstName);
	}

	public boolean equals(Object other) {
		return (lastName.equals(((Student) other).getLastName()) && firstName
				.equals(((Student) other).getFirstName()));
	}

	@Override
	public int compareTo(Object other) {
		int result;

		String otherFirst = ((Student) other).getFirstName();
		String otherLast = ((Student) other).getLastName();
		int otherGrade = ((Student) other).getGrade();

		if (grade == otherGrade) {
			if (lastName.equals(otherLast)) {
				result = firstName.compareTo(otherFirst);
			} else {
				result = lastName.compareTo(otherLast);
			}
		} else {
			result = (grade - otherGrade);
		}

		return result;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public int getGrade() {
		return grade;
	}

	public void setGrade(int grade) {
		this.grade = grade;
	}
}
