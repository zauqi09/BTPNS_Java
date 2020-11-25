package org.example;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//Scan all packages on org.example
@SpringBootApplication(scanBasePackages={"org.example"})
public class TugasDay12 {
    public static void main(String[] args) {
        SpringApplication.run(TugasDay12.class, args);
    }
}
