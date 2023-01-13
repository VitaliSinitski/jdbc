package vitali.homeTraining.jdbcDMdev;

import vitali.homeTraining.jdbcDMdev.util.ConnectionManager;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class JdbcRunner {

    public static void main(String[] args) throws SQLException {
        String sql = """
                 create table if not exists info (
                 id int primary key,
                 data text not null );
                 """;
        try (Connection connection = ConnectionManager.open();
             Statement statement = connection.createStatement()) {
            System.out.println(connection.getTransactionIsolation());
            boolean executeResult = statement.execute(sql);
            System.out.println(executeResult);
        }
    }


}
