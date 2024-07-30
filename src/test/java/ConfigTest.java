import org.junit.Test;

import java.io.IOException;
import java.sql.SQLOutput;

public class ConfigTest {

    @Test
    public void testConfig() throws IOException {
        System.out.println(System.getProperty("browser"));
        Config config = Config.initConfig();
        System.out.println(config.browser);
        System.out.println(config.dbUser);
        System.out.println(config.dbPassword);
        System.out.println(config.dbPort);
    }
}
