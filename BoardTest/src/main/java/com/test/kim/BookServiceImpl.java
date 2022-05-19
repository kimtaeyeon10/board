package com.test.kim;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookServiceImpl implements BookService{

	@Autowired //BookDao 인스턴스 주입
	BookDao bookDao;

	@Override // 상위 인터페이스에 정의된 것을 재정의
	public String create(Map<String,Object> map){
		int affectRowCount = this.bookDao.insert(map);
		if(affectRowCount ==1) {
			return map.get("book_id").toString();
		}
		return null;
	}
	
	@Override
	public Map<String,Object> detail(Map<String,Object> map){
		return this.bookDao.selectDetail(map);
	}
}
