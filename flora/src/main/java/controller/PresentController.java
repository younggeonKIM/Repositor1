package controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import dao.PresDao;
import model.FloMemb;
import model.FloSort;
import model.Present;

@Controller
public class PresentController {
	@Autowired
	private PresDao presDao;
	
	@ModelAttribute
	public Present setUp() {
		return new Present();
		
	}
	
	@RequestMapping(method=RequestMethod.GET)
	public ModelAndView getMsgs(HttpSession ss) {
		List<String> list = this.presDao.getFloMsg();
		FloMemb fmb =(FloMemb)ss.getAttribute("MEMB_KEY");
		ModelAndView mav = new ModelAndView();
		if(fmb != null) {
			mav.addObject("loginMemb",fmb); //Key와 Value의 쌍으로 저장
		} //로그인 한 경우
		mav.addObject("List", list);
		ss.setAttribute("List", list);
		mav.setViewName("present/present");
		return mav;
	}
	
	@RequestMapping (method=RequestMethod.POST)
	public ModelAndView redirectToJsp(Present present, HttpSession ss) {
		System.out.println("검색할 꽃말 : "+present.getFlomsg());
		Present pst = new Present();
		pst.setFlomsg(present.getFlomsg());
		ModelAndView mav = this.getFloDetailByMsg(pst);
		//ModelAndView mav = new ModelAndView();
		FloMemb fmb =(FloMemb)ss.getAttribute("MEMB_KEY");
		if(fmb != null) {
			mav.addObject("loginMemb",fmb); //Key와 Value의 쌍으로 저장
		} //로그인 한 경우
		
		mav.addObject("BODY","flosortDetail.jsp");
		mav.addObject("List",ss.getAttribute("List"));
		mav.setViewName("present/present");
		return mav;
	}
	
	public ModelAndView getFloDetailByMsg(Present pst) {
		
		ModelAndView mav = new ModelAndView();
		List<FloSort> sortList = this.presDao.getFloDetByMsg(pst);
		System.out.println("꽃말로 검색한 꽃 상세 목록 크기 : "+sortList.size());
		mav.addObject("Sorts", sortList);
		FloSort fs = sortList.get(0);
		System.out.println("***꽃 이름***:"+fs.getFloname());
		//mav.setViewName("present/flosortDetail");
		return mav;
	}
}
