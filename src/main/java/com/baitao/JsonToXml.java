package com.example;

import java.util.Map.Entry;
import java.util.Set;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
public class JsonToXml {

	public static void main(String[] args) {
		String xmlStr = jsonToXml("{\"Root\":{\"Head\":{\"Destination\":\"\",\"FuncCode\":\"000\",\"SubBranchId\":6666,\"TxCode\":1032,\"Version\":\"02\",\"TxMoment\":20170824180000,\"Channel\":\"0002\",\"AgentId\":\"CWGS-666666102\",\"TxSerial\":900000000059184752},\"Body\":{\"TxDate\":20191013,\"AcctId\":\"0200004519000100297\",\"CurCode\":\"RMB\",\"BranchId\":104535000306}}}");
		System.out.println(xmlStr);
	}

	private static String jsonToXml(String json){
		try {
			StringBuffer buffer = new StringBuffer();
			buffer.append("<?xml version=\"1.0\" encoding=\"utf-8\"?>");
			JSONObject jObj = JSON.parseObject(json);
			jsonToXmlStr(jObj,buffer);
			return buffer.toString();
		} catch (Exception e) {
			e.printStackTrace();
			return "";
		}
	}

	private static void jsonToXmlStr(JSONObject jObj,StringBuffer buffer ){
		Set<Entry<String, Object>>  se = jObj.entrySet();
		for (Entry<String, Object> en : se) {
			switch (en.getValue().getClass().getName()) {
				case "com.alibaba.fastjson.JSONObject":
					buffer.append("<").append(en.getKey()).append(">");
					JSONObject jo = jObj.getJSONObject(en.getKey());
					jsonToXmlStr(jo, buffer);
					buffer.append("</").append(en.getKey()).append(">");
					break;
				case "com.alibaba.fastjson.JSONArray":
					JSONArray jarray = jObj.getJSONArray(en.getKey());
					for (int i = 0; i < jarray.size(); i++) {
						buffer.append("<").append(en.getKey()).append(">");
						JSONObject jsonobject = jarray.getJSONObject(i);
						jsonToXmlStr(jsonobject, buffer);
						buffer.append("</").append(en.getKey()).append(">");
					}
					break;
				default:
					buffer.append("<").append(en.getKey()).append(">").append(en.getValue());
					buffer.append("</").append(en.getKey()).append(">");
					break;
			}
		}
	}

}
