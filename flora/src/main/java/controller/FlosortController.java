package controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import dao.SortDao;
import model.FloMemb;
import model.FloSort;

@Controller
public class FlosortController {
	
	@Autowired
	private SortDao sortDao;
	
	@Autowired
	private FloSort fst;
	
	
	@RequestMapping(method=RequestMethod.GET)
	public ModelAndView getFloNames(HttpSession ss) {
		List<FloSort> list = sortDao.getAllFloName();
		ModelAndView mav = new ModelAndView();
		FloMemb fmb = (FloMemb)ss.getAttribute("MEMB_KEY");
		if(fmb != null) {
			mav.addObject("loginMemb", fmb);			
		}
		
		mav.addObject("List", list);
		mav.setViewName("flosort/flosort");
		return mav;
	}
	
	@RequestMapping(value="/flosort/flomgsn.html")
	public ModelAndView getFloMGSN(String name, HttpSession ss) {
		List<FloSort> mgsn = this.sortDao.getFloMGSN(name);
		System.out.println("건수:["+mgsn.size()+"]");
		Integer mgsnNo = this.sortDao.floMGSNno(name);
		ModelAndView mav = new ModelAndView();
		FloMemb fmb = (FloMemb)ss.getAttribute("MEMB_KEY");
		if(fmb != null) {
			mav.addObject("loginMemb", fmb);			
		}
		mav.addObject("listMgsn", mgsn);
		mav.addObject("no", mgsnNo);
		mav.setViewName("flosort/flomgsn");
		return mav;
	}
	
	@RequestMapping(value="/flosort/detail.html")
	public ModelAndView getFloDetail(String name, String mok, String gwa, HttpSession ss) {
		
		this.fst.setFloname(name);
		this.fst.setMok(mok);
		this.fst.setGwa(gwa);
		FloSort flst = this.sortDao.getFloDetail(fst);
		ModelAndView mav = new ModelAndView();
		FloMemb fmb = (FloMemb)ss.getAttribute("MEMB_KEY");
		if(fmb != null) {
			mav.addObject("loginMemb", fmb);			
		}
		mav.addObject("Detail" ,flst);
		mav.setViewName("flosort/sortDetail");
		return mav;
	}
}
