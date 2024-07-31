package diTest08;

public class Executor {
	private Worker worker;
	private String runner;
	
	public Executor(Worker worker) {
		super();
		this.worker = worker;
		System.out.println("생성자1");
	}
	public Executor(String runner) {
		super();
		this.runner = runner;
		System.out.println("생성자2");
	}
	public void execute() {
		System.out.println("다음에 의해서 동작하였습니다.");
		if (worker!=null) {
			System.out.println(worker);
		}else{
			System.out.println(runner);
		}
	}
	
	
}
