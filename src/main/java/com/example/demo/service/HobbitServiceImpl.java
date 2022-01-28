package com.example.demo.service;

import com.example.demo.model.Hobbit;
import com.example.demo.repository.HobbitRepository;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
/*
    TODO 2 @Primary, na klasie lub metodzie z adnotacją @Bean,
     najczęściej stosowane na metodach.
 */
@Primary
public class HobbitServiceImpl implements HobbitService {

    private HobbitRepository hobbitRepository;

    public HobbitServiceImpl(HobbitRepository hobbitRepository) {
        this.hobbitRepository = hobbitRepository;
    }

    @Override
    public List<Hobbit> findAll() {
        return hobbitRepository.findAll();
    }
}