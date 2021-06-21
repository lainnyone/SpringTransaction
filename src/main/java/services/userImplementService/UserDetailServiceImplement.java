package services.userImplementService;

import model.UserDetail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.UserDetailRepository;
import services.UserDetailService;

import java.util.List;

@Service
public class UserDetailServiceImplement implements UserDetailService {

    @Autowired
    UserDetailRepository userDetailRepository;

    @Override
    public void save(int userId, UserDetail userDetail) {
        userDetailRepository.save(userId, userDetail);
    }

    @Override
    public void update(UserDetail userDetail) {
        userDetailRepository.update(userDetail);
    }

    @Override
    public UserDetail findById(int id) {
        UserDetail userDetail=userDetailRepository.findById(id);
        return userDetail;
    }

    @Override
    public List<UserDetail> findUserDetails() {
        List<UserDetail> userDetailList=userDetailRepository.findUserDetails();
        return userDetailList;
    }
}
