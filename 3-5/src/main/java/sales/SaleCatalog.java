package sales;

import java.util.ArrayList;
import java.util.List;

import model.Cart;
import model.Item;
import model.ItemSet;
import model.Sale;
import model.SaleDetail;
import model.User;

public interface SaleCatalog {
	//계산하러 가기를 위한 메서드 시작
	
	void checkout(User user, Cart cart);
	Integer findMaxSaleId();
	void create (Sale sale);
	void create (SaleDetail detail);
	//계산하러 가기를 위한 메서드 끝
	Integer calculateTotal(ArrayList<ItemSet> itemList); 
	
	Item findById(Integer id);
	List<Item> findAll();
	
	User findUser(User user); //로그인에 사용할 메서드 선언
	void create(User user); //회원가입에 사용할 메서드 선언
}
