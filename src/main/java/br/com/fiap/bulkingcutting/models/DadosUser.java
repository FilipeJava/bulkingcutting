package br.com.fiap.bulkingcutting.models;

import java.math.BigDecimal;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;


@Entity
public class DadosUser {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String nome;

    @NotNull
    @Min(value = 0, message = "Valor mínimo de idade é 0")
    private Integer idade;

    @NotBlank
    @Email    
    private String email;

    @NotBlank
    private String senha;

    @Enumerated(EnumType.STRING)
    @NotNull
    private Sexo sexo;

    @Enumerated(EnumType.STRING)
    @NotNull
    private Objetivo objetivo;

    @NotNull
    @Min(value = 0, message = "Valor mínimo de peso é 0")
    private BigDecimal peso;

    @NotNull
    @Min(value = 0, message = "Valor mínimo de peso é 0")
    private Integer altura;


    public DadosUser() {
    }

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


    @Override
    public String toString() {
        // TODO Auto-generated method stub
        return "DadosUser [altura=" + altura + ", email=" + email + idade + ", nome=" + nome
                + ", objetivo=" + objetivo + ", peso=" + peso + ", sexo=" + sexo+"]";
    }


}