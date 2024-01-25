package com.fuctura.bibliotecaNoite.profiles;

import com.fuctura.bibliotecaNoite.services.DBService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration //Serve para dizer que esta config deve rodar
@Profile("test") //aqui sinalizamos qual perfil rodar no servidor.
public class TestProfile {

    @Autowired
    private DBService dbService;  //Instaciamos o DB Service aqui.

    @Bean  //Executa o @Configuration e o DBService que estiver ativo no properties
    public void instanciaDB() {
        this.dbService.instanciaDB();
    }

}
