package model;

import java.util.ArrayList;

public class Sale {
	private User user;
	private Integer saleId;
	private String userId;
	private String buy_date;
	
	private ArrayList<SaleDetail> saleDetailList = new ArrayList<SaleDetail>();
	
	public void addSaleDetail (SaleDetail detail) {
		this.saleDetailList.add(detail);
	} //매출 상세 정보 추가 메서드

	
	public String getBuy_date() {
		return buy_date;
	}


	public void setBuy_date(String buy_date) {
		this.buy_date = buy_date;
	}


	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Integer getSaleId() {
		return saleId;
	}

	public void setSaleId(Integer saleId) {
		this.saleId = saleId;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public ArrayList<SaleDetail> getSaleDetailList() {
		return saleDetailList;
	}

	public void setSaleDetailList(ArrayList<SaleDetail> saleDetailList) {
		this.saleDetailList = saleDetailList;
	}
	
	
}
