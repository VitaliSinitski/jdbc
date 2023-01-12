package vitali.homeTraining;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;

public class JdbcConnector {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Properties properties = new Properties();
        try (FileInputStream fileInputStream = new FileInputStream("src/main/resources/database.properties")) {
            properties.load(fileInputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
//        String driver = properties.getProperty("driver");
//        if (driver != null) {
//            Class.forName(driver) ;
//        }

        String url = properties.getProperty("url");
        String username = properties.getProperty("user");
        String password = properties.getProperty("pass");

        Connection connection = DriverManager.getConnection(url, username, password);

        Statement statement = connection.createStatement();

        ResultSet results = statement.executeQuery("select * from actor");

//        while (results.next()) {
//            int id = results.getInt(1);
//            String name = results.getString(2);
//            System.out.println(results.getRow() + ". " + id + "\t" + name);
//        }

        System.out.println(results.getRow());           // 0
        System.out.println(results.isBeforeFirst());    // true
        System.out.println(results.isFirst());          // false

        results.next();

        System.out.println(results.getRow());           // 1
        System.out.println(results.isBeforeFirst());    // false
        System.out.println(results.isFirst());          // true

        results.next();

        System.out.println(results.getRow());           // 2
        System.out.println(results.isBeforeFirst());    // false
        System.out.println(results.isFirst());          // false

        connection.close();
    }
}
