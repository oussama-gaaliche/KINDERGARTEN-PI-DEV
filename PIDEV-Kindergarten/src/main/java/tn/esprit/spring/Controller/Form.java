package tn.esprit.spring.Controller;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;


import tn.esprit.spring.domain.AgendaTeacherJour;
import tn.esprit.spring.domain.CreneauTeacherJour;
import tn.esprit.spring.entity.Creneau;
import tn.esprit.spring.entity.Enfant;
import tn.esprit.spring.entity.Teacher;


@Named(value = "form")
@SessionScoped
public class Form implements Serializable {

  public Form() {
  }
 
  @Inject
  private Application application;
 
  private Long idTeacher;
  private Date jour = new Date();
  private Boolean form1Rendered = true;
  private Boolean form2Rendered = false;
  private Boolean form3Rendered = false;
  private Boolean erreurRendered = false;
  private String form2Titre;
  private String form3Titre;
  private AgendaTeacherJour agendaTeacherJour;
  private Long idCreneau;
  private Teacher teacher;
  private Enfant enfant;
  private Long idEnfant;
  private CreneauTeacherJour creneauChoisi;
  private List<Erreur> erreurs;

  @PostConstruct
  private void init() {
    // l'initialisation s'est-elle bien passée ?
    if (application.getErreur()) {
      // on récupère la liste des erreurs
      erreurs = application.getErreurs();
      // la vue des erreurs est affichée
      setForms(false, false, false, true);
    }
  }

  // liste des enseignants
  public List<Teacher> getTeachers() {
    return application.getTeachers();
  }

  // liste des enfants
  public List<Enfant> getEnfants() {
    return application.getEnfants();
  }

  // agenda
  public void getAgenda() {

    try {
      // on récupère l'enseignant
     teacher = application.gethTeachers().get(idTeacher);
      // titre formulaire 2
   form2Titre = Messages.getMessage(null, "form2.titre", new Object[]{ teacher.getPrenom(), teacher.getNom(), new SimpleDateFormat("dd MMM yyyy").format(jour)}).getSummary();
      // l'agenda de l'enseignant pour un jour donné
      agendaTeacherJour = application.getMetier().getAgendaTeacherJour(teacher.getId(), jour);
      // on affiche le formulaire 2
      setForms(false, true, false, false);
    } catch (Throwable th) {
      // vue des erreurs
      prepareVueErreur(th);
    }
  }

  // action sur RV
  public void action() {
    // on recherche le créneau dans l'agenda
    int i = 0;
    Boolean trouvé = false;
    while (!trouvé && i < agendaTeacherJour.getCreneauxTeacherJour().length) {
      if (agendaTeacherJour.getCreneauxTeacherJour()[i].getCreneau().getId() == idCreneau) {
        trouvé = true;
      } else {
        i++;
      }
    }
    // a-t-on trouvé ?
    if (!trouvé) {
      // c'est bizarre - on réaffiche form2
      setForms(false, true, false, false);
      return;
    }
    // on a trouvé
    creneauChoisi = agendaTeacherJour.getCreneauxTeacherJour()[i];
    // selon l'action désirée
    if (creneauChoisi.getRv() == null) {
      reserver();
    } else {
      supprimer();
    }
  }
  // réservation

  public void reserver() {
    try {
      // titre formulaire 3
      form3Titre = Messages.getMessage(null, "form3.titre", new Object[]{teacher.getPrenom(), teacher.getNom(), new SimpleDateFormat("dd MMM yyyy").format(jour),
                creneauChoisi.getCreneau().getHdebut(), creneauChoisi.getCreneau().getMdebut(), creneauChoisi.getCreneau().getHfin(), creneauChoisi.getCreneau().getMfin()}).getSummary();
      // enfant sélectionné dans le combo
      idEnfant=null;
      // on affiche le formulaire 3
      setForms(false, false, true, false);
    } catch (Throwable th) {
      // vue erreurs
      prepareVueErreur(th);
    }
  }

  public void supprimer() {

    try {
      // suppression d'un Rdv
      application.getMetier().deleteRv(creneauChoisi.getRv().getId());
      // on remet à jour l'agenda
      agendaTeacherJour = application.getMetier().getAgendaTeacherJour(teacher.getId(), jour);
      // on affiche form2
      setForms(false, true, false, false);
    } catch (Throwable th) {
      // vue erreurs
      prepareVueErreur(th);
    }
  }

  // validation Rv
  public void validerRv() {
    try {
      // on récupère une instance du créneau horaire choisi
      Creneau creneau = application.getMetier().getCreneauById(idCreneau);
      // on ajoute le Rv
      application.getMetier().ajouterRdv(jour, creneau,application.gethEnfants().get( idEnfant));
      // on remet à jour l'agenda
      agendaTeacherJour = application.getMetier().getAgendaTeacherJour(idTeacher, jour);
      // on affiche form2
      setForms(false, true, false, false);
    } catch (Throwable th) {
      // vue erreurs
      prepareVueErreur(th);
    }
  }

  // annulation prise de Rdv
  public void annulerRv() {
    // on affiche form2
    setForms(false, true, false, false);
  }

  public void accueil() {
    // on affiche la page d'accueil
    setForms(true, false, false, false);
  }

  // affichage vue
  private void setForms(Boolean form1Rendered, Boolean form2Rendered, Boolean form3Rendered, Boolean erreurRendered) {
    this.form1Rendered = form1Rendered;
    this.form2Rendered = form2Rendered;
    this.form3Rendered = form3Rendered;
    this.erreurRendered = erreurRendered;
  }

  // préparation vueErreur
  private void prepareVueErreur(Throwable th) {
    // on crée la liste des erreurs
    erreurs = new ArrayList<Erreur>();
    erreurs.add(new Erreur(th.getClass().getName(), th.getMessage()));
    while (th.getCause() != null) {
      th = th.getCause();
      erreurs.add(new Erreur(th.getClass().getName(), th.getMessage()));
    }
// la vue des erreurs est affichée
    setForms(false, false, false, true);
  }

  // getters et setters
  public Date getJour() {
    return jour;
  }

  public void setJour(Date jour) {
    this.jour = jour;
  }

  public Long getIdTeacher() {
    return idTeacher;
  }

  public void setIdTeacher(Long idTeacher) {
    this.idTeacher = idTeacher;
  }

  public Boolean getForm1Rendered() {
    return form1Rendered;
  }

  public Boolean getForm2Rendered() {
    return form2Rendered;
  }

  public Boolean getForm3Rendered() {
    return form3Rendered;
  }

  public String getForm2Titre() {
    return form2Titre;
  }

  public AgendaTeacherJour getAgendaTeacherJour() {
    return agendaTeacherJour;
  }

  public void setIdCreneau(Long idCreneau) {
    this.idCreneau = idCreneau;
  }

  public String getForm3Titre() {
    return form3Titre;
  }

  public Long getIdEnfant() {
    return idEnfant;
  }

  public void setIdEnfant(Long idEnfant) {
    this.idEnfant = idEnfant;
  }

  public Boolean getErreurRendered() {
    return erreurRendered;
  }

  public List<Erreur> getErreurs() {
    return erreurs;
  }
}