package SpringBasic.Day13;

public class SingletonDatabaseConnection {
    private static SingletonDatabaseConnection databaseConnection=null;
    private final String URL="https://localhost:3306";
    private final String DATABASE_NAME="SpringDemo";
    private final String DB_USERNAME="root";
    private final String DB_PASSWORD="test123";

    private SingletonDatabaseConnection() {
    }

    public static SingletonDatabaseConnection getInstance(){
        if(databaseConnection == null)
            databaseConnection=new SingletonDatabaseConnection();
        return databaseConnection;
    }
}
