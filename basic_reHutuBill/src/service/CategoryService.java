package service;

import java.util.List;

import dao.CategoryDao;
import entity.Category;

public class CategoryService {
	
	static CategoryDao cd = new CategoryDao();
	
	public  List<Category> listAll() {
		return  cd.listAll();
	}
	
	public void add(String n ) {
		Category c = new Category();
		c.name = n ; 
		c.number = 0 ; 
		cd.add(c);
	}
	
	public void update(Category  c) {
		cd.update(c);
	}
	
	public void delete(int id ) {
		cd.delete(id);
	}
	
}
