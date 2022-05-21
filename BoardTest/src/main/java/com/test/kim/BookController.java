package com.test.kim;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class BookController {
	
	@Autowired //���� ȣ���� ���� ���� �� �߰� , ������ ����
	BookService bookService;
	
	//@RequestMapping�� ��������û�� ����Ǵ� �ڹ� �޼ҵ� ����
	//value�� URI���� . GET - �����ͺ���x, POST - �����ͺ���o
	@RequestMapping(value="/create",method=RequestMethod.GET)
	public ModelAndView create() {
		//Model - ��Ʈ�ѷ��� ��ȯ�� ������ ���, View - ȭ����
		return new ModelAndView("book/create"); // ""���� view�� ���
	}
	
	@RequestMapping(value="/create", method=RequestMethod.POST) // ������ ����(�Է�)�̹Ƿ� POST
	public ModelAndView createPost(@RequestParam Map<String,Object> map) {
		// @RequestParam�� ���� HTTP�Ķ���͸� map������ �ڵ� ���ε� .
		// HTTP�Ķ���ʹ� ���������� ������ �����ϴ� ������(����,�з�,���� �� ����)
		ModelAndView mav = new ModelAndView();
		
		String bookId = this.bookService.create(map); 
		if (bookId == null) { // ������ �Է� ���н� �ٽ� ����ȭ������
			mav.setViewName("redirect:/create");  //setViewName : ���� ��� ����
		}else { // ������ �� ��������
			mav.setViewName("redirect:/detail?bookId=" + bookId);
		}
		return mav;
	}
	
	@RequestMapping(value="/detail", method=RequestMethod.GET)
	public ModelAndView detail(@RequestParam Map<String, Object> map) {
		Map<String,Object> detailMap = this.bookService.detail(map.get("bookId")); //db���� ��ȸ�ѳ��� detailMap��� 
		System.out.println("detailMap"+detailMap);
		ModelAndView mav = new ModelAndView();
		mav.addObject("data",detailMap); // data��� �̸����� ������� ����
		System.out.println("mav"+mav);
		
		String bookId = map.get("bookId").toString();
		mav.addObject("bookId",bookId);
		System.out.println("bookId"+bookId);
		mav.setViewName("/book/detail");
		return mav;
	}
	
	@RequestMapping(value="list")
	public ModelAndView list(@RequestParam Map<String,Object> map) {
		List<Map<String,Object>> list = this.bookService.list(map);
		System.out.println(map.get("title"));
		ModelAndView mav = new ModelAndView();
		mav.addObject("data",list);
		mav.setViewName("/book/list");
		return mav;
		
		
	}
	
}
