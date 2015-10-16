package com.cjc.jsonToMap;

import java.util.LinkedHashMap;
import java.util.List;

import com.cjc.jsonUtil.JsonUtil;


/**
 * 测试1 （测试JSON转java对象（Map集合））
 ***************************************************** 
 * <hr>
 * <dt><span class="strong">类功能简介:</span></dt>
 * <dd>测试1 （测试JSON转java对象）</dd>
 * <dt><span class="strong">创建时间:</span></dt>
 * <dd>2015-10-14 下午3:15:57</dd>
 * <dt><span class="strong">公司:</span></dt>
 * <dd>CorpIt</dd>
 * 
 * @author aa1000777 - Email:aa1000777@qq.com
 ***************************************************** 
 */
public class Test {
	private static List<LinkedHashMap<String, Object>> map;

	public static void main(String[] args) {
		test1();
		test2();
	}

	/**
	 * 
	 ***************************************************** 
	 * 方法简介: [{"retCode": 0,"retShowMsg": "启动成功。","retInternalMsg":
	 * "Start ok.","runListNo": 12,"accessDomain": "mark.xicp.net:10009"}]
	 ***************************************************** 
	 */
	private static void test2() {
		String resultJson = "[{\"retCode\": 0,\"retShowMsg\": \"启动成功。\",\"retInternalMsg\": \"Start ok.\",\"runListNo\": 12,\"accessDomain\": \"mark.xicp.net:10009\"}]";
		if (resultJson != null) {
			map = JsonUtil.readValue(resultJson, List.class);
			System.out.println(map.get(0).get("retCode"));
			System.out.println(map.get(0).get("retShowMsg"));
			System.out.println(map.get(0).get("retInternalMsg"));
			System.out.println(map.get(0).get("runListNo"));
			System.out.println(map.get(0).get("accessDomain"));
		}
	}

	/**
	 ***************************************************** 
	 * 方法简介: [{"status":"1"}]
	 ***************************************************** 
	 */
	private static void test1() {
		// [{"status":"1"}]
		String resultJson = "[{\"status\":\"1\"}]";
		if (resultJson != null) {
			map = JsonUtil.readValue(resultJson, List.class);
			System.out.println(map.get(0).get("status"));
		}
	}
}
