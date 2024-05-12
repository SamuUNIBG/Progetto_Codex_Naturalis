package Grafica;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class User extends JPanel{
	
	//label nomi utente
	JLabel nome;
	//pannello risorse
	JPanel risorsePanel;
	//pannello oggetti
	JPanel oggettiPanel;
	//label risorse
	ArrayList<JLabel> risorse;
	//label oggetti
	ArrayList<JLabel> oggetti;
		
	public User(String username, String userColor) {
		
		//pannello contenente nomi utente
        this.setPreferredSize(new Dimension(500, 300));
        this.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        this.setLayout(new GridLayout(3,1));
        
		risorse = new ArrayList<JLabel>();
		oggetti = new ArrayList<JLabel>();
							
		nome = new JLabel();
		nome.setText(username);
		nome.setFont(new Font("Serif", Font.BOLD | Font.ITALIC, 15));
		switch(userColor) {
	       	case "Azzurro":
	       		nome.setForeground(Color.BLUE);
	       		this.setBackground(Color.RED);
	       		break;
	       	case "Giallo":
	       		nome.setForeground(Color.YELLOW);
	       		this.setBackground(Color.GREEN);
	       		break;
	       	case "Rosso":
	       		nome.setForeground(Color.RED);
	       		this.setBackground(Color.BLUE);
	       		break;
	       	case "Verde":
	      		nome.setForeground(Color.GREEN);
	       		this.setBackground(Color.YELLOW);
	       		break;
	   	}	
				
		risorsePanel = new JPanel();
		risorsePanel.setLayout(new FlowLayout());
		try {
			Scanner sc = new Scanner(new FileInputStream(new File("file/resources_URL.csv")));
	        
	            for(int j=0; j<8; j++) {
	    			risorse.add(new JLabel());
	    			
	    			if(j%2!=0) {
	    				if(sc.hasNextLine()) {
	    		            String frase = sc.nextLine();
	    		            risorse.get(j).setIcon(new ImageIcon(frase));
	    				}
	    			}else
	    				risorse.get(j).setText("0");
	    			
	    			risorsePanel.add(risorse.get(j));
	            }
	            
	        sc.close();
	    } 
	    catch (FileNotFoundException e) {
	        e.printStackTrace();
	    }
			
		oggettiPanel = new JPanel();
		oggettiPanel.setLayout(new FlowLayout());
		try {
			Scanner sc = new Scanner(new FileInputStream(new File("file/objects_URL.csv")));
	        
	            for(int j=0; j<6; j++) {
	            	oggetti.add(new JLabel());
	    			
	    			if(j%2!=0) {
	    				if(sc.hasNextLine()) {
	    		            String frase = sc.nextLine();
	    		            oggetti.get(j).setIcon(new ImageIcon(frase));
	    				}
	    			}else
	    				oggetti.get(j).setText("0");
	    			
	    			oggettiPanel.add(oggetti.get(j));
	            }
	            
	        sc.close();
	    } 
	    catch (FileNotFoundException e) {
	        e.printStackTrace();
	    }
			
		this.add(nome);
		this.add(risorsePanel);
		this.add(oggettiPanel);
	    this.setOpaque(false);
	}
	
}
