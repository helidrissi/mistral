package fr.mistral.saphir.conteneur.backend.conteneurbackend.responses;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@ToString
@NoArgsConstructor
@AllArgsConstructor
@Data
public class UsersResponse {

    private String userId;
    private String firstName;
    private String lastName;
    private String email;
}
