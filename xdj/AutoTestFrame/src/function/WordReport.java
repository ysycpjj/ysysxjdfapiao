package function;

import java.util.ArrayList;
import java.util.List;

public class WordReport {
	
	int a = 1;
	int b = 2;
	int c = 3;
	List<Integer> l = new ArrayList<Integer>();

	public void creatreport1(List<Integer> list) {

		String time = GetTime.getTime();
		JacobWord jw = new JacobWord(false);
		try {
			jw.openDocument("c:\\2.doc");
			for (int i = 0; i < list.size(); i++) {
				jw.putTxtToCell(1, i + 2, 3, list.get(i).toString());
				jw.moveDown(1);
			}
		} catch (Exception e) {
			System.out.println(e);
		} finally {
			jw.save("d:\\WordReport\\" + time + ".doc");
			jw.close();
			jw.closeDocument();
		}
	}

	public void creatreport2(String a, String f1, String f2, String f3,
			String f4, String f5, String f6, String f7, String f8, String f9,
			String f10, String f11, String f12) {

		String time = GetTime.getTime();
		JacobWord jw = new JacobWord(false);
		try {
			jw.openDocument("c:\\1.doc");
			jw.replaceAllText("滚动广告个数", a);
			jw.replaceAllText("01F个数", f1);
			jw.replaceAllText("02F个数", f2);
			jw.replaceAllText("03F个数", f3);
			jw.replaceAllText("04F个数", f4);
			jw.replaceAllText("05F个数", f5);
			jw.replaceAllText("06F个数", f6);
			jw.replaceAllText("07F个数", f7);
			jw.replaceAllText("08F个数", f8);
			jw.replaceAllText("09F个数", f9);
			jw.replaceAllText("10F个数", f10);
			jw.replaceAllText("11F个数", f11);
			jw.replaceAllText("12F个数", f12);
			jw.save("d:\\WordReport\\" + time + ".doc");
		} catch (Exception e) {
			System.out.println(e);
		} finally {
			jw.close();
			jw.closeDocument();
			System.out.println("over");
		}
	}

	public static void main(String[] args) {
		WordReport wr = new WordReport();
		wr.creatreport2(null, null, null, null, null, null, null, null, null, null, null, null, null);
	}
}
