package panz.services;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConn {
	private Connection connection = null;
	private String url = "jdbc:oracle:thin:@192.168.0.104:1521:orcl";
	//创建连接	
	public Connection createConnection(){  
		  try {
		   Class.forName("oracle.jdbc.driver.OracleDriver");
		   connection = DriverManager.getConnection(url, "mssdyy", "mssdyy");
		   return connection;   
		  } catch (ClassNotFoundException e) {
			  e.printStackTrace();
		   return null;
		  } catch (SQLException e) {
			  e.printStackTrace();
			  return null;
		  }
		 } 
	//关闭连接
	public void releaseConnection(){  
		  if (connection!=null)
		   try {
		    connection.close();
		   } catch (SQLException e) {
			   e.printStackTrace();
		   }
		 }

}
