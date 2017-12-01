import java.util.Scanner;

public class rotateImage {
	public static void main(String[] args) {
		new rotateImage().run();
	}

	public void run() {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();// 2
		int m = scanner.nextInt();// 3
		int[][] image = new int[n][m];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				image[i][j] = scanner.nextInt();
			}
		}
		for (int i = 1; i <= m; i++) {
			for (int j = 0; j < n; j++) {
				// (0,2) -> (0,0) (1,2) -> (0,1)
				System.out.print(image[j][m - i]);
				System.out.print(" ");
			}
			System.out.println();
		}
	}
}
