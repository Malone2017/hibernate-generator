package com.malone.helper;

import org.springframework.util.StringUtils;


public class GeneratorHelper {
	public static final String  LINE_BREAK = "<br/>";
	
	public static String columnToField(String column){
		if(!StringUtils.isEmpty(column)){
			if(column.contains("_")){
				StringBuffer sb = new StringBuffer();
				String[] items =  column.split("_");
				int index = 0;
				for(String item : items){
					item = item.toLowerCase();
					if(index > 0){
						item = item.substring(0,1).toUpperCase().concat(item.substring(1));
					}
					sb.append(item);
					index++;
				}
				column = sb.toString();
			}else{
				column = column.toLowerCase();
			}
		}
		return column;
	}
	

	public static String generatorField(String dataType,String columnName,String comments){
		String fieldName = GeneratorHelper.columnToField(columnName);
		String annotation = "@EntityAttribute(column = \""+ columnName +"\", field = \""+ fieldName +"\", comment=\""+ comments +"\")";
		
		return annotation +  LINE_BREAK + "private " + dataType + " " + fieldName + ";" + LINE_BREAK; 
	}
	
	
	public static String generatorColumnComment(String columnName,String comments){
		String comment = "/**"+ comments+"*/" + LINE_BREAK;
		return comment+  "public static final String " + columnName + "_COLUMN = \"" + columnName + "\";" + LINE_BREAK;
	}
	
	public static String generatorFieldComment(String columnName,String comments){
		String fieldName = GeneratorHelper.columnToField(columnName);
		String comment = "/**"+ comments+"*/" + LINE_BREAK;
		return comment + "public static final String " + fieldName.toUpperCase() + "_FIELD = \"" + fieldName + "\";" + LINE_BREAK;
	}
	
	public static String generatorMethod(String columnName,String dataType,String prefix,String comments){
		String comment = "/**"+ comments+"*/" + LINE_BREAK;
		;
		String fieldName = GeneratorHelper.columnToField(columnName);
		String methodName = prefix + fieldName.substring(0,1).toUpperCase().concat(fieldName.substring(1));
		StringBuffer sb = new StringBuffer();
		sb.append(comment);
		if("set".equals(prefix)){
			sb.append("public void " + methodName + "(" + dataType + " " + fieldName + ")");
		}else if("get".equals(prefix)){
			sb.append("public "+ dataType+ " " + methodName + "()");
		}
		sb.append("{");
		sb.append(LINE_BREAK);
		if("set".equals(prefix)){
			sb.append("this." + fieldName + " = " + fieldName);
		}else if("get".equals(prefix)){
			sb.append("return " + fieldName);
		}
		sb.append(";");
		sb.append(LINE_BREAK);
		sb.append("}");
		sb.append(LINE_BREAK);
		return sb.toString();
	}
	
	public static String generatorSetMethod(String columnName,String dataType,String comments){
		return generatorMethod(columnName,dataType,"set",comments);
	}
	
	public static String generatorGetMethod(String columnName,String dataType,String comments){
		return generatorMethod(columnName,dataType,"get",comments);
	}
	
	
	public static String generatorEntity(String tableName,String fields,String comments){
		StringBuffer sb = new StringBuffer();
		//className
		String tempClassName = columnToField(tableName);
		String className = tempClassName.substring(0,1).toUpperCase().concat(tempClassName.substring(1));
		sb.append("public class " + className);
		sb.append("{");
		sb.append("<br/>");
		sb.append("public static final String TABLE_NAME = \"" + tableName.toUpperCase() + "\"");
		sb.append(";");
		sb.append("<br/>");
		sb.append(fields);
		sb.append("}");
		sb.append("<br/>");
		
		return sb.toString();
	}
	
	
	public static String toString(Object value){
		if(value != null){
			if(value instanceof java.lang.String){
				return String.valueOf(value);
			}
		}
		return null;
	}
	
	public static void main(String[] args) {
	}
	
}
