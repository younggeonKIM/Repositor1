package controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import exception.LoginRequiredException;
import model.Cart;
import model.Item;
import model.ItemSet;
import model.User;
import sales.SaleCatalog;

@Controller
public class CartController {
	@Autowired
	private SaleCatalog saleCatalog;
	
	@RequestMapping(value="/cart/cartConfirm.html")
	public ModelAndView confirm(HttpSession session) {
		Cart cart = (Cart)session.getAttribute("CART_KEY");
		if(cart == null) {
			cart = new Cart();
		}
		session.setAttribute("CART_KEY", cart);
		ModelAndView mav = new ModelAndView("cart/cart");
		mav.addObject("cart", cart);
		User loginUser = (User) session.getAttribute("USER_KEY");
		if(loginUser != null) {
			mav.addObject("loginUser", loginUser);
		}
		return mav;
	}
	
	@RequestMapping(value="/cart/cartClear.html")
	public ModelAndView clear(HttpSession session) {
		Cart cart = (Cart)session.getAttribute("CART_KEY");
		if(cart == null) {
			cart = new Cart();
		}
		cart.clearAll();
		session.setAttribute("CART_KEY", cart);
		session.removeAttribute("ITEM_KEY");
		session.removeAttribute("NUMBER");
		ModelAndView mav = new ModelAndView("cart/cart");
		User loginUser = (User)session.getAttribute("USER_KEY");
		if(loginUser != null) {
			mav.addObject("loginUser", loginUser);
		}
		mav.addObject("message", "카트를 비웠습니다.");
		return mav;
	}
	
	@RequestMapping(value="/cart/result.html")
	public ModelAndView reload(HttpSession session) {
		Cart cart = (Cart) session.getAttribute("CART_KEY");
		Item item = (Item) session.getAttribute("ITEM_KEY");
		Integer quantity = (Integer) session.getAttribute("NUMBER");
		User loginUser = (User) session.getAttribute("USER_KEY");
		ModelAndView mav = new ModelAndView("cart/cart");
		
		if(loginUser != null) {
			mav.addObject("loginUser", loginUser);
		}
		mav.addObject("message", item.getItemName()+" 상품을 "+quantity+"개 카트에 담았습니다.");
		mav.addObject("cart", cart);
		return mav;
	}
	
	@RequestMapping(value="/cart/cartAdd.html")
	public ModelAndView add(Integer itemId, Integer quantity, HttpSession session) {
		
		User loginUser = (User)session.getAttribute("USER_KEY");
		if(loginUser == null) {
			throw new LoginRequiredException("로그인이 필요합니다.");
		}
		Item item = this.saleCatalog.findById(itemId);
		Cart cart = (Cart)session.getAttribute("CART_KEY");
		if(cart == null) {
			cart = new Cart();
		}
		ItemSet is = new ItemSet(item, quantity);
		cart.push(is);
		session.setAttribute("CART_KEY", cart);
		session.setAttribute("ITEM_KEY", item);
		session.setAttribute("NUMBER", quantity);
		//화면을 장바구니 결과로 바꾼다.
		ModelAndView mav = new ModelAndView("redirect:/cart/result.html");
		return mav;
	}
}
