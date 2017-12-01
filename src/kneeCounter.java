import java.util.Scanner;

public class kneeCounter {
	public static void main(String[] args) {
		new kneeCounter().run();
	}

	public void run() {
		int pre = 0;
		int after = 0;
		int counter = 0;
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		int[] a = new int[n];
		for (int i = 0; i < n; i++) {
			a[i] = scanner.nextInt();
		}
		for (int i = 1; i < n; i++) {
			pre = after;
			after = (a[i] - a[i - 1] < 0) ? -1 : 1;
			if (pre + after == 0) {
				++counter;
			}
		}
		System.out.println(counter);
	}
}
