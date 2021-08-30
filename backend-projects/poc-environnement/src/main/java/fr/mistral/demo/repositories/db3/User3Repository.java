package fr.mistral.demo.repositories.db3;




//Repository est une interface qui herite de CrudRepository qui contient par default un ensembles de methodes predefinis genre findAll(),findById,sav() .......

import fr.mistral.demo.domain.db3.User3;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface User3Repository extends JpaRepository<User3, Long> {


}
