package com.malone.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.malone.service.DirService;
@Service
public class DirServiceImpl implements DirService {
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Override
	public List<Map<String,Object>> findAll() {
		String sql = "select * from person";
		List<Map<String,Object>> dataList = jdbcTemplate.queryForList(sql);
		return dataList;
	}


	@Override
	public String generator(Map<String, String> paramMap) {
		// TODO Auto-generated method stub
		return null;
	}
}
