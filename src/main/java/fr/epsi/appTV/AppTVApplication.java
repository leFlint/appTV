package fr.epsi.appTV;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;


@SpringBootApplication
public class AppTVApplication {

    public static void main(String[] args) throws JsonParseException, JsonMappingException, IOException {
        SpringApplication.run(AppTVApplication.class, args);
    }
}

