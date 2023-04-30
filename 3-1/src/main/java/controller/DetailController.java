package controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import dao.ItemDao;
import model.Item;

public class DetailController implements Controller {
	private ItemDao itemDao;
	public void setItemDao(ItemDao itemDao) {
		this.itemDao = itemDao;
	}

	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ModelAndView mav =new ModelAndView();
		String id = request.getParameter("ID");
		Item item=itemDao.findById(Integer.parseInt(id));
		mav.addObject("item",item);
		mav.setViewName("WEB-INF/jsp/detail.jsp");
		return mav;
	}

}
