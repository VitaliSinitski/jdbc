package vitali.homeTraining.jdbcDMdev.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public final class ConnectionManager {
    public static final String URL_KEY = "db.url";
    public static final String USER_KEY = "db.username";
    public static final String PASS_KEY = "db.password";

//    static {
//        loadDriver();
//    }

    private ConnectionManager() {
    }

//    private static void loadDriver() {
//        try {
//            Class.forName("com.mysql.jdbc.Driver");
//        } catch (ClassNotFoundException e) {
//            throw new RuntimeException(e);
//        }
//    }

    public static Connection open() {
        try {
            return DriverManager.getConnection(
                    PropertiesUtil.get(URL_KEY),
                    PropertiesUtil.get(USER_KEY),
                    PropertiesUtil.get(PASS_KEY));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
