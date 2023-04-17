package br.com.fiap.bulkingcutting.models.form;

import java.math.BigDecimal;

import br.com.fiap.bulkingcutting.models.Objetivo;
import br.com.fiap.bulkingcutting.models.Sexo;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DadosUserForm {

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

    @NotNull
    private Sexo sexo;

    @NotNull
    private Objetivo objetivo;

    @NotNull
    @Min(value = 0, message = "Valor mínimo de peso é 0")
    private BigDecimal peso;

    @NotNull
    @Min(value = 0, message = "Valor mínimo de altura é 0")
    private Integer altura;

    



}
