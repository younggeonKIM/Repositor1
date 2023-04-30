package controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import dao.ItemDao;
import model.Item;
import model.User;

@Controller
public class DetailController {
	@Autowired
	private ItemDao itemDao;
	
	@RequestMapping
	public ModelAndView detail(Integer ID, HttpSession session) {
		Item item = itemDao.findById(ID);
		ModelAndView mav = new ModelAndView();
		User loginUser = (User)session.getAttribute("USER_KEY");
		if(loginUser != null) {
			mav.addObject("loginUser", loginUser);
		}
		mav.addObject("item", item);
		return mav;
	}
}
