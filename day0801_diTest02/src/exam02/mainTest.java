package exam02;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class mainTest {
	public static void main(String[] args) {
		ApplicationContext context=new ClassPathXmlApplicationContext("exam02/beans.xml");
		GoodsDAO dao=(GoodsDAO)context.getBean("dao");
		dao.insert();
	}
}
