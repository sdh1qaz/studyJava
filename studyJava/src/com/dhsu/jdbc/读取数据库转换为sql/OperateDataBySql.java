package com.dhsu.jdbc.读取数据库转换为sql;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import org.junit.Test;

public class OperateDataBySql {
	
	/**
	 * 实现数据库的导出（方法1）
	 */
	public static void function1() {
		Runtime runtime = Runtime.getRuntime();
		String command = getExportCommand();
		// 这里其实是在命令窗口中执行的 command 命令行
		try {
			Process exec = runtime.exec(command);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * 得到导出数据的命令行语句
	 */
	private static String getExportCommand() {
		StringBuffer command = new StringBuffer();
		String username = "root";// 用户名
		String password = "root";// 密码
		String host = "localhost";// 导入的目标数据库所在的主机
		String port = "3306";// 使用的端口号
		String exportDatabaseName = "dataBaseName";// 导入的目标数据库的名称
		String exportPath = "C:/mytable.sql";// 导入的目标文件所在的位置
		String MysqlPath = "E:/mysql/bin/"; // 路径是mysql中
		// 注意哪些地方要空格，哪些不要空格
		command.append(MysqlPath).append("mysqldump -u").append(username).append(" -p").append(password)// 密码是用的小p，而端口是用的大P。
				.append(" -h").append(host).append(" -P").append(port).append(" ").append(exportDatabaseName)
				.append(" -r ").append(exportPath);
		return command.toString();
	}

	
	
	/**
	 * 实现数据库的导出（方法2）
	 */
	public static String  exportDataSql() {
		String outStr;
		try {
			Runtime rt = Runtime.getRuntime();
			// 调用 调用mysql的安装目录的命令
			Process child = rt.exec("E:\\mysql-5.6.24-win32\\bin\\mysqldump "
					+ "-uroot -padmin tale");
			// 设置导出编码为utf-8。这里必须是utf-8
			// 把进程执行中的控制台输出信息写入.sql文件，即生成了备份文件。注：如果不对控制台信息进行读出，则会导致进程堵塞无法运行
			InputStream in = child.getInputStream();// 控制台的输出信息作为输入流
			InputStreamReader xx = new InputStreamReader(in, "utf-8");
			// 设置输出流编码为utf-8。这里必须是utf-8，否则从流中读入的是乱码
			String inStr;
			StringBuffer sb = new StringBuffer("");
			// 组合控制台输出信息字符串
			BufferedReader br = new BufferedReader(xx);
			while ((inStr = br.readLine()) != null) {
				sb.append(inStr + "\r\n");
			}
			outStr = sb.toString();
			in.close();
			xx.close();
			br.close();
			return outStr;
		} catch (Exception e) {
			e.printStackTrace();
			outStr = "发生了异常";
		}
		return outStr;
	}
	
	public static void exportDataSqlFile() {
		try {
			Runtime rt = Runtime.getRuntime();
			// 调用 调用mysql的安装目录的命令
			rt.exec("E:\\mysql-5.6.24-win32\\bin\\mysqldump "
					+ "-uroot -padmin tale >E:\\tale.sql");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void testexportDataSql() {
		System.out.println(exportDataSql());
	}
	
	@Test
	public void testExportDataSqlFile() {
		exportDataSqlFile();
	}
}
