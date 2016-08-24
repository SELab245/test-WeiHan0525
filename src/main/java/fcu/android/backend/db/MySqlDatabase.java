package fcu.android.backend.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class MySqlDatabase implements IDatabase {
  
  private static final String DB_DRIVER = "com.mysql.jdbc.Driver";
  private static final String DB_CONNECTION = "jdbc:mysql://140.134.26.71:53306/mydb?relaxAutoCommit=true&useSSL=false";
  private static final String DB_USER = "root";
  private static final String DB_PASSWORD = "iecsfcu";
  private Connection con = null; 
  
  @Override
  public Connection getConnection() {
  
    try {
        Class.forName(DB_DRIVER);
    } catch (ClassNotFoundException e) {
        System.out.println(e.getMessage());
    }
    try {
        con = DriverManager.getConnection(DB_CONNECTION, DB_USER, DB_PASSWORD);
       
    } catch (SQLException e) {
        System.out.println(e.getMessage());
    }
    return con;
  } 
}
