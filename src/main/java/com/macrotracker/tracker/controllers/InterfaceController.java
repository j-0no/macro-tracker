package com.macrotracker.tracker.controllers;

import com.macrotracker.tracker.repositories.AlimentoRepository;
import com.macrotracker.tracker.services.MacroCalculatorService;
import jakarta.validation.Valid;
import org.springframework.ui.Model;
import com.macrotracker.tracker.entities.Alimento;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
public class InterfaceController {

    private final MacroCalculatorService macroCalculator;
    List<Alimento> listaDoDia = new ArrayList<>();

    private final AlimentoRepository alimentoRepository;

    public InterfaceController(MacroCalculatorService macroCalculator, AlimentoRepository alimentoRepository) {
        this.macroCalculator = macroCalculator;
        this.alimentoRepository = alimentoRepository;
    }


    @PostMapping("/interface")
    public String salvarAlimento(@Valid @ModelAttribute("alimento") Alimento alimento) {
        alimentoRepository.save(alimento);
        return "redirect:/interface";
    }


    @GetMapping("/interface")
    public String mostrarPagina(Model model) {
        List<Alimento> lista = alimentoRepository.findAll();
        model.addAttribute("alimentos", lista);
        model.addAttribute("alimento", new Alimento());
        model.addAttribute("listaDoDia",listaDoDia);

        double totalCalorias = macroCalculator.calcularTotalCalorias(listaDoDia);
        double totalProteinas =   macroCalculator.calcularTotalProteinas(listaDoDia);
        double totalCarboidratos =  macroCalculator.calcularTotalCarboidratos(listaDoDia);
        double totalGorduras =  macroCalculator.calcularTotalGorduras(listaDoDia);

        model.addAttribute("totalCalorias", totalCalorias);
        model.addAttribute("totalProteinas", totalProteinas);
        model.addAttribute("totalCarboidratos", totalCarboidratos);
        model.addAttribute("totalGorduras", totalGorduras);

        return "interface";
    }


     @PostMapping("/interface/adicionar-dia")
     public String salvarAlimento(@RequestParam List<Long> ids) {
         listaDoDia.addAll(alimentoRepository.findAllById(ids));
         System.out.println(listaDoDia);
         return "redirect:/interface";
    }

}