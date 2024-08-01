package exam12;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("ws")
public class WriteArticleServiceImple {
	
	@Autowired
	private MySqlArticleDAO dao;	//포함(has-a)관계
	
	
	public void setDao(MySqlArticleDAO dao) {
		this.dao = dao;
	}


	public void pro() {
		dao.insert();
	}
}
