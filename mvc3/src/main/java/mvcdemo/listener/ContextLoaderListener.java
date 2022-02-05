package mvcdemo.listener;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class ContextLoaderListener implements ServletContextListener {
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        ServletContext servletContext = servletContextEvent.getServletContext();
        String contextConfig = servletContext.getInitParameter("contextConfigLocation");
        System.out.println(contextConfig);
        // 读取web.xml 全局参数来进行解耦,这样子我们不需要直接传入配置文件的全名,减少耦合
        //ApplicationContext app = new ClassPathXmlApplicationContext("ApplicationContext.xml");
        ApplicationContext app = new ClassPathXmlApplicationContext(contextConfig);
        // 将app存储到ServletContext域
        //ServletContext servletContext = servletContextEvent.getServletContext();
        servletContext.setAttribute("app",app);
        System.out.println("spring 容器由监听器创建1");
    }

    public void contextDestroyed(ServletContextEvent servletContextEvent) {

    }
}
