package diTest10;

public class WriteArticleServiceImple {
	private MySqlArticleDAO dao;	//����(has-a)����

	
	
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
