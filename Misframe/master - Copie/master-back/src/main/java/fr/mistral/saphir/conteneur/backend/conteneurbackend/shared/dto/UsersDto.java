package fr.mistral.saphir.conteneur.backend.conteneurbackend.shared.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@ToString
@NoArgsConstructor
@AllArgsConstructor
@Data
public class UsersDto {

    private long id;
    private String userId;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private String environement;


    private String avatar;
    private Boolean admin;
    private String encryptedPassword;
    //private String emailVerificationToken;
    //private Boolean emailVerificationStatus = false;

}
