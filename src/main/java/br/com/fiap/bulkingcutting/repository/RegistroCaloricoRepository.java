package br.com.fiap.bulkingcutting.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.fiap.bulkingcutting.models.RegistroCalorico;

public interface RegistroCaloricoRepository extends JpaRepository<RegistroCalorico, Long> {
     
    List<RegistroCalorico> findByidDadosUser(Long Id);

}