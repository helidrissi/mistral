package fr.mistral.saphir.conteneur.backend.conteneurbackend.services;


import fr.mistral.saphir.conteneur.backend.conteneurbackend.dao.UsersRepository;
import fr.mistral.saphir.conteneur.backend.conteneurbackend.entities.UsersEntity;
import fr.mistral.saphir.conteneur.backend.conteneurbackend.shared.Utils;
import fr.mistral.saphir.conteneur.backend.conteneurbackend.shared.dto.UsersDto;
import org.modelmapper.ModelMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Transactional
@Service
public class UserService implements UserDetailsService {


    @Autowired
    UsersRepository usersRepository;
    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    Utils utils;

    public UsersDto createUser(UsersDto user) {

        UsersEntity checkUser = usersRepository.findByEmail(user.getEmail());

        if (checkUser != null) throw new RuntimeException("Cet Utilisateur existe dèja !");


        ModelMapper modelMapper = new ModelMapper();

        UsersEntity userEntity = modelMapper.map(user, UsersEntity.class);

        userEntity.setEncryptedPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        userEntity.setUserId(utils.generateStringId(32));

        UsersEntity newUser = usersRepository.save(userEntity);

        UsersDto userDto = modelMapper.map(newUser, UsersDto.class);

        return userDto;
    }


    public ArrayList<UsersEntity> getAllUsers() {
        List<UsersEntity> usersList = (List<UsersEntity>) usersRepository.findAll();

        if (usersList.size() > 0) {
            return (ArrayList<UsersEntity>) usersList;
        } else {
            return new ArrayList<UsersEntity>();
        }
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        UsersEntity usersEntity = usersRepository.findByEmail(email);

        if (usersEntity == null) {
            throw new UsernameNotFoundException(email);
        }

        return new User(usersEntity.getEmail(), usersEntity.getEncryptedPassword(), new ArrayList<>());
    }


    public UsersDto getUser(String email) {

        UsersEntity userEntity = usersRepository.findByEmail(email);

        if (userEntity == null) throw new UsernameNotFoundException(email);

        UsersDto userDto = new UsersDto();

        BeanUtils.copyProperties(userEntity, userDto);

        return userDto;
    }
}
