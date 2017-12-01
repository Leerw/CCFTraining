import java.util.Scanner;

public class xiaochu {
	public static void main(String[] args) {
		new xiaochu().run();
	}

	public void run() {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		int m = scanner.nextInt();
		int[][] board = new int[n][m];
		int temp;
		// ��������
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				temp = scanner.nextInt();
				board[i][j] = temp;
			}
		}
		// �н��б��(������������Ϊ��)
		scanner.close();
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m - 2; j++) {
				if (Math.abs(board[i][j]) == Math.abs(board[i][j + 1])
						&& Math.abs(board[i][j + 1]) == Math.abs(board[i][j + 2])) {
					if (board[i][j] > 0) {
						board[i][j] = -board[i][j];
					}
					if (board[i][j + 1] > 0) {
						board[i][j + 1] = -board[i][j + 1];
					}
					if (board[i][j + 2] > 0) {
						board[i][j + 2] = -board[i][j + 2];
					}
				}
			}
		}
		// �н��б��
		for (int j = 0; j < m; j++) {
			for (int i = 0; i < n - 2; i++) {
				if (Math.abs(board[i][j]) == Math.abs(board[i + 1][j])
						&& Math.abs(board[i + 1][j]) == Math.abs(board[i + 2][j])) {
					if (board[i][j] > 0) {
						board[i][j] = -board[i][j];
					}
					if (board[i + 1][j] > 0) {
						board[i + 1][j] = -board[i + 1][j];
					}
					if (board[i + 2][j] > 0) {
						board[i + 2][j] = -board[i + 2][j];
					}
				}
			}
		}
		// ��������
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (board[i][j] < 0) {
					board[i][j] = 0;
				}
				if (j != 0) {
					System.out.print(" ");
				}
				System.out.print(board[i][j]);
			}
			System.out.println();
		}
	}
}
