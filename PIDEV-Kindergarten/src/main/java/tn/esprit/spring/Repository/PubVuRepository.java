package tn.esprit.spring.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import tn.esprit.spring.entity.PubVu;

@Repository
public interface PubVuRepository extends JpaRepository<PubVu, Integer> {

}
