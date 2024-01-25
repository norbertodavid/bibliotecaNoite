package com.fuctura.bibliotecaNoite.profiles;

import com.fuctura.bibliotecaNoite.services.DBService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration //Para sinalizar ao projeto que esta é um perfil de teste do código.
@Profile("test") //aqui sinalizamos qual perfil rodar no servidor.
public class TestProfile {

    @Autowired
    private DBService dbService;  //Instaciamos o DB Service aqui.

    @Bean  //Mapeamos o código abaixo e deixamos ele executável.
    public void instanciaDB() {
        this.dbService.instanciaDB();
    }

}
