package fr.misral.master.security.master.bootstrap;

import fr.misral.master.security.master.domain.Authority;
import fr.misral.master.security.master.domain.User;
import fr.misral.master.security.master.repositories.AuthorityRepository;
import fr.misral.master.security.master.repositories.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;


@ComponentScan({"fr.mistral.master.sec.*"})
@EnableJpaRepositories("fr.mistral.master.sec.repositories")
@EnableAutoConfiguration
@EntityScan("fr.mistral.master.sec.domain")
@Component
@AllArgsConstructor
public class Bootstrap implements CommandLineRunner {

    private final AuthorityRepository authorityRepository;
    private final UserRepository userRepository;
    private final BCryptPasswordEncoder passwordEncoder;

    private void loadSecurityData() {
        Authority admin = authorityRepository.save(Authority.builder().role("ROLE_ADMIN").build());
        Authority userRole = authorityRepository.save(Authority.builder().role("ROLE_USER").build());
        Authority customer = authorityRepository.save(Authority.builder().role("ROLE_CUSTOMER").build());

        userRepository.save(User.builder()
                .email("spring")
                .password(passwordEncoder.encode("guru"))
                .authority(admin)
                .build());

        userRepository.save(User.builder()
                .email("user")
                .password(passwordEncoder.encode("password"))
                .authority(userRole)
                .build());

        userRepository.save(User.builder()
                .email("scott")
                .password(passwordEncoder.encode("tiger"))
                .authority(customer)
                .build());


    }

    @Override
    public void run(String... args) throws Exception {
        if (authorityRepository.count() == 0) {
            loadSecurityData();
        }
    }
}
