package rowmapper;

import model.User;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

public class UserRowMapper implements RowMapper {
    @Override
    public Object mapRow(ResultSet resultSet, int i) throws SQLException {

        int userId =resultSet.getInt("userId");
        String username=resultSet.getString("username");
        String password=resultSet.getString("password");
        Date creationDate=resultSet.getDate("creationDate");

        User user = new User(userId, username, password, creationDate);

        return user;
    }
}
