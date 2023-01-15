package vitali.homeTraining.project01;


import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class JdbcRunner {

    // 02 JDBC Core 02 MetaData
    public static void main(String[] args) throws SQLException {
        checkMetadata();
    }
    public static void checkMetadata() throws SQLException {
        try (Connection connection = DriverManager.getConnection(DatabaseProperties.URL,
                DatabaseProperties.USER, DatabaseProperties.PASS);) {
            var metaData = connection.getMetaData();
            var catalogs = metaData.getCatalogs();
            while (catalogs.next()) {
                var catalog = catalogs.getString(1);

                var schemas = metaData.getSchemas();
                while (schemas.next()) {
                    var schema = schemas.getString(1);

                    var tables = metaData.getTables(catalog, schema, "%", null);
                    while (tables.next()) {
                        System.out.println(tables.getString("table_name"));
                    }
                }
            }
        }
    }


    // 01 JDBC Core 10 PreparedStatement
    // 02 JDBC Advanced 01 FetchSize, QueryTimeout, setMaxRows

//    public static void main(String[] args) throws SQLException {
//
//        var result = getAgeByPersonIdBetween(1, 5);
//        System.out.println(result);
//
////        int personID = 20;
////        var personIdByAge = getPersonIdByAge(personID);
////        System.out.println(personIdByAge);
//    }
//
//    private static List<Integer> getAgeByPersonIdBetween(int start, int end) throws SQLException {
//        String sql = """
//                SELECT age FROM person
//                WHERE id BETWEEN ? AND ?;
//                """;
//        List<Integer> result = new ArrayList<>();
//
//        try (Connection connection = DriverManager.getConnection(DatabaseProperties.URL,
//                DatabaseProperties.USER, DatabaseProperties.PASS);
//             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
//
//            preparedStatement.setFetchSize(50); // Желательно установить FetchSize. обычно = 50-100 rows
//
//            preparedStatement.setQueryTimeout(10); // как долго я могу ждать выполения запроса.
//                                                // потому что, если выборка большая, я могу ждать очень долго
//            preparedStatement.setMaxRows(100);  // если вдруг запрос будет слишком велик,
//                                                // java приложение может упасть
//            System.out.println(preparedStatement);
//            preparedStatement.setInt(1, start);
//            System.out.println(preparedStatement);
//            preparedStatement.setInt(2, end);
//            System.out.println(preparedStatement);
//            ResultSet resultSet = preparedStatement.executeQuery();
//            System.out.println(preparedStatement);
//
//            while (resultSet.next()) {
//                result.add(resultSet.getObject(1, Integer.class));
//            }
//        }
//
//        return result;
//    }
//
//    private static List<Integer> getPersonIdByAge(int personId) throws SQLException {
//        String sql = """
//                SELECT id FROM person
//                WHERE age = ?
//                """;
//        List<Integer> result = new ArrayList<>();
//        try (Connection connection = DriverManager.getConnection(DatabaseProperties.URL,
//                DatabaseProperties.USER, DatabaseProperties.PASS);
//             var preparedStatement = connection.prepareStatement(sql)) {
//
//            System.out.println(preparedStatement);
//
//            preparedStatement.setInt(1, personId);
//            System.out.println(preparedStatement);
//
//            ResultSet resultSet = preparedStatement.executeQuery();
//            System.out.println(preparedStatement);
//            while (resultSet.next()) {
////                result.add(resultSet.getInt("id"));
//                result.add(resultSet.getObject("id", Integer.class)); // Null safe
//            }
//        }
//        return result;
//    }


// Видео 9 (Есть ошибки в типах. Правильно сделал с типами в задаче с видео 10)

//    public static void main(String[] args) throws SQLException {
//        String personID = "2 or '' = ''";
//        var addressByPersonId = getAddressByPersonId(personID);
//        System.out.println(addressByPersonId);
//    }
//
//    private static List<Integer> getAddressByPersonId (String personId) throws SQLException {
//        String sql = """
//                select id FROM person
//                WHERE address = %s
//                """.formatted(personId);
//        List<Integer> result = new ArrayList<>();
//        try (Connection connection = DriverManager.getConnection(DatabaseProperties.URL,
//                DatabaseProperties.USER, DatabaseProperties.PASS);
//             Statement statement = connection.createStatement()) {
//            ResultSet resultSet = statement.executeQuery(sql);
//            while (resultSet.next()) {
////                result.add(resultSet.getInt("id"));
//                result.add(resultSet.getObject("id", Integer.class)); // Null safe
//            }
//        }
//        return result;
//    }


// Видео 7-8

//    public static void main(String[] args) throws SQLException {
//
//        String sql = """
//                INSERT INTO info (data)
//                VALUES
//                ('autogenerated');
//                """;
//        try (Connection connection = DriverManager.getConnection(DatabaseProperties.URL,
//                DatabaseProperties.USER, DatabaseProperties.PASS);
//             Statement statement = connection.createStatement()) {
//
////            DatabaseMetaData databaseMetaData = connection.getMetaData();
//
////            connection.setTransactionIsolation(Connection.TRANSACTION_READ_COMMITTED);
//
////            connection.setTransactionIsolation(TRANSACTION_READ_COMMITTED);
//
//            System.out.println("TransactionIsolation: " + connection.getTransactionIsolation());
//            System.out.println("AutoCommit: " + connection.getAutoCommit());
//
//            var executeResult = statement.executeUpdate(sql, Statement.RETURN_GENERATED_KEYS);
//
//            var generatedKeys = statement.getGeneratedKeys();
//            if (generatedKeys.next()) {
//                int generatedKeysInt = generatedKeys.getInt(1);
//                System.out.println(generatedKeysInt);
//            }
//
//        }
//    }


}
