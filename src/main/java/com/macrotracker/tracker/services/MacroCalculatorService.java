package com.macrotracker.tracker.services;

import com.macrotracker.tracker.entities.Alimento;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MacroCalculatorService {

    public double calcularTotalCalorias(List<Alimento> alimentos) {
        return alimentos.stream().mapToDouble(a -> a.getCalorias() != null ? a.getCalorias() : 0.0).sum();
    }
    public double calcularTotalProteinas(List<Alimento> alimentos) {
        return alimentos.stream().mapToDouble(a -> a.getProteinas() != null ? a.getProteinas() : 0.0).sum();
    }
    public double calcularTotalCarboidratos(List<Alimento> alimentos) {
        return alimentos.stream().mapToDouble(a -> a.getCarboidratos() != null ? a.getCarboidratos() : 0.0).sum();
    }
    public double calcularTotalGorduras(List<Alimento> alimentos) {
        return alimentos.stream().mapToDouble(a -> a.getGorduras() != null ? a.getGorduras() : 0.0).sum();
    }

}
