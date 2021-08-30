package fr.mistral.demo.repositories.db3;

import fr.mistral.demo.domain.db3.Societe;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SocieteRepository extends JpaRepository<Societe,Long> {
}
