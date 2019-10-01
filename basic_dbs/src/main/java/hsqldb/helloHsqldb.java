package hsqldb;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.hsqldb.util.DatabaseManagerSwing;



public class helloHsqldb {
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		//DatabaseManagerSwing.main(args);
		
		Class.forName("org.hsqldb.jdbcDriver");
		String url = "jdbc:hsqldb:file:E:\\reJAVA\\dbs\\hsqldb\\hsql_db;shutdown=true";
        System.out.println(0);
        Connection c =DriverManager.getConnection(url, "root", "admin");
        System.out.println("1");
        Statement st = c.createStatement();
        System.out.println("2");
        ResultSet rs= st.executeQuery("select * from category");
        while(rs.next()){
            int id = rs.getInt("id");
            String name = rs.getString("name");
			System.out.println(id+"\t"+name);
        }
        System.out.println("3");
        st.close();
        c.close();
        System.out.println("4");
	}
}
