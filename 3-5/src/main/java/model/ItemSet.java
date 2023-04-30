package model;

public class ItemSet {
	private Integer quantity; //개수
	private Item item; //상품 객체
	
	public ItemSet(Item item, Integer quantity) {
		this.item=item; this.quantity=quantity;
	}
	public void addQuantity(Integer addQuantity) {
		quantity = quantity + addQuantity ;
	} //개수 변경 메서드

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public Item getItem() {
		return item;
	}

	public void setItem(Item item) {
		this.item = item;
	}
}
