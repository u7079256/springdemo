package springComponent.config;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.*;
// 导入分支配置文件,参数为数组

@Configuration
@ComponentScan("springComponent")  // 组件扫描
@Import({SubConfig.class})
public class SpringConfiguration {

}
