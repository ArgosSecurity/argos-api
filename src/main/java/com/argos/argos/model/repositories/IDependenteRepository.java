package com.argos.argos.model.repositories;

import com.argos.argos.model.entities.Dependente;
import com.argos.argos.model.entities.Responsavel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IDependenteRepository extends JpaRepository<Dependente, Long> {
    public void deleteAllByResponsavel(Responsavel responsavel);
    public List<Dependente> findAllByResponsavel(Responsavel responsavel);
}
