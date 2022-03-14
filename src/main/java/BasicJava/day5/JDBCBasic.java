package BasicJava.day5;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCBasic {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.jdbc.Driver");
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root","test123");
        Statement statement = connection.createStatement();
        String str = "insert into student values('1','sandesh')";
        statement.executeUpdate(str);
//        ResultSet resultSet = statement.executeQuery("select * from student");
//        while (resultSet.next()){
//            System.out.println(resultSet.getString(1)+" , "+resultSet.getString(2));
//        }
    }
}
