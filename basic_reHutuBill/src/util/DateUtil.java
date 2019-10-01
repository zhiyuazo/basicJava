package util;

import java.util.Calendar;
import java.util.Date;

public class DateUtil {
	
	
	public static java.sql.Date util2sql(java.util.Date d){
		return new java.sql.Date(d.getTime());
	}
	
	public static int totalDays() {
		Calendar c = Calendar.getInstance();
		c.setTime(MonthEnd());
		return c.get(c.DATE);
	}
	
	public static Date today() {
		Calendar c = Calendar.getInstance();
		c.setTime(new Date());
		c.set(Calendar.HOUR,0);
		c.set(Calendar.MINUTE,0);
		c.set(Calendar.SECOND,0);
		return c.getTime();
	}
	
	public static Date MonthBegin() {
		Calendar c = Calendar.getInstance();
		c.setTime(new Date());
		c.set(Calendar.DATE,1);
		c.set(Calendar.HOUR_OF_DAY,0);
		c.set(Calendar.MINUTE,0);
		c.set(Calendar.SECOND,0);
		c.set(Calendar.MILLISECOND,0);
		return c.getTime();
	
	}
	
	public static Date MonthEnd() {
		Calendar c = Calendar.getInstance();
		c.setTime(new Date());
		c.set(Calendar.HOUR,0);
		c.set(Calendar.MINUTE,0);
		c.set(Calendar.SECOND,0);
		//----
		c.set(Calendar.DATE,1);
		c.add(Calendar.MONTH,1);
		c.add(Calendar.DATE,-1);
		return c.getTime();
	}
}
