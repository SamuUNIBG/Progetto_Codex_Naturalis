package Grafica;

import javax.swing.*;

import Logica.LogicaGiocoGrafica;

import java.awt.*;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import java.util.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

/**
 * classe per giocare la partita da Grafica
 */

public class Game extends JFrame implements MouseListener, WindowListener {
	
	private static final long serialVersionUID = 1413119501062599452L;
	private HashMap<Integer, String> cardImageMap;
	public static ArrayList<Icon> CARDIMAGEARR;
	private LogicaGiocoGrafica logica;
	private ArrayList<UserPlayGround> userPlayGround;
	private CarteComuniPanel cComuniPanel;
	private UserPanel userPanel;
	private ScoreTrack scoreTrackPane;
	private JTabbedPane tabbedPane;
	
	public Game(ArrayList<String> username, ArrayList<String> userColor) {

		
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
		this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		this.addWindowListener(this);
		
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
        userPanel.addMouseListener(this);
        
        //sotto pannello contenente le carte
      	cComuniPanel = new CarteComuniPanel(this);
      	
        contenitoreUC.add(userPanel,BorderLayout.WEST);
        contenitoreUC.add(cComuniPanel,BorderLayout.CENTER);
        
        
        scoreTrackPane = new ScoreTrack(userColor, this);
        scoreTrackPane.addMouseListener(this);
			
      	//add component to window
        this.add(tabbedPane,BorderLayout.CENTER);
        this.add(contenitoreUC,BorderLayout.NORTH);
        this.add(scoreTrackPane,BorderLayout.WEST);
      	//makes frame visible
        this.setVisible(true);
        
        logica = new LogicaGiocoGrafica(username, userColor, this);			
	}
	/**
	 * riempie l'HashMap con tutte le carte tramite lettura da file
	 */
	private void createHashMap() {
		
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
	/**
	 * riempie l'arrayList con le immagini di tutte carte 
	 */
	private void istantiateCardImage() {
		
		for(int i=0; i<cardImageMap.size(); i++) {
			ImageIcon image = new ImageIcon(cardImageMap.get(i));
			image.setDescription(i+"");
			CARDIMAGEARR.add(image);
		}
		
	}
	/**
	 * 
	 * @param id
	 * @return l'immagine della carta in posizione id
	 */
	public static Icon getImage(int id) {
		return CARDIMAGEARR.get(id);
	}
	/**
	 * 
	 * @param id
	 * @return il percorso della carta nel file delle carte
	 */
	public String getURLImage(int id) {
		return cardImageMap.get(id);
	} 
	/**
	 * metodo per il piazzamento della carta obiettivo personale
	 * @param giocatore
	 * @param pos
	 * @param carta
	 */
	public void piazzaCartaPers(int giocatore, int pos, Icon carta) {
		userPlayGround.get(giocatore).pescaCartaP(pos, carta);
	}
	/**
	 * metodo per il piazzamento della carta iniziale
	 * @param giocatore
	 * @param carta
	 */
	public void piazzaCartaIniz(int giocatore, Icon carta) {
		userPlayGround.get(giocatore).piazzaCartaIniz(carta);
	}
	/**
	 * metodo per il piazzamento delle carte comuni quindi l obiettivo
	 * comune visibile a tutti i giocatori
	 * @param pos
	 * @param id
	 */
	public void piazzaCartaCom(int pos, Integer id) {
		cComuniPanel.piazzaCarta(pos, Game.getImage(id));
	}
	
	public void piazzaCartaCom(int pos) {
		cComuniPanel.piazzaCarta(pos);
	}
	/**
	 * gestire il pescaggio di una carta
	 * @param pos
	 */
	public void pescaCarta(int pos) {
		logica.pescaCarta(pos);
	}
	/**
	 * metodo che mette la carta pescata in mano al relativo giocatore
	 * @param img
	 */
	public void assegnaCarta(Icon img) {
		userPlayGround.get(LogicaGiocoGrafica.GIOCATOREATTUALE).pescaCartaP(img);
	}
	/**
	 * 
	 * @return la mano del giocatore
	 */
	
	public UserPanel getUserPanel() {
		return userPanel;
	}
	/**
	 * mostra il tracciato segna punti
	 * @return il tracciato
	 */
	public ScoreTrack getScoreTrackPane() {
		return scoreTrackPane;
	}
	/**
	 * 
	 * @param giocatore
	 * @return il campo di gioco del giocatore
	 */

	public UserPlayGround getUserPlayGround(int giocatore) {
		return userPlayGround.get(giocatore);
	}
	/**
	 * gestisce la giocata di una carta
	 * @param idCarta
	 * @param fronte
	 * @param posCarta
	 */
	public void giocaC(int idCarta, boolean fronte, String posCarta) {
		logica.giocaC(idCarta, fronte, posCarta);
	}
	/**
	 * in base al numero di giocatori crea i relativi campi di gioco
	 */
	public void setIndexTabbedPane(int index) {
		tabbedPane.setSelectedIndex(index);
		userPlayGround.get(index).carteVisibili(true);
		for(int i=0; i<LogicaGiocoGrafica.NUMGIOCATORI; i++) {
			if(i != index)
				userPlayGround.get(i).carteVisibili(false);
		}
	}
	/**
	 * se la carta oro soddisfa il requisito per poterla giocare
	 * @param id
	 * @return true se e giocabile
	 */
	public boolean COroGiocabile(int id) {
		return logica.COroGiocabile(id);
		
	}
	
	public boolean carteDisponibili() {
		return logica.carteDisponibili();
	}
	
	public void chiudi() {
		if(JOptionPane.showConfirmDialog(this, "Conferma Uscita", "Uscire dalla partita", JOptionPane.YES_NO_OPTION)==0) {
			this.dispose();
			new Home();
		}
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		Cursor cursor=Toolkit.getDefaultToolkit().createCustomCursor(new ImageIcon(getClass().getResource("X.png")).getImage(), new Point(0,0), "Custum cursor");
		setCursor(cursor);
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		setCursor(Cursor.getDefaultCursor());
		
	}

	@Override
	public void windowOpened(WindowEvent e) {
		JOptionPane.showMessageDialog(null, "sposta il cursore del mouse sulla carta "
				+ "x vederne il retro; \ntasto sinistro x giocarla di fronte; \n"
				+ "tasto destro x giocarla di retro",
				"INFO UTILI X GIOCARE LE CARTE",JOptionPane.INFORMATION_MESSAGE);
		
	}

	@Override
	public void windowClosing(WindowEvent e) {
		this.chiudi();		
	}

	@Override
	public void windowClosed(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowIconified(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowDeiconified(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowActivated(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowDeactivated(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

}
