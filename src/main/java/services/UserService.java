package services;

import model.User;

import java.util.List;

public interface UserService {
    void save(User user);
    void update(User user);
    void deleteById(int id);
    User findById(int id);
    User findWithUserDetailById(int id);
    List<User> findUsers();
}
