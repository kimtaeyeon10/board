package com.test.kim;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class BookController {
	
	@Autowired //서비스 호출을 위해 서비스 빈 추가 , 의존성 주입
	BookService bookService;
	
	//@RequestMapping은 브라우저요청에 실행되는 자바 메소드 지정
	//value는 URI지정 . GET - 데이터변경x, POST - 데이터변경o
	@RequestMapping(value="/create",method=RequestMethod.GET)
	public ModelAndView create() {
		//Model - 컨트롤러가 반환할 데이터 담당, View - 화면담당
		return new ModelAndView("book/create"); // ""안은 view의 경로
	}
	
	@RequestMapping(value="/create", method=RequestMethod.POST) // 데이터 변경(입력)이므로 POST
	public ModelAndView createPost(@RequestParam Map<String,Object> map) {
		// @RequestParam을 통해 HTTP파라미터를 map변수에 자동 바인딩 .
		// HTTP파라미터는 브라우저에서 서버로 전달하는 데이터(제목,분류,가격 등 정보)
		ModelAndView mav = new ModelAndView();
		
		String bookId = this.bookService.create(map); 
		if (bookId == null) { // 데이터 입력 실패시 다시 생성화면으로
			mav.setViewName("redirect:/create");  //setViewName : 뷰의 경로 지정
		}else { // 성공시 상세 페이지로
			mav.setViewName("redirect:/detail?bookId=" + bookId);
		}
		return mav;
	}
	
	@RequestMapping(value="/detail", method=RequestMethod.GET)
	public ModelAndView detail(@RequestParam Map<String, Object> map) {
		Map<String,Object> detailMap = this.bookService.detail(map); //db에서 조회한내용 detailMap담기 
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("data",detailMap); // data라는 이름으로 쿼리결과 담음
		
		String bookId = map.get("bookId").toString();
		mav.addObject("bookId",bookId);
		
		mav.setViewName("/book/detail");
		return mav;
	}
	
}
