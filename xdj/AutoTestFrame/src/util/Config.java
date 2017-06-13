package util;

import org.apache.commons.configuration.PropertiesConfiguration;

public class Config {

	public static String browser;
	public static String browserPath;
	public static int waitTime;
	public static String url;
	public static String emaliAddress;
	public static String passWord;
	public static String exportPath;
	public static String retrycount;
	public static String sourcecodedir;
	public static String sourcecodeencoding;
	public static PropertiesConfiguration config;
	public static ParseXml px;

	/**
	 * static{}，这种用法请大家务必搞清楚，这代表在用到Config这个类时，这个static{}里面的内容会被执行一次，且只被执行一次，就算多
	 * 次用到Config类，也只执行一次，所以，这个static{]一般就在加载一些配置文件，也可以说类似于单例模式。
	 * Integer.valueOf()可以把一个String或者其它的对象变成一个Integer的对象。
	 */
	static {
		try {
			config = new PropertiesConfiguration("config/localconfig.properties");
		}catch(Exception e){
			e.printStackTrace();
		}
		px = new ParseXml("config/config.xml");
		browser = px.getElementText("/config/browser");
		browserPath = px.getElementText("/config/firefox_path");
		waitTime = Integer.valueOf(px.getElementText("/config/waitTime"));
		url = px.getElementText("/config/url");
		emaliAddress = px.getElementText("/config/emaliAddress");
		passWord = px.getElementText("/config/passWord");
		retrycount = px.getElementText("/config/retrycount");
		sourcecodedir = px.getElementText("/config/sourcecodedir");
		sourcecodeencoding = px.getElementText("/config/sourcecodeencoding");
		exportPath =px.getElementText("/config/exportPath");
	}

	public static void main(String[] args) {
		Log.logInfo(Config.browser);
		Log.logInfo(Config.waitTime);
		Log.logInfo(Config.url);
		Log.logInfo(Config.emaliAddress);
		Log.logInfo(Config.passWord);
	}
}
