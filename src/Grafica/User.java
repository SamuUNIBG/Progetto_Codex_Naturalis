package Grafica;

import java.awt.*;
import java.util.ArrayList;

import javax.swing.*;

public class User extends JPanel{

	ArrayList<JPanel> utenti;
	ArrayList<JLabel> nome;
	ArrayList<JPanel> risorsePanel;
	ArrayList<JPanel> oggettiPanel;
	ArrayList<JLabel> risorse;
	ArrayList<JLabel> oggetti;
	
	public User(ArrayList<String> username, ArrayList<String> userColor) {
		
		//pannello contenente nomi utente
        this.setPreferredSize(new Dimension(500, 300));
        this.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        this.setLayout(new GridLayout(2,2));
                
		utenti = new ArrayList<JPanel>();
		nome = new ArrayList<JLabel>();
		for(int i=0; i<username.size(); i++) {
			utenti.add(new JPanel());
			utenti.get(i).setLayout(new GridLayout(3,1));
			
			nome.add(new JLabel());
			nome.get(i).setText(username.get(i));
			nome.get(i).setFont(new Font("Serif", Font.BOLD | Font.ITALIC, 15));
			switch(userColor.get(i)) {
	        	case "Azzurro":
	        		nome.get(i).setForeground(Color.BLUE);
	        		utenti.get(i).setBackground(Color.RED);
	        		break;
	        	case "Giallo":
	        		nome.get(i).setForeground(Color.YELLOW);
	        		utenti.get(i).setBackground(Color.GREEN);
	        		break;
	        	case "Rosso":
	        		nome.get(i).setForeground(Color.RED);
	        		utenti.get(i).setBackground(Color.BLUE);
	        		break;
	        	case "Verde":
	        		nome.get(i).setForeground(Color.GREEN);
	        		utenti.get(i).setBackground(Color.YELLOW);
	        		break;
	    	}
			utenti.get(i).add(nome.get(i));
			this.add(utenti.get(i));
		}
		
		risorsePanel = new ArrayList<JPanel>();
		oggettiPanel = new ArrayList<JPanel>();
		risorse = new ArrayList<JLabel>();
		oggetti = new ArrayList<JLabel>();
		for(int i=0; i<username.size(); i++) {
			risorsePanel.add(new JPanel());
			risorsePanel.get(i).setLayout(new FlowLayout());
			
			for(int j=0; j<8; j++) {
				risorse.add(new JLabel("i"));
				risorsePanel.get(i).add(risorse.get(j));
			}
			
			utenti.get(i).add(risorsePanel.get(i));
			
			oggettiPanel.add(new JPanel());
			oggettiPanel.get(i).setLayout(new FlowLayout());
			
			for(int j=0; j<6; j++) {
				oggetti.add(new JLabel("i"));
				oggettiPanel.get(i).add(oggetti.get(j));
			}
			
			utenti.get(i).add(oggettiPanel.get(i));
			
		}
		       
        this.setOpaque(false);
	}
	
}
