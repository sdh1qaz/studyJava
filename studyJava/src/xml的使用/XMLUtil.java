package xml的使用;

import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.Node;

/**
 * XML操作工具类
 */
public class XMLUtil {
	
	private static final String xml = "<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\">\r\n" + 
			"   <soapenv:Body>\r\n" + 
			"      <exchangeResponse xmlns=\"http://ws.inf.crm.ztesoft.com/exchange/\">\r\n" + 
			"         <out xmlns=\"\"><![CDATA[<?xml version=\"1.0\" encoding=\"UTF-8\"?>\r\n" + 
			"<root>\r\n" + 
			"   <Service_Information>\r\n" + 
			"      <Service_Result_Code>2</Service_Result_Code>\r\n" + 
			"      <Para_Field_Result>用户当前未停机!</Para_Field_Result>\r\n" + 
			"   </Service_Information>\r\n" + 
			"   <seq_id>202003111755047</seq_id>\r\n" + 
			"</root>]]></out>\r\n" + 
			"      </exchangeResponse>\r\n" + 
			"   </soapenv:Body>\r\n" + 
			"</soapenv:Envelope>";
	
	/**
	 * 根据唯一节点名字取内容
	 */
	public static String getNodeValByName(String xml,String nodeName) {
		try {
			xml = xml.replace("&lt;", "<").replace("&gt;", ">");
			if(xml.contains("CDATA")) {
				xml = xml.replace("<?xml version=\"1.0\" encoding=\"UTF-8\"?>", "").replace("<?xml version='1.0' encoding='utf-8'?>", "");
			}
			Document doc = DocumentHelper.parseText(xml);
			Element root = doc.getRootElement();
			Node node = root.selectSingleNode("//" + nodeName);
			return node.getText();
		} catch (Exception e) {
			throw new Exception("");
		}
	}
	
	public static void main(String[] args) {
		System.out.println(xml);
	}
	
}
