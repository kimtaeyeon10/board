package com.test.kim;

import java.util.List;
import java.util.Map;

public interface BookService {

	String create(Map<String, Object> map);


	List<Map<String, Object>> list(Map<String, Object> map);


	Map<String, Object> detail(Object object);

	

}
