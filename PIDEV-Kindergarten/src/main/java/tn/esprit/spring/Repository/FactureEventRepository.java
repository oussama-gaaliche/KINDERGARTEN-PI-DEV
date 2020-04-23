package tn.esprit.spring.Repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import tn.esprit.spring.entity.FactureEvent;
@Repository
public interface FactureEventRepository extends CrudRepository<FactureEvent, Integer> {

}
