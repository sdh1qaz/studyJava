package com.dhsu.basic;
/**
 * @ClassName： SwitchSentenceTest
 * @Author: dhSu
 * @Description: 测试
 * @Date:Created in 2018年11月19日
 */

public class SwitchSentenceTest {
	public static String getResult(String bus) {
		switch(bus) {
		case "sc006":
			return "四川sc006";
		case "sc004":
			return "四川sc004";
		case "sc003":
			return "四川sc003";
			default :
				return "其他";
		}
	}
	
	public static void getResult1(String bus) {
		switch(bus) {
		case "sc006":
			System.out.println("四川sc006");
			break;
		case "sc004":
			System.out.println("四川sc004");
		case "sc003":
			System.out.println("四川sc003");
			default :
				System.out.println("其他");
		}
	}
	
	public static void main(String[] args) {
		//System.out.println(getResult("1"));
		getResult1("sc006");
	}

}
