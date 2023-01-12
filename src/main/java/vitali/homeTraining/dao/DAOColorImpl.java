package vitali.homeTraining.dao;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.Serializable;
import java.sql.*;
import java.util.Properties;

public class DAOColorImpl implements DAOColor {
    @Override
    public Color save(Color color) throws SQLException {
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

        PreparedStatement preparedStatement = null;
        PreparedStatement preparedStatementSelect = null;

        connection.setAutoCommit(false);

        try {

            String sql = "insert into color (name) " + " value ('?');";

            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.executeUpdate(sql.replace("?", color.getName()),
                    Statement.RETURN_GENERATED_KEYS);

            ResultSet rs = preparedStatement.getGeneratedKeys();
            rs.next();
            color.setId(rs.getInt(1));

//            String sql = "insert into color (name) " + "values (?);";
//            preparedStatement = connection.prepareStatement(sql);
//            preparedStatement.setString(1, color.getName());
//            preparedStatement.executeUpdate();
//
//            String sqlSelect = "select * from color where name = ? " + "order by id desc;";
//            preparedStatementSelect = connection.prepareStatement(sqlSelect);
//            preparedStatementSelect.setString(1, color.getName());
//            ResultSet resultSet = preparedStatementSelect.executeQuery();
//
//            while (resultSet.next()) {
//                color.setId(resultSet.getInt("id"));
//                break;
//            }


            connection.commit();
        } catch (SQLException e) {
            connection.rollback();
            e.printStackTrace();
        } finally {
            try {
                if (preparedStatement != null) {
                    preparedStatement.close();
                }
                if (preparedStatementSelect != null) {
                    preparedStatementSelect.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return color;
    }

    @Override
    public Color get(Serializable id) throws SQLException {
        return null;
    }

    @Override
    public void update(Color color) throws SQLException {

    }

    @Override
    public int delete(Serializable id) throws SQLException {
        return 0;
    }
}
