import java.util.Arrays;
import java.util.Scanner;

public class russiaBlock {
	public static void main(String[] args) {
		new russiaBlock().run();
	}

	public void run() {
		Scanner scanner = new Scanner(System.in);
		boolean[][] board = new boolean[16][10];
		boolean[][] block = new boolean[4][4];
		int[] rows = new int[4];
		int[] columns = new int[4];
		int index = -1;
		Arrays.fill(board[15], true);
		// 接受输入
		for (int i = 0; i < 15; i++) {
			String[] line = scanner.nextLine().split(" ");
			for (int j = 0; j < 10; j++) {
				if (line[j].equals("1")) { // 教训：这里不可以用line[j] == "1"，因为==指的是同一个对象，而equals则是真正的值相等
					board[i][j] = true;
				} else {
					board[i][j] = false;
				}
			}
		}
		for (int i = 0; i < 4; i++) {
			String[] blockline = scanner.nextLine().split(" ");
			for (int j = 0; j < 4; j++) {
				if (blockline[j].equals("1")) {
					block[i][j] = true;
				} else {
					block[i][j] = false;
				}
			}
		}
		index = scanner.nextInt();
		scanner.close();
		int k = 0;
		for (int i = 3; i >= 0; i--) {
			for (int j = 0; j < 4; j++) {
				if (block[i][j] == true) {
					rows[k] = i;
					columns[k] = j;
					k++;
				}
			}
		}
		// 模拟下降
		int row = 0;
		int col = index - 1;
		while (true) {
			boolean flag = false;
			for (int i = 0; i < 4; i++) {
				if (board[rows[i] + row][columns[i] + col] == true) {
					flag = true;
				}
			}
			if (flag == true) {
				break;
			}
			++row;
		}
		--row;
		for (int i = 0; i < 4; i++) {
			board[rows[i] + row][columns[i] + col] = true;
		}
		// 输出
		for (int i = 0; i < 15; i++) {
			for (int j = 0; j < 10; j++) {
				if (j != 0)
					System.out.print(" ");
				System.out.print(board[i][j] == true ? 1 : 0);
			}
			System.out.println();
		}
	}
}
