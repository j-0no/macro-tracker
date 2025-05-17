package com.macrotracker.tracker.controllers;

import com.macrotracker.tracker.repositories.AlimentoRepository;
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

    //List<Long> ids = new ArrayList<>();
    List<Alimento> listaDoDia = new ArrayList<>();

    private final AlimentoRepository alimentoRepository;

    public InterfaceController(AlimentoRepository alimentoRepository) {
        this.alimentoRepository = alimentoRepository;
    }


    @PostMapping("/interface")
    public String salvarAlimento(@ModelAttribute("alimento") Alimento alimento) {
        alimentoRepository.save(alimento);
        return "redirect:/interface";
    }


    @GetMapping("/interface")
    public String mostrarPagina(Model model) {
        List<Alimento> lista = alimentoRepository.findAll();
        model.addAttribute("alimentos", lista);
        model.addAttribute("alimento", new Alimento());
        model.addAttribute("listaDoDia",listaDoDia);

        double totalCalorias = listaDoDia.stream().mapToDouble(Alimento::getCalorias).sum();
        double totalProteinas = listaDoDia.stream().mapToDouble(Alimento::getProteinas).sum();
        double totalCarboidratos = listaDoDia.stream().mapToDouble(Alimento::getCarboidratos).sum();
        double totalGorduras = listaDoDia.stream().mapToDouble(Alimento::getGorduras).sum();

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