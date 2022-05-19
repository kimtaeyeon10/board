package com.test.kim;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository //�����Ϳ� �����ϴ� Ŭ�������� ���
public class BookDao { //����xml�����Ű�� Ŭ����

	@Autowired // ����������
	SqlSessionTemplate sqlSessionTemplate; //SqlSessionTemplate ��ü�� new�� ����X, ���������� ���� ���Թ���
	
	public int insert(Map<String, Object> map) {
		return this.sqlSessionTemplate.insert("book.insert",map); //(namespace+id:book.insert, �������޵����� :map)
		// ���� ���� ���� �� �� ��ȯ.. ������ 1 ���н� 0
	}
	
	public Map<String, Object> selectDetail(Map<String,Object> map){
		return this.sqlSessionTemplate.selectOne("book.selectDetail",map); //selectOne�� �����͸� �Ѱ��� ������ �� ���
	}
}
