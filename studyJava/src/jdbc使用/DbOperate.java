package jdbc使用;

import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

/**
 * @ClassName： DbOperate
 * 
 * @Author: dhSu
 * @Description: jdbc操作本地tps数据库
 * @Date:Created in 2018年9月26日
 */

public class DbOperate {
	// JDBC 驱动名及数据库 URL
	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	static final String DB_URL = "jdbc:mysql://localhost:3306/uvn_tps_dev";

	// 数据库的用户名与密码，需要根据自己的设置
	static final String USER = "root";
	static final String PASS = "uvn_tps_dev@1234#";

	public static void main(String[] args) {
		Connection conn = null;
		Statement stmt = null;
		try {
			// 注册 JDBC 驱动
			Class.forName("com.mysql.jdbc.Driver");
			// 打开链接
			System.out.println("连接数据库...");
			conn = DriverManager.getConnection(DB_URL, USER, PASS);
			Connection connection = DriverManager.getConnection(DB_URL, USER, PASS);
			// 执行查询
			System.out.println(" 实例化Statement对象...");
			for (long i = 0; i < 100000000; i++) {
				stmt = conn.createStatement();
				// 获取uuid,用作telnum
				String telnum = UUID.randomUUID().toString();
				long sendTime = System.currentTimeMillis();
				Date date = new Date();
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				String sendTimeStr = sdf.format(date);
				StringBuilder sql = new StringBuilder();
				sql.append("INSERT INTO sms_satisfy_history_ha (`telnum`, `send_time`, `send_time_str`) ");
				sql.append("VALUES ('");
				sql.append(telnum);
				sql.append("','");
				sql.append(sendTime);
				sql.append("','");
				sql.append(sendTimeStr);
				sql.append("')");
				// 影响的行数
				System.out.println("sql:" + sql.toString());
				int lines = stmt.executeUpdate(sql.toString());
				System.out.println("影响了" + lines + "行");
				stmt.close();
			}
			conn.close();
		} catch (SQLException se) {
			// 处理 JDBC 错误
			se.printStackTrace();
		} catch (Exception e) {
			// 处理 Class.forName 错误
			e.printStackTrace();
		} finally {
			// 关闭资源
			try {
				if (stmt != null)
					stmt.close();
			} catch (SQLException se2) {
			} // 什么都不做
			try {
				if (conn != null)
					conn.close();
			} catch (SQLException se) {
				se.printStackTrace();
			}
		}
		System.out.println("Goodbye!");
	}
}
