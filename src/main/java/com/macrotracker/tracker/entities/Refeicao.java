package com.macrotracker.tracker.entities;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Refeicao {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    String name;

    @OneToMany(mappedBy = "refeicao")
    private List<Alimento> alimentos = new ArrayList<>();

}