package boot;

import boot.publisher.DemoPublisher;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class BootDemoApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(BootDemoApplication.class, args);
        DemoPublisher demoPublisher = context.getBean("demoPublisher", DemoPublisher.class);
        demoPublisher.publish("1,2,3,4,5,6").forEach(System.out::println);
    }

}
