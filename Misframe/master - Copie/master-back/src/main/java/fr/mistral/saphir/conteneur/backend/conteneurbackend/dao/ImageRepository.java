package fr.mistral.saphir.conteneur.backend.conteneurbackend.dao;


import fr.mistral.saphir.conteneur.backend.conteneurbackend.entities.ImageModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ImageRepository extends JpaRepository<ImageModel, Long> {

    @Query("SELECT u FROM ImageModel u WHERE u.name = ?1 order by u.id desc")
    List<ImageModel> findByName(String name);
}
