package fr.mistral.demo.repositories.db2;

import fr.mistral.demo.domain.db1.Agence1;
import fr.mistral.demo.domain.db2.Agence2;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Agence2Repository extends JpaRepository<Agence2,Long> {
}
