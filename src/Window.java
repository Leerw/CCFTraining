import java.util.Arrays;
import java.util.Scanner;

public class Window {
	public static void main(String[] args) {
		new Window().run();
	}

	public void run() {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		int m = scanner.nextInt();
		int[][] location = new int[n][4];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < 4; j++) {
				location[i][j] = scanner.nextInt();
			}
		}
		int[] flag = new int[m];
		int[] order = new int[n];
		for (int i = 0; i < n; i++)
			order[i] = n - i - 1;
		Arrays.fill(flag, -1);
		for (int i = 0; i < m; i++) {
			int x = scanner.nextInt();
			int y = scanner.nextInt();
			for (int windowId = 0; windowId < n; windowId++) {
				if (x >= location[order[windowId]][0] && x <= location[order[windowId]][2]
						&& y >= location[order[windowId]][1] && y <= location[order[windowId]][3]) {
					flag[i] = order[windowId];
					if (windowId >= 1) {
						int temp = order[windowId];
						for (int index = windowId; index >= 1; index--) {
							order[index] = order[index - 1];
						}
						order[0] = temp;
					}
					break;
				}
			}
		}
		scanner.close();
		for (int i : flag) {
			if (i != -1) {
				System.out.println(i + 1);
			} else {
				System.out.println("IGNORED");
			}
		}
	}
}
