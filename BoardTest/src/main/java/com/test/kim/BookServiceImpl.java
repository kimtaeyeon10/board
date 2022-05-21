package com.test.kim;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookServiceImpl implements BookService{

	@Autowired //BookDao �ν��Ͻ� ����
	BookDao bookDao;

	@Override // ���� �������̽��� ���ǵ� ���� ������
	public String create(Map<String,Object> map){
		int affectRowCount = this.bookDao.insert(map);
		if(affectRowCount ==1) {
			return map.get("book_id").toString();
		}
		return null;
	}
	
	@Override
	public Map<String, Object> detail(Object object) {
		return this.bookDao.selectDetail(object);
	}
	
	@Override
	public List<Map<String, Object>> list(Map<String,Object>map){
		return this.bookDao.selectList(map);
	}


}
