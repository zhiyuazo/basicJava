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
		this.monthSpend = "��" + monthSpend;  
		this.todaySpend = "��" + todaySpend; ;
		this.dayAvgSpend= "��" + dayAvgSpend; 
		
		if(monthRest > 0) {
			this.monthRest = "��" + monthRest;    
			this.dayAvgRest = "��" + dayAvgRest;
		}else {
			this.monthRest = "��֧" + (0-monthRest);    
			this.dayAvgRest = "��0";
		}
		this.monthEnd   = monthEnd + "��";  
		this.usePercent = usePercent;
	}
}
