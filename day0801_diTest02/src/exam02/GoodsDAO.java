package exam02;

public class GoodsDAO {
	private GoodsVO goodsVO;

	public void setGoodsVO(GoodsVO goodsVO) {
		this.goodsVO = goodsVO;
	}
	
	public void insert() {
		System.out.println("상품을 등록하였습니다.");
		System.out.println(goodsVO);
	}
}
