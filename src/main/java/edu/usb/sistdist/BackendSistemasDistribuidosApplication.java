package edu.usb.sistdist;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@CrossOrigin
@EnableWebMvc
@SpringBootApplication
public class BackendSistemasDistribuidosApplication extends SpringBootServletInitializer {

    public static void main(String[] args) {
        SpringApplication.run(BackendSistemasDistribuidosApplication.class, args);
    }

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(BackendSistemasDistribuidosApplication.class);
    }

}
