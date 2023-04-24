package br.com.fiap.bulkingcutting.models.form;

import java.math.BigDecimal;
import java.time.LocalDate;

import org.springframework.data.domain.Pageable;
import org.springframework.hateoas.EntityModel;

import br.com.fiap.bulkingcutting.controllers.RegistroCaloricoController;
import br.com.fiap.bulkingcutting.models.RegistroCalorico;
import br.com.fiap.bulkingcutting.models.Tipo;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RegistroCaloricoForm {

    private Long usuarioId;

    @NotNull
    private Tipo tipo;

    @NotBlank
    @Size(min = 1, max = 100)
    private String descricao;
    @NotNull
    private LocalDate data;

    @NotNull
    @Min(value = 0, message = "Valor mínimo de calorias é 0")
    private BigDecimal calorias;

}
