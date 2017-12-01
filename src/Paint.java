import java.util.Arrays;
import java.util.Scanner;

public class Paint {
	public static void main(String[] args) {
		new Paint().run();
	}

	public void run() {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		boolean[][] board = new boolean[101][101];
		for (int i = 0; i < n; i++) {
			Arrays.fill(board[i], false);
		}
		int counter = 0;
		for (int line = 0; line < n; line++) {
			// Read every line of data
			int x_low = scanner.nextInt();
			int y_low = scanner.nextInt();
			int x_high = scanner.nextInt();
			int y_high = scanner.nextInt();
			for (int x = x_low; x < x_high; x++) {
				for (int y = y_low; y < y_high; y++) {
					if (board[x][y] == false) {
						// This element have not been filled
						board[x][y] = true;
						++counter;
					}
				}
			}
		}
		scanner.close();
		System.out.print(counter);
	}
}
