package jvm学习;
/**
 * @ClassName： RuntimeConstantPoolOOM1
 * @Author: dhSu
 * @Description:测试jdk1.8中string的intern方法特性
 * @Date:Created in 2019年6月3日
 */

public class RuntimeConstantPoolOOM1 {
	
	public static void main(String[] args) {
		String str1 = new StringBuilder("计算机").append("软件").toString();
		System.out.println(str1.intern() == str1);
		
		String str2 = new StringBuilder("ja").append("va").toString();
		System.out.println(str2.intern() == str2);
		
		String str3 = "你好";
		System.out.println(str3.intern() == str3);
		
		String str4 = "你好";
		System.out.println(str3 == str4);
		
		String str5 = new String("你好");
		System.out.println(str3 == str5);
		
		String str6 = "\"你好\"";
		System.out.println(str6);
		str6 = str6.replace("\"", "");
		System.out.println(str6);
		
	}
}
