/**
 * @ClassName： SingleInstance
 * @Author: dhSu
 * @Description: 用枚举实现单例模式
 * @Date:Created in 2018年10月8日
 */

class DBConnection{
	static {
		System.out.println("DBConnection 初始化");
	}
}

enum SingleInstance {
	DATASOURCE;
	private DBConnection connection = null;
	private SingleInstance() {
		connection = new DBConnection();
	}
	
	public DBConnection getConnection() {
		return connection;
	}
}

public class SingleInstanceTest {
	public static void main(String[] args) {
		DBConnection con1 = SingleInstance.DATASOURCE.getConnection();
		DBConnection con2 = SingleInstance.DATASOURCE.getConnection();
		DBConnection con3 = SingleInstance.DATASOURCE.getConnection();
		System.out.println(con1 == con2);
		System.out.println(con2 == con3);
	}
}
