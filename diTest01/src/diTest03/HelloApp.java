package diTest03;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;


public class HelloApp {

	public static void main(String[] args) {
		ApplicationContext context=new ClassPathXmlApplicationContext("diTest03/beans.xml");
		MessageBean bean=(MessageBean)context.getBean("mb");
		bean.sayHello("spring");
	}
}
