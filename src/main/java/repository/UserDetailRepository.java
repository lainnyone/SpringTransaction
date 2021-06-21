package repository;

import model.UserDetail;

import java.util.List;

public interface UserDetailRepository {
    void save(int userId, UserDetail userDetail);
    void update(UserDetail userDetail);
    UserDetail findById(int id);
    List<UserDetail> findUserDetails();
}
