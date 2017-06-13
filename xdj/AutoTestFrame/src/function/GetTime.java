package function;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class GetTime {
	public static String getTime() {

		DateFormat format = new SimpleDateFormat("yyyy-MM-dd-HHmm");
		Date date = new Date();
		String a = format.format(date);
//		System.out.println(a);
		return a;

	}

}
