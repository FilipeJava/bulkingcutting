package br.com.fiap.bulkingcutting.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import org.springframework.stereotype.Service;

import br.com.fiap.bulkingcutting.models.DadosUser;
import br.com.fiap.bulkingcutting.models.RegistroCalorico;
import br.com.fiap.bulkingcutting.models.Tipo;
import br.com.fiap.bulkingcutting.models.form.RegistroCaloricoForm;
import br.com.fiap.bulkingcutting.models.form.RegistroCaloricoUpdateForm;
import br.com.fiap.bulkingcutting.repository.DadosUserRepository;
import br.com.fiap.bulkingcutting.repository.RegistroCaloricoRepository;
import br.com.fiap.bulkingcutting.service.RegistroColoricoService;

@Service
public class RegistroColoricoServiceImpl implements RegistroColoricoService {

    @Autowired
    private RegistroCaloricoRepository registroCaloricoRepository;

    @Autowired
    private DadosUserRepository dadosUserRepository;

    @Override
    public RegistroCalorico create(RegistroCaloricoForm form) {
        DadosUser usuario = dadosUserRepository.findById(form.getUsuarioId()).get();
        RegistroCalorico registroCalorico = new RegistroCalorico();
        registroCalorico.setUsuario(usuario);
        registroCalorico.setTipo(form.getTipo());
        registroCalorico.setDescricao(form.getDescricao());
        registroCalorico.setData(form.getData());
        registroCalorico.setCalorias(form.getCalorias());

        return registroCaloricoRepository.save(registroCalorico);

    }

    @Override
    public RegistroCalorico getRegistroCalorico(Long id) {
        return registroCaloricoRepository.findById(id).get();
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

    @Override
    public Page<RegistroCalorico> getAllRegistroCaloricoByTipo(Tipo tipo, Pageable paginacao) {

        return registroCaloricoRepository.findByTipo(tipo, paginacao);

    }

    @Override
    public Page<RegistroCalorico> getAllRegistroCalorico(Pageable paginacao) {
        return registroCaloricoRepository.findAll(paginacao);
    }

    public void delete(RegistroCalorico registroCalorico) {

        registroCaloricoRepository.delete(registroCalorico);
    }

}