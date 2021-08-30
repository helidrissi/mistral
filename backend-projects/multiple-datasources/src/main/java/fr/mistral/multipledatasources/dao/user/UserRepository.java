package fr.mistral.multipledatasources.dao.user;

import fr.mistral.multipledatasources.domain.user.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface UserRepository extends JpaRepository<User,Long> {
}
