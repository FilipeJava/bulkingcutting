package br.com.fiap.bulkingcutting.controllers;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.fiap.bulkingcutting.exception.RestNotFoundException;
import br.com.fiap.bulkingcutting.models.RegistroCalorico;
import br.com.fiap.bulkingcutting.repository.RegistroCaloricoRepository;
import br.com.fiap.bulkingcutting.service.RegistroCaloricoService;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/bulkingcutting/api/registrocalorico")
public class RegistroCaloricoController {

    Logger log = LoggerFactory.getLogger(RegistroCaloricoController.class);

    // @Autowired
    // RegistroCaloricoService registroCaloricoService;

    // List<RegistroCalorico> registroCaloricoList = new
    // ArrayList<RegistroCalorico>();

    @Autowired
    RegistroCaloricoRepository registroCaloricoRepository;

    // @GetMapping
    // public List<RegistroCalorico> getRegistroCalorico() {
    // log.info("Todos os registros de calorias");
    // return registroCaloricoRepository.findAll();
    // }

    // @GetMapping("{id}")
    // public ResponseEntity<RegistroCalorico> getRegistroCaloricoById(@PathVariable
    // Long id) {
    // log.info("Buscando de calorias do Usuário" + id);
    // var registroCalorico = getRegistro(id);
    // return ResponseEntity.ok(registroCalorico);
    // }

    @PostMapping
    public ResponseEntity<RegistroCalorico> postRegistroCalorico(
            @RequestBody @Valid RegistroCalorico registroCalorico) {
        log.info("Cadastro do registro de calorias");

        registroCaloricoRepository.save(registroCalorico);

        return ResponseEntity.status(HttpStatus.CREATED).body(registroCalorico);
    }

    // @DeleteMapping("{id}")
    // public ResponseEntity<RegistroCalorico> deleteRegistroCalorico(@PathVariable
    // Long id) {
    // log.info("Exclusão do registro de calorias");
    // var registroCalorico = getRegistro(id);
    // registroCaloricoRepository.delete(registroCalorico);

    // return ResponseEntity.noContent().build();

    // }

    // @PutMapping("{id}")
    // public ResponseEntity<RegistroCalorico> putRegistroCalorico(@PathVariable
    // Long id,
    // @RequestBody @Valid RegistroCalorico registroCalorico) {
    // log.info("Atualização do registro de calorias");

    // getRegistro(id);
    // registroCalorico.setId(id);
    // registroCaloricoRepository.save(registroCalorico);

    // return ResponseEntity.ok(registroCalorico);

    // }

    // private RegistroCalorico getRegistro(Long id) {
    // return registroCaloricoRepository.findById(id)
    // .orElseThrow(() -> new RestNotFoundException("Registro de calorias não
    // encontrado"));
    // }

}