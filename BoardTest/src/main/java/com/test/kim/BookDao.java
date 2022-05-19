package com.test.kim;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository //데이터에 접근하는 클래스임을 명시
public class BookDao { //매퍼xml실행시키는 클래스

	@Autowired // 의존성주입
	SqlSessionTemplate sqlSessionTemplate; //SqlSessionTemplate 객체는 new로 생성X, 의존성주입 통해 주입받음
	
	public int insert(Map<String, Object> map) {
		return this.sqlSessionTemplate.insert("book.insert",map); //(namespace+id:book.insert, 쿼리전달데이터 :map)
		// 쿼리 영향 받은 행 수 반환.. 성공시 1 실패시 0
	}
	
	public Map<String, Object> selectDetail(Map<String,Object> map){
		return this.sqlSessionTemplate.selectOne("book.selectDetail",map); //selectOne은 데이터를 한개만 가져올 때 사용
	}
}
