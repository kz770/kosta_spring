package exam11;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Component
public class MySqlArticleDAO {
	public void insert() {
		System.out.println("추가하였습니다.");
	}
}
