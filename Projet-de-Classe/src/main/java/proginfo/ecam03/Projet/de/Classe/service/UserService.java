package proginfo.ecam03.Projet.de.Classe.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import proginfo.ecam03.Projet.de.Classe.model.endity.Role;
import proginfo.ecam03.Projet.de.Classe.model.endity.User;
import proginfo.ecam03.Projet.de.Classe.repository.RoleRepository;
import proginfo.ecam03.Projet.de.Classe.repository.UserRepository;

import java.util.Arrays;
import java.util.HashSet;

@Service("userService")
public class UserService {


    private  final UserRepository userRepository;
    private final RoleRepository  roleRepository;
    private  final BCryptPasswordEncoder bCryptPasswordEncoder;


    @Autowired
    public  UserService(UserRepository userRepository,
                        RoleRepository roleRepository,
                        BCryptPasswordEncoder bCryptPasswordEncoder){
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    public User findUserByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    public User saverUser(User user) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        user.setActive(1);

        final Role userRole = roleRepository.findByRole("ADMIN");

        user.setRoles(new HashSet<Role>(Arrays.asList(userRole)));


        return userRepository.save(user);
    }

}
