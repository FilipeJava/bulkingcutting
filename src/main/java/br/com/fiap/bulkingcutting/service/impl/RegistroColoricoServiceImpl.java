package br.com.fiap.bulkingcutting.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.fiap.bulkingcutting.models.RegistroCalorico;
import br.com.fiap.bulkingcutting.models.form.RegistroCaloricoForm;
import br.com.fiap.bulkingcutting.models.form.RegistroCaloricoUpdateForm;
import br.com.fiap.bulkingcutting.repository.RegistroCaloricoRepository;
import br.com.fiap.bulkingcutting.service.RegistroColoricoService;

@Service
public class RegistroColoricoServiceImpl implements RegistroColoricoService {

    @Autowired
    private RegistroCaloricoRepository registroCaloricoRepository;

    @Override
    public RegistroCalorico create(RegistroCaloricoForm form) {

           RegistroCalorico registroCalorico = new RegistroCalorico();
           registroCalorico.setCalorias(form.getCalorias());
           registroCalorico.setTipo(form.getTipo());
           registroCalorico.setDescricao(form.getDescricao());
           registroCalorico.setData(form.getData());

           return registroCaloricoRepository.save(registroCalorico);
         

    }

    @Override
    public RegistroCalorico getRegistroCalorico(Long id) {
        return registroCaloricoRepository.findById(id).get();
    }

    @Override
    public List<RegistroCalorico> getAllRegistroCalorico() {
        return registroCaloricoRepository.findAll();
    }

    @Override
    public RegistroCalorico update(RegistroCaloricoUpdateForm form, Long id) {
        RegistroCalorico registroCalorico = registroCaloricoRepository.findById(id).get();
        registroCalorico.setCalorias(form.getCalorias());
        registroCalorico.setTipo(form.getTipo());
        registroCalorico.setDescricao(form.getDescricao());
        registroCalorico.setData(form.getData());
        return registroCaloricoRepository.save(registroCalorico);
    }

    @Override
    public void deleteRegistro(Long id) {
        registroCaloricoRepository.deleteById(id);
    }

   
    
}