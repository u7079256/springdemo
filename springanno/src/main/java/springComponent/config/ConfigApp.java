package springComponent.config;

public class ConfigApp {
    public String getUrl() {
        return url;
    }

    public String getDriver() {
        return Driver;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public void setDriver(String driver) {
        Driver = driver;
    }

    String url;
    String Driver;
}
