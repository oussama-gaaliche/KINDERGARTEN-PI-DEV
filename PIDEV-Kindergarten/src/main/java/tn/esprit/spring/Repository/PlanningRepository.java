package tn.esprit.spring.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tn.esprit.spring.entity.Planning;


@Repository
public interface PlanningRepository extends JpaRepository<Planning, Integer> {

}
