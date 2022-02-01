package springComponent.web;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import springComponent.config.SpringConfiguration;
import springComponent.service.UserService;

public class UserController {
    public static void main(String[] args) {
        ApplicationContext app = new AnnotationConfigApplicationContext(SpringConfiguration.class);
        UserService service = app.getBean(UserService.class);
        service.save();
    }
}
