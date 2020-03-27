import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

public class URLEncoderTest {
	public static void main(String[] args) throws UnsupportedEncodingException {
		
		String url = "http://134.225.251.36:9181/app/api/1c1f930bc32129278fedaff07c571ccc/711c187665728bcc7f96fc5d89267108/queryList?tags=T_JXSDX_TX_NL&libraryId=13&where=";
		String url2 = "{\"and\":[[\"T_JXSDX_TX_HM\",\"=\",\"18178912142\"]]}";
		System.out.println(URLEncoder.encode(url2, "UTF-8"));
		System.out.println("24.0".indexOf("8"));
		System.out.println("24.0".substring(0,2));
	}
}
