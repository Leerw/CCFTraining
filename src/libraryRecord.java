import java.util.Scanner;

public class libraryRecord {
	public static void main(String[] args) {
		new libraryRecord().run();
	}

	public void run() {
		int n = 0;
		Scanner scanner = new Scanner(System.in);
		n = scanner.nextInt();
		int[] readers = new int[n];
		for (int i = 0; i < n; i++) {
			readers[i] = 0;
		}
		for (int i = 0; i < n; i++) {
			int reader = scanner.nextInt();
			if (readers[reader] == 0) {
				System.out.print(1);
				System.out.print(" ");
				++readers[reader];
			} else {
				++readers[reader];
				System.out.print(readers[reader]);
				System.out.print(" ");
			}
		}
		scanner.close();
	}
}
