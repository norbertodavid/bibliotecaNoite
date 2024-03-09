package com.fuctura.bibliotecaNoite.profiles;

import com.fuctura.bibliotecaNoite.services.DBService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration //Serve para dizer que esta config deve rodar
@Profile("dev") //aqui sinalizamos qual perfil rodar no servidor.
public class DevProfile {

    @Autowired
    private DBService dbservice;

    @Value("${spring.jpa.hibernate.ddl-auto}")
    private String ddl;

    @Bean
    public boolean instaciaDB() {
        if (ddl.equals("create-drop")) {
            this.dbservice.instanciaDB();
        }
        return false;
    }
}
