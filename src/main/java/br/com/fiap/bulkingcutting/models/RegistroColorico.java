package br.com.fiap.bulkingcutting.models;

import java.math.BigDecimal;
import java.time.LocalDate;

public class RegistroColorico {

    private Tipo tipo;
    private String descriçãvateo;
    private LocalDate data;
    private BigDecimal calorias;


    public RegistroColorico(Tipo tipo, String descriçãvateo, LocalDate data, BigDecimal calorias) {
        this.tipo = tipo;
        this.descriçãvateo = descriçãvateo;
        this.data = data;
        this.calorias = calorias;
    }


    public Tipo getTipo() {
        return tipo;
    }


    public String getDescriçãvateo() {
        return descriçãvateo;
    }


    public LocalDate getData() {
        return data;
    }


    public BigDecimal getCalorias() {
        return calorias;
    }


    
    
    
    

    
}