package com.argos.argos.service.impl;

import com.argos.argos.model.entities.LoginAcesso;
import com.argos.argos.model.repositories.ILoginAcessoRepository;
import com.argos.argos.service.ILoginAcessoService;
import com.argos.argos.service.exception.ResourceNotFoundException;
import jakarta.persistence.EntityNotFoundException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LoginAcessoService implements ILoginAcessoService {

    private Logger log = LogManager.getLogger(LoginAcessoService.class);
    private final ILoginAcessoRepository loginAcessoRepository;

    public LoginAcessoService(ILoginAcessoRepository loginAcessoRepository) {
        this.loginAcessoRepository = loginAcessoRepository;
    }

    @Override
    public boolean login(String acessoId, String senha) {
        log.info(">>>> [LoginAcessoService] findById(" + acessoId +") iniciado");

//        Optional<LoginAcesso> loginAcesso = loginAcessoRepository.findById(id);
//
//        return Optional.ofNullable(loginAcesso.orElseThrow(() -> new ResourceNotFoundException(id)));
        return false;
    }

    @Override
    public Optional<LoginAcesso> insert(LoginAcesso obj) {
        log.info(">>>> [LoginAcessoService] insert iniciado");

        return Optional.of(loginAcessoRepository.save(obj));
    }

    @Override
    public Optional<LoginAcesso> update(LoginAcesso obj) {
        log.info(">>>> [LoginAcessoService update iniciado]");
        try{
            LoginAcesso entidade = loginAcessoRepository.getReferenceById(obj.getId());
            updateData(entidade, obj);
            return Optional.of(loginAcessoRepository.save(entidade));
        } catch (EntityNotFoundException e){
            throw new ResourceNotFoundException(obj.getId());
        }
    }

    private void updateData(LoginAcesso entidade, LoginAcesso obj){
        entidade.setSenhaAcesso(obj.getSenhaAcesso());
    }

}