package test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Repository("goodsDAO")
public class GoodsDAO {
	@Autowired
	private GoodsVO goodsVO;

	public void insert() {
		System.out.println("��ǰ�� ����Ͽ����ϴ�.");
		System.out.println(goodsVO);
	}
}
