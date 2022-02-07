package mvcdemo.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import mvcdemo.controller.sampleObj.User;
import mvcdemo.controller.sampleObj.VO;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

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

    @RequestMapping ("/quick10")
    @ResponseBody
    // 回写数据而不进行跳转
    public User save10(String user, int age) throws IOException{
        System.out.println(user);
        System.out.println(age);
        User userr = new User();
        userr.setName(user);
        userr.setAge(age);
        return userr;
    }
    @RequestMapping ("/quick11")
    @ResponseBody
    // 当参数的属性名与请求参数的名字一样时,spring可以进行自动封装
    //xxxxx/name=...&age=... => http://localhost:8080/mvc3_war/quick11?name=terry&age=21
    public User save11(User user) throws IOException{
        System.out.println(user);
        return user;
    }

    @RequestMapping ("/quick12")
    @ResponseBody
    // 当参数的属性名与请求参数的名字一样时,spring可以进行自动封装
    // 返回数组数据  http://localhost:8080/mvc3_war/quick12?users=terry&users=yiran&user=pp
    // 注意看最后一个 为user 而不是users  [terry, yiran]返回值是不含有的
    public void save12(String[] users) throws IOException{
        System.out.println(Arrays.asList(users));
    }

    @RequestMapping ("/quick13")
    @ResponseBody
    // 当参数的属性名与请求参数的名字一样时,spring可以进行自动封装
    // 返回数组数据  http://localhost:8080/mvc3_war/quick12?users=terry&users=yiran&user=pp
    // 注意看最后一个 为user 而不是users  [terry, yiran]返回值是不含有的
    public void save13(/*List<User> userList*/ VO vo) throws IOException{
       // 将list包装进VO对象
        System.out.println("ppppp");
        System.out.println(vo);
    }


    @RequestMapping ("/quick14")
    @ResponseBody

    public void save14(@RequestParam(value="username",required = false,defaultValue = "terry") String user) throws IOException{
        // value 强调了输入参数的名字
        // required = false 可以让无参数输入时 不为bad request 400
        // default 是默认值
        System.out.println(user);

    }


    @RequestMapping ("/quick15/{username}")
    @ResponseBody
    //http://localhost:8080/mvc3_war/quick15/terry -> 输出terry
    public void save15(@PathVariable(value = "username")String username) throws IOException{

        System.out.println(username);
        System.out.println("++++++++++++");
    }
    @RequestMapping ("/quick16")
    @ResponseBody
    public void save16(Date date) throws IOException{
        System.out.println(date);
    }

    // tomcat 生成了 request response 和 session 传给 spring 之后 spring 自动将获取到的信息通过参数传递给方法
    @RequestMapping ("/quick17")
    @ResponseBody
    public void save17(HttpServletRequest request, HttpServletResponse response, HttpSession session) throws IOException{
        System.out.println(request);
        System.out.println(session);
        System.out.println(response);
    }
    @RequestMapping ("/quick18")
    @ResponseBody
    public void save18(@RequestHeader(value = "User-Agent",required = false) String user_agent
                        ,@CookieValue(value = "JSESSIONID") String sessionId,
                       @RequestHeader(value = "Cookie",required = false) String cookie) throws IOException{
        System.out.println(user_agent); //Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/98.0.4758.80 Safari/537.36 Edg/98.0.1108.43
        System.out.println(sessionId); // 2051C6FA59457BA9927A228379B3F9D1
        System.out.println(cookie); //JSESSIONID=2051C6FA59457BA9927A228379B3F9D1
    }
    @RequestMapping ("/quick19")
    @ResponseBody
    public void save19(@RequestHeader(value = "User-Agent",required = false) String user_agent
            ,@CookieValue(value = "JSESSIONID") String sessionId,
                       @RequestHeader(value = "Cookie",required = false) String cookie) throws IOException{
        System.out.println(user_agent); //Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/98.0.4758.80 Safari/537.36 Edg/98.0.1108.43
        System.out.println(sessionId); // 2051C6FA59457BA9927A228379B3F9D1
        System.out.println(cookie); //JSESSIONID=2051C6FA59457BA9927A228379B3F9D1
    }
    @RequestMapping ("/quick20")
    @ResponseBody
    public void save20(String username, MultipartFile upload) throws IOException {
        System.out.println(username);
        System.out.println(upload);
        String originName = upload.getOriginalFilename();
        upload.transferTo(new File("D:\\springgit\\springdemo\\mvc3\\src\\main\\java\\mvcdemo"+originName));
    }
}
