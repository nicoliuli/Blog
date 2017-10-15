package cn.itcast.ssm.util;

/*
 * db.properties文件在src下
driver=com.mysql.jdbc.Driver
url=jdbc\:mysql\://localhost\:3306/page
username=root
password=mysqladmin
*/
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;
public class JdbcUtils{
	private static Properties config = new Properties();	//单例模式
	static{	//静态代码块，读取资源文件，加载驱动
		try{
			config.load(JdbcUtils.class.getClassLoader().getResourceAsStream("db.properties"));	//静态代码块，读取配置文件
			
			Class.forName(config.getProperty("driver"));	//加载驱动
			
		}catch(Exception e){
			throw new ExceptionInInitializerError(e);
		}
	}
	
	public static Connection getConnection() throws SQLException{	//创建链接
		return DriverManager.getConnection(config.getProperty("url"),config.getProperty("username"),config.getProperty("password"));
	}
	
	public static void release(Connection conn,Statement st,ResultSet rs){	//释放资源
		if(rs != null){
			try{
				rs.close();
			}catch(Exception e){}
		}
		if(st != null){
			try{
				st.close();
			}catch(Exception e){}
		}
		if(conn != null){
			try{
				conn.close();
			}catch(Exception e){}
		}
	}
}
