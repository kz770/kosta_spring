package exam09;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringCofig {
	
	@Bean
	public Person kim() {
		Person p = new Person();
		p.setName("������");
		p.setAge(20);
		return p;
	}
}
