package com.github.vmazheru.springboottest;

import java.lang.reflect.Field;

import static cl.core.decorator.exception.ExceptionDecorators.uncheck;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.fasterxml.jackson.databind.ObjectMapper;

import cl.json.JsonMapper;

@SpringBootApplication
//@ComponentScan(basePackages = {"com.github.cmazheru.springboottest"})
public class Application {

    public static void main(String[] args) {
        try {
            SpringApplication.run(Application.class, args);
        } catch (Exception e) {
            System.out.println(e.getClass().getName());
            if (e.getClass().getName().contains("SilentExitException")) {
                // ignore this private exception from Spring Boot Devops package.
                // this is how they exit the main thread in Eclipse, so that hot swap is enabled
            } else throw new RuntimeException(e);
        }
    }

    @Bean
    public ObjectMapper objectMapper() {
         return uncheck(() -> {
             JsonMapper jsonMapper = JsonMapper.getJsonMapper();
             Field f = jsonMapper.getClass().getDeclaredField("objectMapper");
             f.setAccessible(true);
             ObjectMapper objectMapper = (ObjectMapper)f.get(jsonMapper);
             return objectMapper; 
         });
    }
}
