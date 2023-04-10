package br.com.fiap.bulkingcutting.config;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;

import br.com.fiap.bulkingcutting.models.DadosUser;
import br.com.fiap.bulkingcutting.models.Objetivo;
import br.com.fiap.bulkingcutting.models.RegistroCalorico;
import br.com.fiap.bulkingcutting.models.Sexo;

import br.com.fiap.bulkingcutting.repository.DadosUserRepository;

public class DatabaseSeeder implements CommandLineRunner {

    @Autowired
    DadosUserRepository dadosUserRepository;

    List<RegistroCalorico> registroCaloricos = new ArrayList<>();

    @Override
    public void run(String... args) throws Exception {
        dadosUserRepository.saveAll(List.of(
                new DadosUser(1L, "João", 20, "jo@jao.com.br", "teste", Sexo.MASCULINO, Objetivo.GANHO_MUSCULO,
                        new BigDecimal(80), 180,registroCaloricos),
                new DadosUser(2L, "Maria", 17, "ma@mah.com.br", "teste", Sexo.FEMININO, Objetivo.PERDA_PESO,
                        new BigDecimal(60), 160,registroCaloricos)

        ));

    }

    

}
