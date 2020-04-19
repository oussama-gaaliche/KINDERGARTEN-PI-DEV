package tn.esprit.spring.Repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import tn.esprit.spring.entity.Event;
@Repository
public interface EventRepository extends CrudRepository<Event, Integer> {

}
