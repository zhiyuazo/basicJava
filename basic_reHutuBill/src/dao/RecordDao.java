package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import entity.Record;
import util.DBUtil;
import util.DateUtil;

public class RecordDao {
	
	public int getTotal() {
		int totle = 0;
		try(Connection c = DBUtil.getConnection() ;Statement s = c.createStatement() ){
			String sql = "select count(*) from record";
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
	
	public void add(Record r) {
		String sql = "insert into record values(null,?,?,?,?)"; 
		try(Connection c = DBUtil.getConnection() ; PreparedStatement ps = c.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS) ){
			ps.setInt(1, r.spend);
			ps.setInt(2, r.cid);
			ps.setString(3, r.comment);
			ps.setDate(4, DateUtil.util2sql(r.date));
			ps.execute();
			ResultSet  rs = ps.getGeneratedKeys();
			if(rs.next()) {
				r.id = rs.getInt(1);
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void update(Record r) {
		String sql = "update record set spend=?,cid=?, comment=? , date= ? where id =?"; 
		try(Connection c = DBUtil.getConnection() ; PreparedStatement ps = c.prepareStatement(sql) ){
			ps.setInt(1, r.spend);
			ps.setInt(2, r.cid);
			ps.setString(3, r.comment);
			ps.setDate(4,DateUtil.util2sql(r.date));
			ps.setInt(5, r.id);
			ps.execute();
		}catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void delete(int id) {
		String sql = "delete from record where id =" + id; 
		try(Connection c = DBUtil.getConnection() ; Statement s = c.createStatement() ){
			s.execute(sql);
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public Record getById(int id) {
		Record  res = null;
		try(Connection c = DBUtil.getConnection() ; Statement s = c.createStatement() ){
			String sql = "select * from record where id =" + id;
			s.execute(sql);
			ResultSet rs = s.getResultSet();
			if(rs.next()) {
				res = new Record();
				res.id= id;
				res.spend= rs.getInt(2);
				res.cid=rs.getInt(3) ;
				res.comment=rs.getString(4) ;
				res.date=rs.getDate(5);
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
		return res;
	}
	
	public List<Record> list(int s , int e){
		List<Record> al = new ArrayList<>();
		String sql = "select * from record order by id desc limit ?,?"; 
		try(Connection c = DBUtil.getConnection() ; PreparedStatement ps = c.prepareStatement(sql) ){
			ps.setInt(1, s);
			ps.setInt(2, e);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				Record res = new Record();
				res.id= rs.getInt(1);
				res.spend= rs.getInt(2);
				res.cid=rs.getInt(3) ;
				res.comment=rs.getString(4) ;
				res.date=rs.getDate(5);
				al.add(res);
			}
		}catch (Exception ee) {
			ee.printStackTrace();
		}
		return al;
	}
	//列出某一条目下所有记录
	public List<Record> list(int cid){
		List<Record> al = new ArrayList<>();
		String sql = "select * from record where cid = " + cid; 
		try(Connection c = DBUtil.getConnection() ; PreparedStatement ps = c.prepareStatement(sql) ){
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				Record res = new Record();
				res.id= rs.getInt(1);
				res.spend= rs.getInt(2);
				res.cid=rs.getInt(3) ;
				res.comment=rs.getString(4) ;
				res.date=rs.getDate(5);
				al.add(res);
			}
		}catch (Exception ee) {
			ee.printStackTrace();
		}
		return al;
	}
	
	//列出指定天记录
	public List<Record> list(Date d){
		List<Record> al = new ArrayList<>();
		String sql = "select * from record where date=?"; 
		try(Connection c = DBUtil.getConnection() ; PreparedStatement ps = c.prepareStatement(sql) ){
			ps.setDate(1, DateUtil.util2sql(d));
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				Record res = new Record();
				res.id= rs.getInt(1);
				res.spend= rs.getInt(2);
				res.cid=rs.getInt(3) ;
				res.comment=rs.getString(4) ;
				res.date=rs.getDate(5);
				al.add(res);
			}
		}catch (Exception ee) {
			ee.printStackTrace();
		}
		return al;
	}
	
	//列出指定月记录
	public List<Record> list(Date d1,Date d2){
		List<Record> al = new ArrayList<>();
//		String sql = "select * from record where date>=? and date<=?"; //Both OK! 
		String sql = "select * from record where date between ? and ?"; 
		try(Connection c = DBUtil.getConnection() ; PreparedStatement ps = c.prepareStatement(sql) ){
			ps.setDate(1, DateUtil.util2sql(d1));
			ps.setDate(2, DateUtil.util2sql(d2));
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				Record res = new Record();
				res.id= rs.getInt(1);
				res.spend= rs.getInt(2);
				res.cid=rs.getInt(3) ;
				res.comment=rs.getString(4) ;
				res.date=rs.getDate(5);
				al.add(res);
			}
		}catch (Exception ee) {
			ee.printStackTrace();
		}
		return al;
	}
	//列出今天	
	public List<Record> listToday (){
		return list(DateUtil.util2sql(DateUtil.today()));
	}
	//列出当月	
	public List<Record> listThisMonth (){
		return list(DateUtil.MonthBegin(),DateUtil.MonthEnd());
	}
	//列出所有	
	public List<Record> listAll(){
		return  list(0,Short.MAX_VALUE);
	}
	
	public static void main(String[] args) {
		RecordDao cd = new RecordDao();
//		Record rd =null;
//		for (int i = 0; i < 100; i++) {
//			rd = new Record();
//			rd.setSpend(i);
//			rd.setCid(8);
//			rd.setComment("");
//			rd.setDate(new Date());
//			cd.add(rd);
//		}
		cd.listThisMonth().forEach(u-> System.out.println(u.toString()));
	}
	
}
