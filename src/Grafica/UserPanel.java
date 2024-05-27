package Grafica;

import java.awt.*;
import java.util.ArrayList;

import javax.swing.*;
/**
 * il pannello delle carte in mano al giocatore
 */
public class UserPanel extends JPanel{

	private static final long serialVersionUID = -4069660505516372388L;
	private ArrayList<User> utenti;
	
	public UserPanel(ArrayList<String> username, ArrayList<String> userColor) {
		
		this.setPreferredSize(new Dimension(500, 300));
        this.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        if(username.size()==2)
        	this.setLayout(new GridLayout(2,1));
        else
        	this.setLayout(new GridLayout(2,2));
        
        utenti = new ArrayList<User>();
        
		for(int i=0; i<username.size(); i++) {
			utenti.add(new User(username.get(i), userColor.get(i)));
			this.add(utenti.get(i));
			
		}
		       
        this.setOpaque(false);
	}
	
	public User getUser(int giocatore) {
		return utenti.get(giocatore);
	}
	
}
