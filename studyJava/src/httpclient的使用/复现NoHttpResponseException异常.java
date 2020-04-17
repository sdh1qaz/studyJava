package httpclient的使用;

public class 复现NoHttpResponseException异常 {
	
	public static void main(String[] args) {
		for (int i = 0; i < 1000; i++) {
			HttpClientUtil.sendPost("http://127.0.0.1:8080/dbmanager/execSql.html", "");
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}
