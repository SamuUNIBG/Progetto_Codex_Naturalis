package Grafica;

import java.awt.*;
import java.util.ArrayList;

import javax.swing.*;

public class UserPanel extends JPanel{

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
	
}
