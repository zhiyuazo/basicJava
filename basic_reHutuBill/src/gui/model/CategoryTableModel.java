package gui.model;

import java.util.List;

import javax.swing.table.AbstractTableModel;

import entity.Category;
import service.CategoryService;

public class CategoryTableModel extends AbstractTableModel{
	
	static CategoryService cs = new CategoryService();
	
	
//	String[] head = new String[] {"序号","分类名称","消费次数"};
	String[] head = new String[] {"分类名称","消费次数"};
	public List<Category> data = cs.listAll() ;
	
	@Override
	public int getColumnCount() {
		return head.length;
	}
	//add by self
	public String getColumnName(int ind) {
		return head[ind];
	}

	@Override
	public int getRowCount() {
		return data.size();
	}

	@Override
	public Object getValueAt(int ind1, int ind2) {
		if(0== ind2) {
			return data.get(ind1).name; 
		}
		if(1== ind2) {
			return data.get(ind1).number; 
		}
		return null;
		
	}
	
	public boolean isCellEditable(int ind1, int ind2) {
		return false;
	}
}
