package dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import model.Item;

@Repository
public class ItemDaoImpl implements ItemDao {
	@Autowired
	private SqlSession session;
	
	
	
	
	public List<Item> findByName(String name) {
		return session.selectList("mapper.myhome.findItem", name);
	}


	public void update(Item item) {
		session.update("mapper.myhome.updateItem", item);
		
	}


	public void delete(Integer id) {
		session.delete("mapper.myhome.deleteItem", id);
	}


	public void create(Item item) {
		session.insert("mapper.myhome.putItem", item);
		
	}


	public Item findById(Integer id) {
		Item item=session.selectOne("mapper.myhome.getItem", id);
		return item;
	}


	public List<Item> findAll() {
		List<Item> list=session.selectList("mapper.myhome.getItemList");
		return list;
	}

}
