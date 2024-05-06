package Grafica;

import javax.swing.*;


import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.BorderLayout;
import java.awt.Color;
import java.util.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

//utilizzare JTabbedPane. Guardare https://www.edatlas.it/scarica/informatica/info_java/Inserto3/5ScrollPaneTabbedPane.pdf

public class Game extends JFrame implements ActionListener{
	
	HashMap<Integer, String> cardImageMap;
	ArrayList<ImageIcon> cardImageArr;
	JFrame frame=new JFrame();
	

	public Game(ArrayList<String> username, ArrayList<String> userColor) {
		
		ImageIcon logo = new ImageIcon("images/codex_logo.png");
		cardImageMap = new HashMap<Integer, String>();
		cardImageArr = new ArrayList<ImageIcon>();
		frame.setIconImage(logo.getImage());
		frame.setTitle("Codex Naturalis - Partita");
		//frame.setMinimumSize(new Dimension(sfondo.getIconWidth()+16, sfondo.getIconHeight()+39));
		//sets the window not resizable by the users
		frame.setResizable(true);
		//gets the size of the screen
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		frame.setSize(1650,1080);
		frame.setExtendedState(JFrame.MAXIMIZED_BOTH); 
		
		//sets the window position to the center of the screen
		frame.setLocation((screenSize.width/2)-(frame.getWidth()/2), (screenSize.height/2)-(frame.getHeight()/2));
		//exit out of application
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		createHashMap();
		istantiateCardImage();
		
		
		
		//per test
		/*System.out.println(username.get(0));
		System.out.println(username.get(1));
		System.out.println(username.get(2));
		System.out.println(username.get(3));
		System.out.println(userColor.get(0));
		System.out.println(userColor.get(1));
		System.out.println(userColor.get(2));
		System.out.println(userColor.get(3));*/
		
		//scrollBar
		
		PlayingField playingField = new PlayingField();
		JScrollPane scrollPlayingField = new JScrollPane(playingField);
		scrollPlayingField.getViewport().setPreferredSize(new Dimension(600, 700));
		playingField.setVisible(true);
		scrollPlayingField.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);  
		scrollPlayingField.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        scrollPlayingField.getHorizontalScrollBar().setValue(((12500-204)/2)-(700));
        scrollPlayingField.getVerticalScrollBar().setValue((5000-142)/2-(250));
        
        PlayingField playingField2 = new PlayingField();
		JScrollPane scrollPlayingField2 = new JScrollPane(playingField2);
		scrollPlayingField2.getViewport().setPreferredSize(new Dimension(600, 700));
		playingField2.setVisible(true);
		scrollPlayingField2.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);  
		scrollPlayingField2.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        scrollPlayingField2.getHorizontalScrollBar().setValue(((12500-204)/2)-(700));
        scrollPlayingField2.getVerticalScrollBar().setValue((5000-142)/2-(250));

        PlayingField playingField3 = new PlayingField();
		JScrollPane scrollPlayingField3 = new JScrollPane(playingField3);
		scrollPlayingField3.getViewport().setPreferredSize(new Dimension(600, 700));
		playingField3.setVisible(true);
		scrollPlayingField3.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);  
		scrollPlayingField3.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        scrollPlayingField3.getHorizontalScrollBar().setValue(((12500-204)/2)-(700));
        scrollPlayingField3.getVerticalScrollBar().setValue((5000-142)/2-(250));
        
        PlayingField playingField4 = new PlayingField();
		JScrollPane scrollPlayingField4 = new JScrollPane(playingField4);
		scrollPlayingField4.getViewport().setPreferredSize(new Dimension(600, 700));
		playingField2.setVisible(true);
		scrollPlayingField4.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);  
		scrollPlayingField4.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        scrollPlayingField4.getHorizontalScrollBar().setValue(((12500-204)/2)-(700));
        scrollPlayingField4.getVerticalScrollBar().setValue((5000-142)/2-(250));
        
      //Pannelli opachi per posizionamento carte/mazzi
        JLabel opacoLabel=new JLabel();
        opacoLabel.setBackground(new Color(170, 170, 170, 80));
        opacoLabel.setOpaque(true);
        opacoLabel.setSize(new Dimension(204, 142));
        opacoLabel.setVisible(true);
        //204, 142
        
        //Pannelli carte personali 
        JPanel cartePersonaliPanel=new JPanel();
        cartePersonaliPanel.setPreferredSize(new Dimension(300,300));
        cartePersonaliPanel.setLayout(new BorderLayout());
        cartePersonaliPanel.setOpaque(true);
        JPanel cartePersonaliPanel2=new JPanel();
        cartePersonaliPanel2.setPreferredSize(new Dimension(300,300));
        cartePersonaliPanel2.setLayout(new BorderLayout());
        cartePersonaliPanel.setOpaque(true);
        JPanel cartePersonaliPanel3=new JPanel();
        cartePersonaliPanel3.setPreferredSize(new Dimension(300,300));
        cartePersonaliPanel3.setLayout(new BorderLayout());
        cartePersonaliPanel.setOpaque(true);
        JPanel cartePersonaliPanel4=new JPanel();
        cartePersonaliPanel4.setPreferredSize(new Dimension(300,300));
        cartePersonaliPanel4.setLayout(new BorderLayout());
        cartePersonaliPanel.setOpaque(true);
        
        
        
        //contenitori carte personali
        JPanel contenitore=new JPanel();
        contenitore.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        contenitore.setLayout(new BorderLayout());
        contenitore.setOpaque(false);
        contenitore.add(scrollPlayingField,BorderLayout.CENTER);
        contenitore.add(cartePersonaliPanel,BorderLayout.SOUTH);
        JPanel contenitore2=new JPanel();
        contenitore2.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        contenitore2.setLayout(new BorderLayout());
        contenitore2.setOpaque(false);
        contenitore2.add(scrollPlayingField2,BorderLayout.CENTER);
        contenitore2.add(cartePersonaliPanel2,BorderLayout.SOUTH);
        JPanel contenitore3=new JPanel();
        contenitore3.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        contenitore3.setLayout(new BorderLayout());
        contenitore3.setOpaque(false);
        contenitore3.add(scrollPlayingField3,BorderLayout.CENTER);
        contenitore3.add(cartePersonaliPanel3,BorderLayout.SOUTH);
        JPanel contenitore4=new JPanel();
        contenitore4.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        contenitore4.setLayout(new BorderLayout());
        contenitore4.setOpaque(false);
        contenitore4.add(scrollPlayingField4,BorderLayout.CENTER);
        contenitore4.add(cartePersonaliPanel4,BorderLayout.SOUTH);
        
     
        //finistre campo gioco giocatori
        JTabbedPane tabbedPane=new JTabbedPane();
        tabbedPane.setTabPlacement(JTabbedPane.TOP);
        tabbedPane.add("Giocatore 1",contenitore);
        tabbedPane.add("Giocatore 2",contenitore2);
        tabbedPane.add("Giocatore 3",contenitore3);
        tabbedPane.add("Giocatore 4",contenitore4);
        
        
      
        //pannello contenente nomi utente
        JPanel userPanel = new JPanel();
        userPanel.setPreferredSize(new Dimension(500, 300));
        userPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        userPanel.setLayout(new GridBagLayout());
        userPanel.setOpaque(false);
        
      //pannello contenente le carte
      	JPanel cartePanel=new JPanel();
      	cartePanel.setPreferredSize(new Dimension(200, 200));
      	cartePanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
      	cartePanel.setLayout(new GridBagLayout());
    	cartePanel.setOpaque(false);
        
        GridBagConstraints gbc = new GridBagConstraints();
		JLabel utente = new JLabel("Username");
		JLabel carte=new JLabel("Carte");
		JLabel carte2=new JLabel("Carte2");
		carte.setMaximumSize(new Dimension(30,30));
		JLabel tracciato=new JLabel("Tracciato");
		utente.setFont(new Font("Serif", Font.BOLD | Font.ITALIC, 15));
		utente.setBackground(Color.BLACK);
		gbc.gridx=0;
		gbc.gridy=0;
		userPanel.add(utente,gbc);
		cartePanel.add(opacoLabel,gbc);
		gbc.gridx=0;
		gbc.gridy=1;
		cartePanel.add(carte2,gbc);
		
		
		 //contenitore carte e username
        JPanel contenitoreUC=new JPanel();
        contenitoreUC.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        contenitoreUC.setLayout(new BorderLayout());
        contenitoreUC.setOpaque(false);
        contenitoreUC.setVisible(true);
        contenitoreUC.add(userPanel,BorderLayout.WEST);
        contenitoreUC.add(cartePanel,BorderLayout.CENTER);
		
		//pannello tracciato
		JPanel tracciatoPanel=new JPanel();
		tracciatoPanel.setPreferredSize(new Dimension(500, 100));
		tracciatoPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		tracciatoPanel.setLayout(new GridBagLayout());
		tracciatoPanel.setOpaque(false);
		tracciatoPanel.add(tracciato,gbc);
       // playingField.addLabel(posReturn);
        
        //test
        /*ArrayList<String> str = new ArrayList<String>(5);
        str.add("40,40");
        str.add("39,39");
        str.add("39,41");
        str.add("41,41");
        str.add("41,39");
        ArrayList<String> str2 = new ArrayList<String>(2);
        str2.add("41,41");
        str2.add("42,42");
        ArrayList<String> str3 = new ArrayList<String>(2);
        str3.add("42,42");
        str3.add("41,43");
        str3.add("43,41");
        playingField.addLabel(str);
        playingField.addLabel(str2);
        playingField.addLabel(str3);*/
      //add homePanel to window
			
      		//frame.add(scrollPlayingField);
			frame.getContentPane().add(tabbedPane);
      		frame.add(contenitoreUC,BorderLayout.NORTH);
      		//frame.add(userPanel,BorderLayout.WEST);
      		frame.add(tracciatoPanel,BorderLayout.WEST);
      		//makes frame visible
      		frame.setVisible(true);				
	}
	
	private void createHashMap() {
		
		//add all card's URL to HashMap
		try {
			Scanner sc = new Scanner(new FileInputStream(new File("cards_URL.csv")));
	        
	        while (sc.hasNextLine()) {
	            String frase = sc.nextLine();
	            
	            String[] splittedString = frase.split(",");
	    		int id = Integer.parseInt(splittedString[0]);
	    		String url = (splittedString[1]);
	    		
	    		cardImageMap.put(id, url);
	        }
	        sc.close();
	    } 
	    catch (FileNotFoundException e) {
	        e.printStackTrace();
	    }
				
	}
	
	private void istantiateCardImage() {
		
		for(int i=0; i<cardImageMap.size(); i++) {
			cardImageArr.add(new ImageIcon(cardImageMap.get(i)));
		}
		
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

}
