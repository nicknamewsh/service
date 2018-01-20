package com.pt.ssm.util;

import java.io.IOException;

  
import org.codehaus.jackson.map.ObjectMapper;
import org.json.JSONException;
import org.json.JSONObject;


public class ToJson {
	
	public static<T> String objectToJson(T obj) throws JSONException, IOException {
	    ObjectMapper mapper = new ObjectMapper(); 
	    String jsonStr = "";
	    try {
	       jsonStr = mapper.writeValueAsString(obj);
	       
	    } catch (IOException e) {
	      throw e;
	    }
	    return jsonStr;
	  }


}
