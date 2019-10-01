package entity;

public class Config {
	public int id;
	public String key;
	public String value;
	
	public  int getId() {
		return  id;
	}
	
	public  String getKey() {
		return  key;
	}
	public  String getValue() {
		return  value;
	}
	
	public  void setId(int id) {
		this.id = id;
	}
	
	public  void setKey(String k) {
		this.key = k;
	}
	public  void setValue(String v) {
		this.value = v;
	}
	
	public String toString() {
		return String.valueOf(id) + "_" + key + "_" + value;
	}
	
	public boolean equals(Config c) {
		if(this.id == c.getId() && this.key.equals(c.getKey()) && this.value.equals(c.getValue())) {
			return true;
		}else {
			return false;
		}
	}
}
