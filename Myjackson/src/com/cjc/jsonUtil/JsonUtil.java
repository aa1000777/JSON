package com.cjc.jsonUtil;

import java.io.File;
import java.io.StringWriter;
import java.io.Writer;

import org.codehaus.jackson.map.ObjectMapper;

/**
 * 
 ***************************************************** 
 * <hr>
 * <dt><span class="strong">类功能简介:</span></dt>
 * <dd>Json 工具类</dd>
 * <dt><span class="strong">创建时间:</span></dt>
 * <dd>2015-10-14 下午3:14:42</dd>
 * <dt><span class="strong">公司:</span></dt>
 * <dd>CorpIt</dd>
 * 
 * @author aa1000777 - Email:aa1000777@qq.com
 ***************************************************** 
 */
public class JsonUtil {

	private static ObjectMapper mapper = new ObjectMapper();

	/**
	 * 把Java对象转换为JSON数据格式
	 * 
	 * @param object
	 * @return
	 */
	public static String getJson(Object object) {
		try {
			Writer strWriter = new StringWriter();
			mapper.writeValue(strWriter, object);
			String dataJson = strWriter.toString();
			return dataJson;
		} catch (Exception e) {
			// logger.error("[JsonUtils]Fail to getjson", e);
		}

		return null;
	}

	/**
	 * 把JSON数据格式转换为JAVA对象
	 * 
	 * @param <T>
	 * @param jsonData
	 *            Json字符串
	 * @param clz
	 * @return
	 */
	public static <T> T readValue(String jsonData, Class<T> clz) {
		try {
			return mapper.readValue(jsonData, clz);
		} catch (Exception e) {
			// logger.error("[JsonUtils]Fail to convert json to object: " +
			// jsonData, e);
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 把JSON数据格式转换为JAVA对象
	 * 
	 * @param <T>
	 * @param src
	 *            文件对象
	 * @param clz
	 * @return
	 */
	public static <T> T readValue(File src, Class<T> clz) {
		try {
			return mapper.readValue(src, clz);
		} catch (Exception e) {
			// logger.error("[JsonUtils]Fail to convert json to object: " +
			// jsonData, e);
			e.printStackTrace();
		}
		return null;
	}
}
