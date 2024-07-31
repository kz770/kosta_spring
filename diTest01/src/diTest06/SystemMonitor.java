package diTest06;

public class SystemMonitor {
	
	private int periodTime;
	
	public SystemMonitor(int periodTime) {
		this.periodTime=periodTime;
	}
	
	public void monitor() {
		System.out.println(periodTime+"분 간격으로 모니터링 합니다");
	}
}
