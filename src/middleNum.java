import java.util.Arrays;
import java.util.Scanner;

public class middleNum {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		int[] array = new int[n];
		for (int i = 0; i < n; i++) {
			array[i] = scanner.nextInt();
		}
		Arrays.sort(array);
		int result = 0;
		int mid = n / 2;
		int leftcount = mid;
		int rightcount = n - mid - 1;
		for (int i = mid - 1; i >= 0; i--) {
			if (array[i] == array[mid])
				--leftcount;
		}
		for (int i = mid + 1; i < array.length; i++) {
			if (array[i] == array[mid])
				++rightcount;
		}
		if (leftcount == rightcount)
			result = array[mid];
		else
			result = -1;
		System.out.println(result);
	}
}
