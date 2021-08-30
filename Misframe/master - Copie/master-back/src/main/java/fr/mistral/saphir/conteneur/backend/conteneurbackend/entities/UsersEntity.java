package fr.mistral.saphir.conteneur.backend.conteneurbackend.entities;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

@ToString
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "users")
public class UsersEntity {

    @Id
    @GeneratedValue
    private long id;
    private String userId;
    private String firstName;
    private String lastName;
    private String email;
    private String environement;
    private String encryptedPassword;
    /*@OneToOne(mappedBy = "user")
    private ImageModel image;*/
    private Boolean admin;


}
