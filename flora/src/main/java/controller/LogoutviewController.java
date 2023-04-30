package controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LogoutviewController {
	
	@RequestMapping (method=RequestMethod.GET)
	public ModelAndView logoutDo(HttpSession ss) {
		ss.invalidate();
		ModelAndView mav = new ModelAndView();
		return mav;
	}
}
