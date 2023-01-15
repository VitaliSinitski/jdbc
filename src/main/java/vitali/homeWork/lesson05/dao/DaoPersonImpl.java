package vitali.homeWork.lesson05.dao;

import vitali.homeTraining.DatabaseProperties;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DaoPersonImpl implements DaoPerson {


    private Connection getConnection() {
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(DatabaseProperties.URL,
                    DatabaseProperties.USER, DatabaseProperties.PASS);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return conn;
    }

    private void close(AutoCloseable auto){
        if (auto != null) {
            try {
                auto.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public Person select(int id) throws SQLException {
        return null;
    }

    @Override
    public void update(Person person) throws SQLException {

    }

    @Override
    public boolean delete(int id) throws SQLException {
        return false;
    }

    @Override
    public Person insert(Person person) throws SQLException {
        return null;
    }
}
