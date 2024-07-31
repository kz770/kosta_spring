package diTest08;

public class Executor {
	private Worker worker;
	private String runner;
	
	public Executor(Worker worker) {
		super();
		this.worker = worker;
		System.out.println("������1");
	}
	public Executor(String runner) {
		super();
		this.runner = runner;
		System.out.println("������2");
	}
	public void execute() {
		System.out.println("������ ���ؼ� �����Ͽ����ϴ�.");
		if (worker!=null) {
			System.out.println(worker);
		}else{
			System.out.println(runner);
		}
	}
	
	
}
