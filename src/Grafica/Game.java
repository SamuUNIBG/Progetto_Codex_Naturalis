package Grafica;

import javax.swing.*;

import Carta.CObb;
import Logica.LogicaGiocoGrafica;
import Tavolo.Giocatore;

import java.awt.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import java.util.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

//utilizzare JTabbedPane. Guardare https://www.edatlas.it/scarica/informatica/info_java/Inserto3/5ScrollPaneTabbedPane.pdf

public class Game extends JFrame{
	
	private HashMap<Integer, String> cardImageMap;
	public static ArrayList<Icon> CARDIMAGEARR;
	private LogicaGiocoGrafica logica;
	private ArrayList<UserPlayGround> userPlayGround;
	private CarteComuniPanel cComuniPanel;
	private UserPanel userPanel;
	private ScoreTrack scoreTrackPane;
	private JTabbedPane tabbedPane;

	public Game(ArrayList<String> username, ArrayList<String> userColor) {
		
		//test
        //scoreTrackPane.movePawn(1, 15);
		
		cardImageMap = new HashMap<Integer, String>();
		CARDIMAGEARR = new ArrayList<Icon>();
		ImageIcon logo = new ImageIcon("images/codex_logo.png");
		
		this.setIconImage(logo.getImage());
		this.setTitle("Codex Naturalis - Partita");
		//sets the window resizable by the users
		this.setResizable(true);
		//gets the size of the screen
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		this.setSize(screenSize);
		this.setExtendedState(JFrame.MAXIMIZED_BOTH);
		//sets the window position to the center of the screen
		this.setLocation((screenSize.width/2)-(this.getWidth()/2), (screenSize.height/2)-(this.getHeight()/2));
		//exit out of application
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		this.createHashMap();
		this.istantiateCardImage();
      	
		
      	//finistre campo gioco giocatori
        tabbedPane = new JTabbedPane();
        tabbedPane.setTabPlacement(JTabbedPane.TOP);
        
        
        //Campo gioco giocatori (PlayFields + Pannello carte personali)
        userPlayGround = new  ArrayList<UserPlayGround>();
        for(int i=0; i<username.size(); i++) {
        	userPlayGround.add(new UserPlayGround(this));
        }
		
        //finistre campo gioco giocatori
        for(int i=0; i<username.size(); i++) {
        	tabbedPane.add(username.get(i),userPlayGround.get(i));
        }
        
		//contenitore carte e username
        JPanel contenitoreUC=new JPanel();
        contenitoreUC.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        contenitoreUC.setLayout(new BorderLayout());
        contenitoreUC.setOpaque(false);
        contenitoreUC.setVisible(true);
        
        //pannello contenente nomi utente
        userPanel = new UserPanel(username, userColor);
        
        //sotto pannello contenente le carte
      	cComuniPanel = new CarteComuniPanel(this);
      	
        contenitoreUC.add(userPanel,BorderLayout.WEST);
        contenitoreUC.add(cComuniPanel,BorderLayout.CENTER);
        
        
        scoreTrackPane = new ScoreTrack(userColor);
        
			
      	//add component to window
        this.add(tabbedPane,BorderLayout.CENTER);
        this.add(contenitoreUC,BorderLayout.NORTH);
      	//frame.add(userPanel,BorderLayout.WEST);
        this.add(scoreTrackPane,BorderLayout.WEST);
      	//makes frame visible
        this.setVisible(true);
        
        logica = new LogicaGiocoGrafica(username, userColor, this);			
	}
	
	private void createHashMap() {
		
		//add all card's URL to HashMap
		try {
			Scanner sc = new Scanner(new FileInputStream(new File("file/cards_URL.csv")));
	        
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
			ImageIcon image = new ImageIcon(cardImageMap.get(i));
			image.setDescription(i+"");
			CARDIMAGEARR.add(image);
		}
		
	}
	
	public static Icon getImage(int id) {
		return CARDIMAGEARR.get(id);
	}
	
	public String getURLImage(int id) {
		return cardImageMap.get(id);
	}
	
	public void piazzaCartaPers(int giocatore, int pos, Icon carta) {
		userPlayGround.get(giocatore).pescaCartaP(pos, carta);
	}
	
	public void piazzaCartaIniz(int giocatore, Icon carta) {
		userPlayGround.get(giocatore).piazzaCartaIniz(carta);
	}
	
	public void piazzaCartaCom(int pos, Integer id) {
		cComuniPanel.piazzaCarta(pos, Game.getImage(id));
		
	}
	
	public void pescaCarta(int pos) {
		logica.pescaCarta(pos);
	}
	
	public void assegnaCarta(Icon img) {
		userPlayGround.get(LogicaGiocoGrafica.GIOCATOREATTUALE).pescaCartaP(img);
	}
	
	public UserPanel getUserPanel() {
		return userPanel;
	}
	
	public ScoreTrack getScoreTrackPane() {
		return scoreTrackPane;
	}

	public UserPlayGround getUserPlayGround(int giocatore) {
		return userPlayGround.get(giocatore);
	}
	
	public void giocaC(int idCarta, boolean fronte, String posCarta) {
		logica.giocaC(idCarta, fronte, posCarta);
	}
	
	public void setIndexTabbedPane(int index) {
		tabbedPane.setSelectedIndex(index);
		userPlayGround.get(index).carteVisibili(true);
		for(int i=0; i<LogicaGiocoGrafica.numGiocatori; i++) {
			if(i != index)
				userPlayGround.get(i).carteVisibili(false);
		}
	}

	public boolean COroGiocabile(int id) {
		return logica.COroGiocabile(id);
		
	}

}
