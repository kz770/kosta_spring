package diTest06;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MonitoringTest {
	public static void main(String[] args) {
		ApplicationContext context=new ClassPathXmlApplicationContext("diTest06/beans.xml");
		SystemMonitor sm=(SystemMonitor)context.getBean("sm");
		sm.monitor();
	}
}
