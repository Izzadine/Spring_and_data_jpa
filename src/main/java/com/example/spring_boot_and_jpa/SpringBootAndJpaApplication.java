package com.example.spring_boot_and_jpa;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SpringBootAndJpaApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootAndJpaApplication.class, args);
    }

    @Bean
    CommandLineRunner commandLineRunner(StudentRepository studentRepository){
        return args ->  {
            // after this line, i remove the id form the table because it automatical generate
            Student maria =new Student(
                    "Fane",
                    "Ahmat",
                    "fane.ahmat@gmail.com",
                    23);
            studentRepository.save(maria);
        };
    }

}
