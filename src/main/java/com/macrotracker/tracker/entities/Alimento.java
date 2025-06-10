package com.macrotracker.tracker.entities;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import jakarta.persistence.*;
import lombok.NoArgsConstructor;

@Entity
@Data
public class Alimento {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @NotBlank(message = "Name is mandatory")
    @Column(name = "nome")
    private String nome;

    @Min(1) 
    @NotNull(message = "Calories is mandatory and diferent than 0")
    @Column(name = "calorias")
    private Double calorias;

    @NotNull(message = "Proteins is mandatory")
    @Column(name = "proteinas")
    private Double proteinas;

    @NotNull(message = "Carbs is mandatory")
    @Column(name = "carboidratos")
    private Double carboidratos;

    @NotNull(message = "Fats is mandatory")
    @Column(name = "gorduras")
    private Double gorduras;

    public Alimento() {}

    @ManyToOne
    @JoinColumn(name = "refeicao_id")
    private Refeicao refeicao;
}