package resultsetextractor;

import model.User;
import model.UserDetail;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

public class UserResultSetExtractor implements ResultSetExtractor {

    @Override
    public Object extractData(ResultSet resultSet) throws SQLException, DataAccessException {
        User user=null;
        UserDetail userDetail=null;
        if(resultSet.next()){
            int userId=resultSet.getInt("userId");
            int userDetailId=resultSet.getInt("userDetailId");
            String username=resultSet.getString("username");
            String password=resultSet.getString("password");
            Date creationDate=resultSet.getDate("creationDate");
            String name=resultSet.getString("name");
            String surname=resultSet.getString("surname");
            Date birthOfDate=resultSet.getDate("birthOfDate");

            user=new User(userId, username, password, creationDate);
            userDetail=new UserDetail(userDetailId, name,surname,birthOfDate);

            user.setUserDetail(userDetail);
        }
        return user;
    }
}
