package com.argos.argos.model.repositories;

import com.argos.argos.model.entities.HistoricoTag;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IHistoricoTagRepository extends JpaRepository<HistoricoTag, Long> {
    public List<HistoricoTag> findByTagID(Long tagID);
}
