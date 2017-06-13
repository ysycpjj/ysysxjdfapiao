package com.young.appiumcombat.utils;

import org.testng.Assert;
import org.apache.log4j.Logger;
import java.util.ArrayList;
import java.util.List;

public class Assertion {
	
	public static boolean flag = true;
	private static Logger logger = Logger.getLogger(Assertion.class);
	public static List<Error> errors = new ArrayList<Error>();
	public static List<String> errorMessage= new ArrayList<String>();
	public static boolean abnomalLogout = false;

	public static void verifyEquals(Object actual, Object expected){
		try{
//			flag = true;
			Assert.assertEquals(actual, expected);
		}catch(Error e){
			flag = false;
			Log.logInfo("actual is ["+actual+"], expected is ["+expected+"].");
		}
	}
	
	public static void verifyEquals(Object actual, Object expected, String message){
		try{
//			flag = true;
			Assert.assertEquals(actual, expected, message);
		}catch(Error e){
			flag = false;
			Log.logInfo(message + " :actual is ["+actual+"], expected is ["+expected+"].");
		}
	}
	public static void assertTrue(boolean actual){
		try{
			Assert.assertTrue(actual);
		}catch(Error e){
//			e.printStackTrace();
			errors.add(e);
			errorMessage.add("exception is true,but find false");
			flag = false;
			logger.info("exception is true,but find false");
		}
	}

	public static void assertTrue(boolean actual,  String message){
		try{
			Assert.assertTrue(actual,message);
		}catch(Error e){
//			e.printStackTrace();
			errors.add(e);
			errorMessage.add(message);
			flag = false;
			logger.info(message);
		}
	}

}
