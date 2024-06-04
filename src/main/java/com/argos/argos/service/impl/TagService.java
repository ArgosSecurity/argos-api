package com.argos.argos.service.impl;

import com.argos.argos.model.entities.Dependente;
import com.argos.argos.model.entities.HistoricoTag;
import com.argos.argos.model.entities.Responsavel;
import com.argos.argos.model.entities.Tag;
import com.argos.argos.model.repositories.IDependenteRepository;
import com.argos.argos.model.repositories.IHistoricoTagRepository;
import com.argos.argos.model.repositories.IResponsavelRepository;
import com.argos.argos.model.repositories.ITagRepository;
import com.argos.argos.service.ITagService;
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
public class TagService implements ITagService {

    private Logger log = LogManager.getLogger(TagService.class);
    private final ITagRepository tagRepository;
    private final IResponsavelRepository responsavelRepository;
    private final IDependenteRepository dependenteRepository;
    private final IHistoricoTagRepository historicoTagRepository;

    public TagService(ITagRepository tagRepository, IResponsavelRepository responsavelRepository, IDependenteRepository dependenteRepository, IHistoricoTagRepository historicoTagRepository) {
        this.tagRepository = tagRepository;
        this.responsavelRepository = responsavelRepository;
        this.dependenteRepository = dependenteRepository;
        this.historicoTagRepository = historicoTagRepository;
    }

    @Override
    public List<Tag> find() {
        log.info(">>>> [TagService] find iniciado");

        return tagRepository.findAll();
    }

    @Override
    public Optional<Tag> findById(Long id) {
        log.info(">>>> [TagService] findById(" + id +") iniciado");

        Optional<Tag> tag = tagRepository.findById(id);

        return Optional.ofNullable(tag.orElseThrow(() -> new ResourceNotFoundException(id)));
    }

    @Override
    public List<Tag> findByIdResponsavel(Long idResponsavel) {
        log.info(">>>> [TagService] find iniciado");

        Optional<Responsavel> responsavel = responsavelRepository.findById(idResponsavel);
        List<Tag> arrTag = tagRepository.findAllByResponsavel(responsavel.get());

        return arrTag;
    }

    @Override
    public List<Tag> findByIdDendente(Long idDependente) {
        log.info(">>>> [TagService] insert iniciado");

        Optional<Dependente> dependente = dependenteRepository.findById(idDependente);
        List<Tag> arrTag = tagRepository.findAllByDependente(dependente.get());

        return arrTag;
    }

    @Override
    public Optional<Tag> insert(Tag obj, Long idResponsavel) {
        log.info(">>>> [TagService] insert iniciado");

        Optional<Responsavel> responsavel = responsavelRepository.findById(idResponsavel);
        obj.setResponsavel(responsavel.get());

        HistoricoTag historico = new HistoricoTag(obj.getId(), obj.getResponsavel().getNome(), obj.getResponsavel().getRg(), "CADASTRO");
        historicoTagRepository.save(historico);

        return Optional.of(tagRepository.save(obj));
    }

    @Override
    public Optional<Tag> update(Tag obj) {
        log.info(">>>> [TagService update iniciado]");
        try{
            Tag entidade = tagRepository.getReferenceById(obj.getId());
            updateData(entidade, obj);
            return Optional.of(tagRepository.save(entidade));
        } catch (EntityNotFoundException e){
            throw new ResourceNotFoundException(obj.getId());
        }
    }

    private void updateData(Tag entidade, Tag obj){
        entidade.setCodRegistroTag(obj.getCodRegistroTag());
        entidade.setResponsavel(obj.getResponsavel());
        entidade.setDependente(obj.getDependente());
        entidade.setHorarioInicio(obj.getHorarioInicio());
        entidade.setHorarioFim(obj.getHorarioFim());
        entidade.setIsTemporario(obj.getIsTemporario());
    }

    @Override
    public Optional<Tag> updateTagByDependente(Tag obj, Long idDependente) {
        log.info(">>>> [updateTagByDependente iniciado]");

        Tag entidade = tagRepository.getReferenceById(obj.getId());
        Optional<Dependente> dependente = dependenteRepository.findById(idDependente);

        entidade.setDependente(dependente.get());

        return Optional.of(tagRepository.save(entidade));
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
        Optional<Tag> tag = findById(id);
        tagRepository.deleteById(id);
    }
}