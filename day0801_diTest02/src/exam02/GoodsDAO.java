package exam02;

public class GoodsDAO {
	private GoodsVO goodsVO;

	public void setGoodsVO(GoodsVO goodsVO) {
		this.goodsVO = goodsVO;
	}
	
	public void insert() {
		System.out.println("��ǰ�� ����Ͽ����ϴ�.");
		System.out.println(goodsVO);
	}
}
