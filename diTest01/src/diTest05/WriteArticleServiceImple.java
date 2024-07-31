package diTest05;

public class WriteArticleServiceImple {
	private MySqlArticleDAO dao;	//포함(has-a)관계
	
	public WriteArticleServiceImple(MySqlArticleDAO dao) {
		this.dao=dao;
	}
	public void pro() {
		dao.insert();
	}
}
