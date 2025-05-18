package com.macrotracker.tracker.entities;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
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
    @NotBlank(message = "Calories is mandatory and diferent than 0")
    @Column(name = "calorias")
    private Double calorias;

    @NotBlank(message = "Proteins is mandatory")
    @Column(name = "proteinas")
    private Double proteinas;

    @NotBlank(message = "Carbs is mandatory")
    @Column(name = "carboidratos")
    private Double carboidratos;

    @NotBlank(message = "Fats is mandatory")
    @Column(name = "gorduras")
    private Double gorduras;

    public Alimento() {}

}