package controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import model.FloMemb;


@Controller
public class IndexController {
	
	@RequestMapping(method=RequestMethod.GET)
	public ModelAndView index(HttpSession ss) {
		FloMemb fmb =(FloMemb)ss.getAttribute("MEMB_KEY");
		ModelAndView mav = new ModelAndView();
		if(fmb != null) {
			mav.addObject("loginMemb",fmb); //Key와 Value의 쌍으로 저장
		} //로그인 한 경우
		return mav;
	}
}
