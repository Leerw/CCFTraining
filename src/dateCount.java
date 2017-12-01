import java.util.Scanner;

public class dateCount {
	public static void main(String[] args) {
		new dateCount().run();
	}

	public void run() {
		final int[] months1 = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
		final int[] months2 = { 31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
		boolean flag = false;
		Scanner scanner = new Scanner(System.in);
		int y = scanner.nextInt();
		int n = scanner.nextInt();
		int month = 0;
		int day = 0;
		scanner.close();
		flag = ((y % 4 == 0 && y % 100 != 0) || (y % 400 == 0)) ? true : false;
		if (flag) {
			// »ÚƒÍ
			int index = 0;
			while (true) {
				if (n < months2[index]) {
					month = index + 1;
					day = n;
					break;
				} else {
					n = n - months2[index];
				}
				++index;
			}
		} else {
			// ∆ΩƒÍ
			int index = 0;
			while (true) {
				if (n < months1[index]) {
					month = index + 1;
					day = n;
					break;
				} else {
					n = n - months1[index];
				}
				++index;
			}
		}
		System.out.println(month);
		System.out.println(day);
	}
}
