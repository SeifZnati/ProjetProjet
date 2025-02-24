package tn.esprit.examen.nomPrenomClasseExamen.controllers;

import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.esprit.examen.nomPrenomClasseExamen.entities.Equipe;
import tn.esprit.examen.nomPrenomClasseExamen.services.IEquipeService;

import java.util.List;

@Tag(name = "Gestion Equipe")
@RestController
@RequestMapping("/equipe")
public class EquipeRestController {

    private final IEquipeService equipeService;

    @Autowired
    public EquipeRestController(IEquipeService equipeService) {
        this.equipeService = equipeService;
    }

    @GetMapping("/retrieve-all-equipes")
    public List<Equipe> getEquipes() {
        return equipeService.retrieveAllEquipes();
    }

    @GetMapping("/retrieve-equipe/{equipe-id}")
    public Equipe retrieveEquipe(@PathVariable("equipe-id") long equipeId) {
        return equipeService.retrieveEquipe(equipeId);
    }

    @PostMapping("/add-equipe")
    public Equipe addEquipe(@RequestBody Equipe equipe) {
        return equipeService.addEquipe(equipe);
    }

    @DeleteMapping("/remove-equipe/{equipe-id}")
    public void removeEquipe(@PathVariable("equipe-id") long equipeId) {
        equipeService.removeEquipe(equipeId);
    }

    @PutMapping("/modify-equipe")
    public Equipe modifyEquipe(@RequestBody Equipe equipe) {
        return equipeService.modifyEquipe(equipe);
    }

    @PutMapping("affecter-projet-a-equipe/{projet-id}/{equipe-id}")
    public void affecterProjetAEquipe(@PathVariable("projet-id") long projetId,
                                      @PathVariable("equipe-id") long equipeId) {
        equipeService.assignProjetToEquipe(projetId, equipeId);
    }
}
