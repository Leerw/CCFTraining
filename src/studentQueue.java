import java.util.ArrayList;
import java.util.Scanner;

public class studentQueue {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		int m = scanner.nextInt();
		ArrayList<Integer> stuQue = new ArrayList<Integer>();
		for (int i = 0; i < n; i++) {
			stuQue.add(i + 1);
		}
		for (int i = 0; i < m; i++) {
			int index = scanner.nextInt();
			int step = scanner.nextInt();
			index = stuQue.indexOf(index);
			if (step > 0) {
				for (int j = index; j < index + step; j++) {
					int temp = 0;
					temp = stuQue.get(j);
					stuQue.set(j, stuQue.get(j + 1));
					stuQue.set(j + 1, temp);
				}
			} else if (step == 0) {

			} else {
				for (int k = index; k > index + step; k--) {
					int temp = 0;
					temp = stuQue.get(k);
					stuQue.set(k, stuQue.get(k - 1));
					stuQue.set(k - 1, temp);
				}
			}
		}
		scanner.close();
		System.out.println(stuQue);
	}
}
