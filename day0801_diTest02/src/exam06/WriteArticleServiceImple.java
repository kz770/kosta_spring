package exam06;

public class WriteArticleServiceImple {
	private MySqlArticleDAO dao;	//����(has-a)����
	
	
	public void setDao(MySqlArticleDAO dao) {
		this.dao = dao;
	}


	public void pro() {
		dao.insert();
	}
}
