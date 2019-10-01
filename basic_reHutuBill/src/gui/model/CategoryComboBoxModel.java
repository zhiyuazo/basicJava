package gui.model;

import java.util.List;

import javax.swing.ComboBoxModel;
import javax.swing.event.ListDataListener;

import entity.Category;
import service.CategoryService;

public class CategoryComboBoxModel implements ComboBoxModel<Category>{
	public List<Category> cs = new CategoryService().listAll();
	
	public Category c  ; 
	
	public CategoryComboBoxModel(){
		if(!cs.isEmpty()) {
			c = cs.get(0);
		}
	}
	
	
	@Override
	public void addListDataListener(ListDataListener arg0) {
		
	}

	@Override
	public Category getElementAt(int ind) {
		return cs.get(ind);
	}

	@Override
	public int getSize() {
		return cs.size();
	}

	@Override
	public void removeListDataListener(ListDataListener arg0) {
		
	}

	@Override
	public Object getSelectedItem() {
		if(cs.isEmpty() ) {
			return null;
		}else {
			return c ;
		}
	}

	@Override
	public void setSelectedItem(Object anItem) {
		c = (Category) anItem;
	}
	
}
