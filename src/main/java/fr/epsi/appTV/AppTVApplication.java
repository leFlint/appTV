package fr.epsi.appTV;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import java.io.IOException;


@SpringBootApplication
@EnableWebMvc
public class AppTVApplication {

    public static void main(String[] args) throws JsonParseException, JsonMappingException, IOException {
        SpringApplication.run(AppTVApplication.class, args);
    }
}

