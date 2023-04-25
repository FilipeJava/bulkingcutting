package br.com.fiap.bulkingcutting.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.fiap.bulkingcutting.models.DadosUser;
import br.com.fiap.bulkingcutting.models.RegistroCalorico;
import br.com.fiap.bulkingcutting.models.form.DadosUserForm;
import br.com.fiap.bulkingcutting.repository.DadosUserRepository;
import br.com.fiap.bulkingcutting.service.DadosUserService;

@Service
public class DadosUserServiceImpl implements DadosUserService {

    @Autowired
    private DadosUserRepository dadosUserRepository;

    @Override
    public DadosUser create(DadosUser dadosUser) {

        // DadosUser dadosUser = new DadosUser();
        // dadosUser.setNome(form.getNome());
        // dadosUser.setSexo(form.getSexo());
        // dadosUser.setAltura(form.getAltura());
        // dadosUser.setEmail(form.getEmail());
        // dadosUser.setSenha(form.getSenha());
        // dadosUser.setPeso(form.getPeso());
        // dadosUser.setIdade(form.getIdade());
        // dadosUser.setObjetivo(form.getObjetivo());

        return dadosUserRepository.save(dadosUser);
    }

    @Override
    public DadosUser getUsuario(Long id) {

        return dadosUserRepository.findById(id).get();

    }

    @Override
    public List<DadosUser> getAllUsuarios() {
        return dadosUserRepository.findAll();
    }

    @Override
    public DadosUser update(DadosUserForm form, Long id) {

        DadosUser dadosUser = dadosUserRepository.findById(id).get();
        dadosUser.setNome(form.getNome());
        dadosUser.setSexo(form.getSexo());
        dadosUser.setAltura(form.getAltura());
        dadosUser.setPeso(form.getPeso());
        dadosUser.setIdade(form.getIdade());
        dadosUser.setObjetivo(form.getObjetivo());
        return dadosUserRepository.save(dadosUser);
    }

    @Override
    public void deleteUsuario(Long id) {
        dadosUserRepository.deleteById(id);

    }

    @Override
    public List<RegistroCalorico> getAllRegistros(Long id) {

        return dadosUserRepository.findById(id).get().getRegistrosCaloricos();

    }

}