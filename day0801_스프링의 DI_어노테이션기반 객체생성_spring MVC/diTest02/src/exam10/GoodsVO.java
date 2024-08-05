package exam10;

public class GoodsVO {
	private int no;
	private String item;
	private int qty;
	private int price;
	public GoodsVO(int no, String item, int qty, int price) {
		super();
		this.no = no;
		this.item = item;
		this.qty = qty;
		this.price = price;
	}
	@Override
	public String toString() {
		return "GoodsVO [no=" + no + ", item=" + item + ", qty=" + qty + ", price=" + price + "]";
	}
}
