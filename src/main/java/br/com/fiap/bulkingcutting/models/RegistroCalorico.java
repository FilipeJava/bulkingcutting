package br.com.fiap.bulkingcutting.models;

import java.math.BigDecimal;
import java.time.LocalDate;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class RegistroCalorico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    @NotNull
    private Tipo tipo; // Enum momentaneo

    @NotBlank
    @Size(min = 1, max = 100)
    private String descricao;

    @NotNull
    private LocalDate data;

    @NotNull
    @Min(value = 0, message = "Valor mínimo de calorias é 0")
    private BigDecimal calorias;

    @ManyToOne
    // @JsonBackReference
    @JoinColumn(name = "usuario_id")
    private DadosUser usuario;

}