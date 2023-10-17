import java.util.*;

public class FirstProgram {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.print("Enter maximum: ");
		double max = Double.parseDouble(input.nextLine());
		try {
			System.out.print("Enter exam points: ");
			double points = Double.parseDouble(input.nextLine());
			input.close();
			if (points < 0 || points > max) {
				System.out.println("Invalid exam points");
			} else {
				double score = points / max;
				if (score < 0.5) {
					System.out.println("\nFailed");
				} else if (score < 0.9) {
					System.out.println("\nPassed");
				} else {
					System.out.println("\nExcellent");
				}
			}
		} catch (NumberFormatException nfe) {
			System.out.println("Invalid exam points");
		}
	}
}
