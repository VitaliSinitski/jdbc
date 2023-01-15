package vitali.homeTraining.project01;

import java.sql.*;


import java.sql.Statement;

public class JdbcConnector {
    public static void main(String[] args) throws SQLException {

        String sql = """
                INSERT INTO info 
                 """;

//        String sql = """
//                    use game;
//                     """;

        Connection connection = DriverManager.getConnection(DatabaseProperties.URL,
                DatabaseProperties.USER, DatabaseProperties.PASS);

        Statement statement = null;
        ResultSet resultSet = null;
        PreparedStatement preparedStatement = null;

        connection.setAutoCommit(false);

        connection.setTransactionIsolation(Connection.TRANSACTION_READ_COMMITTED);


        try {
//            connection = DriverManager.getConnection(DatabaseProperties.URL,
//                    DatabaseProperties.USER, DatabaseProperties.PASS);

            DatabaseMetaData databaseMetaData = connection.getMetaData();

            statement = connection.createStatement();


//            String sql = """
//                    use game;
//                     """;


            System.out.println("TransactionIsolation" + connection.getTransactionIsolation());
            System.out.println("AutoCommit" + connection.getAutoCommit());

            boolean executeResult = statement.execute(sql);

            System.out.println(executeResult);


            connection.commit();
        } catch (SQLException e) {
            System.out.println("catch SQLException connection.rollback()");
            connection.rollback();
            e.printStackTrace();

        } finally {
//            if (resultSet != null) {
//                resultSet.close();
//            }
            if (statement != null) {
                System.out.println("statement.close()");
                statement.close();
            }
            if (connection != null) {
                System.out.println("connection.close()");
                connection.close();
            }
        }


    }


}
