package fr.mistral.saphir.conteneur.backend.conteneurbackend.requests;


import lombok.Data;

@Data
public class UsersRequest {


    private String firstName;
    private String lastName;
    private String email;
    private String password;
}
