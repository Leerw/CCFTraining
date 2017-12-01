import java.util.Scanner;

public class ISBN {
	public static void main(String[] args) {
		new ISBN().run();
	}

	public void run() {
		Scanner scanner = new Scanner(System.in);
		String isbnNumber = new String(scanner.nextLine());
		scanner.close();
		int result = 0;
		int counter = 0;
		for (int i = 0; i < 11; i++) {
			if (isbnNumber.charAt(i) != '-') {
				++counter;
				result += counter * (Integer.parseInt(String.valueOf(isbnNumber.charAt(i))));
			}
		}
		result = result % 11;
		if (result == 10 && isbnNumber.charAt(isbnNumber.length() - 1) == 'X')
			System.out.println("Right");
		else if (result == Integer.parseInt(String.valueOf((isbnNumber.charAt(isbnNumber.length() - 1)))))
			System.out.println("Right");
		else {
			System.out.print(isbnNumber.substring(0, 12));
			System.out.print((result == 10) ? 'X' : ((Integer.parseInt(String.valueOf(result)))));
		}
	}
}
