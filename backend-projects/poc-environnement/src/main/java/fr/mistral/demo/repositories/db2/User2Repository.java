package fr.mistral.demo.repositories.db2;


import fr.mistral.demo.domain.db2.User2;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface User2Repository extends JpaRepository<User2,Long> {
}
