package com.macrotracker.tracker.controllers;

import com.macrotracker.tracker.entities.Alimento;
import com.macrotracker.tracker.repositories.AlimentoRepository;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/alimentos")
public class AlimentoController {

    private final AlimentoRepository repository;

    public AlimentoController(@Valid AlimentoRepository repository) {
        this.repository = repository;
    }

    @PostMapping
    public Alimento addAlimento(@Valid @RequestBody Alimento alimento) {
        return repository.save(alimento);
    }

    @GetMapping
    public List<Alimento> listAlimento() {
        return repository.findAll();
    }
}