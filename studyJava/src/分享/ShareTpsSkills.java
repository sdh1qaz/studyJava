package 分享;

import java.io.StringWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.junit.Test;

import com.alibaba.fastjson.JSONObject;

import freemarker.cache.StringTemplateLoader;
import freemarker.template.Configuration;
import freemarker.template.Template;

public class ShareTpsSkills {
	
	/**
	 * 列表的大小
	 * ?size
	 */
	@Test
	public void test1() {
		//模板
		String template = "列表的大小：${fl?size}";
		System.out.println("模板内容template=：" + template);
		//数据
		HashMap<String, Object> dataMap = new HashMap<>();
		List<Fee> feeList = new ArrayList<>();
		feeList.add(new Fee("套餐及固定费", "30"));
		feeList.add(new Fee("他人代付", "30"));
		feeList.add(new Fee("套餐外费用", "30"));
		feeList.add(new Fee("优惠费", "10"));
		dataMap.put("fl", feeList);
		//合成内容
		String content;
		try {
			content = getContent(template,dataMap);
		} catch (Exception e) {
			content = "组装模版出现异常";
			e.printStackTrace();
		}
		System.out.println("合成后的内容：\n" + content);
	}
	
	/**
	 * 短信展示列表时最后一个项以句号结尾，其他项用逗号
	 * <#if f_has_next>，<#else>。</#if>
	 */
	@Test
	public void test2() {
		//模板
		String template = "总共消费100元，其中：<#list fl as f>${f.name}：${f.fee}元<#if f_has_next>，<#else>。</#if></#list>";
		System.out.println("模板内容template=：" + template);
		//数据
		HashMap<String, Object> dataMap = new HashMap<>();
		List<Fee> feeList = new ArrayList<>();
		feeList.add(new Fee("套餐及固定费", "30"));
		feeList.add(new Fee("他人代付", "30"));
		feeList.add(new Fee("套餐外费用", "30"));
		feeList.add(new Fee("优惠费", "10"));
		dataMap.put("fl", feeList);
		//合成内容
		String content;
		try {
			content = getContent(template,dataMap);
		} catch (Exception e) {
			content = "组装模版出现异常";
			e.printStackTrace();
		}
		System.out.println("合成后的内容：\n" + content);
	}
	
	/**
	 * 字符串替换
	 * ${text?replace("替换前","替换后")}
	 */
	@Test
	public void test3() {
		//模板
		String before = "内容：替换前";
		String template = "${before?replace(\"替换前\",\"替换后\")}";
		System.out.println("模板内容template=：" + template);
		//数据
		HashMap<String, Object> dataMap = new HashMap<>();
		dataMap.put("before", before);
		//合成内容
		String content;
		try {
			content = getContent(template,dataMap);
		} catch (Exception e) {
			content = "组装模版出现异常";
			e.printStackTrace();
		}
		System.out.println("合成后的内容：\n" + content);
	}
	
	/**
	 * 使用JSONObject组装json字符串--一种比直接拼接直观的方法
	 */
	@Test
	public void test4() {
		//方法一：拼接
		String jsonStr1 = "{\"name\":\"张三\",\"age\":\"20\"}";
		//方法二：使用JSONObject
		JSONObject jo = new JSONObject();
		jo.put("name", "张三");
		jo.put("age", "20");
		String jsonStr2 = jo.toJSONString();
		System.out.println("方法1：" + jsonStr1);
		System.out.println("方法2：" + jsonStr2);
	}
	
	
	
	
	//费用类
	public class Fee{
		private String name;
		private String fee;
		public Fee(String name, String fee) {
			super();
			this.name = name;
			this.fee = fee;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public String getFee() {
			return fee;
		}
		public void setFee(String fee) {
			this.fee = fee;
		}
	}
	
	/**
	 * 合成内容方法
	 */
	public static String getContent(String template,HashMap<String, Object> paramMap) throws Exception {
		//获取freemarker连接
		Configuration cfg = new Configuration(Configuration.VERSION_2_3_23);
		StringTemplateLoader stl = new StringTemplateLoader();
		stl.putTemplate("mytemplate", template);
		cfg.setTemplateLoader(stl);
		Template tp = cfg.getTemplate("mytemplate","UTF-8");
		StringWriter sw = new StringWriter();
		tp.process(paramMap, sw);
		return sw.toString();
	}
}
