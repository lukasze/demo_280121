package com.example.demo.service;

import com.example.demo.model.Hobbit;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import java.util.List;

/*
    TODO 2 @Profile na klasie / metodzie z adnotajcą @Bean, pozwala na dynamiczną konfigurację kontekstu Spring
        (jakie ziarna się w nim znajdują)

    Uruchomienie aplikacji z profilem:
    - IntelliJ: Active profiles
    - appication.properties: spring.profiles.active
    - uruchomienie z wiersza poleceń: -Dspring.profiles.active
    - zmienna środowiskowa

    @Profile pozwala na konfigurajcę - dla jakiego profilu tworzyć lub nie ziarna np. @Profile("!dont-creste-for-this")
*/
@Component
@Profile("impl2")
public class HobbitServiceImpl2 implements HobbitService {
    @Override
    public List<Hobbit> findAll() {
        return null;
    }
}
