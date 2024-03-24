package vn.edu.iuh.fit;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import vn.edu.iuh.fit.services.TestMessageSender;

@SpringBootApplication
public class LayerDemoApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(LayerDemoApplication.class, args);
        TestMessageSender testMessageSender = context.getBean(TestMessageSender.class);
        testMessageSender.sendTestMessage();
    }

}
