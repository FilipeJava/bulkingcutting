package br.com.fiap.bulkingcutting.service;

import java.util.List;

import org.springframework.stereotype.Service;

import br.com.fiap.bulkingcutting.models.DadosUser;
import br.com.fiap.bulkingcutting.models.RegistroCalorico;
import br.com.fiap.bulkingcutting.models.form.DadosUserForm;
import br.com.fiap.bulkingcutting.models.form.DadosUserUpdateForm;


public interface DadosUserService {

    DadosUser create(DadosUserForm form);

    DadosUser getUsuario(Long id);

    List<DadosUser> getAllUsuarios();

    DadosUser update(DadosUserForm form, Long id);

    void deleteUsuario(Long id);

    List<RegistroCalorico> getAllRegistros(Long id);
}