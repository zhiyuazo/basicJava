package gui.page;

public class SpendPage {
	
	public String monthSpend ; 
	public String todaySpend ; 
	public String dayAvgSpend ; 
	public String monthRest ; 
	public String dayAvgRest; 
	public String monthEnd ;
	public int usePercent; 
	
	public SpendPage(int monthSpend , int todaySpend , int dayAvgSpend ,
			         int monthRest, int dayAvgRest , int monthEnd,int usePercent) {
		this.monthSpend = "гд" + monthSpend;  
		this.todaySpend = "гд" + todaySpend; ;
		this.dayAvgSpend= "гд" + dayAvgSpend; 
		
		if(monthRest > 0) {
			this.monthRest = "гд" + monthRest;    
			this.dayAvgRest = "гд" + dayAvgRest;
		}else {
			this.monthRest = "│м╓з" + (0-monthRest);    
			this.dayAvgRest = "гд0";
		}
		this.monthEnd   = monthEnd + "╠ь";  
		this.usePercent = usePercent;
	}
}
