import java.util.UUID;

/**
 * @ClassName： StringReplace
 * @Author: dhSu
 * @Description:
 * @Date:Created in 2018年8月23日
 */

public class StringReplace {
	/**
	* @Description: TODO(给定字符串在所有年份（2018）前面加上[n1],年份之后加上[n2])  
	* @param  str:被替换的字符串
	* @return String
	* @throws
	 */
	public static String replaceByRegex(String str) {
    	String[] arr = str.split("2[0-9]{3}年");
    	
    	StringBuffer buffer = new StringBuffer();
    	for(int i=0;i<arr.length;i++) {
    		if(i != arr.length-1) {
    			buffer.append(arr[i] + "[n1]"+ str.substring(str.indexOf(arr[i])+arr[i].length(), str.indexOf(arr[i+1])) + "[n2]");
    		}
    		else {
    			buffer.append(arr[i]);
    			if(!str.endsWith(arr[i]))
    				buffer.append("[n1]" + str.substring(str.indexOf(arr[i])+arr[i].length()) + "[n2]");
    		}
    		
    	}
    	return buffer.toString();
	}
	
	/**
	* @Description: TODO(给定字符串在所有月份前面加上[n2])  
	* @param  str:被替换的字符串
	* @return String
	* @throws
	 */
	public static String addN2BeforeMon(String str) {
    	String[] arr = str.split("[0-9]{2}月");
    	StringBuffer buffer = new StringBuffer();
    	for(int i=0;i<arr.length;i++) {
    		if(i != arr.length-1) {
    			buffer.append(arr[i] + "[n2]"+ str.substring(str.indexOf(arr[i])+arr[i].length(), str.indexOf(arr[i+1])));
    		}
    		else {
    			buffer.append(arr[i]);
    			if(!str.endsWith(arr[i]))
    				buffer.append("[n2]" + str.substring(str.indexOf(arr[i])+arr[i].length()));
    		}
    	}
    	return buffer.toString();
	}
	
	
	public static String replace_r_n(String str) {
		if(str != null) {
			return str.replaceAll("\\\\n", "\\\\\\\\n").replaceAll("\\\\r", "\\\\\\\\r");
		} else {
			return str;
		}
	}
	
    public static void main(String[] args) {
    	/*String str = "09月份您产生其他费152元";
    	System.out.println(addN2BeforeMon(str));*/
		/*String regex = "如果[\\s\\S]*一遍[\\s\\S]*请说[\\s\\S]*名称";
		String teString = "如果，如果如水电费规划局果果你，，56788）（）键一遍哈杀手锏请说科3456789技部名称";
		String result = teString.replaceAll(regex, "替换了");
		System.out.println(result);*/
    	String teString = "你好\\n大海\\r\\n我爱你";
    	/*System.out.println(teString);
    	String after = teString.replaceAll("\\n", "\\\\n").replaceAll("\\r", "\\\\r");
    	System.out.println("**********************************");
    	System.out.println(after);
    	System.out.println("**********************************");
    	System.out.println("你好\\n大海\\r\\n我爱你");*/
    	System.out.println(teString);
    	String aa = replace_r_n(teString);
    	System.out.println(replace_r_n(aa));
    	
    	System.out.println("\\\\n");
    	
    	
    	/*String str = "你好，目前使用的是98元套餐。(201806)";
    	System.out.println("替换前：" + str);
    	String rep = str.replaceAll("\\([0-9]{6}\\)", "");
    	System.out.println("替换后：" +rep);*/
    	
    	/*String str = "2每3每4G";
    	System.out.println("替换前：" + str);
    	String rep = str.replaceAll("2每3每4G", "2G，3G，4G");
    	System.out.println("替换后：" +rep);*/
    	
    	
    	/*String str = "300元/月";
    	System.out.println("替换前：" + str);
    	String rep = str.replaceAll("/月", "每月");
    	System.out.println("替换后：" +rep);*/
    	
    	/*String str = "使用如下：[n2]2";
    	System.out.println("替换前：" + str);
    	String rep = str.replaceAll("使用如下：\\[n2\\]2", "使用如下：[n2]1");
    	System.out.println("替换后：" +rep);*/
    	
    	/*String str = "880中华3人民45共和89国000,中央43.9人民政府678今天成立了0.789！";
    	String[] arr = str.split("[0-9]+[\\.]{0,1}[0-9]*");
    	
    	StringBuffer buffer = new StringBuffer();
    	for(int i=0;i<arr.length;i++) {
    		if(i != arr.length-1) {
    			buffer.append(arr[i] + "[n2]"+ str.substring(str.indexOf(arr[i])+arr[i].length(), str.indexOf(arr[i+1])));
    		}
    		else {
    			buffer.append(arr[i]);
    			if(!str.endsWith(arr[i]))
    				buffer.append("[n2]" + str.substring(str.indexOf(arr[i])+arr[i].length()));
    		}
    		
    	}
    	System.out.println(buffer.toString());*/
    	/*String str = "合约8M20元。2016年读作haah2016年232322099年";
    	System.out.println("替换前：" + str);
    	System.out.println("替换后：" + replaceByRegex(str));*/
//    	String telnum = "telnum";
//    	String sendTime = "2";
//    	System.out.println(UUID.randomUUID().toString());
//    	System.out.println("INSERT INTO sms_satisfy_history_ha (`telnum`, `send_time`, `send_time_str`) "
//					+ "VALUES (" + telnum + "," + sendTime + "," + sendTime + ")");
//    	StringBuilder sql = new StringBuilder();
//    	sql.append("INSERT INTO sms_satisfy_history_ha (`telnum`, `send_time`, `send_time_str`) ");
//		sql.append("VALUES (");
//		sql.append(telnum);
//		sql.append(",");
//		sql.append(sendTime);
//		sql.append(",");
//		sql.append(sendTime);
//		sql.append(")");
//		
//		System.out.println(sql.toString());
    	
    	
	}
}
