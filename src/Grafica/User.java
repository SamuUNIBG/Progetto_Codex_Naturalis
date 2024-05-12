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
import javax.swing.SwingConstants;

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
		nome.setBackground(new Color(0xFEFCEF));
		nome.setOpaque(true);
		nome.setHorizontalAlignment(JLabel.CENTER);
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
		
		FlowLayout layoutRisOgg = new FlowLayout();
		layoutRisOgg.setHgap(5);	
		
		risorsePanel = new JPanel();
		risorsePanel.setLayout(layoutRisOgg);
		risorsePanel.setBackground(new Color(0xFEFCEF));
		risorsePanel.setOpaque(true);
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
		oggettiPanel.setLayout(layoutRisOgg);
		oggettiPanel.setBackground(new Color(0xFEFCEF));
		oggettiPanel.setOpaque(true);
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
	
	public void addResource(int[] risAggiungere) {
		if(risAggiungere[0]!=0) {
			int ris = Integer.parseInt(risorse.get(0).getText());
			risorse.get(0).setText("" + (ris+risAggiungere[0]));
		}
		if(risAggiungere[1]!=0) {
			int ris = Integer.parseInt(risorse.get(1).getText());
			risorse.get(1).setText("" + (ris+risAggiungere[1]));
		}
		if(risAggiungere[2]!=0) {
			int ris = Integer.parseInt(risorse.get(2).getText());
			risorse.get(2).setText("" + (ris+risAggiungere[2]));
		}
		if(risAggiungere[3]!=0) {
			int ris = Integer.parseInt(risorse.get(3).getText());
			risorse.get(3).setText("" + (ris+risAggiungere[3]));
		}
			
	}
	
	public void removeResource(int[] risRimuovere) {
		if(risRimuovere[0]!=0) {
			int ris = Integer.parseInt(risorse.get(0).getText());
			risorse.get(0).setText("" + (ris-risRimuovere[0]));
		}
		if(risRimuovere[1]!=0) {
			int ris = Integer.parseInt(risorse.get(1).getText());
			risorse.get(1).setText("" + (ris-risRimuovere[1]));
		}
		if(risRimuovere[2]!=0) {
			int ris = Integer.parseInt(risorse.get(2).getText());
			risorse.get(2).setText("" + (ris-risRimuovere[2]));
		}
		if(risRimuovere[3]!=0) {
			int ris = Integer.parseInt(risorse.get(3).getText());
			risorse.get(3).setText("" + (ris-risRimuovere[3]));
		}
	}
	
	public void addObjects(int[] oggAggiungere) {
		if(oggAggiungere[0]!=0) {
			int ogg = Integer.parseInt(risorse.get(0).getText());
			risorse.get(0).setText("" + (ogg+oggAggiungere[0]));
		}
		if(oggAggiungere[1]!=0) {
			int ogg = Integer.parseInt(risorse.get(1).getText());
			risorse.get(1).setText("" + (ogg+oggAggiungere[1]));
		}
		if(oggAggiungere[2]!=0) {
			int ogg = Integer.parseInt(risorse.get(2).getText());
			risorse.get(2).setText("" + (ogg+oggAggiungere[2]));
		}
			
	}
	
	public void removeObjects(int[] oggRimuovere) {
		if(oggRimuovere[0]!=0) {
			int ogg = Integer.parseInt(risorse.get(0).getText());
			risorse.get(0).setText("" + (ogg-oggRimuovere[0]));
		}
		if(oggRimuovere[1]!=0) {
			int ogg = Integer.parseInt(risorse.get(1).getText());
			risorse.get(1).setText("" + (ogg-oggRimuovere[1]));
		}
		if(oggRimuovere[2]!=0) {
			int ogg = Integer.parseInt(risorse.get(2).getText());
			risorse.get(2).setText("" + (ogg-oggRimuovere[2]));
		}
	}
	
}
