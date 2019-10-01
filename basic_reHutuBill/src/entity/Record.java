package entity;

import java.util.Date;

public class Record {
	
	public  int id ;
	public  int spend ;
	public  int cid ;
	public String comment;
	public  Date date;
	
	public  int getId() {
		return  id;
	}
	
	public  int getSpend() {
		return  spend;
	}
	
	public  int getCid() {
		return  cid;
	}
	
	public String getComment(String c) {
		return comment ;
	}
	public  Date getDate() {
		return  date;
	}
	
	//---
	public  void setId(int id) {
		this.id= id;
	}
	
	public  void setSpend(int spend) {
		this.spend = spend;
	}
	
	public  void setCid(int cid) {
		this.cid= cid;
	}
	
	public  void setComment(String comment) {
		this.comment = comment;
	}
	public  void setDate(Date d) {
		this.date = d;
	}
	
	public String toString() {
		return String.format("%d_%d_%d_%s_%s", id,spend,cid,comment,date.toString());
	}
	
	
}
