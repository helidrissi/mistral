package fr.mistral.demo.domain.central;

import com.fasterxml.jackson.annotation.JsonIgnore;
import fr.mistral.demo.domain.db1.Agence1;
import fr.mistral.demo.domain.db2.Agence2;
import fr.mistral.demo.domain.db3.Societe;
import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class UserC {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    @JsonIgnore
    @ManyToMany(cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
    @JoinTable(name = "user_environment",
            joinColumns = {@JoinColumn(name = "USER_ID", referencedColumnName = "ID")},
            inverseJoinColumns = {@JoinColumn(name = "environment_ID", referencedColumnName = "ID")})
    private Set<Environment> environments=new HashSet<>();
//    @OneToOne(mappedBy = "user")
//    private Agence1 agence1;

//    @Singular
//    @OneToMany(mappedBy="usr")
//    private Set<Societe> societes;



}
