package tn.esprit.spring.Controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;

import tn.esprit.spring.Services.IMetier;
import tn.esprit.spring.entity.Enfant;
import tn.esprit.spring.entity.Teacher;



@Named(value = "application")
@ApplicationScoped
public class Application {

  // couche métier
  @EJB
  private IMetier metier;
  // cache
  private List<Teacher> teachers;
  private List<Enfant> enfants;
  private Map<Long, Teacher> hTeachers = new HashMap<Long, Teacher>();
  private Map<Long, Enfant> hEnfants = new HashMap<Long, Enfant>();
  // erreurs
  private List<Erreur> erreurs = new ArrayList<Erreur>();
  private Boolean erreur = false;

  public Application() {
  }

  @PostConstruct
  public void init() {
    // on met les enseignants et les enfants en cache
    try {
      teachers = metier.getAllTeachers();
      enfants = metier.getAllEnfants();
    } catch (Throwable th) {
      // on note l'erreur
      erreur = true;
      erreurs.add(new Erreur(th.getClass().getName(), th.getMessage()));
      while (th.getCause() != null) {
        th = th.getCause();
        erreurs.add(new Erreur(th.getClass().getName(), th.getMessage()));
      }
      return;
    }
    // vérification des listes
    if (teachers.size() == 0) {
        // on note l'erreur
        erreur = true;
        erreurs.add(new Erreur("", "La liste des enseignants est vide"));
      }

    
    if (enfants.size() == 0) {
      // on note l'erreur
      erreur = true;
      erreurs.add(new Erreur("", "La liste des enfants est vide"));
    }
    // erreur ?
    if (erreur) {
      return;
    }

    // les dictionnaires
    for (Teacher t : teachers) {
      hTeachers.put(t.getId(), t);
    }
    for (Enfant e : enfants) {
      hEnfants.put(e.getId(), e);
    }
  }

  // getters et setters
  public List<Enfant> getEnfants() {
    return enfants;
  }

  public List<Teacher> getTeachers() {
    return teachers;
  }

  public IMetier getMetier() {
    return metier;
  }

  public Map<Long, Teacher> gethTeachers() {
    return hTeachers;
  }

  public Map<Long, Enfant> gethEnfants() {
    return hEnfants;
  }

  public Boolean getErreur() {
    return erreur;
  }

  public List<Erreur> getErreurs() {
    return erreurs;
  }
}
