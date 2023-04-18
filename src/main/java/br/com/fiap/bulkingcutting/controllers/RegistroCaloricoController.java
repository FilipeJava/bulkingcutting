package br.com.fiap.bulkingcutting.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.fiap.bulkingcutting.models.RegistroCalorico;
import br.com.fiap.bulkingcutting.models.Tipo;
import br.com.fiap.bulkingcutting.models.form.RegistroCaloricoForm;
import br.com.fiap.bulkingcutting.models.form.RegistroCaloricoUpdateForm;
import br.com.fiap.bulkingcutting.service.impl.RegistroColoricoServiceImpl;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/bulkingcutting/api/registrocalorico/")
public class RegistroCaloricoController {

    Logger log = LoggerFactory.getLogger(RegistroCaloricoController.class);

    @Autowired
    private RegistroColoricoServiceImpl registroColoricoService;

   

    @GetMapping("{id}")
    public ResponseEntity<RegistroCalorico> getRegistroCaloricoById(@PathVariable Long id) {
        log.info("Buscando de calorias do Usuário" + id);

        var registroCalorico = registroColoricoService.getRegistroCalorico(id);

        return ResponseEntity.ok(registroCalorico);

    }

    @PostMapping
    public ResponseEntity<RegistroCalorico> postRegistroCalorico(
            @RequestBody @Valid RegistroCaloricoForm registroCalorico) {
        log.info("Cadastro do registro de calorias");

        RegistroCalorico registro = registroColoricoService.create(registroCalorico);

        return ResponseEntity.status(HttpStatus.CREATED).body(registro);
    }

    @PutMapping("{id}")
    public ResponseEntity<RegistroCalorico> putRegistroCalorico(@PathVariable Long id,
            @RequestBody @Valid RegistroCaloricoUpdateForm registroCalorico) {
        log.info("Atualizando o registro de calorias do Usuário" + id);

        RegistroCalorico registro = registroColoricoService.update(registroCalorico, id);

        return ResponseEntity.ok(registro);
    }

    @GetMapping
    public Page<RegistroCalorico> index(@RequestParam(required = false) Tipo tipo,
            @PageableDefault(size = 5) Pageable paginacao) {

                if (tipo == null) {
                    return registroColoricoService.getAllRegistroCalorico(paginacao);

                }


        return registroColoricoService.getAllRegistroCaloricoByTipo(tipo, paginacao);
    }

}

// List<RegistroCalorico> registroCaloricoList = new
// ArrayList<RegistroCalorico>();

// @Autowired
// RegistroCaloricoRepository registroCaloricoRepository;

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

// @PostMapping
// public ResponseEntity<RegistroCalorico> postRegistroCalorico(
// @RequestBody @Valid RegistroCalorico registroCalorico) {
// log.info("Cadastro do registro de calorias");

// registroCaloricoRepository.save(registroCalorico);

// return ResponseEntity.status(HttpStatus.CREATED).body(registroCalorico);
// }

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
