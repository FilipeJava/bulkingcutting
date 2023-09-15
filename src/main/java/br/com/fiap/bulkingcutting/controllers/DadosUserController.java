package br.com.fiap.bulkingcutting.controllers;

import java.util.List;

import org.modelmapper.ModelMapper;
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

import br.com.fiap.bulkingcutting.models.DadosUser;
import br.com.fiap.bulkingcutting.models.RegistroCalorico;
import br.com.fiap.bulkingcutting.models.form.DadosUserForm;
import br.com.fiap.bulkingcutting.models.form.DadosUserResposta;
import br.com.fiap.bulkingcutting.service.impl.DadosUserServiceImpl;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/bulkingcutting/api/usuario/")
public class DadosUserController {

    Logger log = LoggerFactory.getLogger(DadosUserController.class);

    // List<DadosUser> dadosUserList = new ArrayList<DadosUser>();

    @Autowired
    private DadosUserServiceImpl dadosUserService;

    @Autowired
    private ModelMapper modelMapper;

    @GetMapping
    public List<DadosUserResposta> getDadosUser() {
        log.info("Todos os dados dos Usuários");
        List<DadosUser> usuarios = dadosUserService.getAllUsuarios();

        return usuarios.stream().map(this::convertToResposta).toList();

    }

    @GetMapping("{id}")
    public ResponseEntity<DadosUserResposta> getDadosUserById(@PathVariable Long id) {
        log.info("Dados do Usuário" + id + "econtrado");

        var dadosUser = dadosUserService.getUsuario(id);

        return ResponseEntity.ok(convertToResposta(dadosUser));

    }

    @PostMapping
    public ResponseEntity<DadosUserResposta> postDadosUser(@RequestBody @Valid DadosUserForm dadosUser) {
        log.info("Cadastro do Usuário");

        DadosUser usuario = dadosUserService.create(convertToEntity(dadosUser));

        return ResponseEntity.status(HttpStatus.CREATED).body(convertToResposta(usuario));
    }

    @PutMapping("{id}")
    public ResponseEntity<DadosUserResposta> putDadosUser(@PathVariable Long id,
            @RequestBody @Valid DadosUserForm dadosUser) {
        log.info("Atualização do Usuário" + id);

        DadosUser usuario = dadosUserService.update(dadosUser, id);

        return ResponseEntity.ok(convertToResposta(usuario));
    }

    @DeleteMapping("{id}")
    public ResponseEntity<DadosUser> deleteDadosUser(@PathVariable Long id) {
        log.info("Deletando o Usuário" + id);
        dadosUserService.deleteUsuario(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("registro/{id}")
    public List<RegistroCalorico> getRegistroCalorico(@PathVariable Long id) {
        log.info("Todos os registros de calorias");
        return dadosUserService.getAllRegistros(id);
    }

    private DadosUser convertToEntity(DadosUserForm dadosUserForm) {
        return modelMapper.map(dadosUserForm, DadosUser.class);

    }

    private DadosUserResposta convertToResposta(DadosUser dadosUser) {
        return modelMapper.map(dadosUser, DadosUserResposta.class);
    }

    // private DadosUser getDados(Long id) {
    // return dadosUserRepository.findById(id)
    // .orElseThrow(() -> new RestNotFoundException("Dados do Usuário não
    // encontrado"));
    // }

    // @GetMapping
    // public List<DadosUser> getDadosUser() {
    // log.info("Todos os dados dos Usuários");
    // return dadosUserRepository.findAll();
    // }

    // @GetMapping("{id}")
    // public ResponseEntity<DadosUser> getDadosUserById(@PathVariable Long id) {
    // log.info("Dados do Usuário" + id + "econtrado");

    // var dadosUser = getDados(id);

    // return ResponseEntity.ok(dadosUser);

    // }

    // @PostMapping
    // public ResponseEntity<DadosUser> postDadosUser(@RequestBody @Valid DadosUser
    // dadosUser) {
    // log.info("Cadastro do Usuário");

    // dadosUserRepository.save(dadosUser);

    // return ResponseEntity.status(HttpStatus.CREATED).body(dadosUser);
    // }

    // @DeleteMapping("{id}")
    // public ResponseEntity<DadosUser> deleteDadosUser(@PathVariable Long id) {
    // log.info("Deletando o Usuário" + id);
    // var dadosUser = getDados(id);
    // dadosUserRepository.delete(dadosUser);
    // return ResponseEntity.noContent().build();
    // }

    // @PutMapping("{id}")
    // public ResponseEntity<DadosUser> putDadosUser(@PathVariable Long id,
    // @RequestBody @Valid DadosUser dadosUser) {
    // log.info("Atualizando o Usuário" + id);
    // getDados(id);
    // dadosUser.setId(id);
    // dadosUserRepository.save(dadosUser);
    // return ResponseEntity.ok(dadosUser);

    // }

}