package tn.esprit.spring.Repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import tn.esprit.spring.entity.Stock_interne;
@Repository
public interface Stock_interneRepository  extends CrudRepository<Stock_interne, Integer>{

}
