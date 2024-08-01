package exam03;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainTest {
	public static void main(String[] args) {
		ApplicationContext context=new ClassPathXmlApplicationContext("exam03/beans.xml");
		SystemMonitor sm=(SystemMonitor)context.getBean("systemMonitor");
		sm.monitor();
	}
}
