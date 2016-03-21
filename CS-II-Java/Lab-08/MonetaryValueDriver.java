import java.util.InputMismatchException;
import java.util.Scanner;

public class MonetaryValueDriver {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);

		double inputValue;

		String sentinel = "";

		do {
			inputValue = 0.0;

			System.out.print("Please enter a monetary value ($x.xx): $");

			try {
				inputValue = scan.nextDouble();

				Money money = new Money(inputValue);

				money.calculateChange();

				System.out.println("\n" + money);
			} catch (InputMismatchException exception) {
				System.err.println("\nEXCEPTION: Invalid input");
				System.out.println();
			}

			System.out
					.print("Please press Enter to continue or enter Quit to quit: ");
			scan.nextLine();
			sentinel = scan.nextLine();
			sentinel = sentinel.toUpperCase();

			System.out.println();
		} while (!"QUIT".equals(sentinel));
	}
}
