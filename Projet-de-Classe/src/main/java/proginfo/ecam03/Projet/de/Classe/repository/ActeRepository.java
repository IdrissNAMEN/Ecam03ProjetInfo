package proginfo.ecam03.Projet.de.Classe.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import proginfo.ecam03.Projet.de.Classe.model.endity.Acte;

import java.util.List;
import java.util.Optional;

public interface ActeRepository extends JpaRepository<Acte, Long> {

}
