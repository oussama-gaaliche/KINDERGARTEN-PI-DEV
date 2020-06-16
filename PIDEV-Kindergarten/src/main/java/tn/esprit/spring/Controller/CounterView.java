package tn.esprit.spring.Controller;

import javax.faces.bean.ViewScoped;
import javax.inject.Named;

@Named
@ViewScoped
public class CounterView {
	private int number;
	 
    public int getNumber() {
        return number;
    }
 
    public void increment() {
       
    	number++;
    	
    }
    public void decrement() {
        
    	number--;
    	
    }
}
