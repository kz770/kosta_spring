package exam06;

public class WriteArticleServiceImple {
	private MySqlArticleDao dao;
	
	public void setDao(MySqlArticleDao dao) {
		this.dao = dao;
	}

	public void pro() {
		dao.insert();
	}
}
