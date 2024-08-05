package exam08;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainTest {
	public static void main(String[] args) {
		System.out.println("1");
		ApplicationContext context
		= new ClassPathXmlApplicationContext("exam08/beans.xml");		
		System.out.println("2");
		
		Person p1 = (Person)context.getBean("kim");
		Person p2 = (Person)context.getBean("kim");
		System.out.println("3");
		if(p1 == p2) {
			System.out.println("서로 같은 객체를 참조함.");
		}else {
			System.out.println("서로 다른 객체를 참조함.");
		}
		
		p1.setAge(30);
		
		System.out.println(p1);
		System.out.println(p2);
	}
}







