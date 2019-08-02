package json的使用;

/*import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.util.StringUtils;
import org.springframework.beans.BeanUtils;

import com.alibaba.fastjson.JSONArray;*/
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.JSONPath;
/*import com.cmos.tpsappsc.TpsException;
import com.cmos.tpsappsc.beans.csf.BaseResultPojo;
import com.cmos.tpsappsc.constant.ErrorConstant;*/
import com.google.gson.Gson;

/**
 * 
 * @ClassName: JSonUtils
 * @Description: CSF-Json操作工具类,完成自动化JSON<=>Bean的转换
 * @author 王成键
 * @date 2017年8月21日
 *
 */
public class CsfJSonUtils {

	private CsfJSonUtils() {
		throw new IllegalStateException("Utility class");
	}

	/**
	 * @param <T>
	 * 
	 * @Title: jsonString2Bean @Description: 完成JSON串到JavaBean的转化 @param @param
	 * jsonString @param @param jsonPath @param @param
	 * clazz @param @return @param @throws Exception 参数 @return T<T> 返回类型 @throws
	 */
	public static <T> T jsonString2Bean(String jsonString, String jsonPath, Class<T> clazz) {

		JSONObject csfJson = JSONObject.parseObject(jsonString);

		Object eval = JSONPath.eval(csfJson, jsonPath); // 根据JSONPath得到指定节点的JSON
		if (eval == null) {
			return null;
		}

		JSONObject jsonObj = JSONObject.parseObject(eval.toString());
		if (jsonObj == null) {
			return null;
		}
		String json = jsonObj.toString();

		Gson gson = new Gson();

		return gson.fromJson(json, clazz); // 解析
	}

	/*public static <T> List<T> jsonString2Beans(String jsonString, String jsonPath, Class<T> clazz) {

		JSONObject csfJson = JSONObject.parseObject(jsonString);

		Object eval = JSONPath.eval(csfJson, jsonPath); // 根据JSONPath得到指定节点的JSON
		if (eval == null || "[{}]".equals(eval.toString())) {
			List<T> arrayList = new ArrayList<>();
			arrayList.add(jsonString2Bean(jsonString, "$.bean", clazz));
			return arrayList;
		}

		String strObj = eval.toString();
		if (strObj.startsWith("{")) {
			strObj = "[" + strObj + "]";
		}
		JSONArray jsonArray = JSONObject.parseArray(strObj); // 得到JSON数组
		if (jsonArray == null) {
			return null;
		}
		Object beanevel = JSONPath.eval(csfJson, "$.bean");

		BaseResultPojo basebean;
		if (beanevel == null) {
			basebean = new BaseResultPojo();
			basebean.setReturnCode("-12345");
			basebean.setReturnMsg("bean节点为空");
		} else {
			Gson gson = new Gson();
			basebean = gson.fromJson(beanevel.toString(), BaseResultPojo.class);
		}

		List<T> results = new ArrayList<>(); // 保存Beans

		for (int x = 0; x < jsonArray.size(); x++) { // 遍历数组
			Object obj = jsonArray.get(x);

			String jsonStr = obj.toString();

			JSONObject jsonObj = JSONObject.parseObject(jsonStr); // 单个JSON对象

			String json = jsonObj.toString(); // 获取整理后的JSON

			Gson gson = new Gson();

			T result = gson.fromJson(json, clazz); // 解析
			BeanUtils.copyProperties(basebean, result);
			results.add(result); // 向结果集中添加结果
		}
		return results;
	}
*/
	/**
	 * 
	 * @Title: validJsonBean @Description: successCode作为返回值成功码 @param @param
	 * csfJson @param @param retcJsonPath @param @param descJsonPath @param @param
	 * successCode @param @throws Exception 参数 @return void 返回类型 @throws
	 */
	// 验证JSON字符串的Bean/Beans节点,如果验证不通过抛出TpsException(错误代码，提示信息)
	/*public static void validJsonBean(String csfJson, String retcJsonPath, String descJsonPath, String successCode)
			throws TpsException {
		JSONObject json = JSONObject.parseObject(csfJson);

		Object retcObj = JSONPath.eval(json, retcJsonPath); // 根据JSONPath得到指定节点的retc

		String retc = retcObj != null ? retcObj.toString() : null;

		if (StringUtils.isEmpty(retc) || !successCode.equals(retc)) {

			Object descObj = JSONPath.eval(json, descJsonPath); // 根据JSONPath得到指定节点的desc

			String desc = descObj != null ? descObj.toString() : "";

			throw new TpsException(ErrorConstant.NO_CSF_DATA_ERROR, desc);

		}
	}*/

	/**
	 * 
	 * @Title: validJsonBean @Description: 0作为返回值成功码 @param @param
	 * csfJson @param @param retcJsonPath @param @param descJsonPath @param @throws
	 * Exception 参数 @return void 返回类型 @throws
	 */
	/*public static void validJsonBean(String csfJson, String retcJsonPath, String descJsonPath) throws TpsException {
		validJsonBean(csfJson, retcJsonPath, descJsonPath, "0");
	}

	public static void validateCsfInparam(String inParam) throws TpsException {

		String pattern = "\\$\\{[a-zA-Z0-9-_]+\\}";

		String poty = "[a-zA-Z0-9-_]+";
		Pattern r = Pattern.compile(pattern);
		// 现在创建 matcher 对象
		Matcher m = r.matcher(inParam);
		if (m.find()) {

			Pattern patter = Pattern.compile(poty);

			Matcher matcher = patter.matcher(m.group(0));
			if (matcher.find()) {
				throw new TpsException(ErrorConstant.APP_DATA_VALIDATE_ERROR, "CSF入参不完整，缺少字段" + matcher.group(0));
			}
		}
	}*/

}
