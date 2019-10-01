package entity;

public class Category {
	
	public  int id ;
	public String name;
	public  int number;
	
	public  int getId() {
		return  id;
	}
	
	public  String getName() {
		return  name;
	}
	public  int getNumber() {
		return  number;
	}
	
	public  void setId(int id) {
		this.id = id;
	}
	
	public  void setName(String name) {
		this.name = name;
	}
	
	public  void setNumber(int number) {
		this.number = number;
	}
	
	public String toString() {
		return this.name;
	}
}
