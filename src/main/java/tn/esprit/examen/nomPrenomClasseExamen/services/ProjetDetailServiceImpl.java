package tn.esprit.examen.nomPrenomClasseExamen.services;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.examen.nomPrenomClasseExamen.entities.ProjetDetail;
import tn.esprit.examen.nomPrenomClasseExamen.repositories.ProjetDetailRepository;
import tn.esprit.examen.nomPrenomClasseExamen.repositories.ProjetRepository;

@Slf4j
@RequiredArgsConstructor
@Service
public class ProjetDetailServiceImpl implements IProjetDetailService {

    ProjetDetailRepository projetDetailRepository;

    @Autowired
    public ProjetDetailServiceImpl(ProjetDetailRepository projetDetailRepository) {
        this.projetDetailRepository = projetDetailRepository;
    }

    @Override
    public ProjetDetail addProjetDetail(ProjetDetail projetDetail) {
        return projetDetailRepository.save(projetDetail);
    }
}
