package vitali.homeWork.lesson05.dao;

import java.io.Serializable;
import java.sql.SQLException;

public interface Dao<T> {
    T select (int id) throws SQLException;
    void update(T t) throws SQLException;
    boolean delete(int id) throws SQLException;
    T insert (T t) throws SQLException;




}
