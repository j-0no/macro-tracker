package com.macrotracker.tracker.entities;
import lombok.AllArgsConstructor;
import lombok.Data;
import jakarta.persistence.*;
import lombok.NoArgsConstructor;

@Entity
@Data
public class Alimento {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name = "alimento_id")
    private Long id;

    @Column(name = "nome")
    private String nome;
    @Column(name = "calorias")
    private Double calorias;

    @Column(name = "proteinas")
    private Double proteinas;

    @Column(name = "carboidratos")
    private Double carboidratos;

    @Column(name = "gorduras")
    private Double gorduras;

    public Alimento() {}

    public Alimento(String frango, int i, int i1, int i2) {
    }
}

