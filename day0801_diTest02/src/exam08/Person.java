package exam08;

public class Person {	
	String name;
	int age;
	
	public Person() {
		System.out.println("������ ������");
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
