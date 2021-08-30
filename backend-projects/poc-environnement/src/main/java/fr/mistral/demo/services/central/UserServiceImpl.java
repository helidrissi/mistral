package fr.mistral.demo.services.central;

import fr.mistral.demo.domain.central.UserC;
import fr.mistral.demo.repositories.central.UserCRepository;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService, UserDetailsService {

    private final UserCRepository userRepository;

    public UserServiceImpl(UserCRepository userRepository) {
        this.userRepository = userRepository;
    }


    @Override
    public UserC createUser(UserC user) {
        return saveAndReturn(user);
    }


    private UserC saveAndReturn(UserC user) {

        UserC savedUser = userRepository.save(user);


        return savedUser;
    }

    @Override
    public List<UserC> getAllUsers() {
        return userRepository.findAll()
                .stream()
                .collect(Collectors.toList());
    }


    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        int index = email.indexOf("/");
        String group = email.substring(index + 1);
        int foo = Integer.parseInt(group);
        System.out.println("...............here I'am"+foo);
        email = email.substring(0, index);
        UserC appUser = userRepository.findOneByInterval(email,foo);


        if (appUser == null) {
            throw new UsernameNotFoundException(email);
        }


        return new User(appUser.getEmail(), appUser.getPassword(), new ArrayList<>());
    }
}
