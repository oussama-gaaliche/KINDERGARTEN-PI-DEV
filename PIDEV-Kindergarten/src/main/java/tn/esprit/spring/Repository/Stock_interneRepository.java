<<<<<<< HEAD
package tn.esprit.spring.Repository;

import org.springframework.data.jpa.repository.Query ;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import tn.esprit.spring.entity.Stock_interne;

@Repository
public interface Stock_interneRepository extends CrudRepository<Stock_interne, Integer> {
	
	@Query(value="SELECT s FROM Stock_interne s where s.id= :stock_id")
    public Stock_interne Selectnomstock(@Param("stock_id") int idstock);
	

}
=======
package tn.esprit.spring.Repository;

import org.springframework.data.jpa.repository.Query ;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import tn.esprit.spring.entity.Stock_interne;

@Repository
public interface Stock_interneRepository extends CrudRepository<Stock_interne, Integer> {
	
	@Query(value="SELECT s FROM Stock_interne s where s.id= :stock_id")
    public Stock_interne Selectnomstock(@Param("stock_id") int idstock);
	

}
>>>>>>> branch 'master' of https://github.com/gaaliche22/KINDERGARTEN-PI-DEV.git
