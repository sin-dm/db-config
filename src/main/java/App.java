import org.w3c.dom.ls.LSOutput;

import java.io.IOException;
import java.util.List;

public class App {

    public static void main(String[] args) throws IOException {
        Config config = Config.initConfig();
        System.out.println(config.browser);
        System.out.println(config.dbUser);
        System.out.println(config.dbPassword);
        System.out.println(config.dbPort);
//        JdbcTemplateUserRepo userRepo = new JdbcTemplateUserRepo();
//        User user =userRepo.getUserById(1995L);
//        System.out.println(user);
//        System.out.println(userRepo.createUser(new User("TEST", "YANDEX", "JAVA")));
    }
}
