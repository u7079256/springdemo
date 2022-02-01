package springComponent.web;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import springComponent.service.UserService;

public class UserCOController {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext app = new ClassPathXmlApplicationContext("ApplicationContext.xml");
        UserService service = app.getBean(UserService.class);
        service.save();
        app.close();
    }
}
