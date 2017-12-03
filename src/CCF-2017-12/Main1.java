package leerw;

import java.util.Scanner;

public class Main1 {
	public static void main(String[] args) {
		new Main1().run();
	}
	public void run() {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		int[] num = new int[n];
		int result = 0x7f7f7f7f;
		for (int i = 0; i < n; i++) {
			num[i] = scanner.nextInt();
		}
		scanner.close();
		for (int i = 0; i < n - 1; i++) {
			for (int j = i + 1; j < n; j++) {
				int temp = Math.abs(num[i] - num[j]);
				if (temp < result) {
					result = temp; 
				}
			}
		}
		System.out.println(result);
	}
}
