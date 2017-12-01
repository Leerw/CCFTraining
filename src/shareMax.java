import java.util.Scanner;

public class shareMax {
	public static void main(String[] args) {
		new shareMax().run();
	}

	public void run() {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		int[] prices = new int[n];
		int result = 0;
		for (int i = 0; i < n; i++) {
			prices[i] = scanner.nextInt();
		}
		scanner.close();
		for (int i = 0; i < n - 1; i++) {
			int diff = Math.abs(prices[i] - prices[i + 1]);
			if (diff > result) {
				result = diff;
			}
		}
		System.out.println(result);
	}
}
