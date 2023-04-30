package dao;

import model.User;

public interface UserDAO {
	//로그인에 사용할 메서드 선언
	User findUser(User user);
}
