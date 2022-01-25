package org.luis.kafkaelastic;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.env.Environment;

@SpringBootApplication
public class ApplicationInit {


    static Logger log = LoggerFactory.getLogger(ApplicationInit.class);

    public static void main(String[] args) {
        ConfigurableApplicationContext app = SpringApplication.run(ApplicationInit.class, args);
        Environment env = app.getEnvironment();
        log.info("Start app: {}", env.getProperty("spring.name"));


    }

}
