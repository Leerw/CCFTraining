import java.util.Scanner;

public class sumDigit {
	public static void main(String[] args) {
		new sumDigit().run();
	}

	/*
	 * short int �����ֵ��32767 int �����ֵ��2147483647 long de ���ֵ��9223372036854775807
	 */

	public void run() {
		int digit = 0;
		int sum = 0;
		Scanner scanner = new Scanner(System.in);
		int num = scanner.nextInt();
		/*
		 * �ҵı����� while ((num * 10) / 10 != 0) { long backup = num; num = num / 10; long
		 * temp = num * 10; digit = (int) (backup - temp); sum += digit; }
		 */
		while (num != 0) {
			sum += num % 10;
			num /= 10;
		}
		System.out.println(sum);
		System.out.print(Integer.MAX_VALUE);
		System.out.println(Long.MAX_VALUE);
	}
}
