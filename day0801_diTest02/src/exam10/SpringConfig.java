package exam10;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringConfig {
	@Bean
	public GoodsVO goodsVO() {
		GoodsVO g= new GoodsVO(10,"Ãà±¸°ø",20,5000);
		return g;
	}
	
	@Bean
	public GoodsDAO dao() {
		GoodsDAO d=new GoodsDAO();
		d.setGoodsVO(goodsVO());
		return d;
	}
}
