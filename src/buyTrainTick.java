import java.util.Scanner;

/*
 * �𳵹�Ʊ
 */
public class buyTrainTick {
	static int[] record = new int[100]; // �洢Ԥ���˵���λ

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] arr = new int[n]; // �洢ָ��
		for (int i = 0; i < arr.length; i++)
			arr[i] = sc.nextInt();
		sc.close();

		for (int i = 0; i < arr.length; i++) {
			int num = arr[i]; // ��ȡ��Ʊ��
			boolean flag = false; // ��־�Ƿ�����������λ

			for (int j = 0; j < 20; j++) { // ÿ�б���
				for (int k = 0; k < 5; k++) { // 5��
					if (record[j * 5 + k] == 0 && k + num <= 5) { // ���Զ�Ʊ
						for (int t = j * 5 + k; t < j * 5 + k + num; t++)
							record[t] = i + 1; // ��ţ������������
						flag = true;
						break;
					}
				}
				if (flag)
					break;
			}

			if (!flag) { // û����������λ
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

		// ������
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
				} // ���¿�ʼ�����һ��
			}
		}

	}
}
