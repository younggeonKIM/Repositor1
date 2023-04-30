package dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import model.FloMemb;

@Repository
public class MembDaoImpl implements MembDao {
	@Autowired
	private SqlSession session;
	
	public FloMemb findMemb(FloMemb fmb) {
		return session.selectOne("mapper.myhome.getFloMemb", fmb);

	}

	public void insertMemb(FloMemb fmb) {
		session.insert("mapper.myhome.putFloMemb", fmb);
		
	}
	
	
}
