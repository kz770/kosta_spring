package diTest08;

public class Worker {
	private String name;
	private int age;
	
	@Override
	public String toString() {
		return "Worker [name=" + name + ", age=" + age + "]";
	}
	public Worker(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}
	
}
