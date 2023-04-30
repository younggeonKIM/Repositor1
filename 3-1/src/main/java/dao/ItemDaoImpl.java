package dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import model.Item;

public class ItemDaoImpl implements ItemDao {
	private SqlSession session;
	public void setSession(SqlSession session) {
		this.session = session;
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
