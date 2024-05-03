package com.argos.argos.controller;

import com.argos.argos.controller.response.HttpResponse;
import com.argos.argos.model.entities.LoginAcesso;
import com.argos.argos.service.impl.LoginAcessoService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.transaction.Transactional;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping(value = "api/v1/auth")
public class LoginAcessoAPIController {

    private final LoginAcessoService loginAcessoService;
    private final Logger log = LogManager.getLogger(LoginAcessoAPIController.class);

    public LoginAcessoAPIController(LoginAcessoService loginAcessoService) {
        this.loginAcessoService = loginAcessoService;
    }

    @CrossOrigin
    @PostMapping
    @Transactional
    public ResponseEntity<Object> inserirLoginAcesso(@RequestBody LoginAcesso loginAcesso){
        log.info(">>>> [Controller] inserirLoginAcesso iniciado");

        return ResponseEntity.ok().body(loginAcessoService.insert(loginAcesso));
    }

    @CrossOrigin
    @PatchMapping
    @Transactional
    public ResponseEntity<Object> updateLoginAcesso(@RequestBody LoginAcesso loginAcesso){
        log.info(">>>> [Controller] updateLoginAcesso iniciado");

        return ResponseEntity.ok().body(loginAcessoService.update(loginAcesso));
    }
}