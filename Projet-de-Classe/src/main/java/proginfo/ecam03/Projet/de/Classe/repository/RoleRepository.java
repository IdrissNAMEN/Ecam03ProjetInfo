package proginfo.ecam03.Projet.de.Classe.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import proginfo.ecam03.Projet.de.Classe.model.endity.Role;

@Repository("roleRepository")
public interface RoleRepository extends JpaRepository<Role, Integer> {
    Role findByRole(String role);


}
