package fr.mistral.saphir.conteneur.backend.conteneurbackend.dao;


import fr.mistral.saphir.conteneur.backend.conteneurbackend.entities.UsersEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface UsersRepository extends CrudRepository<UsersEntity, Long> {


    UsersEntity findByEmail(String email);

    UsersEntity findByUserId(String uid);
}
