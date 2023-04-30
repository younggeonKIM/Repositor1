package dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import model.FloSort;
import model.Present;

@Repository
public class PresDaoImpl implements PresDao {
	@Autowired
	private SqlSession session;
	
	public List<String> getFloMsg() {
		List<String> lis = session.selectList("mapper.myhome.getFloMsgs");
		return lis;
	}

	public List<FloSort> getFloDetByMsg(Present pst) {
		List<FloSort> lis = session.selectList("mapper.myhome.getDetailByMsg", pst);
		return lis;
	}
	
	
}
