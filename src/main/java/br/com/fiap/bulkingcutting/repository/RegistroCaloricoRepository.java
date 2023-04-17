package br.com.fiap.bulkingcutting.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import br.com.fiap.bulkingcutting.models.RegistroCalorico;
import br.com.fiap.bulkingcutting.models.Tipo;

public interface RegistroCaloricoRepository extends JpaRepository<RegistroCalorico, Long> {
     
    Page<RegistroCalorico> findByTipo( Tipo tipo, Pageable paginacao);

  

}