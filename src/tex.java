import java.util.Scanner;

public class tex {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		long afterTex = scanner.nextLong();
		scanner.close();
		long level1 = 3500; // ���ڴ����ԭ�����ʴ���3500
		long level2 = (long) (level1 + 1500 * 0.97); // ���ڴ����ԭ�����ʴ���5000
		long level3 = (long) (level2 + 3000 * 0.9); // ���ڴ����ԭ�����ʴ���8000
		long level4 = (long) (level3 + 4500 * 0.8); // ���ڴ����ԭ�����ʴ���12500
		long level5 = (long) (level4 + 26000 * 0.75); // ���ڴ����ԭ�����ʴ���38500
		long level6 = (long) (level5 + 20000 * 0.7); // ���ڴ����ԭ�����ʴ���58500
		long level7 = (long) (level6 + 35000 * 0.65); // ���ڴ����ԭ�����ʴ���83500
		if (afterTex > level1) {
			if (afterTex <= level2) {
				System.out.print((long) (afterTex - 3500) / 0.97 + 3500);
			} else if (afterTex <= level3) {
				System.out.print((long) (afterTex - level2) / 0.9 + 5000);
			} else if (afterTex <= level4) {
				System.out.print((long) (afterTex - level3) / 0.8 + 8000);
			} else if (afterTex <= level5) {
				System.out.print((long) (afterTex - level4) / 0.75 + 12500);
			} else if (afterTex <= level6) {
				System.out.print((long) (afterTex - level5) / 0.7 + 38500);
			} else if (afterTex <= level7) {
				System.out.print((long) (afterTex - level6) / 0.65 + 58500);
			} else {
				System.out.print((long) (afterTex - level7) / 0.55 + 83500);
			}
		} else {
			System.out.print(afterTex);
		}
	}
}
