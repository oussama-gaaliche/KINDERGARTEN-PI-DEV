package tn.esprit.spring.Controller;
public class Erreur {
  
  /** Creates a new instance of Erreur */
  public Erreur() {
  }
  
  // champ
  private String classe;
  private String message;

  // constructeur
  public Erreur(String classe, String message){
    this.setClasse(classe);
    this.message=message;
  }
  
  // getters et setters

  public String getMessage() {
    return message;
  }

  public void setMessage(String message) {
    this.message = message;
  }

  public String getClasse() {
    return classe;
  }

  public void setClasse(String classe) {
    this.classe = classe;
  }
  
  
}
