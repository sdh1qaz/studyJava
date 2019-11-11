package 关键字final;
/**
 * @ClassName： FinalClass
 * @Author: dhSu
 * @Description: 无状态对象
 * @Date:Created in 2018年3月29日
 */

import java.util.HashMap;
import java.util.Map;

public class FinalClass {
    public static Map<String, String>  map = new HashMap<String,String>();
    static {
    	map.put("国家主席", "习近平");
    	map.put("主席夫人", "彭丽媛");
    }
    
    public static void main(String[] args) {
		//System.out.println(FinalClass.map.get("国家主席"));
    	
    	System.out.println(new FinalClass().map.get("国家主席"));
	}
}
