package vitali.homeTraining.jd2;

import java.sql.*;
import java.util.Properties;

public class JdbcConnector {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Properties properties = new Properties();

        Connection connection = DriverManager.getConnection(DatabaseProperties.URL, DatabaseProperties.USER, DatabaseProperties.PASS);

        Statement statement = connection.createStatement();

        ResultSet results = statement.executeQuery("select * from actor");

        DatabaseMetaData metadata = connection.getMetaData();



//        while (results.next()) {
//            int id = results.getInt(1);
//            String name = results.getString(2);
//            System.out.println(results.getRow() + ". " + id + "\t" + name);
//        }

//        System.out.println(results.getRow());           // 0
//        System.out.println(results.isBeforeFirst());    // true
//        System.out.println(results.isFirst());          // false
//
//        results.next();
//
//        System.out.println(results.getRow());           // 1
//        System.out.println(results.isBeforeFirst());    // false
//        System.out.println(results.isFirst());          // true
//
//        results.next();
//
//        System.out.println(results.getRow());           // 2
//        System.out.println(results.isBeforeFirst());    // false
//        System.out.println(results.isFirst());          // false

        connection.close();
    }
}
