package com.argos.argos.controller;

import com.argos.argos.controller.response.HttpResponse;
import com.argos.argos.model.entities.HistoricoTag;
import com.argos.argos.model.entities.Tag;
import com.argos.argos.service.impl.HistoricoTagService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.transaction.Transactional;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "api/v1/historico")
public class HistoricoTagAPIController {

    private final HistoricoTagService historicoTagService;
    private final Logger log = LogManager.getLogger(HistoricoTagAPIController.class);

    public HistoricoTagAPIController(HistoricoTagService historicoTagService) {
        this.historicoTagService = historicoTagService;
    }

    @CrossOrigin
    @GetMapping
    @Transactional
    public ResponseEntity<Object> consultaHistoricoTag(){
        log.info(">>>> [Controller] consultaHistoricoTag iniciado");

        return ResponseEntity.ok().body(historicoTagService.find());
    }

    @CrossOrigin
    @GetMapping("/{id}")
    @Transactional
    public ResponseEntity<Object> consultaHistoricoTagPorId(@PathVariable Long id){
        log.info(">>>> [Controller] consultaHistoricoTagPorId iniciado");

        Optional<HistoricoTag> historicoTag = historicoTagService.findById(id);

        return ResponseEntity.ok().body(historicoTag);
    }

    @CrossOrigin
    @GetMapping("/tag/{id}")
    @Transactional
    public ResponseEntity<Object> getHistoricoTagByTagId(@PathVariable Long id){
        log.info(">>>> [Controller] consultaHistoricoTagPorId iniciado");

        List<HistoricoTag> historicoTag = historicoTagService.findByIdTag(id);

        return ResponseEntity.ok().body(historicoTag);
    }

    @CrossOrigin
    @PostMapping
    @Transactional
    public ResponseEntity<Object> inserirHistoricoTag(@RequestBody Tag tag){
        log.info(">>>> [Controller] inserirHistoricoTag iniciado");

        return ResponseEntity.ok().body(historicoTagService.insertHistorico(tag));
    }

    @CrossOrigin
    @PatchMapping
    @Transactional
    public ResponseEntity<Object> updateHistoricoTag(@RequestBody HistoricoTag historicoTag){
        log.info(">>>> [Controller] updateHistoricoTag iniciado");

        return ResponseEntity.ok().body(historicoTagService.update(historicoTag));
    }

    @CrossOrigin
    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity<Object> deleteHistoricoTag(@PathVariable Long id, HttpServletRequest request){
        log.info(">>>> [Controller] deleteHistoricoTag iniciado");

        historicoTagService.delete(id);
        HttpResponse response = new HttpResponse();

        response.setStatus(HttpStatus.OK);
        response.setMessage("HistoricoTag id: " + id +" deletado com sucesso");
        response.setPath(request.getRequestURI());

        return ResponseEntity.ok(response);
    }
}