package controller;

import java.util.ArrayList;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import exception.CartEmptyException;
import exception.LoginRequiredException;
import model.Cart;
import model.ItemSet;
import model.User;
import sales.SaleCatalog;

@Controller
public class CheckoutController {
	@Autowired
	private SaleCatalog saleCatalog;
	
	@RequestMapping 
	public ModelAndView checkout(HttpSession session) {
		User loginUser = (User)session.getAttribute("USER_KEY");
		if(loginUser == null) { //로그인 하지 않은 경우
			throw new LoginRequiredException("로그인이 필요합니다.");
			//예외를 발생시킨다.
		}
		Cart cart = (Cart) session.getAttribute("CART_KEY");
		if(cart == null || cart.isEmpty()) {
			throw new CartEmptyException("카트가 비어있습니다.");
			//예외를 발생시킨다.
		} //카트가 없거나 비어있는 경우
		ModelAndView mav = new ModelAndView();
		mav.addObject("loginUser", loginUser);
		ArrayList<ItemSet> itemList = cart.getItemList();
		mav.addObject("itemList", itemList);
		Integer totalAmount = this.saleCatalog.calculateTotal(itemList); //총액 계산
		mav.addObject("totalAmount", totalAmount);
		return mav;
	}
}
