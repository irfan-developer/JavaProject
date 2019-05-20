package com.sapiens.utils;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBUtils {
	public static final String DRIVER = "oracle.jdbc.driver.OracleDriver";
	public static final String URL ="jdbc:oracle:thin:@localhost:1521:xe" ;
	public static final String USER = "PSUITE";
	public static final String PASSWORD = "XXXXX";
	
	private static Connection connection;
	public static Connection getConnection() throws Exception
	{
		Class.forName(DRIVER);
		connection = DriverManager.getConnection(URL, USER, PASSWORD);
		return connection;
	}
	
	public static void closeConnection() throws Exception
	{
		if(connection != null)
			connection.close();
	}

}
