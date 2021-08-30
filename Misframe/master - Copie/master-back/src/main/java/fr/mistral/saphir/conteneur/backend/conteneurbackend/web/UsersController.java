package fr.mistral.saphir.conteneur.backend.conteneurbackend.web;


import fr.mistral.saphir.conteneur.backend.conteneurbackend.dao.UsersRepository;
import fr.mistral.saphir.conteneur.backend.conteneurbackend.entities.UsersEntity;
import fr.mistral.saphir.conteneur.backend.conteneurbackend.requests.UsersRequest;
import fr.mistral.saphir.conteneur.backend.conteneurbackend.responses.UsersResponse;
import fr.mistral.saphir.conteneur.backend.conteneurbackend.services.UserService;
import fr.mistral.saphir.conteneur.backend.conteneurbackend.shared.dto.UsersDto;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UsersController {
    @Autowired
    UsersRepository usersRepository;
    @Autowired
    UserService userService;

    @PostMapping
    public ResponseEntity<UsersResponse> createUsers(@RequestBody UsersRequest users) {
        ModelMapper modelMapper = new ModelMapper();
        UsersDto userDto = modelMapper.map(users, UsersDto.class);


        UsersDto createUser = userService.createUser(userDto);

        UsersResponse userResponse = modelMapper.map(createUser, UsersResponse.class);

        return new ResponseEntity<UsersResponse>(userResponse, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<UsersEntity>> getAllEUsers() {
        List<UsersEntity> list = userService.getAllUsers();

        return new ResponseEntity<List<UsersEntity>>(list, new HttpHeaders(), HttpStatus.OK);
    }


    @GetMapping("/{userId}")
    public UsersEntity one(@PathVariable String userId) {

        return usersRepository.findByUserId(userId);
    }


}
