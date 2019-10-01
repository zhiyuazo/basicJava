package service;

import javax.swing.JOptionPane;

import dao.ConfigDao;
import entity.Config;

public class ConfigService {
	
	public static final String budget = "budget";
	public static final String default_budget = "500";
	public static final String mysql = "mysql_path";
	
	static ConfigDao dao = new ConfigDao();
	static { init();}
	
	private static  void init() {
		if(dao.getByKey(budget) == null) {
			Config c_budget = new Config();
			c_budget.setKey(budget);
			c_budget.setValue(default_budget);
			dao.add(c_budget);
		}
		if(dao.getByKey(mysql) == null) {
			Config c_mysql = new Config();
			c_mysql.setKey(mysql);
			c_mysql.setValue("");
			dao.add(c_mysql);
		}
	}
	
	public String  get(String k) {
		Config res = dao.getByKey(k);
		if(null == res ) {
			return null;
		}else {
			return res.value;
		}
	}
	
	public void update(String k , String v) {
		Config c = dao.getByKey(k);
		c.setValue(v);
		dao.update(c);
	}
	
}
