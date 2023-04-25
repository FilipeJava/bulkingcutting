package br.com.fiap.bulkingcutting.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Mapaconfig {

    @Bean
    ModelMapper modelMapper() {
        return new ModelMapper();
    }

}