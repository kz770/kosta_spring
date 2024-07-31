package diTest05;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class InsertTest {
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("diTest05/beans.xml");
		WriteArticleServiceImple ws = (WriteArticleServiceImple)context.getBean("ws");
		ws.pro();
	}
}
