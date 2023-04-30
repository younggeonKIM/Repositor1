package dao;

import model.User;

public interface UserDAO {
	
	User findUser(User user); //로그인에 사용할 메서드 선언
	void create(User user); //회원가입에 사용할 메서드 선언
}
