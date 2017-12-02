import java.util.Scanner;

public class pathAnalysis {
	public static void main(String[] args) {
		new pathAnalysis().run();
	}

	public void run() {
		Scanner scanner = new Scanner(System.in);
		int p = scanner.nextInt();
		scanner.nextLine();
		String curPath = scanner.nextLine();
		for (int i = 0; i < p; i++) {
			String procPath = scanner.nextLine();
			// �Ǹ�·������
			if (procPath.charAt(0) != '/') {
				procPath = curPath + "/" + procPath + "/";
			}
			// ȥ�����"/"
			while (procPath.contains("//")) {
				procPath = procPath.replace("//", "/");
			}
			// ȥ��"./"
			while (procPath.contains("/./")) {
				procPath = procPath.replace("/./", "/");
			}
			// ȥ������"/"
			if (procPath.length() > 1 && procPath.charAt(procPath.length() - 1) == '/') {
				procPath = procPath.substring(0, procPath.length() - 1);
			}
			// ȥ��"../"
			int pos;
			while ((pos = procPath.indexOf("/../")) != -1) {
				if (pos == 0) {
					procPath = procPath.substring(3, procPath.length());
				} else {
					int spos = procPath.lastIndexOf(procPath.substring(0, pos));
					procPath = procPath.substring(0, spos + 1) + procPath.substring(pos + 4, procPath.length());
				}
				// ����ǿմ�
				if (procPath.equals("")) {
					procPath = "/";
				}
			}
			System.out.println(procPath);

		}
	}
}
