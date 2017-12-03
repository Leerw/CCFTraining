package leerw;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Scanner;

public class Main2 {
	public static void main(String[] args) {		
		new Main2().run();
	}
	public void run() {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		int k = scanner.nextInt();
		LinkedList<Integer> child = new LinkedList<Integer>();
		for (int  i = 0; i < n; i++) {
			child.add(i + 1);
		}
		int counter = n;
		int num = 1;
		while (counter != 0) {
			int flag[] = new int[counter];
			Arrays.fill(flag, -1);
			int flagCounter = 0;
			for (int i = 0; i < counter; i = i + 1) {
				int curChild = child.get(i);
				if (num % k == 0 || num % 10 == k) {
					flag[flagCounter++] = curChild;
				}
				num = num + 1;
			}
			for (int j = 0; j < flagCounter; j++) {
				if (flag[j] != -1) {
					child.remove(child.indexOf(flag[j]));
					counter = counter - 1;
				}
			}
		}
		if (child.isEmpty()) {
			System.out.println(0);
		} else
			System.out.println(child.getFirst());
	}
}
