package mvcdemo.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import mvcdemo.controller.sampleObj.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

// @RequestMapping(value = "" method = 枚举类型(GET/Post...) params = {"",..}字符串数组)
//@RequestMapping("/xxx") //在类标记RequestMapping 此时 访问路径为 ..../xxx/quick 而不是 .../xxx ,对外访问路径是拼接在一起的
// 可以用类上的注解来区分大的模块 比如 /user
@Controller
public class UserController {
    @RequestMapping(value = "/quick",method = RequestMethod.GET,params = {"username=terry"}) //当访问quick时执行对应逻辑,跳转到对应视图
    // 加入 params -> http://localhost:8080/mvc3_war/quick?username=terry
    public String save(){
        System.out.println("controller save running");
        //现在success.jsp 在 webapp/jsp下,我们可以在spring-mvc.xml 配置内部资源视图解析器,来提取共有的 前缀和后缀
        return "success";    // 在使用类上@requestMapping 时, 返回的资源地址需要加 '/'
    }
    @RequestMapping("/quick2")
    public ModelAndView save2(){
        System.out.println("controller2 is running....");
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("success");
        modelAndView.addObject("user","terryYiran");
        return modelAndView;
    }
    @RequestMapping("/quick3")
    // 解析方法时 参数modelandview 会自动进行注入
    public ModelAndView save3(ModelAndView modelAndView){
        System.out.println("controller3 is running....");
        modelAndView.setViewName("success");
        modelAndView.addObject("user","Kalao");
        return modelAndView;
    }
    @RequestMapping("/quick4")
    // 解析方法时 参数modelandview 会自动进行注入
    public String save4(Model model){
        //modelAndView  = String + Model
        model.addAttribute("user","=====");
        return "success";
    }
    @RequestMapping("/quick5")
    // 解析方法时 参数modelandview 会自动进行注入
    public String save5(HttpServletRequest servletRequest){
        //modelAndView  = String + Model
        servletRequest.setAttribute("user","=====");
        return "success";
    }
    @RequestMapping("/quick6")
    // 回写数据而不进行跳转
    public void save6(HttpServletResponse servletResponse) throws IOException {
        //modelAndView  = String + Model
        servletResponse.getWriter().print("=====");
    }
    @RequestMapping("/quick7")
    @ResponseBody  // 此注解代表了 方法是直接返回字符串得而不进行 页面跳转,与save() 不同
    // 回写数据而不进行跳转
    public String save7() throws IOException {
        //modelAndView  = String + Model
        return "565656";
    }


    @RequestMapping("/quick8")
    @ResponseBody
    // 回写数据而不进行跳转
    public String save8() throws IOException {
        //modelAndView  = String + Model
        User user = new User();
        user.setAge(11);
        user.setName("pppp");
        ObjectMapper objectMapper = new ObjectMapper();
        String json = objectMapper.writeValueAsString(user);
        return json;
    }
    //在spring-mvc.xml中配置RequestMappingHandlerAdapter
    //其中覆写Adapter 为 json to http
    //这样项目中可以通过直接返回对象来让spring 自动把 对象转换为json文件进行输出
    @RequestMapping("/quick9")
    @ResponseBody
    // 回写数据而不进行跳转
    public User save9() throws IOException {
        //modelAndView  = String + Model
        User user = new User();
        user.setAge(11);
        user.setName("ppppqqqq");
        // 希望 springMVC 自动将对象转换为json 格式
        return user;
    }
}
