package dao;

import java.util.List;

import model.Item;

public interface ItemDao {
	Item findById(Integer id);
	List<Item> findAll();
}
