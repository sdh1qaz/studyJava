package freemarker的使用;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.print.DocFlavor.STRING;

import freemarker.cache.StringTemplateLoader;
import freemarker.core.ParseException;
import freemarker.template.Configuration;
import freemarker.template.MalformedTemplateNameException;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import freemarker.template.TemplateNotFoundException;
import json的使用.CsfJSonUtils;
import junit.framework.TestFailure;

import org.junit.Test;

/**
 * @ClassName： FreemarkerTest
 * @Author: dhSu
 * @Description: 学习freemarker的使用
 * @Date:Created in 2019年5月24日
 */


public class FreemarkerTest {
	
	@Test
	public void testFreemarker() throws IOException, TemplateException {
		//json数据转化为字符串
		String jStu = "{\r\n" + 
				"    \"student\": {\r\n" + 
				"        \"name\": \"张三\",\r\n" + 
				"        \"age\": 29,\r\n" + 
				"        \"score\": {\r\n" + 
				"            \"语文\": \"90\",\r\n" + 
				"            \"数学\": \"100\",\r\n" + 
				"            \"英语\": \"81\"\r\n" + 
				"        }\r\n" + 
				"    }\r\n" + 
				"}"; 
		//json串转化成bean对象
		Student s = CsfJSonUtils.jsonString2Bean(jStu, "student", Student.class);
		System.out.println("学生对象：" + s.toString());
		
		//从文件中读取模板
		FileReader fReader = new FileReader("E:\\freemarker_model.txt");
		BufferedReader bf = new BufferedReader(fReader);
		String read;
		StringBuilder sb = new StringBuilder();
		while((read = bf.readLine()) != null) {
			sb.append(read);
		}
		System.out.println("读取的模板：" + sb.toString());
		//获取freemarker连接
		Configuration cfg = new Configuration(Configuration.VERSION_2_3_23);
		StringTemplateLoader stl = new StringTemplateLoader();
		stl.putTemplate("mytemplate", sb.toString());
		cfg.setTemplateLoader(stl);
		
		//放入数据
		HashMap<String, Object> map = new HashMap<>();
		//放入学生对象
		map.put("s", s);
		System.out.println("map的内容：" + map);
		
		Template template = cfg.getTemplate("mytemplate","UTF-8");
		StringWriter sw = new StringWriter();
		template.process(map, sw);
		
		//模板转换的最终内容
		String cont = sw.toString();
		System.out.println("模板填充后的内容：" + cont);
	}
	
	/**
	 * 半年内最近的三笔充值记录
	 */
	@Test
	public void TestF() {
		//String template = "【充值记录查询】尊敬的客户，您好！您的个人账户半年内最近三笔充值记录为<#assign num=0><#assign size=crList?size><#list crList?sort_by(\"effDate\")?reverse as l><#assign num=num+1>${l.effDate}，转账充值${l.chargeSum}元<#if (num < 3) && (num < size)>；<#else>。<#break></#if></#list>如已办理移动宽带，个人缴费记录将体现在融合账户中。请登陆安徽移动手机营业厅，进入“我的移动”选择“我的消费-交费记录”进行查询。下载猛戳http://ah.10086.cn/new/s/kf/khd。【中国移动】";
		//String template = "下面将为您播报个人账户半年内最近三笔充值记录，<#assign num=0><#assign size=crList?size><#list crList?sort_by(\"effDate\")?reverse as l><#assign num=num+1>${l.effDate}，转账充值${l.chargeSum}元<#if (num < 3) && (num < size)>；<#else>。<#break></#if></#list>如您办理移动宽带，缴费会在融合账户中体现。现已将刚才播报内容及融合账户充值查询方式已下发至您的手机，请注意查收。";
		String template = "为您查询到，您最近一笔交费<#list crList?sort_by(\"effDate\")?reverse as l>${l.chargeSum}元<#break></#list>已到账，因每月16日为系统并账期，会扣除部分套餐一半月租费用，您当前可用余额为${balance}元。如需了解本月话费消费明细，请点击稍后下发的短信链接查询。";
		List<ChargeRecords> crList = new ArrayList<ChargeRecords>();
		ChargeRecords cr1 = new ChargeRecords();
		ChargeRecords cr2 = new ChargeRecords();
		ChargeRecords cr3 = new ChargeRecords();
		cr1.setChargeSum("100.0");
		cr1.setEffDate("2019年7月1日");
		cr2.setChargeSum("10.0");
		cr2.setEffDate("2019年7月3日");
		cr3.setChargeSum("300.0");
		cr3.setEffDate("2019年7月5日");
		crList.add(cr1);
		crList.add(cr2);
		crList.add(cr3);
		//crList.add(cr3);
		HashMap<String, Object> map = new HashMap<>();
		map.put("balance", "23.00");
		map.put("crList", crList);
		try {
			System.out.println(getContent(template, map));
		} catch (Exception e) {
			System.out.println("出现了异常");
		}
	}
	
	/**
	 * 半年返还记录
	 */
	@Test
	public void TestF1() {
		//String template = "【充值记录查询】尊敬的客户，您好！您的个人账户半年内最近三笔充值记录为<#assign num=0><#assign size=crList?size><#list crList?sort_by(\"effDate\")?reverse as l><#assign num=num+1>${l.effDate}，转账充值${l.chargeSum}元<#if (num < 3) && (num < size)>；<#else>。<#break></#if></#list>如已办理移动宽带，个人缴费记录将体现在融合账户中。请登陆安徽移动手机营业厅，进入“我的移动”选择“我的消费-交费记录”进行查询。下载猛戳http://ah.10086.cn/new/s/kf/khd。【中国移动】";
		String template = "<#list rList?sort_by(\"monRetDate\")?reverse as l>${l.monRetDate?substring(0,4)}年${l.monRetDate?substring(4,6)}月${l.monRetDate?substring(6,8)}日，返还${l.monRetValue}元。</#list>";
		//String  template = "为您查询到，您最近一笔交费<#list crList?sort_by(\"effDate\")?reverse as l>${l.chargeSum}元<#break></#list>已到账，因每月16日为系统并账期，会扣除部分套餐一半月租费用，您当前可用余额为${balance}元。如需了解本月话费消费明细，请点击稍后下发的短信链接查询。";
		List<ReturnRecords> rList = new ArrayList<ReturnRecords>();
		ReturnRecords r1 = new ReturnRecords();
		ReturnRecords r2 = new ReturnRecords();
		ReturnRecords r3 = new ReturnRecords();
		
		r1.setMonRetDate("20190701");
		r2.setMonRetDate("20190601");
		r3.setMonRetDate("20190501");
		
		r1.setMonRetValue("100.00");
		r2.setMonRetValue("90.00");
		r3.setMonRetValue("80.00");
		
		rList.add(r1);
		rList.add(r2);
		rList.add(r3);
		
		HashMap<String, Object> map = new HashMap<>();
		map.put("balance", "0.90");
		map.put("crList", rList);
		try {
			System.out.println(getContent(template, map));
		} catch (Exception e) {
			System.out.println("出现了异常");
		}
	}
	
	/**
	 * 账单查询
	 */
	@Test
	public void TestF2() {
		String template = "您${yMonth?substring(0,4)}年${yMonth?substring(4,6)}月份的账单为：<#if monthInitFee?? && monthInitFee?number gt 0>上月结余${monthInitFee}元。<#elseif monthInitFee?? && monthInitFee?number lt 0>上月欠费${monthInitFee?replace(\"-\",\"\")}元。</#if><#if fee1?? && fee1?number gt 0>套餐及固定费${fee1}元。</#if><#if fee2?? && fee2?number gt 0>语音通信费${fee2}元。</#if><#if fee3?? && fee3?number gt 0>上网费${fee3}元。</#if><#if fee4?? && fee4?number gt 0>短彩信费${fee4}元。</#if><#if fee5?? && fee5?number gt 0>增值业务费${fee5}元。</#if><#if fee6?? && fee6?number gt 0>代收费业务费用${fee6}元。</#if><#if fee7?? && fee7?number gt 0>其他费${fee7}元。</#if><#if favorSum?? && favorSum?number gt 0>折扣减免${favorSum}元。</#if>近一年的账单查询链接已下发至您的手机，可点击查看使用详情。";
		
		HashMap<String, Object> bMap = new HashMap<>();
		bMap.put("yMonth", "201907");
		bMap.put("monthFee", "100.00");
		bMap.put("monthInitFee", "-70.00");
		bMap.put("fee1", "9.00");
		bMap.put("fee2", "0.00");
		bMap.put("fee3", "10.00");
		bMap.put("fee4", "18.00");
		bMap.put("fee5", "0.00");
		bMap.put("fee6", "40.00");
		bMap.put("fee7", "30.00");
		bMap.put("favorSum", "14.00");
		
		try {
			System.out.println(getContent(template, bMap));
		} catch (Exception e) {
			System.out.println("出现了异常");
		}
	}
	
	@Test
	public void con() {
		System.out.println("201909".compareTo("201908") > 0);
	}
	
	/**
	 * freemarker遍历map
	 */
	@Test
	public void testFreemarker1() throws IOException, TemplateException {
		String template = "【已办业务查询】尊敬的客户，您好！您目前手机已开通业务有：\\r\\n一、主套餐：${prodPrcNameMain}。套餐资费详情：${prodPrcDescMain}\\r\\n二、<#if map?size gt 0>除主套餐外，您订购的业务及月功能费如下：<#list map?keys as key>${key}${map[\"${key}\"]}</#list>如需退订主套餐以外业务请发送77至10086按提示操作即可。<#else>除主套餐外，暂未查询到其他业务。您也可以发送免费短信77至10086按提示查询退订已开通业务。</#if>以上国内资费不包含港澳台。【中国移动】";
		System.out.println("模板：" + template.toString());
		//获取freemarker连接
		Configuration cfg = new Configuration(Configuration.VERSION_2_3_23);
		StringTemplateLoader stl = new StringTemplateLoader();
		stl.putTemplate("mytemplate", template);
		cfg.setTemplateLoader(stl);
		
		//放入数据
		HashMap<String, Object> paramMap = new HashMap<>();
		HashMap<String, Object> map = new HashMap<>();
		//放入学生对象
		map.put("套餐1", "套餐1每月100元");
		map.put("套餐2", "套餐2每月100元");
		paramMap.put("map", map);
		paramMap.put("prodPrcNameMain", "飞享套餐188元");
		paramMap.put("prodPrcDescMain", "该套餐免费");
		System.out.println("数据内容：" + paramMap);
		
		Template tp = cfg.getTemplate("mytemplate","UTF-8");
		StringWriter sw = new StringWriter();
		tp.process(paramMap, sw);
		
		//模板转换的最终内容
		String cont = sw.toString();
		System.out.println("模板填充后的内容：" + cont);
	}
	
	/**
	 * freemarker遍历map
	 * @throws Exception 
	 */
	@Test
	public void testFreemarker2() throws Exception {
		String template = "【已办业务查询】尊敬的客户，您好！您目前手机已开通业务有：\\r\\n一、主套餐：${prodPrcNameMain}。套餐资费详情：${prodPrcDescMain}\\r\\n二、<#if map?size gt 0>除主套餐外，您订购的业务及月功能费如下：<#list map?keys as key>${key}${map[\"${key}\"]}</#list>如需退订主套餐以外业务请发送77至10086按提示操作即可。<#else>除主套餐外，暂未查询到其他业务。您也可以发送免费短信77至10086按提示查询退订已开通业务。</#if>以上国内资费不包含港澳台。【中国移动】";
		System.out.println("模板：" + template.toString());
		
		//放入数据
		HashMap<String, Object> paramMap = new HashMap<>();
		HashMap<String, Object> map = new HashMap<>();
		//放入学生对象
		map.put("套餐1", "套餐1每月100元");
		map.put("套餐2", "套餐2每月100元");
		paramMap.put("map", map);
		paramMap.put("prodPrcNameMain", "飞享套餐188元");
		paramMap.put("prodPrcDescMain", "该套餐免费");
		System.out.println("数据内容：" + paramMap);
		
		//模板转换的最终内容
		System.out.println("模板填充后的内容：" + getContent(template,paramMap));
	}
	
	/**
	 * 安徽话费查询模版 ah0080101
	 */
	@Test
	public void testFreemarkerah0080101(){
		//模版
		String template = "<#if rzllUflow??>您当日日租流量已用${rzllUflow}，<#elseif djrzllUflow??>${djrzllUflow}，</#if> <#if jwbUflow??>当月国内放心用流量已用${jwbUflow}，</#if> <#if gntsbUflow?? && gntsbUflow != \"0\" && gntsbUflow != \"0.00M\" && gntsbUflow != \"0.00\" >提速服务已用${gntsbUflow}。</#if> <#if xybxlllUflow?? && xybxlllUflow != \"0\" && xybxlllUflow != \"0.00M\" && xybxlllUflow != \"0.00\" >校园放心用流量已用xybxlllUflow，</#if> <#if xntsbUflow?? && xntsbUflow != \"0\" && xntsbUflow != \"0.00M\" && xntsbUflow != \"0.00\" >校园提速服务已用${xntsbUflow}。</#if> <#if newUsedFlow?? && newUsedFlow != \"0\" && newUsedFlow != \"0.00M\" && newUsedFlow != \"0.00\" >通用流量已用${newUsedFlow}，</#if> <#if newRestFlow?? && newRestFlow != \"0\" && newRestFlow != \"0.00M\" && newRestFlow != \"0.00\" >套餐内流量剩余${newRestFlow}，</#if> <#if domeresRflow?? && domeresRflow != \"0\" && domeresRflow != \"0.00M\" && domeresRflow != \"0.00\" >其中国内流量剩余${domeresRflow}（含国内结转流量），</#if> <#if provresRflow?? && provresRflow != \"0\" && provresRflow != \"0.00M\" && provresRflow != \"0.00\" >省内流量剩余${provresRflow}（含省内结转流量），</#if> <#if newIdleRflow?? && newIdleRflow != \"0\" && newIdleRflow != \"0.00M\" && newIdleRflow != \"0.00\" >另外，夜间流量剩余${newIdleRflow}（含夜间结转流量）。</#if> <#if cxUflow?? && cxUflow != \"0\" && cxUflow != \"0.00M\" && cxUflow != \"0.00\" >已使用套餐外优惠流量${cxUflow}，</#if> <#if cxRflow?? && cxRflow != \"0\" && cxRflow != \"0.00M\" && cxRflow != \"0.00\" >剩余套餐外优惠流量${cxRflow}， <#if cxxsRflow?? && cxxsRflow != \"0\" && cxxsRflow != \"0.00M\" && cxxsRflow != \"0.00\" >其中套餐外优惠夜间流量剩余${cxxsRflow}，</#if> <#if cxdmRflow?? && cxdmRflow != \"0\" && cxdmRflow != \"0.00M\" && cxdmRflow != \"0.00\" >套餐外优惠单模流量剩余${cxdmRflow}，</#if> <#if cxxyRflow?? && cxxyRflow != \"0\" && cxxyRflow != \"0.00M\" && cxxyRflow != \"0.00\" >套餐外优惠校园流量${cxxyRflow}，</#if> <#if cxsnRflow?? && cxsnRflow != \"0\" && cxsnRflow != \"0.00M\" && cxsnRflow != \"0.00\" >套餐外优惠省内流量剩余${cxsnRflow}，</#if> <#if cxsnRflow?? && cxsnRflow != \"0\" && cxsnRflow != \"0.00M\" && cxsnRflow != \"0.00\" >套餐外优惠国内流量剩余${cxgnRflow}，</#if></#if> <#if shareAllm?? && shareAllm != \"0\" && shareAllm != \"0.00M\" && shareAllm != \"0.00\" ><#if shareInfo?? && shareInfo?index_of(telnum) != -1>共享他人流量${shareAllm}，<#else>被他人共享流量${shareAllm}</#if></#if> 以上国内资费不包含港澳台。如以上查询结果未包含您需要的信息，请说“短信接收”获取更多查询链接。";
		//模版数据
		HashMap<String, Object> paramMap = new HashMap<>();
		paramMap.put("jwbUflow", "20M");
		paramMap.put("gntsbUflow", "0.06M");
		paramMap.put("xybxlllUflow", "30M");
		paramMap.put("xntsbUflow", "40M");
		paramMap.put("newUsedFlow", "20M");
		paramMap.put("newRestFlow", "25M");
		paramMap.put("provresRflow", "12M");
		paramMap.put("cxRflow", "40M");
		paramMap.put("cxxyRflow", "30M");
		paramMap.put("shareAllm", "30M");
		paramMap.put("shareInfo", "123456");
		//模板转换的最终内容
		String ttsContent;
		try {
			ttsContent = getContent(template,paramMap);
		} catch (Exception e) {
			ttsContent = "拼接异常";
			System.out.println("组装模版出现异常");
			e.printStackTrace();
		}
		System.out.println("模板填充后的内容：\n" + ttsContent);
	}
	
	/**
	 * 测试.now
	 */
	@Test
	public void testNow(){
		//模版
		String template = "当前年月：${.now?string[\"YYYY年MM月\"]?replace(\"年\",\"年[n2]555\")}";
		//模版数据
		HashMap<String, Object> paramMap = new HashMap<>();
		//模板转换的最终内容
		String ttsContent;
		try {
			ttsContent = getContent(template,paramMap);
		} catch (Exception e) {
			ttsContent = "拼接异常";
			System.out.println("组装模版出现异常");
			e.printStackTrace();
		}
		System.out.println("模板填充后的内容：\n" + ttsContent);
	}
	
	/**
	 * 测试list的大小
	 * list?size
	 */
	@Test
	public void testListSize(){
		//模版
		String template = "list的大小是：${list?size}";
		List<Student> list = new ArrayList<>();
		for(int i=0;i<100;i++) {
			list.add(new Student());
		}
		//模版数据
		HashMap<String, Object> paramMap = new HashMap<>();
		paramMap.put("list", list);
		//模板生成的内容
		String content;
		try {
			content = getContent(template,paramMap);
		} catch (Exception e) {
			content = "拼接异常";
			System.out.println("组装模版出现异常");
			e.printStackTrace();
		}
		System.out.println("模板填充后的内容：\n" + content);
	}
	
	/**
	 * 测试replace
	 * 正则
	 */
	@Test
	public void testReplace(){
		//模版
		String str = "你好，冲最小扣应冲，有效期24个月，已返还";
		String template = "${str?replace('冲最小扣应冲，有效期24个月，','已返还')?replace('冲最小扣应冲','')}";
		//模版数据
		HashMap<String, Object> paramMap = new HashMap<>();
		paramMap.put("str", str);
		//模板生成的内容
		String content;
		try {
			content = getContent(template,paramMap);
		} catch (Exception e) {
			content = "拼接异常";
			System.out.println("组装模版出现异常");
			e.printStackTrace();
		}
		System.out.println("模板填充后的内容：\n" + content);
	}
	
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
