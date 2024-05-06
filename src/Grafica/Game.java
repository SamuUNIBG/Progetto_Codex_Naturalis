package Grafica;

import javax.swing.*;


import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
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
        opacoLabel.setPreferredSize(new Dimension(163, 113));
        opacoLabel.setVisible(true);
        JLabel opacoLabel2=new JLabel();
        opacoLabel2.setBackground(new Color(170, 170, 170, 80));
        opacoLabel2.setOpaque(true);
        opacoLabel2.setPreferredSize(new Dimension(163, 113));
        opacoLabel2.setVisible(true);
        JLabel opacoLabel3=new JLabel();
        opacoLabel3.setBackground(new Color(170, 170, 170, 80));
        opacoLabel3.setOpaque(true);
        opacoLabel3.setPreferredSize(new Dimension(163, 113));
        opacoLabel3.setVisible(true);
        JLabel opacoLabel4=new JLabel();
        opacoLabel4.setBackground(new Color(170, 170, 170, 80));
        opacoLabel4.setOpaque(true);
        opacoLabel4.setPreferredSize(new Dimension(163, 113));
        opacoLabel4.setVisible(true);
        JLabel opacoLabel5=new JLabel();
        opacoLabel5.setBackground(new Color(170, 170, 170, 80));
        opacoLabel5.setOpaque(true);
        opacoLabel5.setPreferredSize(new Dimension(163, 113));
        opacoLabel5.setVisible(true);
        JLabel opacoLabel6=new JLabel();
        opacoLabel6.setBackground(new Color(170, 170, 170, 80));
        opacoLabel6.setOpaque(true);
        opacoLabel6.setPreferredSize(new Dimension(163, 113));
        opacoLabel6.setVisible(true);
        JLabel opacoLabel7=new JLabel();
        opacoLabel7.setBackground(new Color(170, 170, 170, 80));
        opacoLabel7.setOpaque(true);
        opacoLabel7.setPreferredSize(new Dimension(163, 113));
        opacoLabel7.setVisible(true);
        JLabel opacoLabel8=new JLabel();
        opacoLabel8.setBackground(new Color(170, 170, 170, 80));
        opacoLabel8.setOpaque(true);
        opacoLabel8.setPreferredSize(new Dimension(163, 113));
        opacoLabel8.setVisible(true);
        JLabel opacoLabel9=new JLabel();
        opacoLabel9.setBackground(new Color(170, 170, 170, 80));
        opacoLabel9.setOpaque(true);
        opacoLabel9.setPreferredSize(new Dimension(163, 113));
        opacoLabel9.setVisible(true);
        JLabel opacoLabel10=new JLabel();
        opacoLabel10.setBackground(new Color(170, 170, 170, 80));
        opacoLabel10.setOpaque(true);
        opacoLabel10.setPreferredSize(new Dimension(163, 113));
        opacoLabel10.setVisible(true);
        JLabel opacoLabel11=new JLabel();
        opacoLabel11.setBackground(new Color(170, 170, 170, 80));
        opacoLabel11.setOpaque(true);
        opacoLabel11.setPreferredSize(new Dimension(163, 113));
        opacoLabel11.setVisible(true);
        JLabel opacoLabel12=new JLabel();
        opacoLabel12.setBackground(new Color(170, 170, 170, 80));
        opacoLabel12.setOpaque(true);
        opacoLabel12.setPreferredSize(new Dimension(163, 113));
        opacoLabel12.setVisible(true);
        JLabel opacoLabel13=new JLabel();
        opacoLabel13.setBackground(new Color(170, 170, 170, 80));
        opacoLabel13.setOpaque(true);
        opacoLabel13.setPreferredSize(new Dimension(163, 113));
        opacoLabel13.setVisible(true);
        JLabel opacoLabel14=new JLabel();
        opacoLabel14.setBackground(new Color(170, 170, 170, 80));
        opacoLabel14.setOpaque(true);
        opacoLabel14.setPreferredSize(new Dimension(163, 113));
        opacoLabel14.setVisible(true);
        JLabel opacoLabel15=new JLabel();
        opacoLabel15.setBackground(new Color(170, 170, 170, 80));
        opacoLabel15.setOpaque(true);
        opacoLabel15.setPreferredSize(new Dimension(163, 113));
        opacoLabel15.setVisible(true);
        JLabel opacoLabel16=new JLabel();
        opacoLabel16.setBackground(new Color(170, 170, 170, 80));
        opacoLabel16.setOpaque(true);
        opacoLabel16.setPreferredSize(new Dimension(163, 113));
        opacoLabel16.setVisible(true);
        JLabel opacoLabel17=new JLabel();
        opacoLabel17.setBackground(new Color(170, 170, 170, 80));
        opacoLabel17.setOpaque(true);
        opacoLabel17.setPreferredSize(new Dimension(163, 113));
        opacoLabel17.setVisible(true);
        JLabel opacoLabel18=new JLabel();
        opacoLabel18.setBackground(new Color(170, 170, 170, 80));
        opacoLabel18.setOpaque(true);
        opacoLabel18.setPreferredSize(new Dimension(163, 113));
        opacoLabel18.setVisible(true);
        JLabel opacoLabel19=new JLabel();
        opacoLabel19.setBackground(new Color(170, 170, 170, 80));
        opacoLabel19.setOpaque(true);
        opacoLabel19.setPreferredSize(new Dimension(163, 113));
        opacoLabel19.setVisible(true);
        JLabel opacoLabel20=new JLabel();
        opacoLabel20.setBackground(new Color(170, 170, 170, 80));
        opacoLabel20.setOpaque(true);
        opacoLabel20.setPreferredSize(new Dimension(163, 113));
        opacoLabel20.setVisible(true);
        JLabel opacoLabel21=new JLabel();
        opacoLabel21.setBackground(new Color(170, 170, 170, 80));
        opacoLabel21.setOpaque(true);
        opacoLabel21.setPreferredSize(new Dimension(163, 113));
        opacoLabel21.setVisible(true);
        JLabel opacoLabel22=new JLabel();
        opacoLabel22.setBackground(new Color(170, 170, 170, 80));
        opacoLabel22.setOpaque(true);
        opacoLabel22.setPreferredSize(new Dimension(163, 113));
        opacoLabel22.setVisible(true);
        JLabel opacoLabel23=new JLabel();
        opacoLabel23.setBackground(new Color(170, 170, 170, 80));
        opacoLabel23.setOpaque(true);
        opacoLabel23.setPreferredSize(new Dimension(163, 113));
        opacoLabel23.setVisible(true);
        JLabel opacoLabel24=new JLabel();
        opacoLabel24.setBackground(new Color(170, 170, 170, 80));
        opacoLabel24.setOpaque(true);
        opacoLabel24.setPreferredSize(new Dimension(163, 113));
        opacoLabel24.setVisible(true);
        
        
        
        //Pannelli carte personali 
        JPanel cartePersonaliPanel=new JPanel();
        cartePersonaliPanel.setPreferredSize(new Dimension(300,300));
        FlowLayout CPlayout=new FlowLayout();
        cartePersonaliPanel.setLayout(CPlayout);
        cartePersonaliPanel.setOpaque(true);
        CPlayout.setHgap(190);
        CPlayout.setVgap(90);
        cartePersonaliPanel.add(opacoLabel9);
        cartePersonaliPanel.add(opacoLabel10);
        cartePersonaliPanel.add(opacoLabel11);
        cartePersonaliPanel.add(opacoLabel12);
        
        
        JPanel cartePersonaliPanel2=new JPanel();
        cartePersonaliPanel2.setPreferredSize(new Dimension(300,300));
        FlowLayout CPlayout2=new FlowLayout();
        cartePersonaliPanel2.setLayout(CPlayout2);
        cartePersonaliPanel2.setOpaque(true);
        CPlayout2.setHgap(190);
        CPlayout2.setVgap(90);
        cartePersonaliPanel2.add(opacoLabel13);
        cartePersonaliPanel2.add(opacoLabel14);
        cartePersonaliPanel2.add(opacoLabel15);
        cartePersonaliPanel2.add(opacoLabel16);
        
        
        JPanel cartePersonaliPanel3=new JPanel();
        cartePersonaliPanel3.setPreferredSize(new Dimension(300,300));
        FlowLayout CPlayout3=new FlowLayout();
        cartePersonaliPanel3.setLayout(CPlayout3);
        cartePersonaliPanel3.setOpaque(true);
        CPlayout3.setHgap(190);
        CPlayout3.setVgap(90);
        cartePersonaliPanel3.add(opacoLabel17);
        cartePersonaliPanel3.add(opacoLabel18);
        cartePersonaliPanel3.add(opacoLabel19);
        cartePersonaliPanel3.add(opacoLabel20);
        
        
        JPanel cartePersonaliPanel4=new JPanel();
        cartePersonaliPanel4.setPreferredSize(new Dimension(300,300));
        FlowLayout CPlayout4=new FlowLayout();
        cartePersonaliPanel4.setLayout(CPlayout4);
        cartePersonaliPanel4.setOpaque(true);
        CPlayout4.setHgap(190);
        CPlayout4.setVgap(90);
        cartePersonaliPanel4.add(opacoLabel21);
        cartePersonaliPanel4.add(opacoLabel22);
        cartePersonaliPanel4.add(opacoLabel23);
        cartePersonaliPanel4.add(opacoLabel24);
        
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
      	cartePanel.setLayout(new GridLayout(2,1));
    	cartePanel.setOpaque(false);
    	
    	
    	
    	//sotto pannello contenente le carte
      	JPanel sottoPanel=new JPanel();
      	sottoPanel.setPreferredSize(new Dimension(200, 200));
      	sottoPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
      	FlowLayout layout=new FlowLayout();
      	sottoPanel.setLayout(layout);
      	sottoPanel.setOpaque(false);
      	layout.setHgap(190);
      	layout.setVgap(16);
      	sottoPanel.add(opacoLabel);
      	sottoPanel.add(opacoLabel2);
      	sottoPanel.add(opacoLabel3);
      	sottoPanel.add(opacoLabel4);
    	
    	
    	//sotto pannello contenente le carte
      	JPanel sottoPanel2=new JPanel();
      	sottoPanel2.setPreferredSize(new Dimension(200, 200));
      	sottoPanel2.setBorder(BorderFactory.createLineBorder(Color.BLACK));
      	FlowLayout layout2=new FlowLayout();
      	sottoPanel2.setLayout(layout2);
      	sottoPanel2.setOpaque(false);
      	layout2.setHgap(190);
      	layout2.setVgap(16);
      	sottoPanel2.add(opacoLabel5);
      	sottoPanel2.add(opacoLabel6);
      	sottoPanel2.add(opacoLabel7);
      	sottoPanel2.add(opacoLabel8);
    	
      	
      	cartePanel.add(sottoPanel);
    	cartePanel.add(sottoPanel2);
    	
    	
    	
        GridBagConstraints gbc = new GridBagConstraints();
		JLabel utente = new JLabel("Username");
		JLabel carte=new JLabel("Carte");
		carte.setMaximumSize(new Dimension(30,30));
		JLabel tracciato=new JLabel("Tracciato");
		utente.setFont(new Font("Serif", Font.BOLD | Font.ITALIC, 15));
		utente.setBackground(Color.BLACK);
		gbc.gridx=0;
		gbc.gridy=0;
		userPanel.add(utente,gbc);
//		cartePanel.add(opacoLabel,gbc);
//		gbc.gridx=0;
//		gbc.gridy=1;
//		cartePanel.add(carte2,gbc);
		
		
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
