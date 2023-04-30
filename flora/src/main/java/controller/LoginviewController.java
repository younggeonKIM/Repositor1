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

import dao.MembDao;
import model.FloMemb;
import validator.LoginValidator;

@Controller
public class LoginviewController {
	@Autowired
	private MembDao membDao;
	@Autowired
	private LoginValidator loginValidator;
	
	@ModelAttribute
	public FloMemb setUp() {
		return new FloMemb();
	}
	
	@RequestMapping (method=RequestMethod.GET)
	public String loginTo() {
		return "loginview/login";
	}
	
	@RequestMapping (method=RequestMethod.POST)
	public ModelAndView loginCheck(FloMemb fmb, BindingResult br, HttpSession ss) {
		loginValidator.validate(fmb, br);
		ModelAndView mav = new ModelAndView();
		if(br.hasErrors()) {
			mav.getModel().putAll(br.getModel());
			return mav;
		}
		try {
			FloMemb loginMemb = membDao.findMemb(fmb);
			if(loginMemb != null) { //로그인 성공
				mav.setViewName("loginview/loginResult");
				mav.addObject("loginMemb",loginMemb);
				ss.setAttribute("MEMB_KEY",loginMemb);
				return mav;
			}else { //로그인 실패
				br.reject("error.input.memb");
				mav.getModel().putAll(br.getModel());
				return mav;
			}
		}catch(EmptyResultDataAccessException e) {
			br.reject("error.input.memb");
			mav.getModel().putAll(br.getModel());
			return mav;
		}
	}
	
}
