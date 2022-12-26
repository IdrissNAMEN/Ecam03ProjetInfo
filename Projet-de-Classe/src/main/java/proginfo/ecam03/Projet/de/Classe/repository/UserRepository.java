package proginfo.ecam03.Projet.de.Classe.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import proginfo.ecam03.Projet.de.Classe.model.endity.User;

@Repository("userRepository")
public interface UserRepository extends JpaRepository<User, Long>{
    User findByEmail(String email);
}
