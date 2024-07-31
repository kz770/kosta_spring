package diTest10;

public class WriteArticleServiceImple {
	private MySqlArticleDAO dao;	//포함(has-a)관계

	
	
	public WriteArticleServiceImple() {
		super();
		// TODO Auto-generated constructor stub
	}


	public void setDao(MySqlArticleDAO dao) {
		this.dao = dao;
	}


	public void pro() {
		dao.insert();
	}
}
