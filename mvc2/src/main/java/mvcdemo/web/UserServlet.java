package mvcdemo.web;

import mvcdemo.service.service;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class UserServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //ApplicationContext app = new ClassPathXmlApplicationContext("ApplicationContext.xml");
        ServletContext servletContext = this.getServletContext();  //this.getServletContext()
        // 使用工具类提取对应 容器
        //ApplicationContext app = WebApplicationContextUtils.getWebApplicationContext(servletContext);
        //ApplicationContext app = (ApplicationContext) servletContext.getAttribute("app");
        WebApplicationContext app = WebApplicationContextUtils.getWebApplicationContext(servletContext);
        //ApplicationContext app = WebApplicationContextUtils.getWebApplicationContext(servletContext);
        service userService = app.getBean(service.class);
        userService.save();
        System.out.println("=====================!");
    }
}
