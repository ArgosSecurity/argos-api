package com.argos.argos.service.impl;

import com.argos.argos.model.entities.HistoricoTag;
import com.argos.argos.model.entities.Tag;
import com.argos.argos.model.repositories.IHistoricoTagRepository;
import com.argos.argos.model.repositories.ITagRepository;
import com.argos.argos.service.IHistoricoTagService;
import com.argos.argos.service.exception.DatabaseException;
import com.argos.argos.service.exception.ResourceNotFoundException;
import jakarta.persistence.EntityNotFoundException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class HistoricoTagService implements IHistoricoTagService {

    private Logger log = LogManager.getLogger(HistoricoTagService.class);
    private final IHistoricoTagRepository historicoTagRepository;
    private final ITagRepository tagRepository;

    public HistoricoTagService(IHistoricoTagRepository historicoTagRepository, ITagRepository tagRepository) {
        this.historicoTagRepository = historicoTagRepository;
        this.tagRepository = tagRepository;
    }

    @Override
    public List<HistoricoTag> find() {
        log.info(">>>> [HistoricoTagService] find iniciado");

        return historicoTagRepository.findAll();
    }

    @Override
    public Optional<HistoricoTag> findById(Long id) {
        log.info(">>>> [HistoricoTagService] findById(" + id +") iniciado");

        Optional<HistoricoTag> historicoTag = historicoTagRepository.findById(id);

        return Optional.ofNullable(historicoTag.orElseThrow(() -> new ResourceNotFoundException(id)));
    }

    @Override
    public List<HistoricoTag> findByIdTag(Long idTag) {
        Optional<Tag> tag = tagRepository.findById(idTag);

        return historicoTagRepository.findByTag(tag.get());
    }

    @Override
    public Optional<HistoricoTag> insert(Tag tag) {
        log.info(">>>> [HistoricoTagService] insert iniciado");

        tagRepository.findById(tag.getId());

        HistoricoTag historicoTag = new HistoricoTag(tag);

        return Optional.of(historicoTagRepository.save(historicoTag));
    }

    @Override
    public Optional<HistoricoTag> update(HistoricoTag obj) {
        log.info(">>>> [HistoricoTagService update iniciado]");
        try{
            HistoricoTag entidade = historicoTagRepository.getReferenceById(obj.getId());
            return Optional.of(historicoTagRepository.save(entidade));
        } catch (EntityNotFoundException e){
            throw new ResourceNotFoundException(obj.getId());
        }
    }


    @Override
    public void delete(Long id) {
        log.info(">>>> [delete iniciado]");
        try{
            deleteData(id);
        } catch (EmptyResultDataAccessException e) {
            throw new DatabaseException(e.getMessage());
        }
    }

    private void deleteData(Long id){
        historicoTagRepository.deleteById(id);
    }
}