package springComponent.service.impl;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import springComponent.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import springComponent.service.UserService;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Component("userService") // repository , service 和 component 作用一样, 只不过拥有特定的语义含义: 表示 注册的 服务层/Dao 层的beans
@Scope("singleton") // @scope 可以代替xml文件中对于 单例 和 多例 的 声明
public class UserServiceImpl implements UserService {
    @Value("${jdbc.driver}") // 注入一般变量, 可以通过 el 表达式读取注入properties
    private String Driver;
    //<property name="userDao" ref="userDao"/>
    @Autowired // 从容器中找到一个符合所需类型的 bean @Qualifier 可以省略
    @Qualifier("userDao") // 按照id 从容器中找bean
    private UserDao userDao;
    // 注解方式不需要 set方法

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }


    public void save() {
        System.out.println("service layer is running "+ " ");
        System.out.println(Driver);
        userDao.save();
    }
    @PostConstruct  // init method 注解
    public void init(){
        System.out.println("初始化....");
    }
    @PreDestroy  // destroy method 注解
    public void destroy(){
        System.out.println("正在销毁....");
    }
}
