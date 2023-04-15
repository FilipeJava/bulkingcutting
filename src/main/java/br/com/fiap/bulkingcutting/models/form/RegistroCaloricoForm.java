package br.com.fiap.bulkingcutting.models.form;

import java.math.BigDecimal;
import java.time.LocalDate;

import br.com.fiap.bulkingcutting.models.Tipo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RegistroCaloricoForm {

    private Long usuarioId;

    private Tipo tipo;

    private String descricao;

    private LocalDate data;

    private BigDecimal calorias;

   


}
