package vitali.homeTraining.jd2;

import java.sql.*;

public class JdbcApplicatin {
    Connection connection  = DriverManager.getConnection(
            "jdbc:mysql://localhost:3306/test",
            "login", "password");

    public JdbcApplicatin() throws SQLException {
    }
}
