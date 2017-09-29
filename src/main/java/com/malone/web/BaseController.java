package com.malone.web;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

public abstract class BaseController {
	@Autowired
	protected HttpServletRequest request;
	
	@RequestMapping("/findAll")
	@ResponseBody
	public abstract List<Map<String,Object>> findAll();
	
	@RequestMapping("/generator")
	@ResponseBody
	public abstract String generator();
}
