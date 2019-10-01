package service;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import dao.ConfigDao;
import dao.RecordDao;
import entity.Record;
import gui.page.SpendPage;
import util.DateUtil;

public class SpendService {
	
	RecordDao  rd = new RecordDao();
	ConfigDao  cd = new ConfigDao();
	int base ; 
	Calendar c = Calendar.getInstance();
	Date today = DateUtil.today();
	Date month_s = DateUtil.MonthBegin();
	Date month_e = DateUtil.MonthEnd();
	List<Record> rs ; 
	public SpendPage  getSpendPage() {
		if(null == cd.getByKey("budget")) {
			base= 1;
		}else {
			base = Integer.parseInt(cd.getByKey("budget").getValue()); 
		}
		
		c.setTime(today);
		int past_days = c.get(c.DAY_OF_MONTH);
		c.setTime(month_e);
		int total_days = c.get(c.DAY_OF_MONTH);
		int rest_days = c.get(c.DAY_OF_MONTH)- past_days;
		// compute monthSpend
		int monthSpend = 0  ;
		rs = rd.listThisMonth();
		for(Record i : rs) {
			monthSpend += i.spend;
		}
		
		// compute todaySpend
		int todaySpend =0; 
		rs = rd.listToday();
		for(Record i : rs) {
			todaySpend += i.spend;
		}
		
		// compute dayAvgSpend
		int dayAvgSpend = 0; 
		int sum=0;
		rs = rd.list(month_s,today);
		for(Record i : rs) {
			sum += i.spend;
		}
		dayAvgSpend = sum/past_days;
		
		// compute monthRest
		int monthRest = base - monthSpend ; 
		
		// compute dayAvgRest
		int dayAvgRest = monthRest/rest_days; 
		
		// compute monthEnd
		int monthEnd = rest_days ;

		// compute usePercent
		int usePercent = (int) (sum/((base*1.0f) )*100);
		System.out.println(usePercent);
		System.out.println(sum);
		SpendPage sp = new SpendPage(monthSpend,todaySpend,dayAvgSpend,monthRest,dayAvgRest,monthEnd,usePercent);
		return sp;
	}
	public static void main(String[] args) {
		System.out.println(new SpendService().getSpendPage());
	}
}
