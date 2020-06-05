package tn.esprit.spring.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tn.esprit.spring.entity.Classe;
import tn.esprit.spring.entity.PasswordResetToken;

@Repository
public interface PasswordTokenRepository extends JpaRepository<PasswordResetToken, Long> {

}
