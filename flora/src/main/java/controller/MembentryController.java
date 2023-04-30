package controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import dao.MembDao;
import model.FloMemb;
import validator.MembentryValidator;

@Controller
public class MembentryController {
	
	@Autowired
	private MembentryValidator membentryValidator;
	
	@Autowired
	private MembDao membDao;
	
	@ModelAttribute
	public FloMemb setUp() {
		return new FloMemb();
	}
	
	@RequestMapping (method=RequestMethod.GET)
	public String doMembEntry() {
		return "membentry/membEntry";
	}
	@RequestMapping (method=RequestMethod.POST)
	public ModelAndView exeMembEntry(FloMemb fmb, BindingResult br, HttpSession ss) {
		this.membentryValidator.validate(fmb, br);
		ModelAndView mav = new ModelAndView();
		if(br.hasErrors()) {
			mav.getModel().putAll(br.getModel());
			return mav;
		}
		try {
			this.membDao.insertMemb(fmb);
			mav.addObject("Memb", fmb);
			mav.setViewName("membentry/membEntryResult"); 
			ss.setAttribute("MEMB_KEY", fmb); //가입과 동시에 로그인
			mav.addObject("loginMemb", fmb);
			return mav;
		}catch(DataIntegrityViolationException e) {
			br.reject("error.duplicat.memb");
			mav.getModel().putAll(br.getModel());
			return mav;
		}
	}
}
