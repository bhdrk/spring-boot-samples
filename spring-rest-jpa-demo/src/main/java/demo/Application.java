package demo;

import demo.config.MyApplicationProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.data.domain.PageRequest;

@SpringBootApplication
@EnableConfigurationProperties(MyApplicationProperties.class)
public class Application {

    public static void main(String[] args) {


        SpringApplication.run(Application.class, args);
    }
}
