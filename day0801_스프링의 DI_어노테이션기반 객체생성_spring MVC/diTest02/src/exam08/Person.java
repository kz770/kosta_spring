package exam08;

public class Person {
	private String name;
	private int age;
	
	public Person() {
		System.out.println("생성자 동작함!");
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setAge(int age) {
		this.age = age;
	}
	@Override
	public String toString() {
		return "Person [name=" + name + ", age=" + age + "]";
	}
}
