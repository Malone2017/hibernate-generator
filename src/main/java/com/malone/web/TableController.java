package com.malone.web;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.malone.service.TableService;

@RestController
@RequestMapping("/table")
public class TableController extends BaseController {
	private static Logger logger = Logger.getLogger(TableController.class);
	
	@Autowired()
	private TableService tableService;

	@Override
	public List<Map<String, Object>> findAll() {
		return null;
	}

	@Override
	public String generator() {

		Object tableName = request.getParameter("tableName");

		if (tableName == null) {
			logger.error("请输入表名");
			return "请输入表名";
		}
		Map<String, String> paramMap = new HashMap<>();
		paramMap.put("tableName", tableName.toString());
		return tableService.generator(paramMap);
	}

}
