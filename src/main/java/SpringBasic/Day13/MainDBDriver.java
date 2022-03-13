package SpringBasic.Day13;

public class MainDBDriver {
    public static void main(String[] args) {
        SingletonDatabaseConnection databaseConnection = SingletonDatabaseConnection.getInstance();
        Thread thread = new Thread();

        SingletonDatabaseConnection databaseConnection1 = SingletonDatabaseConnection.getInstance();
        System.out.println("DB1 :"+databaseConnection.hashCode()+" ||  DB2 :"+databaseConnection1.hashCode());
    }
}
