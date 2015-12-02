package panz.services;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConn {
	private Connection connection = null;
	private String url = "jdbc:oracle:thin:@192.168.0.104:1521:orcl";
	//��������	
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
	//�ر�����
	public void releaseConnection(){  
		  if (connection!=null)
		   try {
		    connection.close();
		   } catch (SQLException e) {
			   e.printStackTrace();
		   }
		 }

}
