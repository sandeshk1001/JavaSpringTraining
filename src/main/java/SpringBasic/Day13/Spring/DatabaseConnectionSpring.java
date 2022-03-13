package SpringBasic.Day13.Spring;

import SpringBasic.Day13.SingletonDatabaseConnection;

public class DatabaseConnectionSpring {
        private static SingletonDatabaseConnection databaseConnection=null;
        private final String URL="https://localhost:3306";
        private final String DATABASE_NAME="SpringDemo";
        private final String DB_USERNAME="root";
        private final String DB_PASSWORD="test123";

        DatabaseConnectionSpring() {
        }

//        public static Day13.SingletonDatabaseConnection getInstance(){
//            if(databaseConnection == null)
//                databaseConnection=new Day13.SingletonDatabaseConnection();
//            return databaseConnection;
//        }

}
