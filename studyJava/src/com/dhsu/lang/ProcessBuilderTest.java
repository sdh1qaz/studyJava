package com.dhsu.lang;
/**
 * @ClassName： ProcessBuilderTest
 * @Author: dhSu
 * @Description:使用ProcessBuilder类打开记事本并命名
 * @Date:Created in 2018年11月16日
 */

public class ProcessBuilderTest {
	public static void main(String[] args) {
		try {
			ProcessBuilder processBuilder = new ProcessBuilder("notepad.exe","testfile");
			processBuilder.start();
		}catch (Exception e) {
			System.out.println("Error executing notepad");
		}
	}

}
