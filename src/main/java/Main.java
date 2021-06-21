import model.User;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import services.UserService;
import services.userImplementService.UserServiceImplement;

import java.util.Date;

public class Main {
    public static void main(String[] args) {
        ConfigurableApplicationContext applicationContext =new ClassPathXmlApplicationContext("applicationContext.xml");

        UserService userService=applicationContext.getBean("userServiceImplement", UserServiceImplement.class);

        User user=new User(103, "lainnyone","123456", new Date());
        userService.save(user);

        applicationContext.close();
    }
}
