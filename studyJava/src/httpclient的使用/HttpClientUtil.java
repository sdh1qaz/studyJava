package httpclient的使用;

import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.hibernate.validator.constraintvalidation.HibernateConstraintValidatorContext;
import org.junit.Test;

/**
 * @ClassName： HttpClientUtil
 * 
 * @Author: dhSu
 * @Description: 访问API地址，处理相应
 * @Date:Created in 2018年3月10日
 */

public class HttpClientUtil {
	
	/**
	 * 模拟请求
	 * @param url 资源地址
	 * @param parmJson 入参json字符串
	 * @return String 反参字符串
	 */
	public static String sendPost(String url, String parmJson) {
		String result = null;
		try {
			// 创建httpclient对象
			CloseableHttpClient httpclient = HttpClients.createDefault();
			// 创建post方式请求对象
			HttpPost httpPost = new HttpPost(url);
			StringEntity se = new StringEntity(parmJson);
			// 设置参数到请求对象中
			httpPost.setEntity(se);
			System.out.println("请求地址：" + url);
			System.out.println("请求参数：" + parmJson);

			// 设置header信息
			// 指定报文头【Content-type】、【User-Agent】
			httpPost.setHeader("Content-type", "application/json");
			httpPost.setHeader("User-Agent",
					"Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/64.0.3282.186 Safari/537.36");
			// 执行请求操作，并拿到结果（同步阻塞）
			CloseableHttpResponse response = httpclient.execute(httpPost);
			// 获取结果实体
			HttpEntity entity = response.getEntity();
			if (entity != null) {
				// 按指定编码转换结果实体为String类型
				result = JsonFormatUtil.formatJson(EntityUtils.toString(entity, "UTF-8"));
			}
			EntityUtils.consume(entity);
			// 释放链接
			response.close();
		} catch (Exception e) {
			result = "请求接口出现了异常：\n" + e.toString();
			e.printStackTrace();
		} 
		return result;
	}
	
	
	@Test
	public void test() {
		System.out.println(sendPost("http://127.0.0.1:8687/user/items/getItems", ""));
	}
}
