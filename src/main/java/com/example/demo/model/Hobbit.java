package com.example.demo.model;

import lombok.Data;

import javax.persistence.*;

/*
    TODO 3 encja - klasa mapowana do tabeli w relacyjnej bazie danych,
      zwróć uwagęna jej użycie w HobbitRepository<TypEncji, TypKluczaWencji>
 */
@Data
@Entity
@Table(name = "hobbits")
public class Hobbit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String lastName;
}
