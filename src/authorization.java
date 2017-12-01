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
		// 接受权限
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
		// 接受角色
		int r = scanner.nextInt();
		scanner.nextLine();
		int[][] roles = new int[r][privilege.size()];
		for (int i = 0; i < r; i++) {
			for (int j = 0; j < privilege.size(); j++) {
				roles[i][j] = -1;
			}
		}
		// 每行的结构是：权限1的等级,...,权限n的等级,分级值就是等级，不分级就是0，不存在该权限就是-1
		Map<String, Integer> rolesId = new HashMap<String, Integer>();
		// 角色和编号
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
						System.out.println("您输入的权限不存在");
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
						System.out.println("您输入的权限不存在");
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

		// 接受用户
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
					System.out.println("您输入的角色不存在");
				} else {
					int id = rolesId.get(rolename);
					users[i][id] = 1;
				}
			}
		}
		// 接受查询
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
			int quserId = usernameId.get(qusername); // 用户ID
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
				int prId = privilege.get(prname); // 权限ID
				int[] quser = users[quserId];
				for (int j = 0; j < r; j++) {
					if (quser[j] != 0) {
						// 找到一个角色，则j就是角色的id
						int result = roles[j][prId];
						if (priority == -1) {
							// 不分级
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
