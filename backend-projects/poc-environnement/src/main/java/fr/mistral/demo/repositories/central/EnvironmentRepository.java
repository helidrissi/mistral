package fr.mistral.demo.repositories.central;

import fr.mistral.demo.domain.central.Environment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EnvironmentRepository extends JpaRepository<Environment,Long> {
}
