package bank;

import java.sql.Connection;
import java.sql.DriverManager;

public class DataBaseConnection {
	final static private String myurl = "jdbc:mysql://localhost:3306/"; // path
	final static private String mydriver ="com.mysql.jdbc.Driver"; // driver
	final static private String mydb = "test"; 
	final static private String pass = "root";
	final static private String user = "root";
		
    public static Connection javaConnection() 
    {
    	//System.out.println("connection");
        Connection conn = null;
        try
		{
			Class.forName(mydriver).newInstance();
			conn = (Connection) DriverManager.getConnection(myurl + mydb+"?characterEncoding=UTF-8", user,pass);
		} 
		catch (Exception e)
		{
			e.printStackTrace();
		}
        return conn;
	}
    

	}
