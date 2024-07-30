import java.io.IOException;
import java.util.Properties;

public class Config {

    String dbUser;
    String dbPassword;
    String dbPort;
    String browser;

    public Config(String dbUser, String dbPassword, String dbPort, String browser) {
        this.dbUser = dbUser;
        this.dbPassword = dbPassword;
        this.dbPort = dbPort;
        this.browser = browser;
    }

    public String getDbUser() {
        return dbUser;
    }

    public void setDbUser(String dbUser) {
        this.dbUser = dbUser;
    }

    public String getDbPassword() {
        return dbPassword;
    }

    public void setDbPassword(String dbPassword) {
        this.dbPassword = dbPassword;
    }

    public String getDbPort() {
        return dbPort;
    }

    public void setDbPort(String dbPort) {
        this.dbPort = dbPort;
    }

    public String getBrowser() {
        return browser;
    }

    public void setBrowser(String browser) {
        this.browser = browser;
    }

    public static Config initConfig() throws IOException {
        String environment = System.getProperty("environment");
        Properties prop = new Properties();
        prop.load(Thread.currentThread().getContextClassLoader().getResourceAsStream(environment + ".properties"));
        Config config = new Config(prop.getProperty("dbUser"), prop.getProperty("dbPassword"), prop.getProperty("dbPort"),
                prop.getProperty("browser"));
        return config;
    }
}
