package model;

public class SaleDetail {
	private Integer saleId;
	private Integer itemId;
	private Integer quantity;
	private Integer saleDetailId;
	private String buy_date;
	private Sale sale;
	private Item item;
	
	public SaleDetail(Sale sale, Integer saleDetailId, ItemSet itemSet) {
		this.sale=sale; this.saleDetailId=saleDetailId; this.item = itemSet.getItem();
		this.quantity = itemSet.getQuantity();
	}
	

	public Item getItem() {
		return item;
	}


	public String getBuy_date() {
		return buy_date;
	}


	public void setBuy_date(String buy_date) {
		this.buy_date = buy_date;
	}


	public Integer getSaleId() {
		return saleId;
	}
	public void setSaleId(Integer saleId) {
		this.saleId = saleId;
	}
	public Integer getItemId() {
		return itemId;
	}
	public void setItemId(Integer itemId) {
		this.itemId = itemId;
	}
	public Integer getQuantity() {
		return quantity;
	}
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	public Integer getSaleDetailId() {
		return saleDetailId;
	}
	public void setSaleDetailId(Integer saleDetailId) {
		this.saleDetailId = saleDetailId;
	}
	public Sale getSale() {
		return sale;
	}
	public void setSale(Sale sale) {
		this.sale = sale;
	}
	
}
