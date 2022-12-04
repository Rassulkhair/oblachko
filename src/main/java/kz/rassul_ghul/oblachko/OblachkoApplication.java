package kz.rassul_ghul.oblachko;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = {SecurityAutoConfiguration.class})
public class OblachkoApplication {

    public static void main(String[] args) {
        SpringApplication.run(OblachkoApplication.class, args);
    }

}

