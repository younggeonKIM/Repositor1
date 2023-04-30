package model;

import java.util.ArrayList;

public class Cart {
	private ArrayList<ItemSet> itemList = new ArrayList<ItemSet>();

	public ArrayList<ItemSet> getItemList() {
		return itemList;
	}
	
	public void push(ItemSet pushedItemSet) {
		boolean itemExistInCart = false; //이미 있는 물건인지 검사
		Item pushedItem = pushedItemSet.getItem();
		int pushedItemId = pushedItem.getItemId(); //담으려는 상품번호
		for (ItemSet cartItemSet : this.itemList ) {
			Item cartItem = cartItemSet.getItem(); //장바구니 상품
			int cartItemId = cartItem.getItemId(); //장바구니 속 기존 상품번호
			if(pushedItemId == cartItemId) {
				cartItemSet.addQuantity(pushedItemSet.getQuantity());
				itemExistInCart = true; //이미 동일 상품이 존재함을 검사
				break; //반복 중지
			} //장바구니 속 기존 상품번호와 담으려는 상품번호가 같은 경우
		} //for의 끝
		if( ! itemExistInCart) {this.itemList.add(pushedItemSet); }//장바구니에 추가
	} //메서드의 끝
	
	public void clearAll() {
		this.itemList = new ArrayList<ItemSet>();
	} //장바구니(itemList>를 비우는 메서드
	
	public boolean isEmpty() {
		if(this.itemList == null || this.itemList.isEmpty()) {
			return true;
		} return false;
	}
}
