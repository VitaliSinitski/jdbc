package vitali.homeTraining.jdbcDMdev;

import vitali.homeTraining.jdbcDMdev.util.ConnectionManager;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.SQLException;
import java.sql.Statement;

public class JdbcRunner {

    public static void main(String[] args) throws SQLException {

//        String sql = """
//                CREATE DATABASE game;
//                 """;

        try (Connection connection = ConnectionManager.open();
             Statement statement = connection.createStatement()) {

            DatabaseMetaData databaseMetaData = connection.getMetaData();



//            connection.setTransactionIsolation(TRANSACTION_READ_COMMITTED);

            System.out.println(connection.getTransactionIsolation());

//            boolean executeResult = statement.execute(sql);
//            System.out.println(executeResult);
        }
    }


}
