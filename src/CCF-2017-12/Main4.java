package leerw;

import java.util.Arrays;
import java.util.Scanner;

public class Main4 {
	public static void main(String[] args) {
		new Main4().run();
	}
	public void run() {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		int m = scanner.nextInt();
		int[][] matrix = new int[n][n];
		for (int i = 0; i < n; i++) {
			Arrays.fill(matrix[i], 0);
		}
		scanner.nextLine();
		for (int i = 0; i < m; i++) {
			boolean flag = false;
			String[] infos = scanner.nextLine().split(" ");
			if (infos[0].equals("1")) {
				// small
				matrix[Integer.parseInt(infos[1]) - 1][Integer.parseInt(infos[2]) - 1] = 
						-1 * Integer.parseInt(infos[3]);
				matrix[Integer.parseInt(infos[2]) - 1][Integer.parseInt(infos[1]) - 1] = 
						-1 * Integer.parseInt(infos[3]);
			} else {
				matrix[Integer.parseInt(infos[1]) - 1][Integer.parseInt(infos[2]) - 1] = 
						Integer.parseInt(infos[3]);
				matrix[Integer.parseInt(infos[2]) - 1][Integer.parseInt(infos[1]) - 1] = 
						Integer.parseInt(infos[3]);
			}
		}
		scanner.close();
		int[] v = new int[n];
		Arrays.fill(v, 0);
		for (int i = 0; i < n; i++) {
			for (int j = i + 1; j < n; j++) {
				if (matrix[i][j] != 0) {
					//keda
					for (int k = j + 1; k < n; k++) {
						if (matrix[j][k] != 0) {
							if (matrix[i][k] != 0) {
								int w1 = (matrix[i][k] < 0) ? -1 * matrix[i][k] * matrix[i][k] : matrix[i][k];
								int w2 = 0;
								if (matrix[i][j] < 0 && matrix[j][k] < 0) {
									w2 = -1 * (matrix[i][j] + matrix[j][k]) * (matrix[i][j] + matrix[j][k]);
									if (w1 > w2)
										v[k] = 1;
								} else if (matrix[i][j] > 0 && matrix[i][j] > 0) {
									w2 = matrix[i][j] + matrix[j][k];
								} else if (matrix[i][j] > 0 && matrix[j][k] < 0) {
									w2 = matrix[i][j] + matrix[j][k] * matrix[j][k];
								} else {
									w2 = matrix[i][j] * matrix[i][j] + matrix[j][k];
								}
								matrix[i][k] = (Math.abs(w1) < Math.abs(w2)) ? w1 : w2;
							} else {
								if (matrix[i][j] < 0 && matrix[j][k] < 0) {
									if (v[j] == 1) {
										matrix[i][k] = ((int) Math.sqrt(-1 * matrix[i][j]) - matrix[j][k]) * ((int) Math.sqrt(-1 * matrix[i][j]) - matrix[j][k]);
									} else
										matrix[i][k] = -1 * (matrix[i][j] + matrix[j][k]) * (matrix[i][j] + matrix[j][k]);
									v[k] = 1;
								} else if (matrix[i][j] > 0 && matrix[j][k] > 0) {
									matrix[i][k] = matrix[i][j] + matrix[j][k];
								} else if (matrix[i][j] > 0 && matrix[j][k] < 0) {
									matrix[i][k] = matrix[i][j] + matrix[j][k] * matrix[j][k];
								} else {
									if (v[j] == 1)
										matrix[i][k] = -1 * matrix[i][j] + matrix[j][k];
									else
										matrix[i][k] = matrix[i][j] * matrix[i][j] + matrix[j][k];
								}
							}
						}
					}
				}
			}
		}
		
		System.out.print(matrix[0][n-1]);
	}
}
