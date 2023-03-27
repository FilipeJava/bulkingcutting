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

import br.com.fiap.bulkingcutting.models.DadosUser;
import br.com.fiap.bulkingcutting.repository.DadosUserRepository;

@RestController
public class DadosUserController {

    Logger log = LoggerFactory.getLogger(DadosUserController.class);

    List<DadosUser> dadosUserList = new ArrayList<DadosUser>();

    @Autowired
    DadosUserRepository dadosUserRepository;

    @GetMapping("/bulkingcutting/api/dados")
        public List<DadosUser> getDadosUser() {
        log.info("Todos os dados dos Usuários");
        return dadosUserRepository.findAll();
    }

    @GetMapping("/bulkingcutting/api/dados/{id}")
    public ResponseEntity<DadosUser> getDadosUserById(@PathVariable Long id) {
        log.info("Dados do Usuário" + id + "econtrado");

        var dadosUser = dadosUserRepository.findById(id);
        if (dadosUser.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(dadosUser.get());

    }

    @PostMapping("/bulkingcutting/api/dados")
    public ResponseEntity<DadosUser> postDadosUser(@RequestBody DadosUser dadosUser) {
        log.info("Cadastro do Usuário");
        
        dadosUserRepository.save(dadosUser);

        return ResponseEntity.status(HttpStatus.CREATED).body(dadosUser);
    }

    @DeleteMapping("/bulkingcutting/api/dados/{id}")
    public ResponseEntity<DadosUser> deleteDadosUser(@PathVariable Long id) {
        log.info("Deletando o Usuário" + id);
        var dadosUser = dadosUserRepository.findById(id);
        if (dadosUser.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        dadosUserRepository.delete(dadosUser.get());

        return ResponseEntity.noContent().build();

    }

    @PutMapping("/bulkingcutting/api/dados/{id}")
    public ResponseEntity<DadosUser> putDadosUser(@PathVariable Long id, @RequestBody DadosUser dadosUser) {
        log.info("Atualizando o Usuário" + id);

        var dadosFilter = dadosUserRepository.findById(id);
        if (dadosFilter.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        dadosUserList.remove(dadosFilter.get());
        dadosUser.setId(id);
        dadosUserRepository.save(dadosUser);
        return ResponseEntity.ok().body(dadosUser);

    }
}