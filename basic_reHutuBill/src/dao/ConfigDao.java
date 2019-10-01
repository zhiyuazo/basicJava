package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import entity.Config;
import util.DBUtil;

public class ConfigDao {
	
	public int getTotal() {
		int totle = 0;
		try(Connection c = DBUtil.getConnection() ;Statement s = c.createStatement() ){
			String sql = "select count(*) from config";
			s.execute(sql);
			ResultSet rs = s.getResultSet();
			while(rs.next()) {
				totle = rs.getInt(1);
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
		return totle;
	}
	
	public void add(Config cfg) {
		String sql = "insert into config values(null,?,?)"; 
		try(Connection c = DBUtil.getConnection() ; PreparedStatement ps = c.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS) ){
			ps.setString(1, cfg.key);
			ps.setString(2, cfg.value);
			ps.execute();
			ResultSet  rs = ps.getGeneratedKeys();
			if(rs.next()) {
				int id = rs.getInt(1);
				cfg.id = id;
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void update(Config cfg) {
		String sql = "update config set key_=?,value=?where id =?"; 
		try(Connection c = DBUtil.getConnection() ; PreparedStatement ps = c.prepareStatement(sql) ){
			ps.setString(1, cfg.key);
			ps.setString(2, cfg.value);
			ps.setInt(3, cfg.id);
			ps.execute();
		}catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void delete(int id) {
		String sql = "delete from config where id =" + id; 
		try(Connection c = DBUtil.getConnection() ; Statement s = c.createStatement() ){
			s.execute(sql);
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public Config getById(int id) {
		Config  res = null;
		try(Connection c = DBUtil.getConnection() ; Statement s = c.createStatement() ){
			String sql = "select * from config where id =" + id;
			s.execute(sql);
			ResultSet rs = s.getResultSet();
			if(rs.next()) {
				res = new Config();
				res.id= id;
				res.key= rs.getString(2);
				res.value=rs.getString(3) ;
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
		return res;
	}
	
	public Config getByKey(String k) {
		Config  res = null;
		String sql = "select * from config where key_=?"; 
		try(Connection c = DBUtil.getConnection() ; PreparedStatement ps = c.prepareStatement(sql) ){
			
			ps.setString(1, k);
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				res = new Config();
				res.id= rs.getInt(1);
				res.key= k;
				res.value=rs.getString(3) ;
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
		return res;
	}
	
	public List<Config> listAll(){
		return  list(0,Short.MAX_VALUE);
	}
	
	public List<Config> list(int s , int e){
		List<Config> al = new ArrayList<>();
		String sql = "select * from config order by id desc limit ?,?"; 
		try(Connection c = DBUtil.getConnection() ; PreparedStatement ps = c.prepareStatement(sql) ){
			ps.setInt(1, s);
			ps.setInt(2, e);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				Config cfg = new Config();
				cfg.setId(rs.getInt(1));
				cfg.setKey(rs.getString(2));
				cfg.setValue(rs.getString(3));
				al.add(cfg);
			}
		}catch (Exception ee) {
			ee.printStackTrace();
		}
		return al;
	}
}
