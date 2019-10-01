package service;

import java.util.Date;

import dao.RecordDao;
import entity.Category;
import entity.Record;

public class RecordService {
	RecordDao  rd = new RecordDao();
	public  void add(int spend , Category c , String comment , Date d) {
		Record r = new Record();
		r.spend = spend;
		r.cid =  c.id;
		r.comment = comment;
		r.date = d; 
		rd.add(r);
	}
}
