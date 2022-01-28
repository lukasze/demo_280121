package com.example.demo.controller;

import com.example.demo.model.Hobbit;
import com.example.demo.service.HobbitService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class HobbitController {

    /*
        TODO 1 'programowanie do interfejsów' jest bardzo naturalne, gdy używamy Spring'a
          HobbitService to typ bazowy. Spring, żeby wstrzyknąć (dostraczyć implementację), potrzebuje
          wiedzieć, którą dokładnie implementację użyć (jeśli jest więcej niż jedna).

     */

    private final HobbitService hobbitService;

    public HobbitController(HobbitService hobbitService) {
        this.hobbitService = hobbitService;
    }

    @GetMapping("/hobbits")
    List<Hobbit> findAll() {
        return hobbitService.findAll();
    }
}
