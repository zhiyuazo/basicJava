package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import entity.Category;
import service.CategoryService;
import util.DBUtil;

public class CategoryDao {
	
	public void delete (int id) {
		String sql = "delete from category where id =" + id;
		try(Connection c = DBUtil.getConnection(); PreparedStatement ps = c.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS)){
			ps.execute();
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void update(Category cg) {
		String sql = "update category set name=?, number=? where id = ?";
		try(Connection c = DBUtil.getConnection(); PreparedStatement ps = c.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS)){
			ps.setString(1, cg.name);
			ps.setInt(2, cg.number);
			ps.setInt(3, cg.id);
			ps.execute();
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void add (Category cg) {
		String sql = "insert category values(null,?,?)";
		try(Connection c = DBUtil.getConnection(); PreparedStatement ps = c.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS)){
			ps.setString(1, cg.name);
			ps.setInt(2, cg.number);
			ps.execute();
			ResultSet rs = ps.getGeneratedKeys();
			if(rs.next()) {
				cg.id = rs.getInt(1);
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
	}

	public Category getById(int id ) {
		Category kind = null;
		try(Connection c = DBUtil.getConnection(); Statement s = c.createStatement()){
			String sql = "select * from category where id=" + id;
			s.execute(sql);
			ResultSet rs = s.getResultSet();
			if(rs.next()) {
				kind = new Category();
				kind.id = id  ;
				kind.name = rs.getString(2)  ;
				kind.number =rs.getInt(3)  ;
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
		return kind;
	}
	
	public Category getByName(String n ) {
		Category kind = null;
		String sql = "select * from category where name=?";
		try(Connection c = DBUtil.getConnection(); PreparedStatement ps = c.prepareStatement(sql)){
			ps.setString(1, n);
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				kind = new Category();
				kind.id = rs.getInt(1)  ;
				kind.name = n  ;
				kind.number =rs.getInt(3)  ;
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
		return kind;
	}
	
	public int getTotal() {
		int total = 0 ;
		try(Connection c = DBUtil.getConnection(); Statement s = c.createStatement()){
			String sql = "select count(*) from category";
			s.execute(sql);
			ResultSet rs = s.getResultSet();
			if(rs.next()) {
				total = rs.getInt(1);
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
		return total;
	}
	
	public List<Category> listAll() {
		return list(0,Short.MAX_VALUE);
	}
	
	public List<Category> list(int s,int e) {
		List<Category> al = new ArrayList<>();
		Category cg ;
		try(Connection c = DBUtil.getConnection(); Statement ss = c.createStatement()){
			String sql = "select * from category";
			ss.execute(sql);
			ResultSet rs = ss.getResultSet();
			while(rs.next()) {
				cg = new Category();
				cg.setId(rs.getInt(1));
				cg.setName(rs.getString(2));
				cg.setNumber(rs.getInt(3));
				al.add(cg);
			}
		}catch (Exception ee) {
			ee.printStackTrace();
		}
		return al;
	}
}
