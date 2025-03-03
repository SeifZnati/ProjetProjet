package tn.esprit.examen.nomPrenomClasseExamen.controllers;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.esprit.examen.nomPrenomClasseExamen.entities.Projet;
import tn.esprit.examen.nomPrenomClasseExamen.services.IProjetService;

import java.util.List;

@Tag(name = "Gestion Projet")
@RestController
@RequestMapping("/projet")
@AllArgsConstructor
public class ProjetRestController {

    @Autowired
    private final IProjetService projetService;

    @GetMapping("/retrieve-all-projets")
    public List<Projet> getProjets() {
        return projetService.retrieveAllProjects();
    }

    @GetMapping("/retrieve-projet/{projet-id}")
    public Projet retrieveProjet(@PathVariable("projet-id") long projetId) {
        return projetService.retrieveProjet(projetId);
    }

    @PostMapping("/add-projet")
    public Projet addProjet(@RequestBody Projet projet) {
        return projetService.addProjet(projet);
    }

    @DeleteMapping("/remove-projet/{projet-id}")
    public void removeProjet(@PathVariable("projet-id") long projetId) {
        projetService.removeProjet(projetId);
    }

    @PutMapping("/modify-projet")
    public Projet modifyProjet(@RequestBody Projet projet) {
        return projetService.modifyProjet(projet);
    }

    @PostMapping("/ajouter-projet-et-projet-detail")
    public Projet addProjetAndProjetDetail(@RequestBody Projet p) {
        Projet projet = projetService.addProjetAndProjetDetailAndAssign(p);
        return projet;
    }

    @PutMapping("affecter-projet-a-projet-details/{projet-id}/{projet-details-id}")
    public void affecterProjetaProjetDetail(@PathVariable("projet-id") long projetId,
                                            @PathVariable("projet-details-id") long projetDetailId) {
        projetService.assignProjetDetailToProjet(projetId, projetDetailId);
    }

    @PostMapping("creer-projet-et-affecter-projet-detail-a-projet/{projet-details-id}")
    public Projet creerProjetEtAffecterProjetDetailAProjet(@RequestBody Projet projet,
                                                           @PathVariable("projet-details-id") long projetDetailId) {
        return projetService.addProjetAndAssignProjetToProjetDetail(projet, projetDetailId);
    }

    @PutMapping("desaffecter-projet-detail-de-projet/{projet-id}")
    public Projet desaffecterProjetDetalDeProjet(@PathVariable("projet-id") long projetId) {
        return projetService.DesaffecterProjetDetalFromProjet(projetId);
    }

    @PutMapping("desaffecter-projets-de-equipe/{equipe-id}")
    public List<Projet> desaffecterProjetsDeEquipe(
            @PathVariable("equipe-id") long equipeId,
            @RequestParam("projetIds") List<Long> projetIds) {
        return projetService.desaffecterProjetsDeEquipe(projetIds, equipeId);
    }

}

