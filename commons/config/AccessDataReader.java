package config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import java.util.HashMap;

import org.hsqldb.DatabaseManager;


public class AccessDataReader {
	
	public HashMap<String,HashMap<String,String>> readExcelFile()
	{
		HashMap<String,HashMap<String,String>> master = new HashMap<>();
		
		try{
			Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
			Connection conn = DriverManager.getConnection("jdbc:ucanaccess://.//reasource//DataBase.accdb" , "", "" );
			Statement pstmt = conn.createStatement();
			ResultSet resultSet = pstmt.executeQuery("Select * from LogInDetails");
			while(resultSet.next())
			{
				ResultSetMetaData temp = resultSet.getMetaData();
				int columnCount = temp.getColumnCount();
				for (int i = 1; i <= columnCount; i++ ) 
				{
					  String name = temp.getColumnName(i);
					  String value = resultSet.getString(i);
					  System.out.println(name + "------" + value);
				}
			}
		}catch(Exception ex)
		{
			
		}
		return master;
	}

}
