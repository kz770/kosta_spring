package diTest07;

public class SystemMonitor {
	private int periodTime;
	private SMSSender sender;
	
	public SystemMonitor(int min,SMSSender sender) {
		this.sender=sender;
		this.periodTime=min;
	}
	
	public void monitor() {
		System.out.println(periodTime+"�� ��������");
		sender.send();
		System.out.println("====================");
	}
	
}
