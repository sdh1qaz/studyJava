package com.dhsu.jdbc.Java调用SQL脚本执行的方案;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.apache.ibatis.jdbc.ScriptRunner;
import org.junit.Test;

/**
 * 运行Sql脚本 sql脚本放在resources下的sql文件夹下
 */
public final class RunSqlScript {
	
	// JDBC 驱动名及数据库 URL
	static final String DB_URL = "jdbc:mysql://localhost:3306/tale?characterEncoding=UTF-8";
	// 数据库的用户名与密码，需要根据自己的设置
	static final String USER = "root";
	static final String PASS = "admin";

	/**
	 * 运行指定的sql脚本
	 * @param sqlFileName 如"E://tale.sql"
	 */
	public static void runSqlFile(String sqlFileName) {
		try {
			/*
			 * // 获取数据库相关配置信息 Properties props =
			 * Resources.getResourceAsProperties("db.properties"); // jdbc 连接信息: 注:
			 * 现在版本的JDBC不需要配置driver，因为不需要Class.forName手动加载驱动 String url =
			 * props.getProperty("jdbc.url"); String username =
			 * props.getProperty("jdbc.username"); String password =
			 * props.getProperty("jdbc.password");
			 */

			// 建立连接
			Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);

			// 创建ScriptRunner，用于执行SQL脚本
			ScriptRunner runner = new ScriptRunner(conn);
			runner.setErrorLogWriter(null);
			runner.setLogWriter(null);
			// 执行SQL脚本
			runner.runScript(new InputStreamReader(new FileInputStream(sqlFileName), "utf-8"));
			// 关闭连接
			conn.close();
			// 若成功，打印提示信息
			System.out.println("====== 数据库同步完成 ======");
		} catch (IOException | SQLException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void testrunSqlFile() {
		runSqlFile("E://tale.sql");
	}
}