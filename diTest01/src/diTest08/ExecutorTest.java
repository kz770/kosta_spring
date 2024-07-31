package diTest08;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ExecutorTest {
	public static void main(String[] args) {
		ApplicationContext context=new ClassPathXmlApplicationContext("diTest08/beans.xml");
		Executor exe=(Executor) context.getBean("executor");
		exe.execute();
	}
}
