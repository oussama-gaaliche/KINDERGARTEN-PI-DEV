package tn.esprit.spring.Repository;

import tn.esprit.spring.entity.Ingredient;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface IngredientRepository extends JpaRepository<Ingredient, Integer> {

}
