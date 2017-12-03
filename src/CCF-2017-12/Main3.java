package leerw;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main3 {
	public static void main(String[] args) {
//		new Main3().run();
	}
	public void run() {
		Scanner scanner = new Scanner(System.in);
		String info = scanner.nextLine();
		String[] infos = info.split(" ");
		int n = Integer.parseInt(infos[0]);
		Integer sTime = Integer.parseInt(infos[1]);
		Integer eTime = Integer.parseInt(infos[2]);
		int curTime = sTime;
//		ArrayList<String> list = new ArrayList<String>();
		Map<String[], String> crontabs = new HashMap<String[], String>();
		for (int i = 0; i < n; i++) {
			String curCrontab = scanner.nextLine();
			// jiexi
			String[] curInfos = curCrontab.split(" ");
			crontabs.put(curInfos, curInfos[5]);
//			String min = curInfos[0];
//			String hr = curInfos[1];
//			String day = curInfos[2];
//			String month = curInfos[3];
//			String week = curInfos[4];
//			String command = curInfos[5];
		}
		while (curTime <= eTime) {
			
		}
	}
	
	public static int getweekday(Integer time) {
		int weekday = -1;
		Integer days = 0;
		return weekday;
		
	}
	
	public static int getyear(Integer time) {
		return Integer.parseInt(String.valueOf(time).substring(0,4));
	}
	
	public static boolean isRunYear(int year) {
		return ((year % 4 == 0 && year % 100 != 0) || (year % 400 == 0));
	}
}
	
