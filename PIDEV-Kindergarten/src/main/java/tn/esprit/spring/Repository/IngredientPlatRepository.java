package tn.esprit.spring.Repository;

import java.util.Date;
import java.util.List;

import tn.esprit.spring.entity.Ingredient;
import tn.esprit.spring.entity.IngredientPlat;
import tn.esprit.spring.entity.Plat;
import tn.esprit.spring.entity.Repas;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
@Repository
public interface IngredientPlatRepository extends JpaRepository<IngredientPlat, Integer> {
	
	
	 @Query("SELECT DISTINCT ip.plb FROM IngredientPlat ip "
				+ "join ip.plb p  "
				+" where ip.plb=p.id_plat ")
	 public List<Plat> GetIPlat();
	 
	 
	 @Query("SELECT DISTINCT ip.ingredient FROM IngredientPlat ip "
				+ "join ip.ingredient i  "
				 +"join ip.plb p  "
				+" where ip.ingredient=i.id and "
				+ "p.id_plat=:plat")
	 public List<Ingredient> GetIngreidnet(@Param("plat") int plat);
	 
	 
	 @Query("select ip.quantity from IngredientPlat ip "
	 		 +"join ip.plb p  "
	 		 +"join ip.ingredient i  "
			+" where i.id=:ing and " 
	 		 +"p.id_plat=:plat" )
	    public double getQuntityIngredient(@Param("ing") int ing,@Param("plat") int plat);
	

}
