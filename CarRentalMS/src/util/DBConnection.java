package util;



import java.sql.Connection;
import java.sql.DriverManager;
// 获取数据库的连接
public class DBConnection {
	private String dburl = "jdbc:mysql://115.159.5.230:3306/CarRentalMS?useSSL=true&useUnicode=true&characterEncoding=UTF-8";
	private String dbusername = "liuleilei";
	private String dbpassword = "liuleilei1011";
	
	private String dbdriver = "com.mysql.jdbc.Driver";
	
	@SuppressWarnings("finally")
	public Connection LinkDB() {
		Connection conn = null;
		try{
			Class.forName(dbdriver);
			conn = DriverManager.getConnection(dburl, dbusername, dbpassword);
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			return conn;
		}
	}
}