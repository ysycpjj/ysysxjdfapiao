package datadriver;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SqlServerData {

	private String JDriver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";// SQL数据库引擎
	private String connectDBName = "jdbc:sqlserver://10.10.10.202:1433;DatabaseName=";// 数据源
	private Connection con;
	private Statement stmt;
	private ResultSet rs;
	private String sql1 = "select top ";
	private String sql2 = " SysNo from Product p where p.ProductChannelShowType like '%2-2%' and p.IsSaleOver=0 and p.IsSaleStop=0 and SysNo not in (select top ";
	private String sql3 = " SysNo from Product p where p.ProductChannelShowType like '%2-2%' and p.IsSaleOver=0 and p.IsSaleStop=0)";

	public SqlServerData(String connectDB, String userName, String passWord) {
		try {
			Class.forName(JDriver);// 加载数据库引擎，返回给定字符串名的类
		} catch (ClassNotFoundException e) {
			System.out.println("加载数据库引擎失败");
			System.exit(0);
		}
		// System.out.println("数据库驱动成功");
		try {
			con = DriverManager.getConnection(connectDBName + connectDB,
					userName, passWord);// 连接数据库对象
			// System.out.println("连接数据库成功");
			stmt = con.createStatement();// 创建SQL命令对象
			// System.out.println("开始读取数据");
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("数据库连接错误");
			System.exit(0);
		}
	}

	public SqlServerData() {

	}

	public List<String> getColumnData(String columnName, int fromRowNum,
			int rowNum) {
		List<String> list = new ArrayList<String>();
		try {
			rs = stmt.executeQuery(sql1 + rowNum + sql2 + fromRowNum + sql3);
			while (rs.next()) {
				list.add(rs.getString(columnName));
				// System.out.println(rs.getString("SysNo"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	
	public List<String> excuteSql(String sql, String columnName){
		List<String> list = new ArrayList<String>();
		try {
			rs = stmt.executeQuery(sql);
			while (rs.next()) {
				list.add(rs.getString(columnName));
				// System.out.println(rs.getString("SysNo"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	public void closeConnect() {
		try {
			con.close();
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
			System.exit(0);
		}
	}

	public String getJDriver() {
		return JDriver;
	}

	public String getConnectDBName() {
		return connectDBName;
	}

	public Connection getCon() {
		return con;
	}

	public Statement getStmt() {
		return stmt;
	}

}
