import java.util.Scanner;

public class ZScan {
	public static void main(String[] args) {
		new ZScan().run();
	}

	public void run() {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		int[][] matrix = new int[n][n];
		int[] result = new int[n];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				matrix[i][j] = scanner.nextInt();
			}
		}
		final int EAST = 0;
		final int SOUTH = 1;
		final int SOUTHWEST = 2;
		final int NORTHEAST = 3;
		int[] x = { 0, 1, 1, -1 };
		int[] y = { 1, 0, -1, 1 };
		int row = 0;
		int col = 0;
		int next = EAST;
		System.out.print(matrix[row][col]);
		while (row != n - 1 || col != n - 1) {
			row += x[next];
			col += y[next];
			System.out.print(" " + matrix[row][col]);

			if (next == EAST && row == 0)
				next = SOUTHWEST;
			else if (next == EAST && row == n - 1)
				next = NORTHEAST;
			else if (next == SOUTH && col == 0)
				next = NORTHEAST;
			else if (next == SOUTH && col == n - 1)
				next = SOUTHWEST;
			else if (next == SOUTHWEST && row == n - 1)
				next = EAST;
			else if (next == SOUTHWEST && col == 0)
				next = SOUTH;
			else if (next == NORTHEAST && col == n - 1)
				next = SOUTH;
			else if (next == NORTHEAST && row == 0)
				next = EAST;
		}
		System.out.println();
	}
}
