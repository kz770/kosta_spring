package exam10;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainTest {
	public static void main(String[] args) {
		ApplicationContext context
		= new AnnotationConfigApplicationContext(SpringCofing.class);
		
		GoodsDAO dao = (GoodsDAO)context.getBean("dao");
		dao.insert();
	}
}
