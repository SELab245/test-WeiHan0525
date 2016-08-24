package fcu.android.backend.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import fcu.android.backend.data.User;

public class DatabaseManager {

  private static DatabaseManager DB_MANAGER = new DatabaseManager();

  public static DatabaseManager getInstance() {
    return DB_MANAGER;
  }

  private IDatabase database = DatabaseFactory.getDatabase(DatabaseFactory.DatabaseType.MySql);

  private DatabaseManager() {

  }

  public boolean addUser(User user) {
    Connection conn = database.getConnection();
    PreparedStatement preStmt = null;
    Statement stmt = null;
    String sql = "INSERT INTO USER(userName, password, email)  VALUES(?, ? ,?)";
    String query = "SELECT * FROM USER";
    try {
      preStmt = conn.prepareStatement(sql);
      preStmt.setString(1, user.getUserName());
      preStmt.setString(2, user.getPassword());
      preStmt.setString(3, user.getEmail());
      preStmt.executeUpdate();
      preStmt.close();

      stmt = conn.createStatement();
      ResultSet rs = stmt.executeQuery(query);
      System.out.println("List All Users");
      while (rs.next()) {
        System.out.println("User Name: " + rs.getString("userName") + ", Email: " + rs.getString("email"));
      }
      stmt.close();
      conn.commit();
      return true;
    } catch (SQLException e) {
      e.printStackTrace();
    } finally {
      try {
        conn.close();
      } catch (SQLException e) {
        e.printStackTrace();
      }
    }
    return false;
  }

  public boolean validateUser(String email, String password) {
    Connection conn = database.getConnection();
    PreparedStatement stmt = null;
    String query = "SELECT * FROM USER WHERE email = ? and password = ?";
    try {
      stmt = conn.prepareStatement(query);
      stmt.setString(1, email);
      stmt.setString(2, password);
      ResultSet rs = stmt.executeQuery();
      boolean valid = rs.first();
      stmt.close();
      conn.commit();
      return valid;
    } catch (SQLException e) {
      e.printStackTrace();
    } finally {
      try {
        conn.close();
      } catch (SQLException e) {
        e.printStackTrace();
      }
    }
    return false;
  }

  public User getUser(String email) {
    Connection conn = database.getConnection();
    PreparedStatement stmt = null;
    String query = "select * from USER where email = ?";
    try {
      stmt = conn.prepareStatement(query);
      stmt.setString(1, email);
      ResultSet rs = stmt.executeQuery();
      User user = new User();
      if (rs.next()) {
        user.setUserName(rs.getString("userName"));
        user.setPassword(rs.getString("password"));
        user.setEmail(rs.getString("email"));
      }
      stmt.close();
      conn.commit();
      return user;
    } catch (SQLException e) {
      e.printStackTrace();
    } finally {
      try {
        conn.close();
      } catch (SQLException e) {
        e.printStackTrace();
      }
    }
    return new User();
  }

  public List<User> listAllUsers() {
    List<User> lsUsers = new ArrayList<User>();

    Connection conn = database.getConnection();
    String sql = "SELECT * FROM USER";
    Statement stmt = null;

    try {
      stmt = conn.createStatement();
      ResultSet rs = stmt.executeQuery(sql);
      while (rs.next()) {
        String name = rs.getString("userName");
        String password = rs.getString("password");
        String email = rs.getString("email");

        User user = new User();
        user.setUserName(name);
        user.setPassword(password);
        user.setEmail(email);
        lsUsers.add(user);
      }
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return lsUsers;
  }

}
