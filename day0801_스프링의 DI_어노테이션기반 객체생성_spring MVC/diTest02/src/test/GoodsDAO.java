package test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Repository("goodsDAO")
public class GoodsDAO {
	@Autowired
	private GoodsVO goodsVO;

	public void insert() {
		System.out.println("상품을 등록하였습니다.");
		System.out.println(goodsVO);
	}
}
