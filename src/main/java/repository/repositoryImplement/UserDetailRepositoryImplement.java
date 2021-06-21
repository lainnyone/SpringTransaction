package repository.repositoryImplement;

import model.UserDetail;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcDaoSupport;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;
import repository.UserDetailRepository;

import java.util.List;

@Repository
public class UserDetailRepositoryImplement extends NamedParameterJdbcDaoSupport implements UserDetailRepository {

    //Query for SQL commands
    String query;

    @Override
    public void save(int userId, UserDetail userDetail) {
        String queryUserDetail="INSERT INTO userdetail(userDetailId, name, surname, birthOfDate) VALUES(:userDetailId, :name, :surname, :birthOfDate)";
        String queryUpdateUser="UPDATE user SET userDetailId= :userDetailId WHERE userId= :userId";

        try {
            SqlParameterSource source=new MapSqlParameterSource("userDetailId", userDetail.getUserDetailId())
                    .addValue("name", userDetail.getName())
                    .addValue("surname", userDetail.getSurname())
                    .addValue("birthOfDate", userDetail.getBirthOfDate());

            getNamedParameterJdbcTemplate().update(queryUserDetail, source);

            SqlParameterSource sourceUpdateUser=new MapSqlParameterSource("userId", userId);
            getNamedParameterJdbcTemplate().update(queryUpdateUser, sourceUpdateUser);

        }catch (RuntimeException exception){
            System.out.println("Error: "+exception);
        }
    }

    @Override
    public void update(UserDetail userDetail) {
        query="UPDATE userdetail SET name= :name, surname= :surname, birthOfDate= :birthOfDate WHERE userDetailId= :userDetailId";

        try {

            SqlParameterSource source=new MapSqlParameterSource("name", userDetail.getName())
                    .addValue("surname", userDetail.getSurname())
                    .addValue("birthOfDate", userDetail.getBirthOfDate())
                    .addValue("userDetailId", userDetail.getBirthOfDate());

            getNamedParameterJdbcTemplate().update(query, source);
        }catch (RuntimeException exception){
            System.out.println("Error: "+exception);
        }
    }

    @Override
    public UserDetail findById(int id) {
        query="SELECT * FROM userdetail WHERE userId= :userId";

        UserDetail userDetail=null;

        try{
            userDetail=getNamedParameterJdbcTemplate().queryForObject(query, new MapSqlParameterSource("userDetailId", id), new BeanPropertyRowMapper<>(UserDetail.class));
        }catch (RuntimeException exception){
            System.out.println("Error: "+exception);

        }
        return userDetail;
    }

    @Override
    public List<UserDetail> findUserDetails() {
        query ="SELECT * FROM userdetail";

        List<UserDetail> userDetailList=null;

        try{
            userDetailList= getNamedParameterJdbcTemplate().query(query, new BeanPropertyRowMapper<>(UserDetail.class));
        }catch (RuntimeException exception){
            System.out.println("Error: "+exception);
        }
        return userDetailList;
    }
}
