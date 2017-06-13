package function;

import java.util.Random;

public class Randomint {
	
	/**
	 * 取得max和min之间的随机数
	 * @param min
	 * @param max
	 * @return
	 */
	public static int randomint(int min, int max) {

		Random random = new Random();
		int s = random.nextInt(max-min+1)+min;
//		System.out.println(s);
		return s;
	}
	
	public int randomint2(int min, int max) {
		float d = new Random().nextInt(100);
//		System.out.println(d);
		float f = d/100;
		int r = Math.round((min + (max-min)*f));
		return r;
		
	}
}