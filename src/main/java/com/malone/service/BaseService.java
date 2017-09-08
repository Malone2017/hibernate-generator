package com.malone.service;

import java.util.List;
import java.util.Map;

public interface BaseService {
	
	public List<Map<String,Object>> findAll();
	
	public String generator(Map<String,String> paramMap);
}
