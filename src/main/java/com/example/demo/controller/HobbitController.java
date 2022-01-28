package com.example.demo.controller;

import com.example.demo.model.Hobbit;
import com.example.demo.service.HobbitService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/*
    TODO 5 Spring ma wiele adnotacji, często adnotacja 'opakowuje' kilka innych
     @RestController = @Controller + @ResponseBody
     Najczęściej adnotacja na poziomie klasy:
     - zmienia klasę w kandydata na ziarno Spring'a (@RestController -> @Controller -> @Component)
     - często aktywuje dodatkowe supermoce', w naszym wypadku @Controller aktywuje biblioteki Spring MVC
 */
@RestController
public class HobbitController {

    private final HobbitService hobbitService;

    public HobbitController(HobbitService hobbitService) {
        this.hobbitService = hobbitService;
    }

    @GetMapping("/hobbits")
    List<Hobbit> findAll() {
        return hobbitService.findAll();
    }
}
