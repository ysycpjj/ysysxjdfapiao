package datasource;

import datadriver.ExcelData;
import org.testng.annotations.DataProvider;



public class StaticProvider {
	
	@DataProvider(name = "floor")
	public static Object[][] floor() {
		return new Object[][] { { 0 }, { 1 }, { 2 }, { 3 }, { 4 }, { 5 }, { 6 }, { 7 } };
	}
	
	@DataProvider(name = "register")
	public static Object[][] register() {
		ExcelData data = new ExcelData("ExcelData", "register");
		return data.getobjstring();
	}
	
	@DataProvider(name = "login")
	public static Object[][] login() {
		ExcelData data = new ExcelData("ExcelData", "login");
		return data.getobjstring();
	}
	
	@DataProvider(name = "brands")
	public static Object[][] brands() {
		ExcelData data = new ExcelData("ExcelData", "brands");
		return data.getobjint();
	}
	
	@DataProvider(name = "industry")
	public static Object[][] industry() {
		ExcelData data = new ExcelData("ExcelData", "industry");
		return data.getobjint();
	}
	@DataProvider(name = "comment")
	public static Object[][] comment() {
		ExcelData data = new ExcelData("ExcelData", "comment");
		return data.getobjint();
	}


}
