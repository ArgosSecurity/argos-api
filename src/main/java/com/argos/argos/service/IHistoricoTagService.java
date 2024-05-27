package com.argos.argos.service;

import com.argos.argos.model.entities.HistoricoTag;
import com.argos.argos.model.entities.Tag;

import java.util.List;
import java.util.Optional;


public interface IHistoricoTagService {
    public List<HistoricoTag> find();

    public Optional<HistoricoTag> findById(Long id);

    public List<HistoricoTag> findByIdTag(Long idTag);

    public Optional<HistoricoTag> insert(Tag tag);

    public Optional<HistoricoTag> update(HistoricoTag obj);

    public void delete(Long id);
}
