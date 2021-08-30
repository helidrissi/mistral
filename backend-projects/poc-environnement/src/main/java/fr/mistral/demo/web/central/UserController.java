package fr.mistral.demo.web.central;

import fr.mistral.demo.domain.central.UserC;
import fr.mistral.demo.services.central.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(UserController.BASE_URL)
public class UserController {
    public static final String BASE_URL = "/api/v1/users";
    @Autowired
    UserService userService;


    @GetMapping
    public List<UserC> getAllUsers() {

        List<UserC> users = userService.getAllUsers();


        return users;
    }


    @PostMapping
    public ResponseEntity<UserC> createUser(@RequestBody UserC user) throws Exception {


        UserC createUser = userService.createUser(user);


        return new ResponseEntity<UserC>(createUser, HttpStatus.CREATED);

    }
}
