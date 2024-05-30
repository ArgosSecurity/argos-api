package com.argos.argos.config;

import com.argos.argos.model.entities.*;
import com.argos.argos.model.repositories.*;

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
            ILoginAcessoRepository loginAcessoRepository,
            IResponsavelRepository responsavelRepository,
            ITagRepository tagRepository,
            IHistoricoTagRepository historicoTagRepository
    ) {
        return args -> {
            // Criação e inserção do novo login de acesso
            LoginAcesso loginAcesso1 = new LoginAcesso("admin", "admin");
            loginAcessoRepository.save(loginAcesso1);

            LoginAcesso loginAcesso2 = new LoginAcesso("1234", "user123");
            loginAcessoRepository.saveAll(Arrays.asList(loginAcesso1, loginAcesso2));

            // Criação e inserção do novo administrador
            Administrador administrador1 = new Administrador("Administrador", loginAcesso1);
            administradorRepository.save(administrador1);

            Responsavel responsavel1 = new Responsavel(
                    "Fulano de Tal",
                    "123456789",
                    "101",
                    loginAcesso2
                    );

            responsavelRepository.save(responsavel1);

            Tag tag1 = new Tag(
                    false,
                    null,
                    null,
                    "AB2 A2C D4F 123",
                    responsavel1,
                    null
            );

            tagRepository.save(tag1);

            HistoricoTag historico = new HistoricoTag(tag1);
            historicoTagRepository.save(historico);

            log.info(">>>> [LoadDatabase] dados inseridos no Banco de dados");
        };
    }
}