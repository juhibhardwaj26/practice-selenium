package generic_utility;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class JavaUtility {
	public static int createRandom() {
		double value=Math.random()*10000;
		int ran =(int)value;
		return ran;
	}
	
	public static String getCurrentTime() {
		String time=	LocalDateTime.now().format(DateTimeFormatter.ofPattern("HHmmss_ddMMMyyyy"));
		return time;
	}
}
