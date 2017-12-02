import java.util.Arrays;
import java.util.Scanner;

public class PaintASCII {
	public static void main(String[] args) {
		new PaintASCII().run();
	}

	public void run() {
		Scanner scanner = new Scanner(System.in);
		int m = scanner.nextInt();
		int n = scanner.nextInt();
		int q = scanner.nextInt();
		char[][] board = new char[n][m];
		for (int i = 0; i < n; i++) {
			Arrays.fill(board[i], '.');
		}
		scanner.nextLine();
		for (int i = 0; i < q; i++) {
			String line = scanner.nextLine();
			String[] values = line.split(" ");
			if (line.charAt(0) == '0') {
				// 画线段，横线y坐标相等，画‘-’
				int x1 = Integer.parseInt(values[1]);
				int y1 = Integer.parseInt(values[2]);
				int x2 = Integer.parseInt(values[3]);
				int y2 = Integer.parseInt(values[4]);
				if (y1 == y2) {
					// 画横线
					int x_low = (x1 > x2) ? x2 : x1;
					int x_high = (x_low == x1) ? x2 : x1;
					int index = x_low;
					while (index <= x_high) {
						if (board[y1][index] == '|') {
							board[y1][index] = '+';
						} else {
							board[y1][index] = '-';
						}
						++index;
					}
				}
				if (x1 == x2) {
					// 画竖线
					int y_low = (y1 > y2) ? y2 : y1;
					int y_high = (y_low == y1) ? y2 : y1;
					int index = y_low;
					while (index <= y_high) {
						if (board[index][x1] == '-') {
							board[index][x1] = '+';
						} else {
							board[index][x1] = '|';
						}
						++index;
					}
				}
			}
			if (line.charAt(0) == '1') {
				// 填充
				int start_x = Integer.parseInt(values[1]);
				int start_y = Integer.parseInt(values[2]);
				char fillChar = line.charAt(line.length() - 1);
				fill(start_x, start_y, fillChar, m, n, board);
			}
		}
		scanner.close();
		// 输出
		for (int i = n - 1; i >= 0; i--) {
			for (int j = 0; j < m; j++) {
				if (j != 0)
					System.out.print(" ");
				System.out.print(board[i][j]);
			}
			System.out.println();
		}
	}

	public static void fill(int x, int y, char c, int m, int n, char[][] board) {
		int nx, ny;
		board[y][x] = c;
		int[] directx = { -1, 1, 0, 0 };
		int[] directy = { 0, 0, -1, 1 };
		for (int i = 0; i < 4; i++) {
			nx = x + directx[i];
			ny = y + directy[i];
			if (0 <= nx && nx < m && 0 <= ny && ny < n && board[ny][nx] != '|' && board[ny][nx] != '-'
					&& board[ny][nx] != '+' && board[ny][nx] != c) {
				fill(nx, ny, c, m, n, board);
			}
		}
	}
}
