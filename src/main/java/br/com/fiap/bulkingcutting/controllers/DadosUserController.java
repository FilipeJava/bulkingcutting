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

import br.com.fiap.bulkingcutting.models.DadosUser;

@RestController
public class DadosUserController {
    

Logger log = LoggerFactory.getLogger(DadosUserController.class);


List<DadosUser> dadosUserList = new ArrayList<DadosUser>();


@GetMapping("/bulkingcutting/api/dados")
public List<DadosUser> getDadosUser() {
    log.info("Todos os dados dos Usuários");
    return dadosUserList;
}

@GetMapping("/bulkingcutting/api/dados/{id}")
public ResponseEntity<DadosUser> getDadosUserById( @PathVariable Long id) {
    log.info("Dados do Usuário"+id+"econtrado");

  var dadosUser = dadosUserList.stream().filter(dados-> dados.getId().equals(id)).findFirst();
    if(dadosUser.isEmpty()){
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }   

    return ResponseEntity.ok(dadosUser.get());

}



@PostMapping("/bulkingcutting/api/dados")
public ResponseEntity postDadosUser(@RequestBody DadosUser dadosUser) {
    log.info("Cadastro do Usuário");
    dadosUser.setId((long)dadosUserList.size() + 1);
    this.dadosUserList.add(dadosUser);
    return  ResponseEntity.status(HttpStatus.CREATED).body(dadosUser);     
}


@DeleteMapping("/bulkingcutting/api/dados/{id}")
public ResponseEntity deleteDadosUser(@PathVariable Long id) {
    log.info("Deletando o Usuário"+id);
    var dadosUser = dadosUserList.stream().filter(dados-> dados.getId().equals(id)).findFirst();
    if(dadosUser.isEmpty()){
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }   
    dadosUserList.remove(dadosUser.get());
    return ResponseEntity.status(HttpStatus.NO_CONTENT).build();

}

@PutMapping("/bulkingcutting/api/dados/{id}")
public ResponseEntity<DadosUser> putDadosUser(@PathVariable Long id, @RequestBody DadosUser dadosUser) {
    log.info("Atualizando o Usuário"+id);
    var dadosFilter = dadosUserList.stream().filter(dados-> dados.getId().equals(id)).findFirst();
    if(dadosFilter.isEmpty()){
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }   
    dadosUserList.remove(dadosFilter.get());
    dadosUser.setId(id);
    dadosUserList.add(dadosUser);
    return ResponseEntity.status(HttpStatus.NO_CONTENT).build();


}
}