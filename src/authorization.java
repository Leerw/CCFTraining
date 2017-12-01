import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;

public class authorization {
	public static void main(String[] args) {
		new authorization().run();
	}

	public void run() {
		Scanner scanner = new Scanner(System.in);
		int p = scanner.nextInt();
		scanner.nextLine();
		// ����Ȩ��
		Map<String, Integer> privilege = new HashMap<String, Integer>();
		for (int i = 0; i < p; i++) {
			String tempString = scanner.nextLine();
			if (tempString.contains(":")) {
				String[] ns = tempString.split(":");
				privilege.put(ns[0], Integer.parseInt(ns[1]));
			} else {
				privilege.put(tempString, 0);
			}
		}
		// ���ܽ�ɫ
		int r = scanner.nextInt();
		scanner.nextLine();
		int[][] roles = new int[r][privilege.size()];
		for (int i = 0; i < r; i++) {
			for (int j = 0; j < privilege.size(); j++) {
				roles[i][j] = -1;
			}
		}
		// ÿ�еĽṹ�ǣ�Ȩ��1�ĵȼ�,...,Ȩ��n�ĵȼ�,�ּ�ֵ���ǵȼ������ּ�����0�������ڸ�Ȩ�޾���-1
		Map<String, Integer> rolesId = new HashMap<String, Integer>();
		// ��ɫ�ͱ��
		for (int i = 0; i < r; i++) {
			String roleInfo = scanner.nextLine();
			String[] ns = roleInfo.split(" ");
			String name = ns[0];
			rolesId.put(name, i);
			int num = Integer.parseInt(ns[1]);
			for (int j = 0; j < num; j++) {
				String priv = ns[j + 2];
				if (priv.contains(":")) {
					String[] newStr = priv.split(":");
					String privName = newStr[0];
					int priority = Integer.parseInt(newStr[1]);
					if (!privilege.containsKey(privName)) {
						System.out.println("�������Ȩ�޲�����");
					} else {
						int counter = 0;
						Iterator iter = privilege.entrySet().iterator();
						while (iter.hasNext()) {
							Map.Entry entry = (Map.Entry) iter.next();
							if (!entry.getKey().equals(privName)) {
								++counter;
							} else {
								break;
							}
						}
						if (roles[i][counter] == -1)
							roles[i][counter] = priority;
						else if (roles[i][counter] < priority)
							roles[i][counter] = priority;
					}
				} else {
					String privname = priv;
					if (!privilege.containsKey(privname)) {
						System.out.println("�������Ȩ�޲�����");
					} else {
						int counter = 0;
						Iterator iter = privilege.entrySet().iterator();
						while (iter.hasNext()) {
							Map.Entry entry = (Map.Entry) iter.next();
							if (!entry.getKey().equals(privname)) {
								++counter;
							} else {
								break;
							}
						}
						if (roles[i][counter] == -1)
							roles[i][counter] = 0;
					}
				}
			}
		}

		// �����û�
		int u = scanner.nextInt();
		scanner.nextLine();
		int[][] users = new int[u][r];
		Map<String, Integer> usernameId = new HashMap<String, Integer>();
		for (int i = 0; i < u; i++) {
			String newUser = scanner.nextLine();
			String[] infos = newUser.split(" ");
			String username = infos[0];
			usernameId.put(username, i);
			int roleNum = Integer.parseInt(infos[1]);
			for (int j = 2; j < infos.length; j++) {
				String rolename = infos[j];
				if (!rolesId.containsKey(rolename)) {
					System.out.println("������Ľ�ɫ������");
				} else {
					int id = rolesId.get(rolename);
					users[i][id] = 1;
				}
			}
		}
		// ���ܲ�ѯ
		int q = scanner.nextInt();
		scanner.nextLine();
		String[] queries = new String[q];
		for (int i = 0; i < q; i++) {
			String query = scanner.nextLine();
			queries[i] = query;
		}
		scanner.close();
		for (int i = 0; i < q; i++) {
			String[] qsplit = queries[i].split(" ");
			String qusername = qsplit[0];
			int quserId = usernameId.get(qusername); // �û�ID
			String qinfo = qsplit[1];
			if (!usernameId.containsKey(qusername)) {
				System.out.println("false");
			} else {
				String prname = new String();
				int priority = -1;
				if (!qinfo.contains(":")) {
					prname = qinfo;
				} else {
					prname = qinfo.split(":")[0];
					priority = Integer.parseInt(qinfo.split(":")[1]);
				}
				int prId = privilege.get(prname); // Ȩ��ID
				int[] quser = users[quserId];
				for (int j = 0; j < r; j++) {
					if (quser[j] != 0) {
						// �ҵ�һ����ɫ����j���ǽ�ɫ��id
						int result = roles[j][prId];
						if (priority == -1) {
							// ���ּ�
							if (result == 0) {
								System.out.println("true");
							} else if (result == -1) {
								System.out.println("false");
							} else {
								System.out.println(result);
							}
						} else {
							if (result == 0) {
								System.out.println("true");
							} else if (result == -1) {
								System.out.println("false");
							}
							if (result >= priority) {
								System.out.println(priority);
							}
						}
					}
				}
			}
		}
	}
}
