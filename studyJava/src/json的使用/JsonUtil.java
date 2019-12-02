package json的使用;

import org.junit.Test;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;

/**
 * @ClassName： JsonUtil
 * @Author: dhSu
 * @Description:
 * @Date:Created in 2019年12月2日
 */

public class JsonUtil {
	
	/**
	 * json字符串格式化
	 */
	public static String formatJsonStr(String jStr) {
		JSONObject json = JSONObject.parseObject(jStr);
		return JSON.toJSONString(json,SerializerFeature.PrettyFormat,SerializerFeature.WriteMapNullValue,
				SerializerFeature.WriteDateUseDateFormat);
	}
	
	@Test
	public void testFormatJsonStr() {
		String jstr = "{ 	\"rtnCode\": \"0\", 	\"rtnMsg\": \"成功!\", 	\"bean\": {}, 	\"beans\": [], 	\"object\": { 		\"respDesc\": \"success\", 		\"respCode\": \"0\", 		\"object\": { 			\"result\": { 				\"productEndTime\": \"\", 				\"stopFlag\": \"\", 				\"prodPrcName\": \"\", 				\"lastLoginDefeated\": \"\", 				\"broadBandAddress\": \"丹东东港市黄海大街黄海路新华小区11号楼3单元6层603\", 				\"accessWay\": \"\", 				\"busiCode\": \"D15114181481\", 				\"radiusSpeed\": \"\", 				\"cooperationModel\": \"\", 				\"idNo\": \"\", 				\"productStartTime\": \"\", 				\"dynamicParams\": { 					\"createOrgId\": \"15021001\", 					\"createOpId\": \"15020478\", 					\"attrValue\": \"1\", 					\"doneDate\": \"2015-12-06 09:55:50.0\" 				}, 				\"lastLoginTime\": \"\", 				\"ifOnline\": \"\", 				\"loginName\": \"15114181481@net\", 				\"stopTime\": \"\", 				\"runTime\": \"2015-12-06 09:55:50.0\", 				\"runState\": \"0\", 				\"broadBandSpeed\": \"\", 				\"radiusState\": \"\" 			}, 			\"respDesc\": \"success\", 			\"respCode\": \"0\", 			\"resultRows\": \"1\" 		} 	} }";
		System.out.println(formatJsonStr(jstr));
	}
}
