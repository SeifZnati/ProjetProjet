package tn.esprit.examen.nomPrenomClasseExamen.services;

import tn.esprit.examen.nomPrenomClasseExamen.entities.Projet;

import java.util.List;

public interface IProjetService {
    List<Projet> retrieveAllProjects();

    Projet retrieveProjet(Long id);

    Projet addProjet(Projet projet);

    void removeProjet(Long id);

    Projet modifyProjet(Projet projet);

    Projet addProjetAndProjetDetailAndAssign(Projet projet);

    void assignProjetDetailToProjet(Long projetId, Long projetDetailId);

    Projet addProjetAndAssignProjetToProjetDetail(Projet projet, Long projetDetailId);

    Projet DesaffecterProjetDetalFromProjet(Long projetId);
    List<Projet> desaffecterProjetsDeEquipe(List<Long> projetIds, Long equipeId);
}
