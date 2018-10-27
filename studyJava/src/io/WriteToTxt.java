package io;

public class WriteToTxt {
    public static void main(String[] args) {
		//要写的文件
    	String filePath = "D:\\ping00.bat";
    	for (int i = 2; i <= 200; i++) {
			String pingCmd = "ping 192.168.1." + i + " >>d:\\ping.txt";
			System.out.println(pingCmd);
			FileOperation.addContentToTxt(filePath, pingCmd);
		}
	}
}
