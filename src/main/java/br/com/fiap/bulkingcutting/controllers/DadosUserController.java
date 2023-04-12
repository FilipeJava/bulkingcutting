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
import br.com.fiap.bulkingcutting.models.DadosUser;
import br.com.fiap.bulkingcutting.repository.DadosUserRepository;
import br.com.fiap.bulkingcutting.repository.RegistroCaloricoRepository;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/bulkingcutting/api/dados")
public class DadosUserController {

    Logger log = LoggerFactory.getLogger(DadosUserController.class);

    

    @Autowired
    DadosUserRepository dadosUserRepository;

    @Autowired
    RegistroCaloricoRepository registroCaloricoRepository;

    @GetMapping
    public List<DadosUser> getDadosUser() {
        log.info("Todos os dados dos Usuários");
        return dadosUserRepository.findAll();
    }

    @GetMapping("{id}")
    public ResponseEntity<DadosUser> getDadosUserById(@PathVariable Long id) {
        log.info("Dados do Usuário" + id + "econtrado");

        DadosUser dadosUser = getDados(id);

        dadosUser.setRegistrosCaloricos(registroCaloricoRepository.findByidDadosUser(dadosUser.getId()));

        return ResponseEntity.ok(dadosUser);

    }

    @PostMapping
    public ResponseEntity<DadosUser> postDadosUser(@RequestBody @Valid DadosUser dadosUser) {
        log.info("Cadastro do Usuário");

        dadosUserRepository.save(dadosUser);

        return ResponseEntity.status(HttpStatus.CREATED).body(dadosUser);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<DadosUser> deleteDadosUser(@PathVariable Long id) {
        log.info("Deletando o Usuário" + id);
        var dadosUser = getDados(id);
        dadosUserRepository.delete(dadosUser);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("{id}")
    public ResponseEntity<DadosUser> putDadosUser(@PathVariable Long id, @RequestBody @Valid DadosUser dadosUser) {
        log.info("Atualizando o Usuário" + id);
        getDados(id);
        dadosUser.setId(id);
        dadosUserRepository.save(dadosUser);
        return ResponseEntity.ok(dadosUser);

    }

    private DadosUser getDados(Long id) {
        return dadosUserRepository.findById(id)
                .orElseThrow(() -> new RestNotFoundException("Dados do Usuário não encontrado"));
    }

}