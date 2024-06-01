package com.argos.argos.model.repositories;

import com.argos.argos.model.entities.Dependente;
import com.argos.argos.model.entities.Responsavel;
import com.argos.argos.model.entities.Tag;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ITagRepository extends JpaRepository<Tag, Long> {
    public List<Tag> findAllByResponsavel(Responsavel responsavel);
    public void deleteAllByResponsavel(Responsavel responsavel);
    public void deleteAllByDependente(Dependente dependente);
}
