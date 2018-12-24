package com.ssm.common;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import net.sf.json.JsonConfig;
import net.sf.json.processors.JsonValueProcessor;

public class JsonDateValueProcessor implements JsonValueProcessor{

	private String datePattern = "yyyy-MM-dd HH:mm:ss";
	
	public JsonDateValueProcessor() {
		super();
	}
	
	public JsonDateValueProcessor(String format) {
		super();
		this.datePattern = format;
	}
	
	@Override
	public Object processArrayValue(Object obj, JsonConfig json) {
		return process(obj);
	}

	@Override
	public Object processObjectValue(String key, Object obj, JsonConfig json) {
		return process(obj);
	}
	
	private Object process(Object obj) {
		try {
			if (obj instanceof Date) {
				SimpleDateFormat sdf = new SimpleDateFormat(datePattern, Locale.UK);
				return sdf.format((Date) obj);
			}
			return obj == null ? "" : obj.toString();
		} catch (Exception e) {
			e.printStackTrace();
			return "";
		}
	}

	public String getDatePattern() {
		return datePattern;
	}

	public void setDatePattern(String datePattern) {
		this.datePattern = datePattern;
	}
	

}
