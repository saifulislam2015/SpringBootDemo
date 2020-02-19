package com.example.demoapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;



@SpringBootApplication(scanBasePackages={"com.example"})
@EntityScan(value = {"com.example"})
@EnableJpaRepositories("com.example")
//@EnableMongoRepositories("com.example.Repo")

public class DemoapiApplication extends SpringBootServletInitializer {

    public static void main(String[] args) {
        SpringApplication.run(DemoapiApplication.class, args);
    }

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(DemoapiApplication.class);
    }
}
