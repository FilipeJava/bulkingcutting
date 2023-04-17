package br.com.fiap.bulkingcutting.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import br.com.fiap.bulkingcutting.models.RegistroCalorico;
import br.com.fiap.bulkingcutting.models.form.RegistroCaloricoForm;
import br.com.fiap.bulkingcutting.models.form.RegistroCaloricoUpdateForm;

public interface RegistroColoricoService {




   RegistroCalorico create(RegistroCaloricoForm form);
    
   RegistroCalorico getRegistroCalorico(Long id);

    List<RegistroCalorico> getAllRegistroCalorico();

    Page<RegistroCalorico>getAllRegistroCaloricoByTipo(String tipo , Pageable paginacao);

    RegistroCalorico update(RegistroCaloricoUpdateForm form, Long id); 

    Page<RegistroCalorico> findAllPaginacao(Pageable paginacao);
    
    void deleteRegistro(Long id);
}