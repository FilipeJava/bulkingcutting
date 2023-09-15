package br.com.fiap.bulkingcutting.config;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import br.com.fiap.bulkingcutting.models.DadosUser;
import br.com.fiap.bulkingcutting.models.Objetivo;
import br.com.fiap.bulkingcutting.models.RegistroCalorico;
import br.com.fiap.bulkingcutting.models.Sexo;
import br.com.fiap.bulkingcutting.models.Tipo;
import br.com.fiap.bulkingcutting.repository.DadosUserRepository;
import br.com.fiap.bulkingcutting.repository.RegistroCaloricoRepository;

@Configuration
public class DatabaseSeeder implements CommandLineRunner {

  @Autowired
  DadosUserRepository dadosUserRepository;

  @Autowired
  RegistroCaloricoRepository registroCaloricoRepository;

  List<RegistroCalorico> registroCaloricos = new ArrayList<>();

  @Override
  public void run(String... args) throws Exception {

    DadosUser user1 = new DadosUser(1L, "João", 20, "jo@jao.com.br", "teste", Sexo.MASCULINO, Objetivo.GANHO_MUSCULO,
        new BigDecimal(80), 180, registroCaloricos);

    DadosUser user2 = new DadosUser(2L, "Maria", 17, "ma@mah.com.br", "teste", Sexo.FEMININO, Objetivo.PERDA_PESO,
        new BigDecimal(60), 160, registroCaloricos);

    dadosUserRepository.saveAll(List.of(user1, user2));

    registroCaloricoRepository.saveAll(List.of(

        // Registros Caloricos do João
        RegistroCalorico.builder().tipo(Tipo.REFEICAO).descricao("Almoco").data(LocalDate.now())
            .calorias(new BigDecimal(450)).usuario(user1).build(),
        RegistroCalorico.builder().tipo(Tipo.REFEICAO).descricao("Cafe da Manha").data(LocalDate.now())
            .calorias(new BigDecimal(350)).usuario(user1).build(),
        RegistroCalorico.builder().tipo(Tipo.REFEICAO).descricao("Janta").data(LocalDate.now())
            .calorias(new BigDecimal(150)).usuario(user1).build(),
        RegistroCalorico.builder().tipo(Tipo.REFEICAO).descricao("Ceia").data(LocalDate.now())
            .calorias(new BigDecimal(100)).usuario(user1).build(),
      

        // Registros Caloricos da Maria

        RegistroCalorico.builder().tipo(Tipo.REFEICAO).descricao("Arroz").data(LocalDate.now())
            .calorias(new BigDecimal(100)).usuario(user2).build(),
        RegistroCalorico.builder().tipo(Tipo.REFEICAO).descricao("Arroz").data(LocalDate.now())
            .calorias(new BigDecimal(100)).usuario(user2).build(),
        RegistroCalorico.builder().tipo(Tipo.REFEICAO).descricao("Arroz").data(LocalDate.now())
            .calorias(new BigDecimal(100)).usuario(user2).build(),
        RegistroCalorico.builder().tipo(Tipo.REFEICAO).descricao("Arroz").data(LocalDate.now())
            .calorias(new BigDecimal(100)).usuario(user2).build(),
        RegistroCalorico.builder().tipo(Tipo.REFEICAO).descricao("Arroz").data(LocalDate.now())
            .calorias(new BigDecimal(100)).usuario(user2).build(),
        RegistroCalorico.builder().tipo(Tipo.REFEICAO).descricao("Arroz").data(LocalDate.now())
            .calorias(new BigDecimal(100)).usuario(user2).build(),
        RegistroCalorico.builder().tipo(Tipo.REFEICAO).descricao("Arroz").data(LocalDate.now())
            .calorias(new BigDecimal(100)).usuario(user2).build(),
        RegistroCalorico.builder().tipo(Tipo.REFEICAO).descricao("Arroz").data(LocalDate.now())
            .calorias(new BigDecimal(100)).usuario(user2).build(),
        RegistroCalorico.builder().tipo(Tipo.REFEICAO).descricao("Arroz").data(LocalDate.now())
            .calorias(new BigDecimal(100)).usuario(user2).build(),
        RegistroCalorico.builder().tipo(Tipo.REFEICAO).descricao("Arroz").data(LocalDate.now())
            .calorias(new BigDecimal(100)).usuario(user2).build(),
        RegistroCalorico.builder().tipo(Tipo.REFEICAO).descricao("Arroz").data(LocalDate.now())
            .calorias(new BigDecimal(100)).usuario(user2).build(),
        RegistroCalorico.builder().tipo(Tipo.REFEICAO).descricao("Arroz").data(LocalDate.now())
            .calorias(new BigDecimal(100)).usuario(user2).build(),
        RegistroCalorico.builder().tipo(Tipo.REFEICAO).descricao("Arroz").data(LocalDate.now())
            .calorias(new BigDecimal(100)).usuario(user2).build()

    ));
  }

}
