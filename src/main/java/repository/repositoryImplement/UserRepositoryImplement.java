package repository.repositoryImplement;

import model.User;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcDaoSupport;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;
import repository.UserRepository;
import resultsetextractor.UserResultSetExtractor;
import rowmapper.UserRowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class UserRepositoryImplement extends NamedParameterJdbcDaoSupport implements UserRepository {

    //Query for SQL commands
    String query;

    //SQL parameter
    SqlParameterSource source;

    @Override
    public void save(User user) {

        // Save function SQL command
        query="INSERT INTO user(userId, username, password, creationDate) VALUES(:userId, :username, :password, :creationDate) ";

        try{
            source= new MapSqlParameterSource("userId", user.getUserId())
                    .addValue("username",user.getUsername())
                    .addValue("password", user.getPassword())
                    .addValue("creationDate", user.getCreationDate());
            // write to database
            getNamedParameterJdbcTemplate().update(query,source);
        }catch (RuntimeException exception){
            System.out.println("Error: "+ exception);
        }
    }

    @Override
    public void update(User user) {

        //Update function SQL command
        query="UPDATE user SET username= :username, password= :password WHERE userId= :userId";

        try {
            source=new MapSqlParameterSource("username", user.getUsername())
            .addValue("password ", user.getPassword())
            .addValue("userId", user.getUserId());

            getNamedParameterJdbcTemplate().update(query, source);
        }catch (RuntimeException exception){
            System.out.println("Error: "+ exception);
        }


    }

    @Override
    public void deleteById(int id) {
        String queryFindUser="SELECT userDetailId FROM user WHERE userId= :userId";
        String queryDeleteUser="DELETE FROM user WHERE userId= :userId";
        String queryDeleteUserDetail="DELETE FROM userdetail WHERE userDetailId= :userDetailId";

        try {
            SqlParameterSource source=new MapSqlParameterSource("userId", id);

            Integer userDetailId= getNamedParameterJdbcTemplate().query(queryFindUser, new ResultSetExtractor<Integer>() {
                @Override
                public Integer extractData(ResultSet resultSet) throws SQLException, DataAccessException {
                    Integer userDetailId=resultSet.getInt("userDetailId");
                    return userDetailId;
                }
            });

             source=new MapSqlParameterSource("userId",id);
            getNamedParameterJdbcTemplate().update(queryDeleteUser,source);
            source = new MapSqlParameterSource("userDetailId", userDetailId);
            getNamedParameterJdbcTemplate().update(queryDeleteUserDetail, source);

        }catch (RuntimeException exception){
            System.out.println("Error: "+exception);
        }
    }

    @Override
    public User findById(int id) {
        query = "SELECT * FROM user WHERE userId = :userId";
        User user=null;
        try {
            source = new MapSqlParameterSource("userId", id);

            user= (User) getNamedParameterJdbcTemplate().queryForObject(query, source, new UserRowMapper());

        }catch (RuntimeException exception){
            System.out.println("Error: "+ exception);
        }

        return user;
    }

    @Override
    public User findWithUserDetailById(int id) {

        query="SELECT * FROM user u LEFT JOIN userdetail ud ON(u.userDetailId=ud.userDetailId) WHERE userId= :userId";

        try{
            source =new MapSqlParameterSource("userId", id);

            this.getNamedParameterJdbcTemplate().query(query, source, new UserResultSetExtractor());
        }catch (RuntimeException exception){
            System.out.println("Error: "+exception);
        }
        return null;
    }

    @Override
    public List<User> findUsers() {

        query = "SELECT * FROM user";
        List<User> users=null;

        try{
            users=getNamedParameterJdbcTemplate().query(query, new UserRowMapper());
        }catch (RuntimeException exception){
            System.out.println("Error: "+exception);
        }
        return users;
    }
}
