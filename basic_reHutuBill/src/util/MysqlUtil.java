package util;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;

public class MysqlUtil {
	
	static Runtime r = Runtime.getRuntime();
	
	public static void backup(String mysqlPath , String backupfile) throws IOException {
		
		String commandFormat = "\"%s/bin/mysqldump.exe\" -u%s -p%s   -hlocalhost   -P%d %s -r \"%s\"";
		String command = String.format(commandFormat, mysqlPath, DBUtil.db_user, DBUtil.db_password, 
													  DBUtil.db_port, DBUtil.db, backupfile);
		r.exec(command);
	}

	public static void recover(String mysqlPath, String recoverfile) throws IOException {
		try {
			String commandFormat = "\"%s/bin/mysql.exe\" -u%s -p%s   %s ";
			String command = String.format(commandFormat, mysqlPath, DBUtil.db_user, DBUtil.db_password,
					DBUtil.db);
			Process p = r.exec(command);
			OutputStream out = p.getOutputStream();
            StringBuffer sb = new StringBuffer("");
			String orgSql;
            String exeSql;
            BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(recoverfile), "utf8"));
            while ((orgSql = br.readLine()) != null) {
                sb.append(orgSql + "\r\n");
            }
            exeSql = sb.toString();
 
            OutputStreamWriter writer = new OutputStreamWriter(out, "utf8");
            writer.write(exeSql);
            writer.flush();
            out.close();
            br.close();
            writer.close();
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
	
	}
	
	
}
