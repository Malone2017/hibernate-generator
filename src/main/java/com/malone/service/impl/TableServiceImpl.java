package com.malone.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import com.malone.DataType;
import com.malone.helper.GeneratorHelper;
import com.malone.service.TableService;
@Service
public class TableServiceImpl implements TableService {
	private static Logger logger = Logger.getLogger(TableServiceImpl.class);
	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public List<Map<String, Object>> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String generator(Map<String, String> paramMap) {
		
		if(!CollectionUtils.isEmpty(paramMap)){
			String tableName = GeneratorHelper.toString(paramMap.get("tableName"));
			tableName = tableName.toUpperCase();
			String sql = "select * from user_tab_columns where table_name = ?";
			List<Map<String, Object>> dataList = jdbcTemplate.queryForList(sql,new Object[]{tableName});
			
			if(!CollectionUtils.isEmpty(dataList)){
				StringBuffer comments = new StringBuffer();
				StringBuffer fields = new StringBuffer();
				StringBuffer methods = new StringBuffer();
				
				Map<String,String> commentMap = this.queryColumnCommentMap(tableName);
				for(Map<String,Object> dataMap : dataList){
					String columnName = GeneratorHelper.toString(dataMap.get("COLUMN_NAME"));
					String dataType = DataType.getDataType(GeneratorHelper.toString(dataMap.get("DATA_TYPE")));
					
					comments.append(GeneratorHelper.generatorColumnComment(columnName, commentMap.get(columnName)));
					comments.append(GeneratorHelper.generatorFieldComment(columnName, commentMap.get(columnName)));
					
					fields.append(GeneratorHelper.generatorField(dataType, columnName,commentMap.get(columnName)));
					
					methods.append(GeneratorHelper.generatorSetMethod(columnName, dataType,commentMap.get(columnName)));
					methods.append(GeneratorHelper.generatorGetMethod(columnName, dataType,commentMap.get(columnName)));
				}
				
				comments.append(GeneratorHelper.LINE_BREAK).append(fields).append(GeneratorHelper.LINE_BREAK).append(methods);
				
				
				return GeneratorHelper.generatorEntity(tableName, comments.toString(),null);
			}
		}
		return null;
	}
	
	
	private Map<String,String> queryColumnCommentMap(String tableName){
		String sql = "select * from  user_col_comments where table_name = ?";
		List<Map<String, Object>> dataList = jdbcTemplate.queryForList(sql,new Object[]{tableName});
		Map<String,String> resultMap = new HashMap<String, String>();
		if(!CollectionUtils.isEmpty(dataList)){
			for(Map<String,Object> dataMap : dataList){
				String columnName = GeneratorHelper.toString(dataMap.get("COLUMN_NAME"));
				String comments = GeneratorHelper.toString(dataMap.get("COMMENTS"));
				resultMap.put(columnName, comments);
			}
		}
		return resultMap; 
	}

}
