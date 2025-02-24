package tn.esprit.examen.nomPrenomClasseExamen.services;

import tn.esprit.examen.nomPrenomClasseExamen.entities.Equipe;

import java.util.List;

public interface IEquipeService {
    List<Equipe> retrieveAllEquipes();

    Equipe retrieveEquipe(Long id);

    Equipe addEquipe(Equipe equipe);

    void removeEquipe(Long id);

    Equipe modifyEquipe(Equipe equipe);

    void assignProjetToEquipe(Long projetId, Long equipeId);
    }
