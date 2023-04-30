package controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import dao.UserDAO;
import etc.LoginValidator;
import model.User;

@Controller
public class LoginformController {
	@Autowired
	private UserDAO userDao;
	
	@Autowired
	private LoginValidator loginValidator;
	
	@ModelAttribute
	public User setUp() {
		return new User();
	}
	
	@RequestMapping (method=RequestMethod.GET)
	public String loginForm() {
		return "loginform/login";
	}
	
	@RequestMapping (method=RequestMethod.POST)
	public ModelAndView toLogin(User user, BindingResult br, HttpSession session) {
		loginValidator.validate(user, br);
		ModelAndView mav = new ModelAndView();
		if(br.hasErrors()) {
			mav.getModel().putAll(br.getModel());
			return mav;
		}
		try {
			User loginUser = userDao.findUser(user);
			if(loginUser != null) { //로그인 성공
				mav.setViewName("loginform/loginSuccess");
				mav.addObject("loginUser",loginUser);
				session.setAttribute("USER_KEY", loginUser);
				return mav;
			}else { //로그인 실패
				br.reject("error.input.user");
				mav.getModel().putAll(br.getModel());
				return mav;
			}
		}catch(EmptyResultDataAccessException e) {
			br.reject("error.input.user");
			mav.getModel().putAll(br.getModel());
			return mav;
		}finally {
			
		}
		
	}
}
