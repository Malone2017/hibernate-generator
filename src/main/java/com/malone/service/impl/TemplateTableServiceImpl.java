package com.malone.service.impl;

import java.io.IOException;
import java.io.StringWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.malone.Application;
import com.malone.service.TableService;

import freemarker.template.Template;
import freemarker.template.TemplateException;
@Service("templateTableService")
public class TemplateTableServiceImpl implements TableService {

	@Override
	public List<Map<String, Object>> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String generator(Map<String, String> paramMap) {
		try {
			
			Template template = Application.cfg.getTemplate("tableToEntity.ftl");

			Map<String,Object> dataMap = new HashMap<>();
			
			StringWriter writer = new StringWriter();
			template.process(dataMap, writer);

			writer.close();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (TemplateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

}
