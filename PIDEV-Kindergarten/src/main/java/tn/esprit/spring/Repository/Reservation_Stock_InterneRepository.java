package tn.esprit.spring.Repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import tn.esprit.spring.entity.Reservation_Stock_Interne;
@Repository
public interface Reservation_Stock_InterneRepository extends CrudRepository<Reservation_Stock_Interne, Integer>{

}
