package fr.mistral.demo.repositories.db1;


import fr.mistral.demo.domain.db1.User1;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

//Repository est une interface qui herite de CrudRepository qui contient par default un ensembles de methodes predefinis genre findAll(),findById,sav() .......

@Repository
public interface User1Repository extends JpaRepository<User1, Long> {


}
