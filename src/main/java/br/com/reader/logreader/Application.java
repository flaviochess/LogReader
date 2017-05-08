package br.com.reader.logreader;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 *
 * @author Flavio Andrade
 */
@SpringBootApplication
@EntityScan(basePackages = {"br.com.reader.logreader"})
@ComponentScan(basePackages = {"br.com.reader.logreader"})
@EnableJpaRepositories(basePackages = {"br.com.reader.logreader"})
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

}
