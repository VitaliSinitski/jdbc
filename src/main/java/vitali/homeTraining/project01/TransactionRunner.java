package vitali.homeTraining.project01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class TransactionRunner {
    public static void main(String[] args) throws SQLException {

        int personId = 9;
        var deletePerson = "DELETE FROM person WHERE id = ?";

        Connection connection = null;
        PreparedStatement deletePersonStatement = null;

        try {
            connection = DriverManager.getConnection(DatabaseProperties.URL,
                    DatabaseProperties.USER, DatabaseProperties.PASS);

            deletePersonStatement = connection.prepareStatement(deletePerson);

            connection.setAutoCommit(false);

            deletePersonStatement.setInt(1, personId);

            deletePersonStatement.executeUpdate();

            connection.commit();
        } catch (Exception e) {
            if (connection != null) {
                connection.rollback();
            }
            throw e;
        } finally {
            if (connection != null) {
                connection.close();
            }
            if (deletePersonStatement != null) {
                deletePersonStatement.close();
            }
        }
    }
}
