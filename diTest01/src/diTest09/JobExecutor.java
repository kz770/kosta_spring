package diTest09;

public class JobExecutor {
	public JobExecutor(String name,int seconds) {
		System.out.println("생성자 호출1");
	}
	public JobExecutor(String name, long miliseconds) {
		System.out.println("생성자 호출2");
	}
//	public JobExecutor(String name, String seconds) {
//		System.out.println("생성자 호출3");
//	}
	public void pro() {
		System.out.println("job executor");
	}
}
