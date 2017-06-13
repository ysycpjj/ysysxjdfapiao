package datadriver;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;

import java.io.File;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

public class ExcelData implements Iterator<Object[]> {
	private Workbook book = null;
	private Sheet sheet = null;
	private int rowNum = 0;// 行数
	private int curRowNo = 0;// 当前行数
	private int columnNum = 0;// 列数
	private String[] columnnName;// 列名

	/*
	 * 在TestNG中，由@DataProvider（dataProvider="name"）修饰的方法读取Exel时，调用此类的构造方法（
	 * 此方法会得到列名并将当前行移到下一行）执行完后，转到TestNG自己的方法中去，然后由他们调用此类实现的hasNext()、next() 方法；
	 * 得到一行数据，然后返回给由@Test（dataProvider="name"）修饰的方法，如此反复到数据读完为止。
	 * 
	 * @param filepath Excel文件名
	 * 
	 * @param casename 用例名
	 */

	public ExcelData(String filepath, String casename) {
		try {
			File directory = new File("DataSrc");
//			String ss = ".";
			String ss = "/";
			//ExcelData
			book = Workbook.getWorkbook(new File(directory.getCanonicalPath()
//					+ ss.replaceAll("\\.", Matcher.quoteReplacement("/"))
					+ ss
					+ filepath + ".xls"));
			this.sheet = book.getSheet(casename);
			this.rowNum = sheet.getRows();

			Cell[] c = sheet.getRow(0);
			this.columnNum = c.length;
			columnnName = new String[c.length];
			for (int i = 0; i < c.length; i++) {
				columnnName[i] = c[i].getContents().toString();
				System.out.println(columnnName[i]);
			}
			this.curRowNo++;

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public boolean hasNext() {
		/**
		 * 方法功能：是否有下一条数据 如果行数为0即空sheet或者 当前行数大于总行数 就关闭对excel的操作返回false，否则返回true
		 */
		if (this.rowNum == 0 || this.curRowNo >= this.rowNum) {
			try {
				book.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
			return false;
		} else
			return true;
	}

	@Override
	public Object[] next() {
		/*
		 * 方法功能：得到并返回下一行数据
		 * 使用for将一行的数据放入TreeMap中（TreeMap默认按照Key值升序排列，HashMap没有排序）
		 * 然后将Map装入Object[]并返回，且将curRowNo当前行下移
		 */
		Cell[] c = sheet.getRow(this.curRowNo);
		Map<String, String> s = new TreeMap<String, String>();
		for (int i = 0; i < this.columnNum; i++) {
			String temp = "";
			try {
				temp = c[i].getContents().toString();
			} catch (ArrayIndexOutOfBoundsException ex) {
				temp = "";
			}
			s.put(this.columnnName[i], temp);
		}

		Object r[] = new Object[1];
		r[0] = s;
		this.curRowNo++;
		return r;
	}

	public Object[][] getobjstring() {
		Object[][] obj = new Object[this.rowNum - 1][this.columnNum];
		for (int i = 0; i < this.rowNum - 1; i++) {
			for (int j = 0; j < this.columnNum; j++) {
				obj[i][j] = sheet.getCell(j, i + 1).getContents()
						.toString();
			}
		}
		return obj;
	}

	public Object[][] getobjint() {
		Object[][] obj = new Object[this.rowNum - 1][this.columnNum];
		for (int i = 0; i < this.rowNum - 1; i++) {
			for (int j = 0; j < this.columnNum; j++) {
				obj[i][j] = Integer.parseInt(sheet.getCell(j, i + 1)
						.getContents().toString());
			}
		}
		return obj;
	}

	@Override
	public void remove() {
		throw new UnsupportedOperationException("remove unsupported.");
	}

	public static void main(String[] args) {
		ExcelData ed = new ExcelData("ExcelTest", "register");
		ed.getobjstring();
	}
}
