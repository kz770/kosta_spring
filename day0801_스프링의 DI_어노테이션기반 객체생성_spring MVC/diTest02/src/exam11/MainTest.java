package exam11;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainTest {
	public static void main(String[] args) {
		ApplicationContext context
		= new ClassPathXmlApplicationContext("exam11/beans.xml");
		WriteArticleServiceImple ws = (WriteArticleServiceImple)context.getBean("ws");
		ws.pro();
	}
}
