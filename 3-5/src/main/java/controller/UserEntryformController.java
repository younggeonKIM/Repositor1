package controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.support.MessageSourceAccessor;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import dao.UserDAO;
import etc.UserEntryValidator;
import model.User;

@Controller
public class UserEntryformController {
	@Autowired
	private UserEntryValidator userEntryValidator;
	
	@Autowired
	private MessageSource messageSource;
	
	@Autowired
	private UserDAO userDao;
	
	@ModelAttribute
	public User setup() {
		User user = new User();
		MessageSourceAccessor msa = new MessageSourceAccessor(messageSource);
		user.setUserId(msa.getMessage("user.userId.default"));
		user.setUserName(msa.getMessage("user.userName.default"));
		return user;
	}
	
	@RequestMapping(method=RequestMethod.GET)
	public String userEntryForm() {
		return "userentryform/userEntry";
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public ModelAndView onSubmit(User user, BindingResult br, HttpSession session) {
		this.userEntryValidator.validate(user, br);
		ModelAndView mav = new ModelAndView();
		if(br.hasErrors()) {
			mav.getModel().putAll(br.getModel());
			return mav;
		}
		try {
			this.userDao.create(user);
			mav.addObject("user",user);
			mav.setViewName("userentryform/userEntrySuccess");
			session.setAttribute("USER_KEY", user); //가입과 동시에 로그인
			mav.addObject("loginUser", user);
			return mav;
		}catch(DataIntegrityViolationException e) { 
			br.reject("error.duplicate.user");
			mav.getModel().putAll(br.getModel());
			return mav;
		}
		
	}
}
