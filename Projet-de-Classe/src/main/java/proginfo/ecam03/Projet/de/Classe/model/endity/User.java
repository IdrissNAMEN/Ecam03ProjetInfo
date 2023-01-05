package proginfo.ecam03.Projet.de.Classe.model.endity;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

import java.util.Set;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "user_id")
    private long user_id;

    @Email(message = "email")
    @NotEmpty(message = "*please provide an email")
    @Column(name = "email")
    private String email;

    @Column(name = "password")
    private String password;
    @Column(name = "name")
    @NotEmpty(message = "please provide your name")
    private String name;
    @Column(name = "last_name")
    @NotEmpty(message = "please provide your last name")
    private String lastName;
    @Column(name = "active")
    private int active;
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "user_role", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> roles;

}
