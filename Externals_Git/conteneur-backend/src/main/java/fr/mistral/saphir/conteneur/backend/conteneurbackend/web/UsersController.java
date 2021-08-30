package fr.mistral.saphir.conteneur.backend.conteneurbackend.web;


import fr.mistral.saphir.conteneur.backend.conteneurbackend.exceptions.RecordNotFoundException;
import fr.mistral.saphir.conteneur.backend.conteneurbackend.requests.UsersRequest;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UsersController {

    @PostMapping
    public ResponseEntity<UsersRequest> createOrUpdateEmployee(UsersRequest users)
            throws RecordNotFoundException {
        ModelMapper modelMapper = new ModelMapper();
        UserDto userDto = modelMapper.map(userRequest, UserDto.class);

        UserDto createUser = userService.createUser(userDto);

        UserResponse userResponse =  modelMapper.map(createUser, UserResponse.class);

        return new ResponseEntity<UserResponse>(userResponse, HttpStatus.CREATED);
    }
}
