package exam03;

public class SystemMonitor {
	private int periodTime;
	private SMSSender sender;
	
	
	
	public void setPeriodTime(int periodTime) {
		this.periodTime = periodTime;
	}



	public void setSender(SMSSender sender) {
		this.sender = sender;
	}



	public void monitor() {
		System.out.println(periodTime+"�� ��������");
		sender.send();
		System.out.println("====================");
	}
	
}
