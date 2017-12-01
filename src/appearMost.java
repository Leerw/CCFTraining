import java.util.Arrays;
import java.util.Scanner;

public class appearMost {
	public static void main(String[] args) {
		new appearMost().run();
	}

	public void run() {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		int[] s = new int[10001];
		Arrays.fill(s, 0);
		int val = 0;
		int max = 0;
		for (int i = 0; i < n; i++) {
			val = scanner.nextInt();
			++s[val];
			if (s[val] > s[max]) {
				s[max] = val;
			} else if (s[val] == s[max] && val < max) {
				s[max] = val;
			}
		}
		System.out.println(s[max]);
	}
}
