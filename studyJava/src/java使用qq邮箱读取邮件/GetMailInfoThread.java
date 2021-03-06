package java使用qq邮箱读取邮件;

import java.io.File;
import java.io.FileOutputStream;

/**
 * 用于获取多个邮件信息的线程
 * @author SuDenghui
 */
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import com.dhsu.jdbc.Java调用SQL脚本执行的方案.RunSqlScript;

/**
 * 用于获取邮箱中邮件信息的线程
 * 
 * @author lupf
 *
 */
public class GetMailInfoThread extends Thread {
	Message message[] = null;
	MailImfo re = null;

	public GetMailInfoThread(Message message[]) {
		this.message = message;
	}

	@Override
	public void run() {
		super.run();
		if (null != message) {
			int len = message.length;
			for (int i = len; i > 0; i--) {
				try {
					re = new MailImfo((MimeMessage) message[i - 1]);
					//如果邮件主题包含“小书包数据同步”字样，则读取
					if (re.getSubject().contains("小书包数据同步")) {
						//需要的内容，sql
						/*String[] sql = re.getBodyText().split("$$$");
						System.out.println(sql[0]+"***********************");*/
						int end = re.getBodyText().indexOf("<html>");
						String sql = re.getBodyText().substring(0, end);
						//将sql写到文件E://tale.sql
						File f = new File("E://tale.sql");
						if (!f.exists()) {
							f.createNewFile();
						}
						FileOutputStream fout = new FileOutputStream(f);
						fout.write(sql.getBytes());
						fout.close();
						RunSqlScript.runSqlFile("E://tale.sql");
						//执行sql脚本
						break;
					}
				} catch (MessagingException e) {
					e.printStackTrace();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
	}
}
