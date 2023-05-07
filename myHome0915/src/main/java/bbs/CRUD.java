package bbs;

import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import items.CartItem;
import items.Item;
import notice.Notice;

public class CRUD {
	private final String namespace="mapper.myhome";
	
	public List<CartItem> getCart (String id) {
		SqlSession ss = getSession();
		List<CartItem> list=null;
		try {
			list=ss.selectList(namespace+".getCart",id);
		}finally {
			ss.close();
		}
		return list;
	}
	public int deleteCart(CartItem ci) {
		SqlSession ss=getSession();
		int result=0;
		try {
			result=ss.delete(namespace+".deleteCart", ci);
			if(result>0) {ss.commit();}
			else {ss.rollback();}
		}finally {
			ss.close();
		}
		return result;
	}
	public int updateCart(CartItem ci) {
		SqlSession ss=getSession();
		int result=0;
		try {
			result=ss.update(namespace+".updateCart",ci);
			if(result>0) {
				ss.commit();
			}else {
				ss.rollback();
			}
		}finally {
			ss.close();
		}
		return result;
	}
	public int addCart(CartItem ci) {
		SqlSession ss=getSession();
		int result=0;
		try {
			result=ss.insert(namespace+".addCart",ci);
			if(result>0) {
				ss.commit();
			}else {ss.rollback();}
		}finally {
			ss.close();
		}
		return result; 
	}
	public int maxCart() {
		SqlSession ss=getSession();
		int result=-1;
		try {
			Integer r=ss.selectOne(namespace+".maxCart");
			if(r==null) {
				result=0;
			}else {result=r;}
		}finally {
			ss.close();
		}
		return result;
	}
	public Item getItem(String code) {
		SqlSession ss=getSession();
		Item item=null; //��ȸ ����� ������ ���� ����
		try {
			item=ss.selectOne(namespace+".getItem",code);
		}finally {
			ss.close();
		}
		return item;
	}
	public int putItem(Item it) {
		SqlSession ss=getSession();
		int result=-1;
		try {
			result=ss.insert(namespace+".putItem",it);
			if (result>0) {ss.commit();}
			else {ss.rollback();}
		}finally {
			ss.close();
		}return result;
	}
	public Notice getNotice(int seqno) {
		SqlSession ss=getSession();
		Notice notice = null;
		try {
			notice=ss.selectOne(namespace+".getNotice",seqno);
		}finally {
			ss.close();
		}
		return notice;
	}
	
	public int getNoticeCount() {
		SqlSession ss= getSession();
		int result=-1;
		try {
			Integer r = ss.selectOne(namespace+".getNoticeCount");
			if(r==null) {
				result=0;
			}else {result = r;}
		}finally {
			ss.close();
		}
		return result;
	}
	public List<Notice> getAllNotice(int pageNo) {
		SqlSession ss=getSession();
		List<Notice> list = null;
		try {
			list=ss.selectList(namespace+".getAllNotice",pageNo);
		}finally {
			ss.close();
		}
		return list;
	}
	public int getNoticeMaxSeqno() {
		SqlSession ss=getSession();
		int result=-1;
		try {
			Integer r =ss.selectOne(namespace+".getMaxSeqno");
			if(r==null) {
				result = 0;
			}else {
				result = r;
			}
		}finally {
			ss.close();
		}
		return result;
	}
	public int putNotice(Notice n) {
		SqlSession ss=getSession();
		int result=-1;
		try {
			result=ss.insert(namespace+".putNotice",n);
			if(result>0) {ss.commit();}
			else {ss.rollback();}
			
		}finally {
			ss.close();
		}
		return result;
	}
	public String getPwd(String id) {
		SqlSession ss=getSession();
		String pwd=null; //��ȸ ����� ������ ���� ����
		try {
			pwd=ss.selectOne(namespace+".getPwd",id);
		}finally {
			ss.close();
		}
		return pwd;
	}
	public BBS getBBS(Integer seqno) {
		SqlSession ss = getSession();
		BBS bbs=null;
		try {
			bbs= ss.selectOne(namespace+".getBBS", seqno);
		}finally {
			ss.close();		
		}
		return bbs;
	}
	public Integer getBBSCount() {
		SqlSession ss= getSession();
		Integer count =null;
		try {
			count = ss.selectOne(namespace+".getBBSCount");
			if(count==null) {count = 0;}
		}finally {
			ss.close();
		}
		return count;
	}
	public List<BBS> getAllBBS(Integer page) {
		SqlSession ss = getSession();
		List<BBS> list=null;
		try {
			list=ss.selectList(namespace+".getAllBBS",page);
		}finally {
			ss.close();
		}
		return list;
	}
	public Integer putBBS(BBS bbs) {
		SqlSession ss = getSession();
		Integer result=null;
		try {
			result= ss.insert(
				namespace+".putBBS",bbs);
			if (result>0) ss.commit();
			else ss.rollback();
		}finally {
			ss.close();
		}
		return result;
	}
	public int getMaxSeqno() {
		SqlSession ss= getSession();
		int max=-1;
		try {
			Integer i=
				ss.selectOne(
					namespace+".maxSeqno");
			if(i==null) max=0;
			else max=i;
		}finally {
			ss.close();
		}
		return max;
	}//�����Խ��ǿ��� ���� ū �۹�ȣ�� ã�� �޼���
	
	private SqlSession getSession() {
		//SqlSession �� ���� : ���۸� ���ؼ� ������ ȣ���Ѵ�.
		String config="MyBatisConfig.xml"; //���̹�Ƽ�� ȯ�漳�� ������ �̸�
		InputStream is =null;
		try {
			is=Resources.getResourceAsStream(config);
			//������ ����� ȯ�漳�� ������ ����.
		}catch(Exception e) {
			
		}
		SqlSessionFactoryBuilder builder = 
			new SqlSessionFactoryBuilder();
		SqlSessionFactory factory =builder.build(is);
		SqlSession session = factory.openSession();
		return session;
	}
}
