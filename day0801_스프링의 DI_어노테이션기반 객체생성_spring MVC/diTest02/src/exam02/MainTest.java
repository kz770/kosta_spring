package exam02;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainTest {
	public static void main(String[] args) {
		ApplicationContext applicationContext
		 = new ClassPathXmlApplicationContext("exam02/beans.xml");
		
		GoodsDAO dao  =(GoodsDAO) applicationContext.getBean("goodsDAO");
		dao.insert();
	}
}
