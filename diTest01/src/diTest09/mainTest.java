package diTest09;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class mainTest {

	public static void main(String[] args) {
		ApplicationContext context=new ClassPathXmlApplicationContext("diTest09/beans.xml");
		JobExecutor job=(JobExecutor)context.getBean("job");
		job.pro();
	}

}
