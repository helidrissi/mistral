package fr.mistral.saphir.conteneur.backend.conteneurbackend.requests;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class UsersRequest {


    private String firstName;
    private String lastName;
    private String email;
    private String environement;


    private String password;
    private String avatar;
    private Boolean admin;
}
