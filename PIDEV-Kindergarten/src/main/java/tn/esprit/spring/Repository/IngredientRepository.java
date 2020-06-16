package tn.esprit.spring.Repository;

import tn.esprit.spring.entity.Ingredient;
import tn.esprit.spring.entity.Plat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
@Repository
public interface IngredientRepository extends JpaRepository<Ingredient, Integer> {
	 @Query("select i.id from Ingredient i  where i.nom=:nom")
		public int GetId (@Param("nom") String nom);
	 @Query("select i.nom from Ingredient i  where i.id=:id")
		public String GetNom (@Param("id") int id);
	 @Query("select i from Ingredient i  where i.nom=:nom")
		public Ingredient  GETI (@Param("nom") String nom);

}
