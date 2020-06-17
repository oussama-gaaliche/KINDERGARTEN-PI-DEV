package tn.esprit.spring.Controller;


import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean()
@SessionScoped()
public class ChangeLocale implements Serializable{
  
  private String locale="fr";
  
  public ChangeLocale() {
  }
  
  public void setFrenchLocale(){
    locale="fr";
  }
  
  public void setEnglishLocale(){
    locale="en";
  }
  
  // getters et setters

  public String getLocale() {
    return locale;
  }

  public void setLocale(String locale) {
    this.locale = locale;
  }
  
}
