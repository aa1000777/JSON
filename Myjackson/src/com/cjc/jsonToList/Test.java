package com.cjc.jsonToList;

import java.io.IOException;
import java.util.List;

import com.cjc.jsonUtil.JsonUtil;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;

/**
 * JSON转换为List对象（List中嵌套Llist对象）
 ***************************************************** 
 * <hr>
 * <dt><span class="strong">类功能简介:</span></dt>
 * <dd>JSON转换为List对象（List中嵌套Llist对象）</dd>
 * <dt><span class="strong">创建时间:</span></dt>
 * <dd>2015-10-15 上午11:57:51</dd>
 * <dt><span class="strong">公司:</span></dt>
 * <dd>CorpIt</dd>
 * 
 * @author aa1000777 - Email:aa1000777@qq.com
 ***************************************************** 
 */
public class Test {
	private static Bean[] map;
	static OkHttpClient client = new OkHttpClient();

	static String run(String url) throws IOException {
		Request request = new Request.Builder().url(url).build();

		Response response = client.newCall(request).execute();
		return response.body().string();
	}

	public static void main(String[] args) throws IOException {
		String url = "http://171.221.223.206:8182/SysService.svc/videos";
		// 读在线
		String resultJson = run(url);
		System.out.println(resultJson);
		// 读文件
		// File resultJson = new File("jsonToList.json");
		if (resultJson != null) {
			map = JsonUtil.readValue(resultJson, Bean[].class);
			System.out.println(map.length);
			for (int i = 0; i < map.length; i++) {
				System.out.println("	" + map[i].BaseName);
				System.out.println("	" + map[i].BaseID);
				System.out.println("	" + map[i].BaseVideoCount);
				List<lstVideoInfo> map2 = map[i].lstVideoInfos;
				for (int j = 0; j < map2.size(); j++) {
					System.out.println("		" + map2.get(j).videoDesc);
					System.out.println("		" + map2.get(j).videoIP);
					System.out.println("		" + map2.get(j).videoPort);
					System.out.println("		" + map2.get(j).videoPwd);
					System.out.println("		" + map2.get(j).videoType);
					System.out.println("		" + map2.get(j).videoUserName);
				}
			}
		}
	}

}
