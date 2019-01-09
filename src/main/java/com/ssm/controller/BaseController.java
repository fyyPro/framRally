package com.ssm.controller;

import java.sql.Date;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;
import org.apache.log4j.Logger;
import com.ssm.common.JsonDateValueProcessor;


public class BaseController {

	private static Logger log = Logger.getLogger(BaseController.class);
	
	public JSONObject responseSuccess(Object obj){
		JSONObject jsonobj = null;
		if(obj != null){
			JsonConfig cfg = new JsonConfig();
			cfg.registerJsonValueProcessor(Date.class, new JsonDateValueProcessor());
			jsonobj = JSONObject.fromObject(obj,cfg);
		}
		//log.info("输出结果:"+jsonobj.toString());
		return jsonobj;
	}
	
	public JSONArray responseArraySuccess(Object obj){
		JSONArray jsonobj = null;
		if(obj != null){
			JsonConfig cfg = new JsonConfig();
			cfg.registerJsonValueProcessor(Date.class, new JsonDateValueProcessor());
			jsonobj = JSONArray.fromObject(obj,cfg);
		}
		log.info("输出结果:"+jsonobj.toString());
		return jsonobj;
	}
	
}
