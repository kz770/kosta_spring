package exam12;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Repository
public class MySqlArticleDao {
	public void insert() {
		System.out.println("추가하였습니다.");
	}
}
