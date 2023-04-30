package dao;

import java.util.List;

import model.Item;

public interface ItemDao {
	Item findById(Integer id);
	List<Item> findAll();
	void create(Item item); //상품 삽입
	void delete(Integer id); //상품 삭제
	void update(Item item); //상품 변경
	
	List<Item> findByName(String name); //이름으로 상품 검색
}
