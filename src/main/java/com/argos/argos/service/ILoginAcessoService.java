package com.argos.argos.service;

import com.argos.argos.model.entities.LoginAcesso;

import java.util.Optional;

public interface ILoginAcessoService {
    public boolean login(String acessoId, String senha);

    public Optional<LoginAcesso> insert(LoginAcesso obj);

    public Optional<LoginAcesso> update(LoginAcesso obj);

    // todo - depois ver como fazer o esquema do login

}
