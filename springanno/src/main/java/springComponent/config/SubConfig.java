package springComponent.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.PropertySource;

@PropertySource ("classpath:my.properties") // 加载配置文件
public class SubConfig {
    @Value ("${jdbc.driver}")
    String driver;
    @Value("${jdbc.url}")
    String url;
    @Bean ("sampleBean")
    public ConfigApp getConfigApp(){
        ConfigApp app = new ConfigApp();
        app.setDriver(driver);
        app.setUrl(url);
        return app;
    }
}
