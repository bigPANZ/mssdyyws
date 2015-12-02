package panz.services;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public class Test {

	private static DBConn db = new DBConn();

	public String dbexquery(String sql) {
		ResultSet rs = null;
		JSONArray array = null;
		try {
			System.out.println("------------调用webservice---------");
			System.out.println("sql: "+sql);
			PreparedStatement pState = db.createConnection().prepareStatement(sql);
			rs = pState.executeQuery();
		     array = new JSONArray();  
		     // 获取列数  
		     ResultSetMetaData metaData = rs.getMetaData();  
		     int columnCount = metaData.getColumnCount();  
			while (rs.next()) {
				JSONObject jsonObj = new JSONObject();  
				String value=null;
	          // 遍历每一列  
	          for (int i = 1; i <= columnCount; i++) {  
	              String columnName =metaData.getColumnLabel(i);  
	              if("".equals(rs.getString(columnName)) || rs.getString(columnName)==null){
	            	  value="";
	              }else{
	            	  value = rs.getString(columnName);
	              }  
	              jsonObj.put(columnName, value);  
	          }   
	          array.add(jsonObj);   
			}
		      for(int j=0;j<array.size();j++){
		    	  for(int i=1;i<columnCount;i++){
			    	  String columnName =metaData.getColumnLabel(i);  
			    	  JSONObject resultObj = array.optJSONObject(j);
			    	//获取数据项
			    	  String value = resultObj.getString(columnName);
			    	  if(i==columnCount-1){
			    		  System.out.println(resultObj);
			    	  }
			      }
		      }
			System.out.println("-----------调用webservice结束--------");
			return array.toString();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		db.releaseConnection();
		return null;
	}

	public static void main(String[] args) {
		Test test = new Test();
		test.dbexquery("select * from zl_spzlb where resid in (314979,314981)");
	}
}
