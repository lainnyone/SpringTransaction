package services.userImplementService;

import model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.UserRepository;
import services.UserService;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImplement implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public void save(User user) {
        userRepository.save(user);
    }

    @Override
    public void update(User user) {
        userRepository.update(user);
    }

    @Override
    public void deleteById(int id) {
        userRepository.deleteById(id);
    }

    @Override
    public User findById(int id) {
        User user=userRepository.findById(id);
        return user;
    }

    @Override
    public User findWithUserDetailById(int id) {
        User user =userRepository.findWithUserDetailById(id);
        return user;
    }

    @Override
    public List<User> findUsers() {
        List<User> userList=userRepository.findUsers();
        return userList;
    }
}
