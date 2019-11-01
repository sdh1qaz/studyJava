package 方法可变参数;

import org.junit.Test;

public class Variableparameters {

	public void printVariParam(String ...params) {
		System.out.println("入参：");
		for (String str : params) {
			System.out.println(str);
		}
	}
	
	@Test
	public void test(){
		printVariParam("参数1","参数2","参数3","参数4");
	}
}
