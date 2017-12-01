import java.util.Scanner;

public class arraySegment {
	public static void main(String[] args) {
		new arraySegment().run();
	}

	public void run() {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		int[] a = new int[n];
		for (int i = 0; i < n; i++) {
			a[i] = scanner.nextInt();
		}
		int pre = a[0];
		int current;
		int counter = 1;
		for (int i = 1; i < n; i++) {
			current = a[i];
			if (current != pre) {
				++counter;
			}
			pre = a[i];
		}
		System.out.println(counter);
	}
}
