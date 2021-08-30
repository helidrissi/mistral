package fr.mistral.demo.repositories.central;

import fr.mistral.demo.domain.central.UserC;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
public interface UserCRepository extends JpaRepository<UserC, Long> {

    UserC findByEmail(String email);





    @Query(value = "SELECT * FROM Userc p , user_environment c  WHERE c.user_id=p.id and p.email= ?1 and c.environment_id = ?2 ",nativeQuery=true)
    UserC findOneByInterval(String email,Integer env) ;
}
