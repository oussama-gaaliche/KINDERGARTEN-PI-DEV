package tn.esprit.spring.Repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import tn.esprit.spring.entity.Salle;
@Repository
public interface SalleRepository extends CrudRepository<Salle, Integer>{

}
