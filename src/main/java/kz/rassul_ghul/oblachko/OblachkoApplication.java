package kz.rassul_ghul.oblachko;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;


@SpringBootApplication(exclude = {SecurityAutoConfiguration.class})
@EnableJpaAuditing
@OpenAPIDefinition(info = @Info(title = "Oblachko"))
public class OblachkoApplication {

    public static void main(String[] args) {
        SpringApplication.run(OblachkoApplication.class, args);
    }
}

