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
	
	public Item findById(Integer id) {
		Item item=session.selectOne("mapper.myhome.getItem", id);
		return item;
		
	}
	public List<Item> findAll() {
		List<Item> list=session.selectList("mapper.myhome.getItemList");
		return list;
	}

}
