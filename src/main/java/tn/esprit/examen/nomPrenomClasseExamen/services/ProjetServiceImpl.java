package tn.esprit.examen.nomPrenomClasseExamen.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.examen.nomPrenomClasseExamen.entities.Projet;
import tn.esprit.examen.nomPrenomClasseExamen.entities.ProjetDetail;
import tn.esprit.examen.nomPrenomClasseExamen.repositories.ProjetDetailRepository;
import tn.esprit.examen.nomPrenomClasseExamen.repositories.ProjetRepository;

import java.util.List;

@Service
public class ProjetServiceImpl implements IProjetService {

    private final ProjetRepository projetRepository;
    private final ProjetDetailRepository projetDetailRepository;

    @Autowired
    public ProjetServiceImpl(ProjetRepository projetRepository, ProjetDetailRepository projetDetailRepository) {
        this.projetRepository = projetRepository;
        this.projetDetailRepository = projetDetailRepository;
    }

    @Override
    public List<Projet> retrieveAllProjects() {
        return projetRepository.findAll();
    }

    @Override
    public Projet retrieveProjet(Long id) {
        return projetRepository.findById(id).orElse(null);
    }

    @Override
    public Projet addProjet(Projet projet) {
        return projetRepository.save(projet);
    }

    @Override
    public void removeProjet(Long projetId) {
        projetRepository.deleteById(projetId);
    }

    @Override
    public Projet modifyProjet(Projet projet) {
        return projetRepository.save(projet);
    }

    @Override
    public Projet addProjetAndProjetDetailAndAssign(Projet projet)
    {
        return projetRepository.save(projet);
    }
    @Override
    public void assignProjetDetailToProjet(Long projetId, Long projetDetailId) {
        Projet projet = projetRepository.findById(projetId).get();
        ProjetDetail projetDetail = projetDetailRepository.findById(projetDetailId).get();
        projet.setProjetDetail(projetDetail);
        projetRepository.save(projet);
    }
}

