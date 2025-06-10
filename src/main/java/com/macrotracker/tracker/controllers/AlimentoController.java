package com.macrotracker.tracker.controllers;

import com.macrotracker.tracker.entities.Alimento;
import com.macrotracker.tracker.repositories.AlimentoRepository;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

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

    @DeleteMapping("/alimentos/{id}")
    public ResponseEntity<Void> deletarAlimento(@PathVariable Long id) {
        Optional<Alimento> alimentoExiste = repository.findById(id);

        if (alimentoExiste.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        repository.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> atualizar(
            @PathVariable Long id,
            @Valid @RequestBody Alimento novoAlimento
    ) {
        Optional<Alimento> alimentoExiste = repository.findById(id);

        if (alimentoExiste.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        Alimento alimentoAtual = alimentoExiste.get();

        alimentoAtual.setNome(novoAlimento.getNome());
        alimentoAtual.setCalorias(novoAlimento.getCalorias());
        alimentoAtual.setProteinas(novoAlimento.getProteinas());
        alimentoAtual.setGorduras(novoAlimento.getGorduras());

        repository.save(alimentoAtual);
        return ResponseEntity.ok(alimentoAtual);

    }
}