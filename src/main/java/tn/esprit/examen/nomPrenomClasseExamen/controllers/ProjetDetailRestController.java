package tn.esprit.examen.nomPrenomClasseExamen.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tn.esprit.examen.nomPrenomClasseExamen.entities.ProjetDetail;
import tn.esprit.examen.nomPrenomClasseExamen.services.IProjetDetailService;

@RequiredArgsConstructor
@RequestMapping("/projetDetail")
@RestController
public class ProjetDetailRestController {
    private final IProjetDetailService projetDetailService;

    @PostMapping("/add")
    public ProjetDetail addProjetDetail(@RequestBody ProjetDetail projetDetail) {
        return projetDetailService.addProjetDetail(projetDetail);
    }
}
