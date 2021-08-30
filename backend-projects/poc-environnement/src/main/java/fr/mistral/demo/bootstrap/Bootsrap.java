package fr.mistral.demo.bootstrap;

import fr.mistral.demo.domain.central.UserC;
import fr.mistral.demo.domain.db1.Agence1;
import fr.mistral.demo.domain.db2.Agence2;
import fr.mistral.demo.domain.db3.Societe;
import fr.mistral.demo.repositories.central.UserCRepository;
import fr.mistral.demo.repositories.db1.Agence1Repository;
import fr.mistral.demo.repositories.db1.User1Repository;
import fr.mistral.demo.repositories.db2.Agence2Repository;
import fr.mistral.demo.repositories.db2.User2Repository;
import fr.mistral.demo.repositories.db3.SocieteRepository;
import lombok.AllArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@AllArgsConstructor
@Component
public class Bootsrap implements CommandLineRunner {



    private final UserCRepository userCRepository;
    private final Agence1Repository agence1Repository;
    private final Agence2Repository agence2Repository;
    private final SocieteRepository societeRepository;
    private final PasswordEncoder passwordEncoder;
    @Override
    public void run(String... args) throws Exception {

        Agence1 agence1 = agence1Repository.save(Agence1.builder().name("paris").build());
        Agence2 agence2 = agence2Repository.save(Agence2.builder().name("nice").build());
        Societe societe = societeRepository.save(Societe.builder().name("mistral").build());
//        UserC hamza = userCRepository.save(UserC.builder().firstName("hamza")
//                        .lastName("elidrissi").email("hamza@mistral.fr")
//                .password(passwordEncoder.encode("123456"))
//                //.agence1(agence1)
//                //.societe(societe)
//                .build());

    }
}
