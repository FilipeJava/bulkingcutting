package br.com.fiap.bulkingcutting.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.fiap.bulkingcutting.models.RegistroCalorico;

public interface RegistroCaloricoRepository extends JpaRepository<RegistroCalorico, Long> {
     
}