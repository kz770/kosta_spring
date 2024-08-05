package exam11;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("ws")
public class WriteArticleServiceImple {
	@Autowired
	private MySqlArticleDao dao;
	
	public void setDao(MySqlArticleDao dao) {
		this.dao = dao;
	}

	public void pro() {
		dao.insert();
	}
}
