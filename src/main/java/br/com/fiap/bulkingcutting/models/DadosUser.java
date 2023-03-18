package br.com.fiap.bulkingcutting.models;

import java.math.BigDecimal;

public class DadosUser {

    private Long id;
    private String nome;
    private Integer idade;
    private String email;
    private String senha;
    private Sexo sexo;
    private Objetivo objetivo;
    private BigDecimal peso;
    private Integer altura;
    
    public DadosUser(Long id, String nome, Integer idade, String email, String senha, Sexo sexo, Objetivo objetivo,
            BigDecimal peso, Integer altura) {
        this.id = id;
        this.nome = nome;
        this.idade = idade;
        this.email = email;
        this.senha = senha;
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


    public String getNome() {
        return nome;
    }


    public Integer getIdade() {
        return idade;
    }


    public Sexo getSexo() {
        return sexo;
    }


    public Objetivo getObjetivo() {
        return objetivo;
    }


    public BigDecimal getPeso() {
        return peso;
    }


    public Integer getAltura() {
        return altura;
    }






    public Long getId() {
        return id;
    }






    public void setId(Long id) {
        this.id = id;
    }






    public String getEmail() {
        return email;
    }






    public void setEmail(String email) {
        this.email = email;
    }






    public String getSenha() {
        return senha;
    }






    public void setSenha(String senha) {
        this.senha = senha;
    }

    
    
    
    
    


    
}