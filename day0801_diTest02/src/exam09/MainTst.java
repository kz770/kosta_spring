package exam09;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainTst {
	public static void main(String[] args) {
		ApplicationContext context=new AnnotationConfigApplicationContext(SpringConfig.class);
		Person p=(Person)context.getBean("kim");
		System.out.println(p);
	}
}
