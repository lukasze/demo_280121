package com.example.demo.service;

import com.example.demo.model.Hobbit;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import java.util.List;


@Component
public class HobbitServiceImpl2 implements HobbitService {
    @Override
    public List<Hobbit> findAll() {
        return null;
    }
}
