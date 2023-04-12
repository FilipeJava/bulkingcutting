package br.com.fiap.bulkingcutting.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.fiap.bulkingcutting.models.DadosUser;

public interface DadosUserRepository extends JpaRepository<DadosUser, Long> {

}