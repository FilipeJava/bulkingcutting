package br.com.fiap.bulkingcutting.service;

import java.util.List;

import br.com.fiap.bulkingcutting.models.RegistroCalorico;
import br.com.fiap.bulkingcutting.models.form.RegistroCaloricoForm;
import br.com.fiap.bulkingcutting.models.form.RegistroCaloricoUpdateForm;

public interface RegistroColoricoService {




   RegistroCalorico create(RegistroCaloricoForm form);
    
   RegistroCalorico getRegistroCalorico(Long id);

    List<RegistroCalorico> getAllRegistroCalorico();

    RegistroCalorico update(RegistroCaloricoUpdateForm form, Long id); 
    
    void deleteRegistro(Long id);
}