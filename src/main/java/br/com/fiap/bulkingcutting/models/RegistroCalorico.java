package br.com.fiap.bulkingcutting.models;

import java.math.BigDecimal;
import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
public class RegistroCalorico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    @NotNull
    private Tipo tipo; // Enum momentaneo

    @NotBlank
    @Size(min = 5, max = 100)
    private String descricao;

    @NotNull
    private LocalDate data;

    @NotNull
    @Min(value = 0, message = "Valor mínimo de calorias é 0")
    private BigDecimal calorias;

    public RegistroCalorico() {
    }

    public RegistroCalorico(Long id, Tipo tipo, String descricao, LocalDate data, BigDecimal calorias) {
        this.id = id;
        this.tipo = tipo;
        this.descricao = descricao;
        this.data = data;
        this.calorias = calorias;
    }

    public Tipo getTipo() {
        return tipo;
    }

    public String getDescricao() {
        return descricao;
    }

    public LocalDate getData() {
        return data;
    }

    public BigDecimal getCalorias() {
        return calorias;
    }

    public void setTipo(Tipo tipo) {
        this.tipo = tipo;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public void setCalorias(BigDecimal calorias) {
        this.calorias = calorias;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        // TODO Auto-generated method stub
        return "RegistroCalorico [calorias=" + calorias + ", data=" + data + ", descricao=" + descricao + ", id=" + id
                + ", tipo=" + tipo + "]";
    }

}