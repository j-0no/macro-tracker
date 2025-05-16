package com.macrotracker.tracker.repositories;

import com.macrotracker.tracker.entities.Alimento;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AlimentoRepository extends JpaRepository<Alimento, Long> {
}
