package DAO;

import java.sql.Connection;  
import java.sql.DriverManager;  
import java.sql.SQLException;  

public class ConnectionFactory {
	   public static final int MYSQL = 0;  
	   private static final String MySQLDriver = "com.mysql.jdbc.Driver";  
	  
	   public static Connection conexion(String url, String nom, String password,  
	         int banco) throws ClassNotFoundException, SQLException {  
	      switch (banco) {        
	      case MYSQL:           
	         Class.forName(MySQLDriver);  
	         break;  
	      }  
	      return DriverManager.getConnection(url, nom, password);  
	   }  
	
}
