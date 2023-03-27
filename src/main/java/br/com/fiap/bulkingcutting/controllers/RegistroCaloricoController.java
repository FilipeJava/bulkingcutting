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
import org.springframework.web.bind.annotation.RestController;

import br.com.fiap.bulkingcutting.models.RegistroCalorico;
import br.com.fiap.bulkingcutting.repository.RegistroCaloricoRepository;

@RestController
public class RegistroCaloricoController {

    Logger log = LoggerFactory.getLogger(RegistroCaloricoController.class);

    List<RegistroCalorico> registroCaloricoList = new ArrayList<RegistroCalorico>();

    @Autowired
    RegistroCaloricoRepository registroCaloricoRepository;

    @GetMapping("/bulkingcutting/api/registrocalorico")
    public List<RegistroCalorico> getRegistroCalorico() {
        log.info("Todos os registros de calorias");
        return registroCaloricoRepository.findAll();
    }

    @GetMapping("/bulkingcutting/api/registrocalorico/{id}")
    public ResponseEntity<RegistroCalorico> getRegistroCaloricoById(@PathVariable Long id) {
        log.info("Registro de calorias do Usuário" + id + "econtrado");

        var registroCalorico = registroCaloricoRepository.findById(id);

        if (registroCalorico.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(registroCalorico.get());
    }

    @PostMapping("/bulkingcutting/api/registrocalorico")
    public ResponseEntity<RegistroCalorico> postRegistroCalorico(@RequestBody RegistroCalorico registroCalorico) {
        log.info("Cadastro do registro de calorias");

        registroCaloricoRepository.save(registroCalorico);

        return ResponseEntity.status(HttpStatus.CREATED).body(registroCalorico);
    }

    @DeleteMapping("/bulkingcutting/api/registrocalorico/{id}")
    public ResponseEntity<RegistroCalorico> deleteRegistroCalorico(@PathVariable Long id) {
        log.info("Exclusão do registro de calorias");
        var registroCalorico = registroCaloricoRepository.findById(id);

        if (registroCalorico.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        registroCaloricoRepository.delete(registroCalorico.get());
        return ResponseEntity.noContent().build();

    }

    @PutMapping("/bulkingcutting/api/registrocalorico/{id}")
    public ResponseEntity<RegistroCalorico> putRegistroCalorico(@PathVariable Long id,
            @RequestBody RegistroCalorico registroCalorico) {
        log.info("Atualização do registro de calorias");

        var registroCaloricoAtual = registroCaloricoRepository.findById(id);
        if (registroCaloricoAtual.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        registroCalorico.setId(id);
        registroCaloricoRepository.save(registroCalorico);

        return ResponseEntity.ok().body(registroCalorico);

    }

}