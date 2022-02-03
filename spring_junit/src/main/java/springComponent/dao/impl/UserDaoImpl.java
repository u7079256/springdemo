package springComponent.dao.impl;

import springComponent.dao.UserDao;
import org.springframework.stereotype.Component;

//<bean id="userDao" class="dao.impl.UserDaoImpl"/> 等价于 =>
@Component("userDao")
public class UserDaoImpl implements UserDao {


    public void save() {
        System.out.println("save is running");
    }
}
