package vitali.homeTraining.jd2.dao;

import java.sql.SQLException;

public class RunDAO {
    public static void main(String[] args) throws SQLException {

        Color color = Color.builder()
                .name("желтый")
                .build();

        DAO<Color> dao = new DAOColorImpl();
        dao.save(color);
        System.out.println(color.getId());
    }
}
