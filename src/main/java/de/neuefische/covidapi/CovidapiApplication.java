package de.neuefische.covidapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class CovidapiApplication {

    public static void main(String[] args) {
        SpringApplication.run(CovidapiApplication.class, args);
    }

    @Bean
    public RestTemplate restTemplate (){
        return new RestTemplate();
    }

}
