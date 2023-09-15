package br.com.fiap.bulkingcutting.models.form;

import java.math.BigDecimal;

import br.com.fiap.bulkingcutting.models.Objetivo;
import br.com.fiap.bulkingcutting.models.Sexo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DadosUserResposta {

    private Long id;

    private String nome;

    private Integer idade;

    private String email;

    private Sexo sexo;

    private Objetivo objetivo;

    private BigDecimal peso;

    private Integer altura;

}