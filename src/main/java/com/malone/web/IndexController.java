package com.malone.web;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.malone.service.TableService;

@Controller
@RequestMapping
public class IndexController {
	@Autowired
	private TableService tableService;
	
	@RequestMapping("/index")
	public ModelAndView entity(HttpServletRequest request){
		Object tableName = request.getParameter("tableName");
		
		if(StringUtils.isEmpty(tableName)){
			return new ModelAndView("500");
		}
		Map<String,String> paramMap = new HashMap<>();
		paramMap.put("tableName", tableName.toString());
		String entity = tableService.generator(paramMap);
		request.setAttribute("entity",entity);
		return new ModelAndView("index");
	}
}
