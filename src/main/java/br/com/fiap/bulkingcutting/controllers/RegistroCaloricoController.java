package br.com.fiap.bulkingcutting.controllers;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

@RestController
public class RegistroCaloricoController {

    Logger log = LoggerFactory.getLogger(RegistroCaloricoController.class);

    List<RegistroCalorico> registroCaloricoList = new ArrayList<RegistroCalorico>();

    @GetMapping("/bulkingcutting/api/registrocalorico")
    public List<RegistroCalorico> getRegistroCalorico() {
        log.info("Todos os registros de calorias");
        return registroCaloricoList;
    }

    @GetMapping("/bulkingcutting/api/registrocalorico/{id}")
    public ResponseEntity<RegistroCalorico> getRegistroCaloricoById(@PathVariable Long id) {
        log.info("Registro de calorias do Usuário" + id + "econtrado");

        var registroCalorico = registroCaloricoList.stream().filter(registro -> registro.getId().equals(id))
                .findFirst();
        if (registroCalorico.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }

        return ResponseEntity.ok(registroCalorico.get());
    }

    @PostMapping("/bulkingcutting/api/registrocalorico")
    public ResponseEntity postRegistroCalorico(@RequestBody RegistroCalorico registroCalorico) {
        log.info("Cadastro do registro de calorias");
        registroCalorico.setId((long) registroCaloricoList.size() + 1);
        this.registroCaloricoList.add(registroCalorico);
        return ResponseEntity.status(HttpStatus.CREATED).body(registroCalorico);
    }

    @DeleteMapping("/bulkingcutting/api/registrocalorico/{id}")
    public ResponseEntity deleteRegistroCalorico(@PathVariable Long id) {
        log.info("Exclusão do registro de calorias");
        var registroCalorico = registroCaloricoList.stream().filter(registro -> registro.getId().equals(id))
                .findFirst();
        if (registroCalorico.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        registroCaloricoList.remove(registroCalorico.get());
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();

    }

    @PutMapping("/bulkingcutting/api/registrocalorico/{id}")
    public ResponseEntity<RegistroCalorico> putRegistroCalorico(@PathVariable Long id,
            @RequestBody RegistroCalorico registroCalorico) {
        log.info("Atualização do registro de calorias");

        var registroCaloricoAtual = registroCaloricoList.stream().filter(registro -> registro.getId().equals(id))
                .findFirst();
        if (registroCaloricoAtual.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }

        registroCaloricoList.remove(registroCaloricoAtual.get());
        registroCalorico.setId(id);
        registroCaloricoList.add(registroCalorico);

        return ResponseEntity.status(HttpStatus.OK).body(registroCalorico);

    }

}