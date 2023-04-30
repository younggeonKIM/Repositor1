package controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import dao.ItemDao;
import model.Item;
import model.User;

@Controller
public class IndexController {
	@Autowired
	private ItemDao itemDao;
	
	@RequestMapping
	public ModelAndView handle (HttpSession session) {
		User user = (User)session.getAttribute("USER_KEY");
		List<Item> itemList = itemDao.findAll();
		ModelAndView mav = new ModelAndView();
		if(user != null) {
			mav.addObject("loginUser", user); //Key와 Value의 쌍으로 저장
		} //로그인 한 경우
		mav.addObject("itemList", itemList);
		return mav;
	}
}
