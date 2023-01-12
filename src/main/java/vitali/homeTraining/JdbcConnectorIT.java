package vitali.homeTraining;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;

public class JdbcConnectorIT {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Properties properties = new Properties();
        try (FileInputStream fileInputStream = new FileInputStream("src/main/resources/database.properties")) {
            properties.load(fileInputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }

        String url = properties.getProperty("url");
        String username = properties.getProperty("user");
        String password = properties.getProperty("pass");

        Connection connection = DriverManager.getConnection(url, username, password);

        Statement statement;
        ResultSet resultSet;

        connection.setAutoCommit(false);

        try {
            statement = connection.createStatement();
//            resultSet = statement.executeQuery();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
}
