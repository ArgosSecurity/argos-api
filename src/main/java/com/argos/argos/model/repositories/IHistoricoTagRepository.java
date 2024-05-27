package com.argos.argos.model.repositories;

import com.argos.argos.model.entities.HistoricoTag;
import com.argos.argos.model.entities.Tag;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IHistoricoTagRepository extends JpaRepository<HistoricoTag, Long> {
    public List<HistoricoTag> findByTag(Tag tag);
}
