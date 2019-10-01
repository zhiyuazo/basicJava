package service;

import java.awt.Image;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import dao.RecordDao;
import entity.Record;
import util.ChartUtil;
import util.DateUtil;
import util.ShowUtil;

public class ReportService {
	
	RecordDao  rd = new RecordDao() ;

	public  int countDaySpend(Date d) {
		List<Record> day_rs = rd.list(d);
		int sum = 0; 
		for(Record r : day_rs) {
			sum += r.spend;
		}
		return sum;
	}

	public double[] eachDaySpendInThisMonth(){
		int totalDays = DateUtil.totalDays();
		double[] result = new double[totalDays];
		Calendar c = Calendar.getInstance();
		Date begin = DateUtil.MonthBegin();
		c.setTime(begin);
		for (int i = 0; i < totalDays; i++) {
			result[i] = countDaySpend(c.getTime());
			c.add(Calendar.DATE, 1);
		}
		return result;
	}
}
