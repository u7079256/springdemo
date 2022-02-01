import com.heima.dao.UserDao;
import com.heima.dao.UserDaoProto;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SPringTestForSingleton {
    @Test
    public void test1(){
        // 无参构造 -> 初始化方法 -> 运行方法 -> 销毁方法
        // 单例容器在类初始化的时候就已经新建了, prototype 是随着 getbean或者其他调用容器的操作实例化的

        ApplicationContext app = new ClassPathXmlApplicationContext("applicationCOntext.xml");
        UserDao userDao1 = (UserDao) app.getBean("userDao");
        UserDao userDao2 = (UserDao) app.getBean("userDao");
        assert userDao1 == userDao2;
        System.out.println(userDao1);
        System.out.println(userDao2);
    }
    @Test
    public void test2(){
        ApplicationContext app = new ClassPathXmlApplicationContext("applicationCOntext.xml");
        UserDaoProto userDao1 = (UserDaoProto) app.getBean("UserDaoProto");
        UserDaoProto userDao2 = (UserDaoProto) app.getBean("UserDaoProto");
        assert userDao1 != userDao2;
        System.out.println(userDao1);
        System.out.println(userDao2);
    }
    @Test
    public void test3(){
        ApplicationContext app = new ClassPathXmlApplicationContext("applicationCOntext.xml");
        UserDao userDao1 = (UserDao) app.getBean("UserDaoFactory");
        UserDao userDao2 = (UserDao) app.getBean("UserDaoFactory");
        //assert userDao1 == userDao2;
        System.out.println(userDao1);
        System.out.println(userDao2);
    }
    @Test
    public void test4(){
        ApplicationContext app = new ClassPathXmlApplicationContext("applicationCOntext.xml");
        UserDao userDao1 = (UserDao) app.getBean("dynamicUserDaoFactory");
        UserDao userDao2 = (UserDao) app.getBean("UserDaoFactory");
        //assert userDao1 == userDao2;
        System.out.println(userDao1);
        System.out.println(userDao2);
    }
}
