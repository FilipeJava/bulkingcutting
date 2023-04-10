package br.com.fiap.bulkingcutting.models;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
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
    @Min(value = 0, message = "Valor mínimo de altura é 0")
    private Integer altura;

    @OneToMany(mappedBy = "dadosUser", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<RegistroCalorico> registrosCaloricos = new ArrayList<>();

    

}