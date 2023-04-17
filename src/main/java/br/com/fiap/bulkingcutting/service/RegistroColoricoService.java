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

   Page<RegistroCalorico> getAllRegistroCalorico(Pageable paginacao);

    Page<RegistroCalorico>getAllRegistroCaloricoByTipo(String tipo , Pageable paginacao);

    RegistroCalorico update(RegistroCaloricoUpdateForm form, Long id); 

  
    
    void deleteRegistro(Long id);
}