import java.util.Scanner;

public class SortedGradebookDriver {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);

		Student[] students = new Student[5];

		System.out
				.println("==================================================");
		System.out
				.println("|                Sorted Gradebook                |");
		System.out
				.println("==================================================");

		for (int i = 0; i < 5; ++i) {
			String firstName, lastName;
			int grade;

			System.out.print("Please enter student #" + (i + 1)
					+ "'s first name: ");
			firstName = scan.next();

			System.out.print("Please enter student #" + (i + 1)
					+ "'s last name: ");
			lastName = scan.next();

			System.out.print("Please enter student #" + (i + 1)
					+ "'s test grade: ");
			grade = scan.nextInt();

			System.out.println();

			students[i] = new Student(firstName, lastName, grade);
		}

		Sorting.selectionSort(students);

		System.out
				.println("\n---------------- Sorted Gradebook ----------------");

		for (int j = 0; j < 5; ++j) {
			System.out.println(students[5 - (j + 1)]);
		}
	}
}
