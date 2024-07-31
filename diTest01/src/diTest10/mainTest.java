package diTest10;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class mainTest {
	public static void main(String[] args) {
		
		ApplicationContext context=new ClassPathXmlApplicationContext("diTest10/beans.xml");
		WriteArticleServiceImple ws=(WriteArticleServiceImple) context.getBean("ws");
		ws.pro();
	}
}
