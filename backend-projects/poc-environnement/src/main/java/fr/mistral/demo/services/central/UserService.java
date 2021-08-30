package fr.mistral.demo.services.central;

import fr.mistral.demo.domain.central.UserC;

import java.util.List;

public interface UserService {

    UserC createUser(UserC user);
    List<UserC> getAllUsers();
}
