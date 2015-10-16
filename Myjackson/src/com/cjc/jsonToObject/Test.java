package com.cjc.jsonToObject;

import java.io.File;

import com.cjc.jsonUtil.JsonUtil;

/**
 ***************************************************** 
 * <hr>
 * <dt><span class="strong">类功能简介:</span></dt>
 * <dd>JSON转换为实体对象（实体中嵌套Llist对象）</dd>
 * <dt><span class="strong">创建时间:</span></dt>
 * <dd>2015-10-15 下午1:43:27</dd>
 * <dt><span class="strong">公司:</span></dt>
 * <dd>SHLD</dd>
 * 
 * @author aa1000777 - Email:aa1000777@qq.com
 ***************************************************** 
 */
public class Test {
	public static void main(String args[]) {
		Bean bean = JsonUtil.readValue(new File("custom.json"), Bean.class); // 读取
		System.out.println("country:" + bean.country);
		System.out.println("orgood:" + bean.orgood);
		System.out.println("	golden:" + bean.countryInfo.golden);
		System.out.println("	silver:" + bean.countryInfo.silver);
		System.out.println("	copper:" + bean.countryInfo.copper);
		System.out.println("	tank:" + bean.countryInfo.tank);
		CountryDetail[] detail = bean.countryDetail;
		for (int i = 0; i < detail.length; i++) {
			System.out.println("-----------------------");
			System.out.println("		id:" + detail[i].id);
			System.out.println("		header:" + detail[i].header);
			System.out.println("		fieldIndex:" + detail[i].fieldIndex);
			System.out.println("		sortOrder:" + detail[i].sortOrder);
			System.out.println("		printable:" + detail[i].printable);
		}
	}
}
