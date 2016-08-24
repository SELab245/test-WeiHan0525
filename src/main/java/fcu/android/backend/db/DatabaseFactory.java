package fcu.android.backend.db;

public class DatabaseFactory {
  
  enum DatabaseType {
    H2,MySql;
  }
  
  private static IDatabase DATABASE = null;
  
  public static IDatabase getDatabase(DatabaseType databaseType) {
    if(DATABASE == null) {
      if(databaseType == DatabaseType.H2) {
        DATABASE = new H2Database();
      } else if(databaseType == DatabaseType.MySql) {
        DATABASE = new MySqlDatabase();
      }
    }
    return DATABASE;
  }

}
