package dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import model.FloSort;



@Repository
public class SortDaoImpl implements SortDao {
	
	@Autowired
	private SqlSession session;
	
	public List<FloSort> getAllFloName() {
		return session.selectList("mapper.myhome.getFloSortName");
	}

	public List<FloSort> getFloMGSN(String name) {
		System.out.println("이름:["+name+"]");
		List<FloSort> li = session.selectList("mapper.myhome.getFloMGSN", name);
		return li;
	}

	public Integer floMGSNno(String name) {
		Integer num = session.selectOne("mapper.myhome.getMGSNno", name);
		return num;
	}

	public FloSort getFloDetail(FloSort fst) {
		FloSort lis = session.selectOne("mapper.myhome.getFloDetail", fst );
		return lis;
	}

	

}
