package panz.services;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

@javax.jws.WebService(targetNamespace = "http://services.panz/", serviceName = "TestService", portName = "TestPort", wsdlLocation = "WEB-INF/wsdl/TestService.wsdl")
public class TestDelegate {

	panz.services.Test test = new panz.services.Test();

	public String dbexquery(String sql) {
		return test.dbexquery(sql);
	}

	public void main(String[] args) {
		test.main(args);
	}

}