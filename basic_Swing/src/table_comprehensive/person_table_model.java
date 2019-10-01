package table_comprehensive;

import java.util.*;
import javax.swing.table.AbstractTableModel;

public class person_table_model extends AbstractTableModel {

	String[] head = new String[] {"id","name","hp","age"};
	
	public List<person> all = new LinkedList<>();
	
	person_table_model(){
		person tmp;
		Random rnd  = new Random();
		for(int i = 0;i<3;i++) {
			String id = String.valueOf(i);
			String name = "nokia-" + id;
			String hp = String.valueOf(rnd.nextInt(120)+1);
			String age = String.valueOf(rnd.nextInt(45)+1);
			String[] bundle = {id,name,hp,age};		
			tmp = new person(bundle);
			all.add(tmp);
			
		}
	}
	
	
	public void delete(int idx) {
		all.remove(idx);
	}
	
	public void add(String[] p) {
		if(p.length != 4) {
			System.out.println("args not correct!");
			System.exit(100);
		}else {
			all.add(0,new person(p));
		}	
	}
	
	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return all.size() ; 
	}
	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return head.length;
	}
	
	public String getColumnName(int ind) {
		return head[ind];
	}
	
	public boolean isCellEditable(int rowIndex,int columnIndex) {
		return false;
	}
	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		// TODO Auto-generated method stub
		person p = all.get(rowIndex); 
		if(columnIndex == 0) {
			return p.getid();
		}
		if(columnIndex == 1) {
			return p.getname();
		}
		if(columnIndex == 2) {
			return p.gethp();
		}
		if(columnIndex == 3) {
			return p.getage();
		}
		return null;
	}
}

class person {
	private String id;
	private String name;
	private String hp;
	private String age;
	
	public person(String[] info) {
		this.id = info[0];
		this.name = info[1];
		this.hp =info[2];
		this.age = info[3];
	}
	public String getid() {
		return id;
	}
	
	public String getname() {
		return name;
	}
	public String gethp() {
		return hp;
	}
	public String getage() {
		return age;
	}
}

