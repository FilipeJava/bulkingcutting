package br.com.fiap.bulkingcutting.models;

import java.math.BigDecimal;

public class DadosUser {

    private String nome;
    private Integer idade;
    private Sexo sexo;
    private Objetivo objetivo;
    private BigDecimal peso;
    private Integer altura;


    public DadosUser(String nome, Integer idade, Sexo sexo, Objetivo objetivo, BigDecimal peso, Integer altura) {
        this.nome = nome;
        this.idade = idade;
        this.sexo = sexo;
        this.objetivo = objetivo;
        this.peso = peso;
        this.altura = altura;
    }


    public void setNome(String nome) {
        this.nome = nome;
    }


    public void setIdade(Integer idade) {
        this.idade = idade;
    }


    public void setSexo(Sexo sexo) {
        this.sexo = sexo;
    }


    public void setObjetivo(Objetivo objetivo) {
        this.objetivo = objetivo;
    }


    public void setPeso(BigDecimal peso) {
        this.peso = peso;
    }


    public void setAltura(Integer altura) {
        this.altura = altura;
    }

    
    
    
    


    
}