package diTest07;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MonitorTest {
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("diTest07/beans.xml");
		SystemMonitor sm=(SystemMonitor) context.getBean("sm");
		sm.monitor();
	}
}
