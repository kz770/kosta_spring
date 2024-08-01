package exam07;

public class WriteArticleServiceImple {
	private MySqlArticleDAO dao;	//포함(has-a)관계
	
	
	public void setDao(MySqlArticleDAO dao) {
		this.dao = dao;
	}


	public void pro() {
		dao.insert();
	}
}
