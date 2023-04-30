package controller;

import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import dao.ItemDao;
import model.Item;

@Controller
public class ItemController {
	@Autowired
	private ItemDao itemDao;
	
	@RequestMapping(value="/item/search.html")
	public ModelAndView search(String itemName) {
		if(itemName == null || itemName.equals("")) {
			return this.index(); //목록을 출력한다.
		} //이름이 없는 경우
		List<Item> itemList = this.itemDao.findByName(itemName);
		if(itemList == null || itemList.isEmpty()) {
			return this.index(); //목록을 출력한다.
		} //조회 결과가 없는 경우
		ModelAndView mav = new ModelAndView("index");
		mav.addObject("itemList", itemList);
		return mav;
	}
	
	@RequestMapping(value="/item/update.html")
	public ModelAndView update(Item item, HttpServletRequest request)throws Exception {
		ServletContext ctx = request.getSession().getServletContext();
		String path=ctx.getRealPath("/upload");
		String encType="euc-kr";
		int maxSize = 5*1024*1024;
		MultipartRequest multipart = new MultipartRequest(request, path, maxSize, encType, new DefaultFileRenamePolicy());
		String fileName=multipart.getFilesystemName("pictureUrl"); //업로드 실행
		item.setItemId(Integer.parseInt(multipart.getParameter("itemId")));
		item.setItemName(multipart.getParameter("itemName"));
		item.setPrice(Integer.parseInt(multipart.getParameter("price")));
		item.setInfo(multipart.getParameter("info"));
		if( fileName != null ) {
			item.setPictureUrl(fileName);
		} //이미지 이름 다른 경우, 즉 이미지 변경하는 경우
		this.itemDao.update(item); //DAO의 update 메서드 호출
		return this.index(); //목록으로 돌아감.
	}
	
	@RequestMapping(value="/item/edit.html")
	public ModelAndView edit(Integer itemId) {
		ModelAndView mav =new ModelAndView("update");
		Item item = this.itemDao.findById(itemId);
		mav.addObject(item);
		return mav;
	}
	
	@RequestMapping(value="/item/delete.html")
	public ModelAndView delete(Integer itemId) {
		this.itemDao.delete(itemId);
		return index();
	}
	
	@RequestMapping(value="/item/confirm.html")
	public ModelAndView confirm(Integer itemId) {
		ModelAndView mav =new ModelAndView("delete");
		Item item = this.itemDao.findById(itemId);
		mav.addObject(item); //검색 결과를 JSP에 주입한다.
		mav.addObject("imageName", item.getPictureUrl());
		return mav;
	}
	
	@RequestMapping(value="/item/register.html")
	public ModelAndView register(Item item, HttpServletRequest request) throws Exception {
		ServletContext ctx = request.getSession().getServletContext();
		String realPath = ctx.getRealPath("/upload");
		
		String encType ="euc-kr";
		int maxSize = 5*1024*1024;
		MultipartRequest multipart = 
				new MultipartRequest(request, realPath, maxSize, encType, new DefaultFileRenamePolicy());
		String fileName = multipart.getFilesystemName("pictureUrl"); //업로드 실행
		System.out.println("업로드 경로 : "+realPath);
		
		item.setItemId(Integer.parseInt(multipart.getParameter("itemId")));
		item.setItemName(multipart.getParameter("itemName"));
		item.setPrice(Integer.parseInt(multipart.getParameter("price")));
		item.setPictureUrl(fileName);
		item.setInfo(multipart.getParameter("info"));
		this.itemDao.create(item); //DAO를 이용해서 삽입
		return index(); //삽입 후 목록을 출력함.
	}
	
	@RequestMapping(value="/item/create.html")
	public ModelAndView create() {
		ModelAndView mav = new ModelAndView("add");
		mav.addObject(new Item());
		return mav;
	}
	
	@RequestMapping(value="/item/index.html")
	public ModelAndView index() {
		List<Item> itemList = this.itemDao.findAll();
		ModelAndView mav =new ModelAndView("index");
		mav.addObject("itemList", itemList);
		return mav;
	}
}
