package controller;

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
public class LoginFormController {
	private UserDAO userDao;
	private LoginValidator loginValidator;
	
	public void setLoginValidator(LoginValidator loginValidator) {
		this.loginValidator = loginValidator;
	}
	public void setUserDao(UserDAO userDao) {
		this.userDao = userDao;
	}

	@ModelAttribute
	public User setUp() {
		return new User();
	}
	
	@RequestMapping(method=RequestMethod.GET)
	public String loginForm() {
		return "login";
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public ModelAndView loginDo(User user, BindingResult br) {
		loginValidator.validate(user, br);
		ModelAndView mav = new ModelAndView();
		if(br.hasErrors()) { //입력폼에 문제가 있는 경우
			mav.getModel().putAll(br.getModel());
			return mav;
		}
		try {
			User loginUser = userDao.findUser(user);
			if(loginUser!=null) { //로그인 성공
				mav.addObject("loginUser",loginUser);
				mav.setViewName("loginSuccess"); //뷰(JSP) 이름
				return mav;
			}else { //로그인 실패
				br.reject("error.login.user");
				mav.getModel().putAll(br.getModel());
				return mav;
			}
		}catch(Exception e) {
			
		}finally {
			
		}
		return null;
	}
}
