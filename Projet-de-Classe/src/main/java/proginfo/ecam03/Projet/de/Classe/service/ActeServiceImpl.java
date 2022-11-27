package proginfo.ecam03.Projet.de.Classe.service;

import org.springframework.stereotype.Service;
import proginfo.ecam03.Projet.de.Classe.model.endity.Acte;
import proginfo.ecam03.Projet.de.Classe.repository.ActeRepository;

import java.util.List;
@Service

public class ActeServiceImpl {

    private final ActeRepository acteRepository;


    public ActeServiceImpl(ActeRepository acteRepository) {
        this.acteRepository = acteRepository;
    }

    public Acte save(Acte acte){
        return acteRepository.save(acte);
    }

    public List<Acte> getAllActe() {
        return acteRepository.findAll();
    }
}
