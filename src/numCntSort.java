import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;

public class numCntSort {
	public static void main(String[] args) {
		new numCntSort().run();
	}

	public void run() {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		Map<Integer, Integer> numCnt = new HashMap<Integer, Integer>();
		int val = 0;
		for (int i = 0; i < n; i++) {
			val = scanner.nextInt();
			if (!numCnt.containsKey(val)) {
				numCnt.put(val, 1);
			} else {
				numCnt.replace(val, numCnt.get(val) + 1);
			}
		}
		List<Map.Entry<Integer, Integer>> list = new ArrayList<Map.Entry<Integer, Integer>>(numCnt.entrySet());
		Collections.sort(list, new Comparator<Map.Entry<Integer, Integer>>() {
			@Override
			public int compare(Entry<Integer, Integer> o1, Entry<Integer, Integer> o2) {
				// TODO Auto-generated method stub
				return o2.getValue().compareTo(o1.getValue());
			}
		});
		for (Map.Entry<Integer, Integer> entry : list) {
			System.out.println(entry.getKey() + " " + entry.getValue());
		}
	}
}
