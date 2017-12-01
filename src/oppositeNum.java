import java.util.Arrays;
import java.util.Scanner;

public class oppositeNum {
	public static void main(String[] args) {
		new oppositeNum().run();
	}

	/*
	 * 前提就是题目中的“非零且各不相同”，否则还需要进一步筛选
	 */
	public void run() {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		int[] numbers = new int[10001];
		Arrays.fill(numbers, 0);
		int val = 0;
		int counter = 0;
		for (int i = 0; i < n; i++) {
			val = scanner.nextInt();
			if (numbers[Math.abs(val)] != 0 && val + numbers[Math.abs(val)] == 0) {
				++counter;
			} else {
				numbers[Math.abs(val)] = val;
			}
		}
		System.out.print(counter);
	}
}
