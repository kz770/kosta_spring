package exam06;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainTest {

	public static void main(String[] args) {
		ApplicationContext context=new ClassPathXmlApplicationContext("exam06/beans.xml");
		WriteArticleServiceImple ws=(WriteArticleServiceImple)context.getBean("ws");
		ws.pro();
	}

}
