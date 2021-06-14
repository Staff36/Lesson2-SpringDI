package ru.tronin;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import java.util.Scanner;

@Configuration
@ComponentScan("ru.tronin")
public class AppConfig {

    @Bean
    public Scanner consoleScanner(){
        return new Scanner(System.in);
    }

}
