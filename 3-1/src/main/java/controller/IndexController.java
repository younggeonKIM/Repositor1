/**
 * 
 */
package controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import dao.ItemDao;
import model.Item;

public class IndexController implements Controller {
	private ItemDao itemDao;
	public void setItemDao(ItemDao itemDao) {
		this.itemDao = itemDao;
	}

	
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ModelAndView mav = new ModelAndView();
		//mav에 조회결과를 저장.
		List<Item> list=itemDao.findAll(); //DB에서 조회
		mav.addObject("itemList",list);
		mav.setViewName("WEB-INF/jsp/index.jsp");
		return mav;
	}

}
