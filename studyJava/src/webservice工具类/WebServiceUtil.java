/*import org.apache.axis.AxisFault;
import org.apache.axis.Message;
import org.apache.axis.message.SOAPEnvelope;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


import javax.xml.namespace.QName;

import org.apache.axis.client.Call;
import org.apache.axis.client.Service;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.ConnectException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Map;

public class WebServiceUtil {

    protected static Logger logger = LoggerFactory.getLogger(WebServiceUtil.class);

    public String getWebService_Exchange(String url,String xmlParam,String qName)throws Exception{
        String result = "";
        Map<String, Object> retMap = null;
        //实例化接口服务对象
        Service service = new Service();
        try
        {
            //获取call
            Call call = (Call) service.createCall();

            //设置调用超时时长
            call.setTimeout(60000);

            //设置调用对象
            call.setOperationName(new QName(qName, "exchange"));

            //设置调用URL
            call.setTargetEndpointAddress(new java.net.URL(url));
            result = (String) call.invoke(new Object[] {xmlParam });

            logger.debug("响应报文：" + result);

//            retMap =  MapUtil.xmlToMap(result);

        } catch (Exception e) {
            logger.error(e.toString());
            return null;
//            throw new Exception("调用异常");
        }
//        return retMap;
        return result;
    }


    public String getWebService_http(String url,String xmlParam)throws Exception{
        String result = "";
        Map<String, Object> retMap = null;
        String contentType = "text/xml; charset=utf-8";

        String urlString = url;
        HttpURLConnection httpConn = null;
        OutputStream out = null;
        try
        {
            URL u = new URL(url);
            HttpURLConnection conn = (HttpURLConnection) u.openConnection();
            conn.setDoInput(true);
            httpConn = (HttpURLConnection) new URL(urlString).openConnection();
            httpConn.setRequestProperty("Content-Type", contentType);

            httpConn.setRequestMethod("POST");
            httpConn.setDoOutput(true);
            httpConn.setDoInput(true);
            httpConn.connect();
            out = httpConn.getOutputStream(); // 获取输出流对象
            httpConn.getOutputStream().write(xmlParam.getBytes("UTF-8")); // 将要提交服务器的SOAP请求字符流写入输出流
            out.flush();
            out.close();
            int code = httpConn.getResponseCode(); // 用来获取服务器响应状态
            String tempString = null;
            StringBuffer sb1 = new StringBuffer();
            if (code == HttpURLConnection.HTTP_OK) {
                BufferedReader reader = new BufferedReader(
                        new InputStreamReader(httpConn.getInputStream(),"UTF-8"));
                while ((tempString = reader.readLine()) != null) {
                    sb1.append(tempString);
                }
                if (null != reader) {
                    reader.close();
                }
            } else {
                BufferedReader reader = new BufferedReader(
                        new InputStreamReader(httpConn.getErrorStream(),"UTF-8"));
                // 一次读入一行，直到读入null为文件结束
                while ((tempString = reader.readLine()) != null) {
                    sb1.append(tempString);
                }
                if (null != reader) {
                    reader.close();
                }
            }
            // 响应报文
            result = sb1.toString();

            logger.debug("响应报文：" + result);

            //处理接口中含有<![CDATA[  ]]报文问题，目前挂失解挂接口出现
            if (result.contains("<![CDATA[") && result.contains("<Root>")){
                int s =result.indexOf("<Root>");
                int e =result.indexOf("</Root>")+7;
                result = result.substring(s,e);
            }

        } catch (Exception e) {
            logger.error(e.toString());
       //     throw new Exception("调用异常");
        return  null;
        }

//        retMap =  MapUtil.xmlToMap(result);
//        return retMap;
        return result;
    }



    public String getWebService_SOAPEnvelope(String url,String xmlParam) throws Exception{
        Map<String, Object> retMap = null;
        String result = "";

        System.out.println("请求报文为："+ xmlParam);
        Service service = new Service();
        ByteArrayInputStream stream=new ByteArrayInputStream(xmlParam.trim().getBytes("UTF-8"));

        SOAPEnvelope req = new SOAPEnvelope(stream);

//        String url ="http://134.224.120.59:6000/UAWeb/services/ods.jx.ct10000.com?wsdl";
        Integer timeout = 60;  //超时时间
        SOAPEnvelope rsp;
        Call call = new Call(service);
        call.setTargetEndpointAddress(url);

        if (timeout != null)
            call.setTimeout(timeout * 1000);
        try {
            rsp = call.invoke(req);
            result = rsp.getAsString();
            logger.debug("响应报文：" + result);
        } catch (AxisFault fault) {
            if (fault.detail instanceof ConnectException) {
                logger.error("无法连接到操作所请求的服务地址");
        		throw new Exception("8001,无法连接到操作所请求的服务地址ַ");
            }
            if (fault.detail == null) {
                logger.error("WebService调用异常");
        		throw new Exception("8999,WebService调用异常," + fault.getFaultString());
            }

            Message msg = call.getResponseMessage();
            if (msg != null && msg.getSOAPEnvelope() != null) {
                rsp = msg.getSOAPEnvelope();
                result = rsp.getAsString();
                logger.debug("响应报文：" + result);
            } else {
        		throw new Exception("8002,"+fault.getFaultString());
            }
        } finally {
            try {
                stream.close();
            } catch (Exception e) {
                logger.error("流关闭异常");
                throw new Exception("流关闭异常");
            }
        }
//        retMap =  MapUtil.xmlToMap(result);
//        return retMap;
        return result;
    }

}
*/