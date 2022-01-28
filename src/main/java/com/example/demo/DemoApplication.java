package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;
/*
    TODO 2 Klasa główna - adnotacje dodają supermoce, poniższa adnotacja oznacza:
    - klasę konfiguracyjną Spring'a (także ziarno Springa)
    - aktywuje autokonfiguratory Spring Boot
    - włącza domyślne skanowanie pakietów, w poszukiwaniu ziaren Springa (bieżący pakiet i podpakiety)

 */
@SpringBootApplication
public class DemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

}
