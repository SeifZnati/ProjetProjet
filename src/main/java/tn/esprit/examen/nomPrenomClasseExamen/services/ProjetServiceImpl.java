package tn.esprit.examen.nomPrenomClasseExamen.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.examen.nomPrenomClasseExamen.entities.Equipe;
import tn.esprit.examen.nomPrenomClasseExamen.entities.Projet;
import tn.esprit.examen.nomPrenomClasseExamen.entities.ProjetDetail;
import tn.esprit.examen.nomPrenomClasseExamen.repositories.EquipeRepository;
import tn.esprit.examen.nomPrenomClasseExamen.repositories.ProjetDetailRepository;
import tn.esprit.examen.nomPrenomClasseExamen.repositories.ProjetRepository;

import java.util.List;

@Service
public class ProjetServiceImpl implements IProjetService {

    private final ProjetRepository projetRepository;
    private final ProjetDetailRepository projetDetailRepository;
    private final EquipeRepository equipeRepository;

    @Autowired
    public ProjetServiceImpl(ProjetRepository projetRepository, ProjetDetailRepository projetDetailRepository, EquipeRepository equipeRepository) {
        this.projetRepository = projetRepository;
        this.projetDetailRepository = projetDetailRepository;
        this.equipeRepository = equipeRepository;
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

    @Override
    public Projet addProjetAndAssignProjetToProjetDetail(Projet projet,Long projetDetailId) {
        ProjetDetail projetDetail = projetDetailRepository.findById(projetDetailId).get();
        projet.setProjetDetail(projetDetail);
        return projetRepository.save(projet);
    }

    @Override
    public Projet DesaffecterProjetDetalFromProjet(Long projetId) {
        Projet projet = projetRepository.findById(projetId).get();
        projet.setProjetDetail(null);
        return projetRepository.save(projet);
    }

    @Override
    public List<Projet> desaffecterProjetsDeEquipe(List<Long> projetIds, Long equipeId) {
        Equipe equipe = equipeRepository.findById(equipeId).orElseThrow(() -> new RuntimeException("Equipe not found"));
        List<Projet> projetsToRemove = projetRepository.findAllById(projetIds);
        equipe.getProjets().removeAll(projetsToRemove);
        equipeRepository.save(equipe);
        return projetsToRemove;
    }


}

