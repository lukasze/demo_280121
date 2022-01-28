package com.example.demo.repository;

import com.example.demo.model.Hobbit;
import org.springframework.data.jpa.repository.JpaRepository;



/*
    TODO 4 rozszerzamy Repository<T,ID> - projekt Spring Data zadba o dostarczenie implementacji
     W Spring'u ziarana oznaczamy @Component lub 'dzieciaki" - @Configuration, @Service itd.
     Jeśli klasa implementuje, znany Spring'owi interfejs, nie musimy używać @Component
     Podstawowe warstwy aplikacji:
     @Controller, @Service, @Repository
 */
public interface HobbitRepository extends JpaRepository<Hobbit, Long> {
}
