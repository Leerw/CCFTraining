import java.util.Arrays;
import java.util.Scanner;

public class adjPairNum {
	public static void main(String[] args) {
		new adjPairNum().run();
	}

	public void run() {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		int num;
		int counter = 0;
		boolean[] flags = new boolean[1000 + 2];
		Arrays.fill(flags, false);
		for (int i = 0; i < n; i++) {
			num = scanner.nextInt();
			flags[num] = true;
			if (flags[num - 1] == true) {
				++counter;
			}
			if (flags[num + 1] == true) {
				++counter;
			}
		}
		scanner.close();
		System.out.println(counter);
	}
}
