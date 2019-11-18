package freemarker的使用.demo;

/**
 * @Date:Created in 2019年11月6日
 */
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.StringWriter;
import java.io.Writer;
import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

import freemarker.cache.StringTemplateLoader;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;

public class FreemarkerDemo {

	@Test
	public void helloWord() throws IOException, TemplateException {

		Configuration cfg = new Configuration(Configuration.VERSION_2_3_0);
		// 指定模板文件的来源
		String path = FreemarkerDemo.class.getClassLoader().getResource("template").getPath();
		cfg.setDirectoryForTemplateLoading(new File(path));
		// 这是模板的编码
		cfg.setDefaultEncoding("UTF-8");
		// 获取模板
		Template template = cfg.getTemplate("helloworld.ftl");
		// 创建FreeMarker的数据模型
		Map<String, String> root = new HashMap<String, String>();
		root.put("who", "freemarker");
		// 这是输出文件
		File file = new File("E://" + "result.txt");
		Writer out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file)));
		// 将模板与数据模型合并
		template.process(root, out);
		out.flush();
		out.close();
	}
	
	/**
	 * temName-模板，paramsMap-数据
	 * 拼装后的内容输出到E:\result.txt
	 */
	public static void  getTtsSms(String temName,Map<String, Object> paramsMap) throws Exception {

		Configuration cfg = new Configuration(Configuration.VERSION_2_3_0);
		// 指定模板文件的来源
		String path = FreemarkerDemo.class.getClassLoader().getResource("template").getPath();
		cfg.setDirectoryForTemplateLoading(new File(path));
		// 这是模板的编码
		cfg.setDefaultEncoding("UTF-8");
		// 获取模板
		Template template = cfg.getTemplate(temName);
		// 这是输出文件
		File file = new File("E://" + "result.txt");
		Writer out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file),"UTF-8"));
		// 将模板与数据模型合并
		template.process(paramsMap, out);
		out.flush();
		out.close();
	}
	
	/**
	 * templateName-模板，paramsMap-数据
	 * 返回拼装后的内容
	 */
	public static String getTtsSmsStr(String templateName,Map<String, Object> paramsMap) throws Exception {
		
		Configuration cfg = new Configuration(Configuration.VERSION_2_3_23);
		// 指定模板文件的来源
		String path = FreemarkerDemo.class.getClassLoader().getResource("template").getPath();
		cfg.setDirectoryForTemplateLoading(new File(path));
		// 获取模板
		Template template = cfg.getTemplate(templateName,"UTF-8");
		StringWriter sw = new StringWriter();
		template.process(paramsMap, sw);
		return sw.toString();
	}
	
	@Test
	public void testSd042_tts02() throws Exception {
		Map<String, Object> paramsMap = new HashMap<String, Object>();
		paramsMap.put("cr", "2017-12-05");
		System.out.println(getTtsSmsStr("test.ftl", paramsMap));
	}
	

	/**
	 * freemarker 25098除100保留2位小数
	 * @throws Exception 
	 */
	@Test
	public void test1() throws Exception {
		Map<String, Object> paramsMap = new HashMap<String, Object>();
		paramsMap.put("cr", "-23.45");
		paramsMap.put("total", "25.00");
		paramsMap.put("leftNum", "20.00");
		System.out.println(getTtsSmsStr("test1.ftl", paramsMap));
		System.out.println(0.00 > 0);
		System.out.println(5.00+8);
		System.out.println(Double.valueOf("1000"));
	}
}
