package 学习json.freemarker.jdbc;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.StringWriter;
import java.util.HashMap;
import java.util.Map;

import javax.print.DocFlavor.STRING;

import com.dhsu.json.CsfJSonUtils;

import freemarker.cache.StringTemplateLoader;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;

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
		/*map.put("套餐1", "套餐1每月100元");
		map.put("套餐2", "套餐2每月100元");*/
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
}
