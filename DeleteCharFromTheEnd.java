import java.util.*;

public class DeleteCharFromTheEnd {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.print("Enter a string: ");
		String text = input.nextLine();
		input.close();
		text = text.replaceAll("\\s", "");
		if (text.length() == 0) {
			System.out.println("No input");
		} else {
			int x = text.length();
			for (int i = 0; i < text.length(); i++) {
				System.out.println(text.substring(0, x));
				x--;
			}
		}
	}
}
