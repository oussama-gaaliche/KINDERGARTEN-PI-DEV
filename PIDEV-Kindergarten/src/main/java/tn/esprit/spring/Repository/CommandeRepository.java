package tn.esprit.spring.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import tn.esprit.spring.entity.Article;
import tn.esprit.spring.entity.Commande;
import tn.esprit.spring.entity.EtatCommande;
@Repository
public interface CommandeRepository extends JpaRepository<Commande, Long> {
	@Modifying
	@Query(value="INSERT INTO commande (etat_cmd,montant_ht,montant_ttc,qte_cmd,total_tva,id_article) values (:etat , :ht , :ttc , :qte , :tva , :article)",nativeQuery = true)
	public void addToPanier(@Param("etat") EtatCommande etat, @Param("ht") float ht, @Param("ttc") float ttc, @Param("qte") int qte, @Param("tva") float tva, @Param("article") Article article);
	@Modifying
	@Query("update Commande c set c.commandepk.etat_cmd = :etat where c.id = :id")
	int updateCommandeById( @Param("etat") EtatCommande etat,@Param("id") Long long1);
	@Query("select c FROM Commande c where c.commandepk.etat_cmd= :etat and c.commandepk.userid = :iduser")
	List<Commande> retrieveCommandById(@Param("etat") EtatCommande etat,@Param("iduser") Long long2);
	@Modifying
	@Query("delete  FROM Commande c where c.commandepk.articleid = :idarticle and c.commandepk.userid = :iduser")
	public void deleteCommande(@Param("idarticle") Long long1,@Param("iduser") Long long2);
	@Modifying
	@Query("delete  FROM Commande c where c.commandepk.articleid = :idarticle and c.commandepk.userid = :iduser and c.commandepk.etat_cmd = :etat")
	public void deleteCommandeByPk(@Param("idarticle") Long long1,@Param("iduser") Long long2,@Param("etat") EtatCommande etat);
	@Query("select c FROM Commande c where c.commandepk.articleid= :idarticle and c.commandepk.userid = :iduser and c.commandepk.etat_cmd = :etat")
	Commande retrieveCommandByIds(@Param("idarticle") Long long1,@Param("iduser") Long long2,@Param("etat") EtatCommande etat);
	@Query("select c FROM Commande c where c.facture.id= :id")
	List<Commande> retrieveCommandByfact(@Param("id") Long id);
}
