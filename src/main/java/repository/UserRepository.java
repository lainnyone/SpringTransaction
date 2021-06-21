package repository;

import model.User;

import java.util.List;

public interface UserRepository {
    void save(User user);
    void update(User user);
    void deleteById(int id);
    User findById(int id);
    User findWithUserDetailById(int id);
    List<User> findUsers();

}
