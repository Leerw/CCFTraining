import java.util.Scanner;

/*
 * 火车购票
 */
public class buyTrainTick {
	static int[] record = new int[100]; // 存储预定了的座位

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] arr = new int[n]; // 存储指令
		for (int i = 0; i < arr.length; i++)
			arr[i] = sc.nextInt();
		sc.close();

		for (int i = 0; i < arr.length; i++) {
			int num = arr[i]; // 获取订票数
			boolean flag = false; // 标志是否有连续的座位

			for (int j = 0; j < 20; j++) { // 每行遍历
				for (int k = 0; k < 5; k++) { // 5列
					if (record[j * 5 + k] == 0 && k + num <= 5) { // 可以订票
						for (int t = j * 5 + k; t < j * 5 + k + num; t++)
							record[t] = i + 1; // 编号，用于区分输出
						flag = true;
						break;
					}
				}
				if (flag)
					break;
			}

			if (!flag) { // 没有连续的座位
				while (num-- > 0) {
					for (int j = 0; j < record.length; j++) {
						if (record[j] == 0) {
							record[j] = i + 1;
							break;
						}
					}
				}
			}

		} // end for

		// 输出结果
		int count = 0;
		for (int i = 0, j = 1; i < record.length; i++) {
			if (record[i] == j) {
				System.out.print(i + 1 + " ");
				count++;
				if (count == arr[j - 1]) {
					System.out.println();
					i = 0;
					j++;
					count = 0;
				} // 重新开始输出下一行
			}
		}

	}
}
