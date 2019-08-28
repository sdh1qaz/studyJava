package json的使用;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.Map;

import org.junit.Test;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

/**
 * @ClassName： JsonObjectTest
 * 
 * @Author: dhSu
 * @Description:
 * @Date:Created in 2019年2月1日
 */


public class JsonObjectTest {
	
	@Test
	public void tes() {
		double d = 0.00;
		System.out.println(d > 0);
		String s = "2019071200";
		System.out.println(s.substring(0, 6));
		System.out.println(new SimpleDateFormat("yyyyMM").format(new Date()));
	}

	//判断是json对象还是json数组
	@Test
	public void tes2() {
		//json数据转化为字符串
		String jStu = "{\r\n" + 
				"	\"student\": {\r\n" + 
				"		\"name\": \"张三\",\r\n" + 
				"		\"age\": 20,\r\n" + 
				"		\"score\": [{\r\n" + 
				"			\"语文\": \"91\",\r\n" + 
				"			\"数学\": \"100\",\r\n" + 
				"			\"英语\": \"80\"\r\n" + 
				"		}, {\r\n" + 
				"			\"语文\": \"90\",\r\n" + 
				"			\"数学\": \"100\",\r\n" + 
				"			\"英语\": \"80\"\r\n" + 
				"		}]\r\n" + 
				"	}\r\n" + 
				"}";
		JSONObject stuObj = JSONObject.parseObject(jStu);
		System.out.println(jStu);
		Object obj = stuObj.getJSONObject("student").get("score");
		JSONArray j = (JSONArray)obj;
		System.out.println(j.getJSONObject(1).getString("语文"));
		/*System.out.println(j.size());
		System.out.println(obj instanceof JSONArray);
		
		System.out.println(stuObj.getString("student.name"));
		System.out.println(stuObj.getJSONObject("student").getString("name"))*/;
				
	}
	
	//json数组为空的情况
	@Test
	public void tes4() {
		//json数据转化为字符串
		String jStu = "{\r\n" + 
				"	\"student\": {\r\n" + 
				"		\"name\": \"张三\",\r\n" + 
				"		\"age\": 20,\r\n" + 
				"		\"score\": []\r\n" + 
				"	}\r\n" + 
				"}";
		JSONObject stuObj = JSONObject.parseObject(jStu);
		System.out.println(jStu);
		JSONArray jsonArray = stuObj.getJSONObject("student").getJSONArray("score");
		System.out.println(jsonArray.size());
		System.out.println(jsonArray==null);
		
	}
	
	//getJsonObject 空指针异常
	@Test
	public void tes3() {
		//json数据转化为字符串
		String jStu = "{\r\n" + 
				"	\"student\": {\r\n" + 
				"		\"name\": \"张三\",\r\n" + 
				"		\"age\": 20,\r\n" + 
				"		\"score\": [{\r\n" + 
				"			\"语文\": \"91\",\r\n" + 
				"			\"数学\": \"100\",\r\n" + 
				"			\"英语\": \"80\"\r\n" + 
				"		}, {\r\n" + 
				"			\"语文\": \"90\",\r\n" + 
				"			\"数学\": \"100\",\r\n" + 
				"			\"英语\": \"80\"\r\n" + 
				"		}],\r\n" + 
				"		\"object\": {}\r\n" + 
				"	}\r\n" + 
				"}";
		JSONObject stuObj = JSONObject.parseObject(jStu);
		System.out.println(jStu);
		JSONObject obj = stuObj.getJSONObject("student").getJSONObject("object").getJSONObject("outData");
		System.out.println(obj == null);
		//System.out.println(!obj.containsKey("outData.list") || !obj.getJSONObject("outData.list").containsKey("data"));
		
	}
	
	
	@Test
	public void tes1() {
		//模板字符串
		String csfInParams = "{\r\n" + 
				"	\"params\": {\r\n" + 
				"		\"loginNo\": \"Y18600IVR\",\r\n" + 
				"		\"masterServId\": \"1001\",\r\n" + 
				"		\"orderBy\": \"EFF_DATE_DESC\",\r\n" + 
				"		\"prodPrcid\": \"${prodPrcid}\",\r\n" + 
				"		\"qryMode\": \"PRC\",\r\n" + 
				"		\"serviceNo\": \"${telnum}\"\r\n" + 
				"	}\r\n" + 
				"}";
		csfInParams = csfInParams.replace("${prodPrcid}", "17737112692");
		System.out.println(csfInParams);
	}
	
	@Test
	public void getKeysFromJson() {
		//json数据转化为字符串
		String jStu = "{\r\n" + 
				"    \"student\": {\r\n" + 
				"        \"name\": \"张三\",\r\n" + 
				"        \"age\": 20,\r\n" + 
				"        \"score\": {\r\n" + 
				"            \"语文\": \"90\",\r\n" + 
				"            \"数学\": \"100\",\r\n" + 
				"            \"英语\": \"80\"\r\n" + 
				"        }\r\n" + 
				"    }\r\n" + 
				"}"; 
		//json字符串转化为JsonObject
		JSONObject stuObj = JSONObject.parseObject(jStu);
		System.out.println("观察JsonObject对象的toString方法打印：" + stuObj.toString());
		System.out.println("观察JsonObject对象的toJsonString方法打印：" + stuObj.toJSONString());
		//取得张三的语文成绩
		Iterator<String> it = stuObj.keySet().iterator();
		while(it.hasNext()) {
			System.out.println(it.next());
		}
	}
	
	@Test
	public void getKeysFromJson2() {
		//json数据转化为字符串
		String jStu = "{\r\n" + 
				"    \"student\": {\r\n" + 
				"        \"name\": \"张三\",\r\n" + 
				"        \"age\": 20,\r\n" + 
				"        \"score\": {\r\n" + 
				"            \"语文\": \"90\",\r\n" + 
				"            \"数学\": \"100\",\r\n" + 
				"            \"英语\": \"80\"\r\n" + 
				"        }\r\n" + 
				"    }\r\n" + 
				"}"; 
		//json字符串转化为JsonObject
		JSONObject stuObj = JSONObject.parseObject(jStu);
		JSONArray ja = stuObj.getJSONObject("student").getJSONArray("score");
		System.out.println(ja.toJSONString());
	}
	
	@Test
	public void getKeysFromJson1() {
		//json数据转化为字符串
		String jsonStr = "{\r\n" + 
				"    \"rtnCode\": \"0\",\r\n" + 
				"    \"rtnMsg\": \"成功!\",\r\n" + 
				"    \"bean\": {\r\n" + 
				"         \"returnCode\":\"\",\r\n" + 
				"        \"returnMsg\": \"ok!\",\r\n" + 
				"        \"userMsg\": \"处理成功!\",\r\n" + 
				"        \"promptMsg\": \"\",\r\n" + 
				"        \"detailMsg\": \"OK!\"\r\n" + 
				"    },\r\n" + 
				"    \"beans\": [],\r\n" + 
				"    \"object\": {\r\n" + 
				"        \"outData.data\": {\r\n" + 
				"            \"idNo\": 11310005864525,\r\n" + 
				"            \"createTime\": \"20170201000000\",\r\n" + 
				"            \"creditMark\": \"四星\",\r\n" + 
				"            \"remark\": \"\",\r\n" + 
				"            \"mainStatus\": \"01\",\r\n" + 
				"            \"effDate\": \"20170401000000\",\r\n" + 
				"            \"expDate\": \"20180331235959\",\r\n" + 
				"            \"effFlag\": \"1\",\r\n" + 
				"            \"systemStatus\": \"01\",\r\n" + 
				"            \"runCode\": \"A\",\r\n" + 
				"            \"yearArpu\": \"126\",\r\n" + 
				"            \"starScore\": \"247\",\r\n" + 
				"            \"starLevel\": \"5\",\r\n" + 
				"            \"phoneNo\": \"18256096817\",\r\n" + 
				"            \"mainStatusCash\": \"100\",\r\n" + 
				"            \"shutdownTimes\": \"0\"\r\n" + 
				"        }\r\n" + 
				"    }\r\n" + 
				"}";
		//json字符串转化为JsonObject
		JSONObject jsonObj = JSONObject.parseObject(jsonStr);
		//取得张三的语文成绩
		System.out.println(jsonObj.getJSONObject("object").getJSONObject("outData.data").getString("starLevel"));
	}
	
	@Test
	public void getObjFromJson() {
		//json数据转化为字符串
		String jStu = "{\r\n" + 
				"    \"student\": {\r\n" + 
				"        \"name\": \"张三\",\r\n" + 
				"        \"age\": 20,\r\n" + 
				"        \"score\": {\r\n" + 
				"            \"语文\": \"90\",\r\n" + 
				"            \"数学\": \"100\",\r\n" + 
				"            \"英语\": \"80\"\r\n" + 
				"        }\r\n" + 
				"    }\r\n" + 
				"}"; 
		//json字符串转化为JsonObject
		JSONObject stuObj = JSONObject.parseObject(jStu);
		//取得张三的语文成绩
		String score = stuObj.getJSONObject("student").getJSONObject("score").getString("语文");
		System.out.println("张三的语文成绩：" + score);
	}

	// 获取jsonObject中total值
	@Test
	public void getNodeJson() {
		//1.构造一个json字符串
		String jsonStr = "{\r\n" + "    \"rtnCode\": \"0\",\r\n" + "    \"rtnMsg\": \"成功!\",\r\n"
				+ "    \"bean\": {},\r\n" + "    \"beans\": [],\r\n" + "    \"object\": {\r\n"
				+ "        \"total\": 11,\r\n" + "        \"resultList\": [\r\n" + "            {\r\n"
				+ "                \"wrkfmSts\": \"3\",\r\n"
				+ "                \"wrkfmShowSwftno\": \"20190111105618X378157858\",\r\n"
				+ "                \"currWorkItemOwnerName\": \"\",\r\n"
				+ "                \"srvReqstTypeId\": \"002002005\",\r\n"
				+ "                \"acptTime\": \"2019-01-11 10:56:19.0\",\r\n"
				+ "                \"currWorkItemGroupName\": \"在线公司投诉工单班|2018030210017\"\r\n" + "            }\r\n"
				+ "        ]\r\n" + "    }\r\n" + "}";
		//System.out.println(jsonStr);
		//2.json字符串转化为JsonObject
		JSONObject jsonObj =  JSONObject.parseObject(jsonStr);
		//获取total节点
		int total = jsonObj.getJSONObject("object").getIntValue("total");
		System.out.println(total);
	}
	
	//宽带故障中获取用户宽带状态osStatus
	@Test
	public void getOsStatus() {
		String jsonStr = "{\r\n" + 
				"    \"rtnCode\": \"0\",\r\n" + 
				"    \"rtnMsg\": \"成功!\",\r\n" + 
				"    \"bean\": {},\r\n" + 
				"    \"beans\": [],\r\n" + 
				"    \"object\": {\r\n" + 
				"        \"flag\": \"1\",\r\n" + 
				"        \"billId\": \"18277157029\",\r\n" + 
				"        \"resultList\": [\r\n" + 
				"            {\r\n" + 
				"                \"baseInfo\": {\r\n" + 
				"                    \"currSpeed\": \"12M\",\r\n" + 
				"                    \"speedEffectDate\": \"20151017 203601\",\r\n" + 
				"                    \"linkPhone\": \"18277157029\",\r\n" + 
				"                    \"imsBillId\": \"\",\r\n" + 
				"                    \"resSpecId\": \"0\",\r\n" + 
				"                    \"linkName\": \"陈征雄\",\r\n" + 
				"                    \"openType\": \"null\",\r\n" + 
				"                    \"stsDate\": \"20180830 113820\",\r\n" + 
				"                    \"stdAddress\": \"广西|南宁|西乡塘区|西乡塘区|大学东路100号广西大学西校园|3栋|4楼\",\r\n" + 
				"                    \"speedExpireDate\": \"20991231 235959\",\r\n" + 
				"                    \"expireDate\": \"20991231 235959\",\r\n" + 
				"                    \"objType\": \"001\",\r\n" + 
				"                    \"addrType\": \"01\",\r\n" + 
				"                    \"effectDate\": \"20151017 203601\",\r\n" + 
				"                    \"coverScope\": \"null\",\r\n" + 
				"                    \"bindBillId\": \"18277157029\",\r\n" + 
				"                    \"saleMode\": \"0\",\r\n" + 
				"                    \"addrCounty\": \"7122|东区销售分公司\",\r\n" + 
				"                    \"oldStdAddr\": \"\",\r\n" + 
				"                    \"catType\": \"null\",\r\n" + 
				"                    \"installAddress\": \"广西|南宁|西乡塘区|西乡塘区|大学东路100号广西大学西校园|3栋|4楼\",\r\n" + 
				"                    \"isRenewFromTietong\": \"0\",\r\n" + 
				"                    \"isTieTongUser\": \"1\",\r\n" + 
				"                    \"regionId\": \"771\",\r\n" + 
				"                    \"areaAttr\": \"\",\r\n" + 
				"                    \"installType\": \"FTTB\",\r\n" + 
				"                    \"billId\": \"18277157029\",\r\n" + 
				"                    \"osStatus\": \"00000000\",\r\n" + 
				"                    \"imei\": \"null\",\r\n" + 
				"                    \"addrRegion\": \"771|南宁\",\r\n" + 
				"                    \"account\": \"18277157029\",\r\n" + 
				"                    \"catSupplier\": \"null\"\r\n" + 
				"                },\r\n" + 
				"                \"orderList\": [\r\n" + 
				"                    {\r\n" + 
				"                        \"effectDate\": \"20140412 184215\",\r\n" + 
				"                        \"offerName\": \"（代办铁通）（免预存）2013年南宁校园校园方案-手机合约型-12M 88元档             \",\r\n" + 
				"                        \"tariffType\": \"1\",\r\n" + 
				"                        \"endDate\": \"20150512 184215\",\r\n" + 
				"                        \"favoFee\": \"0\",\r\n" + 
				"                        \"favoDesc\": \"null\",\r\n" + 
				"                        \"lowerLimit\": \"0\",\r\n" + 
				"                        \"widthType\": \"3\",\r\n" + 
				"                        \"marketType\": \"3\",\r\n" + 
				"                        \"productInfo\": [\r\n" + 
				"                            {\r\n" + 
				"                                \"effectDate\": \"20140412 184215\",\r\n" + 
				"                                \"productId\": \"221093009190\",\r\n" + 
				"                                \"expireDate\": \"20991231 235959\",\r\n" + 
				"                                \"state\": \"1\",\r\n" + 
				"                                \"productType\": \"2\",\r\n" + 
				"                                \"productName\": \"2012年全区宽带易享套餐校园计划（月）12M88元档\"\r\n" + 
				"                            },\r\n" + 
				"                            {\r\n" + 
				"                                \"effectDate\": \"20140412 184215\",\r\n" + 
				"                                \"productId\": \"224000000808\",\r\n" + 
				"                                \"expireDate\": \"20991231 235959\",\r\n" + 
				"                                \"state\": \"1\",\r\n" + 
				"                                \"productType\": \"2\",\r\n" + 
				"                                \"productName\": \"宽带基础产品\"\r\n" + 
				"                            },\r\n" + 
				"                            {\r\n" + 
				"                                \"effectDate\": \"20140412 184215\",\r\n" + 
				"                                \"productId\": \"221093009260\",\r\n" + 
				"                                \"expireDate\": \"20991231 235959\",\r\n" + 
				"                                \"state\": \"1\",\r\n" + 
				"                                \"productType\": \"2\",\r\n" + 
				"                                \"productName\": \"2012年全区校园裸宽带月标准资费（12M）\"\r\n" + 
				"                            }\r\n" + 
				"                        ],\r\n" + 
				"                        \"beginDate\": \"20140412 184215\",\r\n" + 
				"                        \"tariffLevel\": \"null\",\r\n" + 
				"                        \"baseFee\": \"0\",\r\n" + 
				"                        \"offerId\": \"211199000434\",\r\n" + 
				"                        \"upperLimit\": \"0\",\r\n" + 
				"                        \"treatyTime\": \"12\",\r\n" + 
				"                        \"expireDate\": \"20991231 235959\",\r\n" + 
				"                        \"userType\": \"1\",\r\n" + 
				"                        \"state\": \"1\",\r\n" + 
				"                        \"paymentMax\": \"1\",\r\n" + 
				"                        \"packedFlag\": \"1\"\r\n" + 
				"                    }\r\n" + 
				"                ]\r\n" + 
				"            }\r\n" + 
				"        ]\r\n" + 
				"    }\r\n" + 
				"}";
		//2.json字符串转化为JsonObject
		JSONObject jsonObj =  JSONObject.parseObject(jsonStr);
		//获取包含有宽带状态的baseInfo
		JSONObject baseInfo = (JSONObject)jsonObj.getJSONObject("object").getJSONArray("resultList").get(0);
		//获取宽带状态status
		String status = baseInfo.getJSONObject("baseInfo").getString("osStatus");
		String flag = jsonObj.getJSONObject("object").getString("flag");
		/*System.out.println(baseInfo);
		System.out.println(status);
		System.out.println(flag);
		
		Iterator<String> it = jsonObj.keySet().iterator();
		while(it.hasNext()) {
			System.out.println("********************");
			System.out.println(it.next());
		}*/
		
		String installAddress = baseInfo.getJSONObject("baseInfo").getString("installAddress");
		System.out.println(installAddress);
	}
	
	//2.4.0  查看一键清理记录
	@Test
	public void getCleanListSize() {
		String jsonStr = "{\r\n" + 
				"    \"rtnCode\": \"0\",\r\n" + 
				"    \"rtnMsg\": \"成功!\",\r\n" + 
				"    \"bean\": {},\r\n" + 
				"    \"beans\": [],\r\n" + 
				"    \"object\": {\r\n" + 
				"        \"cleanList\": [\r\n" + 
				"            {\r\n" + 
				"                \"billId\": \"18277157029\",\r\n" + 
				"                \"channel\": \"GXYYDH\",\r\n" + 
				"                \"createTime\": \"2019-01-11 16:56:02\",\r\n" + 
				"                \"errorMessage\": \"1111\",\r\n" + 
				"                \"ext1\": \"\",\r\n" + 
				"                \"ext2\": \"\",\r\n" + 
				"                \"ext3\": \"\",\r\n" + 
				"                \"opId\": \"77180258\"\r\n" + 
				"            },\r\n" + 
				"            {\r\n" + 
				"                \"billId\": \"18277157029\",\r\n" + 
				"                \"channel\": \"GXYYDH\",\r\n" + 
				"                \"createTime\": \"2019-01-11 17:11:59\",\r\n" + 
				"                \"errorMessage\": \"1111\",\r\n" + 
				"                \"ext1\": \"\",\r\n" + 
				"                \"ext2\": \"\",\r\n" + 
				"                \"ext3\": \"\",\r\n" + 
				"                \"opId\": \"77180258\"\r\n" + 
				"            }\r\n" + 
				"        ],\r\n" + 
				"        \"cleanListSize\": 6\r\n" + 
				"    }\r\n" + 
				"}";
		JSONObject jsonObj = JSONObject.parseObject(jsonStr);
		
		int cleanListSize = jsonObj.getJSONObject("object").getIntValue("cleanListSize");
		System.out.println(cleanListSize);
	}
	
	//2.4.0宽带一键检测
	@Test
	public void testCheckBoardBand() {
		String jsonStr = "{\r\n" + 
				"    \"rtnCode\": \"0\",\r\n" + 
				"    \"rtnMsg\": \"成功!\",\r\n" + 
				"    \"bean\": {},\r\n" + 
				"    \"beans\": [],\r\n" + 
				"    \"object\": {\r\n" + 
				"        \"resultFlag\": 0,\r\n" + 
				"        \"resultMsg\": \"\"\r\n" + 
				"    }\r\n" + 
				"}";
		JSONObject jsonObj = JSONObject.parseObject(jsonStr);
		int resultFlag = jsonObj.getJSONObject("object").getIntValue("resultFlag");
		System.out.println(resultFlag);
	}
	
	//辽宁2.5.0 是否绑定宽带
	@Test
	public void testIsBandBoard() {
		String jsonStr = "{\r\n" + 
						"    \"rtnCode\": \"0\",\r\n" + 
						"    \"rtnMsg\": \"成功!\",\r\n" + 
						"    \"bean\": {},\r\n" + 
						"    \"beans\": [],\r\n" + 
						"    \"object\": {\r\n" + 
						"        \"respDesc\": \"success\",\r\n" + 
						"        \"respCode\": \"0\",\r\n" + 
						"        \"object\": {\r\n" + 
						"            \"result\": {\r\n" + 
						"                \"srvCode\": \"D15114181481\",\r\n" + 
						"                \"dynamicParams\": {\r\n" + 
						"                    \"loginName\": \"15114181481@net\"\r\n" + 
						"                },\r\n" + 
						"                \"runCode\": \"0\",\r\n" + 
						"                \"custId\": \"100066680929\",\r\n" + 
						"                \"runTime\": \"2015-12-06 09:55:50.0\",\r\n" + 
						"                \"idNo\": \"\"\r\n" + 
						"            },\r\n" + 
						"            \"respDesc\": \"success\",\r\n" + 
						"            \"respCode\": \"0\",\r\n" + 
						"            \"resultRows\": \"1\"\r\n" + 
						"        }\r\n" + 
						"    }\r\n" + 
						"}";
		JSONObject jsonObj = JSONObject.parseObject(jsonStr);
		String resultFlag = jsonObj.getJSONObject("object").getJSONObject("object").getString("resultRows");
		if (Integer.valueOf(resultFlag) > 0) {
			System.out.println("resultFlag: " + resultFlag);
		}
	}

	
	

}
