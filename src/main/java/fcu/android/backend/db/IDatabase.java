package fcu.android.backend.db;

import java.sql.Connection;

public interface IDatabase {
  
  Connection getConnection();

}
