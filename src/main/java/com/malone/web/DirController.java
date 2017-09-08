package com.malone.web;

import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.malone.service.DirService;

@RestController
@RequestMapping("/dir")
public class DirController extends BaseController{
	@Autowired
	private DirService dirService;
	
	@Override
	public List<Map<String,Object>> findAll(){
		return dirService.findAll();
	}

	@Override
	public String generator() {
		return null;
	}
}
