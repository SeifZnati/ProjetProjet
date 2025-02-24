package tn.esprit.examen.nomPrenomClasseExamen.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.examen.nomPrenomClasseExamen.entities.Equipe;
import tn.esprit.examen.nomPrenomClasseExamen.entities.Projet;
import tn.esprit.examen.nomPrenomClasseExamen.repositories.EquipeRepository;
import tn.esprit.examen.nomPrenomClasseExamen.repositories.ProjetRepository;

import java.util.List;

@Service
public class EquipeServiceImpl implements IEquipeService { // Fixed class name

    private final EquipeRepository equipeRepository;
    private final ProjetRepository projetRepository;

    @Autowired
    public EquipeServiceImpl(EquipeRepository equipeRepository, ProjetRepository projetRepository) { // Fixed constructor name
        this.equipeRepository = equipeRepository;
        this.projetRepository = projetRepository;
    }

    @Override
    public List<Equipe> retrieveAllEquipes() {
        return equipeRepository.findAll();
    }

    @Override
    public Equipe retrieveEquipe(Long id) {
        return equipeRepository.findById(id).orElse(null);
    }

    @Override
    public Equipe addEquipe(Equipe equipe) {
        return equipeRepository.save(equipe);
    }

    @Override
    public void removeEquipe(Long id) {
        equipeRepository.deleteById(id);
    }

    @Override
    public Equipe modifyEquipe(Equipe equipe) {
        return equipeRepository.save(equipe);
    }

    @Override
    public void assignProjetToEquipe(Long projetId, Long equipeId) {
        Projet projet = projetRepository.findById(projetId).get();
        Equipe equipe = equipeRepository.findById(equipeId).get();
        equipe.getProjets().add(projet);
        equipeRepository.save(equipe);
    }
}
