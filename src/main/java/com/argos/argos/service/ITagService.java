package com.argos.argos.service;

import com.argos.argos.model.entities.Tag;

import java.util.List;
import java.util.Optional;

public interface ITagService {
    public List<Tag> find();

    public Optional<Tag> findById(Long id);

    public List<Tag> findByIdResponsavel(Long idResponsavel);

    public List<Tag> findByIdDendente(Long idDependente);

    public Optional<Tag> insert(Tag obj, Long idResponsavel);

    public Optional<Tag> update(Tag obj);

    public Optional<Tag> updateTagByDependente(Tag obj, Long idDependente);

    public void delete(Long id);
}
