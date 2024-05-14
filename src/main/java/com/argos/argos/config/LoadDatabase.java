package com.argos.argos.config;

import com.argos.argos.model.entities.Administrador;
import com.argos.argos.model.entities.LoginAcesso;
import com.argos.argos.model.repositories.IAdministradorRepository;

import com.argos.argos.model.repositories.ILoginAcessoRepository;
import com.argos.argos.service.ILoginAcessoService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;

@Configuration
public class LoadDatabase {

    Logger log = LogManager.getLogger(LoadDatabase.class);

    @Bean
    CommandLineRunner initDatabase(
            IAdministradorRepository administradorRepository,
            ILoginAcessoRepository loginAcessoRepository
    ) {
        return args -> {

            // Criação e inserção do novo login de acesso
            LoginAcesso loginAcesso1 = new LoginAcesso("admin");
            loginAcessoRepository.save(loginAcesso1);

            // Criação e inserção do novo administrador
            Administrador administrador1 = new Administrador("Administrador", loginAcesso1);
            administradorRepository.save(administrador1);

            log.info(">>>> [LoadDatabase] dados inseridos no Banco de dados");
        };
    }
}