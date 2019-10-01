package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtil {
	
	static {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public  static  String db = "rehutubill";
	public  static  String db_address = "127.0.0.1";
	public  static int db_port = 3306;
	public  static String db_encoding = "utf-8";
	public  static String db_user = "root";
	public  static String db_password = "admin";
	
	public static Connection getConnection() throws SQLException {
		
		String url = String.format("jdbc:mysql://%s:%d/%s?characterEncoding=%s&useSSL=false",db_address,db_port,db,db_encoding);
		Connection c = DriverManager.getConnection(url,db_user,db_password);
		return c;
	}
	
}
