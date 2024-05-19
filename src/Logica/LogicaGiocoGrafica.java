package Logica;

import java.util.ArrayList;

import javax.swing.*;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Toolkit;
import java.awt.event.*;

import Carta.CGiocabiliSpeciali;
import Carta.CIniz;
import Carta.CObb;
import Carta.COro;
import Carta.CRis;

import Enumerazione.Simbolo;
import Enumerazione.TipoCarta;

import Grafica.Game;
import Grafica.GoalDecision;
import Grafica.Home;
import Grafica.StartDecision;

import Tavolo.CartaTavolo;
import Tavolo.Giocatore;
import Tavolo.Tracciato;

public class LogicaGiocoGrafica extends JFrame implements InterfacciaLogica,ActionListener {

	private Game game;
	
	private CartaTavolo cartaTavolo;
	
	private Tracciato tracciato;
	public static int NUMGIOCATORI;
	private JFrame frame = new JFrame();
	private JButton closeButton;
	private ArrayList<CObb> cObb;
	private ImageIcon[] imgObb;
	private ArrayList<Integer> idCCom;
	
	private Giocatore giocatoreAttuale;
	public static int GIOCATOREATTUALE;
	
	private boolean punti20;
	private boolean ultimoGiro;
	private int counterUltimoGiro;
	
	public LogicaGiocoGrafica(ArrayList<String> username, ArrayList<String> userColor, Game game) {
		
		this.game = game;
		
		idCCom = new ArrayList<Integer>();
		cartaTavolo = new CartaTavolo();
		tracciato = new Tracciato(username, userColor);
		LogicaGiocoGrafica.NUMGIOCATORI = tracciato.getNumGiocatori();
		imgObb = new ImageIcon[2];
		
		for(int i=0; i<LogicaGiocoGrafica.NUMGIOCATORI; i++) {
			LogicaGiocoGrafica.GIOCATOREATTUALE = i;
			cObb = new ArrayList<CObb>();
			
			for(int j=0; j<2; j++) {
				CRis carta = (CRis) cartaTavolo.pesca(TipoCarta.CRis);
				tracciato.getGiocatore(i).pescaC(carta);
//				System.out.println(carta.toString());
				this.pescaCPers(LogicaGiocoGrafica.GIOCATOREATTUALE, j, Game.getImage(carta.getIdCarta()));
				
				cObb.add((CObb)cartaTavolo.pesca(TipoCarta.CObb));
//				System.out.println(cObb.get(j).toString());
				imgObb[j]=(ImageIcon) Game.getImage(cObb.get(j).getIdCarta());
			}
			
			COro cartaOro = (COro) cartaTavolo.pesca(TipoCarta.COro);
			tracciato.getGiocatore(LogicaGiocoGrafica.GIOCATOREATTUALE).pescaC(cartaOro);
//			System.out.println(cartaOro.toString());
			this.pescaCPers(LogicaGiocoGrafica.GIOCATOREATTUALE, 2, Game.getImage(cartaOro.getIdCarta()));
			
			//L'utente sceglie la carta obbiettivo da tenere
			GoalDecision decisioneObb = new GoalDecision(imgObb, username.get(LogicaGiocoGrafica.GIOCATOREATTUALE), game, this);
			
			CIniz cartaIniz = (CIniz) cartaTavolo.pesca(TipoCarta.CIniz);
			tracciato.getGiocatore(LogicaGiocoGrafica.GIOCATOREATTUALE).pescaC(cartaIniz);
//			System.out.println(cartaIniz.toString());
			
			//L'utente sceglie da che lato giocare la carta iniziale
			StartDecision decisioneIniz = new StartDecision(Game.getImage(cartaIniz.getIdCarta()), username.get(LogicaGiocoGrafica.GIOCATOREATTUALE), game, this);
		}
		
		idCCom.add(cartaTavolo.getMazzoRis().getCMazzo().get(0).getIdCarta());
//		System.out.println(cartaTavolo.getMazzoRis().getCMazzo().get(0).toString());
		idCCom.add(cartaTavolo.getcRisScp().get(0).getIdCarta());
//		System.out.println(cartaTavolo.getcRisScp().get(0).toString());
		idCCom.add(cartaTavolo.getcRisScp().get(1).getIdCarta());
//		System.out.println(cartaTavolo.getcRisScp().get(1).toString());
		idCCom.add(cartaTavolo.getcObbScp().get(0).getIdCarta());
//		System.out.println(cartaTavolo.getcObbScp().get(0).toString());
		
		idCCom.add(cartaTavolo.getMazzoOro().getCMazzo().get(0).getIdCarta());
//		System.out.println(cartaTavolo.getMazzoOro().getCMazzo().get(0).toString());
		idCCom.add(cartaTavolo.getcOroScp().get(0).getIdCarta());
//		System.out.println(cartaTavolo.getcOroScp().get(0).toString());
		idCCom.add(cartaTavolo.getcOroScp().get(1).getIdCarta());
//		System.out.println(cartaTavolo.getcOroScp().get(1).toString());
		idCCom.add(cartaTavolo.getcObbScp().get(1).getIdCarta());
//		System.out.println(cartaTavolo.getcObbScp().get(1).toString());
		
		this.piazzaCCom(idCCom);
		
		LogicaGiocoGrafica.GIOCATOREATTUALE=-1;
		punti20=false;
		ultimoGiro=false;
		counterUltimoGiro = LogicaGiocoGrafica.NUMGIOCATORI;
		
		Turni();
			
	}
	
	public void pescaCPers(int giocatore, int pos, Icon image) {
		game.piazzaCartaPers(giocatore, pos, image);
	}
	
	public void pescaCObb(int giocatore, int carta) {
		tracciato.getGiocatore(giocatore).pescaC(cObb.get(carta));
		game.piazzaCartaPers(giocatore, 3, imgObb[carta]);
	}
	
	public void pescaCIniz(Icon url) {
		game.piazzaCartaIniz(LogicaGiocoGrafica.GIOCATOREATTUALE, url);
	}
	
	public void piazzaCCom(ArrayList<Integer> idCCom) {
		for(int i=0; i<idCCom.size(); i++) {
			game.piazzaCartaCom(i, idCCom.get(i));
		}
		
	}

	@Override
	public void Turni() {
		if(LogicaGiocoGrafica.GIOCATOREATTUALE==LogicaGiocoGrafica.NUMGIOCATORI-1){
			LogicaGiocoGrafica.GIOCATOREATTUALE=0;
			if(punti20)
				ultimoGiro = true;
		}else
			LogicaGiocoGrafica.GIOCATOREATTUALE++;
		if(ultimoGiro)
			counterUltimoGiro--;
		
		if(counterUltimoGiro>=0) {	
			giocatoreAttuale = tracciato.getGiocatore(LogicaGiocoGrafica.GIOCATOREATTUALE);
			game.setIndexTabbedPane(LogicaGiocoGrafica.GIOCATOREATTUALE);
			game.getUserPlayGround(LogicaGiocoGrafica.GIOCATOREATTUALE).mouseListenerEnable(true);
		}else	//ovvero counterUltimoGiro == -1
			AddPuntiObb();		
		
		//da gestire nel mouse listener del Playing Field
				//if(!ultimoGiro)
					//pescaCarta(giocatoreAttuale);
		
	} 
	
	public boolean giocaCIniz(boolean fronte) {
		giocatoreAttuale = tracciato.getGiocatore(LogicaGiocoGrafica.GIOCATOREATTUALE);
		CIniz cInizAttuale=giocatoreAttuale.getCInizPer();
		
		//se la carta e' stata giocata sul retro si setta l'attributo fronte=false
		if(!fronte) {
			cInizAttuale.retro();
		}
		
		giocatoreAttuale.getCPiazzate().put(cInizAttuale.getIdCarta(), cInizAttuale.toStringBreve());
		giocatoreAttuale.piazzaC(giocatoreAttuale.getCPiazzate(), "40,40", cInizAttuale);
		
		if(fronte) {
			//aggiunge al vettore delle risorse possedute le risorse centrali della carta
			for(int i=0; i<cInizAttuale.getRisorseCentrali().size(); i++) {
				if(cInizAttuale.getRisorseCentrali().get(i)==Simbolo.FOGLIA) {
					giocatoreAttuale.getRisPossedute()[0]+=1;
				}else if(cInizAttuale.getRisorseCentrali().get(i)==Simbolo.LUPO) {
					giocatoreAttuale.getRisPossedute()[1]+=1;
				}else if(cInizAttuale.getRisorseCentrali().get(i)==Simbolo.FUNGO) {
					giocatoreAttuale.getRisPossedute()[2]+=1;
				}else if(cInizAttuale.getRisorseCentrali().get(i)==Simbolo.FARFALLA) {
					giocatoreAttuale.getRisPossedute()[3]+=1;
				}
			}
		}
		
		game.getUserPanel().getUser(LogicaGiocoGrafica.GIOCATOREATTUALE).aggiornaResource(giocatoreAttuale.getRisPossedute());
		
		game.getUserPlayGround(LogicaGiocoGrafica.GIOCATOREATTUALE).getPlayingField().addLabel(giocatoreAttuale.getCampoG().getPosReturn());
		
		return true;
		
	}
	
	public boolean COroGiocabile(int idCarta) {
		int numCarta=-1;
		ArrayList<CGiocabiliSpeciali> cManoAttuale=giocatoreAttuale.getCMano();
		for(int i=0; i<cManoAttuale.size(); i++) {
			if(cManoAttuale.get(i).getIdCarta()==idCarta)
				numCarta=i;
		}
		CGiocabiliSpeciali carta = cManoAttuale.get(numCarta);
		
		//controllo da fare in carte personali panel
		//controllo giocabilit e' carta oro
		//if(carta instanceof COro)
		if(((COro)carta).VerificaPrerequisito(giocatoreAttuale.getRisPossedute()))
			return true;
		else
			return false;
		
	}
	
	public boolean giocaC(int idCarta, boolean fronte, String posCarta) {
		
		System.out.println("giocatore: " + LogicaGiocoGrafica.GIOCATOREATTUALE + " idCarta: " + idCarta + " fronte: " + fronte + " posCarta: " + posCarta);
		
		int numCarta=-1;
		ArrayList<CGiocabiliSpeciali> cManoAttuale=giocatoreAttuale.getCMano();
		
		for(int i=0; i<cManoAttuale.size(); i++) {
			if(cManoAttuale.get(i).getIdCarta()==idCarta)
				numCarta=i;
		}
		CGiocabiliSpeciali carta = cManoAttuale.get(numCarta);
		cManoAttuale.remove(numCarta);
		
		//se la carta e' stata giocata sul retro si crea una nuova carta
		if(!fronte) {
			if(carta instanceof CRis) {
				CRis cartaRetro= new CRis(((CRis)carta).getSimbolo(), ((CRis)carta).getColore(), ((CRis)carta).getIdCarta());
				carta = cartaRetro;
			}else if(carta instanceof COro) {
				COro cartaRetro= new COro(((COro)carta).getSimbolo(), ((COro)carta).getColore(), ((COro)carta).getIdCarta());
				carta = cartaRetro;
			}
		}else {
			int puntiCarta = carta.getPunti();
			if(carta instanceof COro)
				puntiCarta = ((COro)carta).calcolaMiniObb(posCarta, giocatoreAttuale);
			giocatoreAttuale.addPunteggio(puntiCarta);
			game.getScoreTrackPane().movePawn(LogicaGiocoGrafica.GIOCATOREATTUALE, giocatoreAttuale.getPunteggio());
		}
		
		giocatoreAttuale.getCPiazzate().put(carta.getIdCarta(), carta.toStringBreve());
		System.out.println(carta.toStringBreve());
		giocatoreAttuale.piazzaC(giocatoreAttuale.getCPiazzate(), posCarta, carta);

		game.getUserPanel().getUser(LogicaGiocoGrafica.GIOCATOREATTUALE).aggiornaResource(giocatoreAttuale.getRisPossedute());
		game.getUserPanel().getUser(LogicaGiocoGrafica.GIOCATOREATTUALE).aggiornaObjects(giocatoreAttuale.getOggPosseduti());
		
		game.getUserPlayGround(LogicaGiocoGrafica.GIOCATOREATTUALE).getPlayingField().addLabel(giocatoreAttuale.getCampoG().getPosReturn());
		game.getUserPlayGround(LogicaGiocoGrafica.GIOCATOREATTUALE).getPlayingField().removeLabel(giocatoreAttuale.getCampoG().getPosNonPiuDisponibili());
		
		return true;
	}
	
	public void pescaCarta(int pos) {
		
		if(giocatoreAttuale.getPunteggio() > 0 || (cartaTavolo.getMazzoOro().getCRimaste()==0 && cartaTavolo.getMazzoRis().getCRimaste()==0)) {
			punti20 = true;
		}
		
		switch(pos) {
			case 0:
				CRis carta = (CRis) cartaTavolo.pesca(TipoCarta.CRis);
				giocatoreAttuale.pescaC(carta);
				game.piazzaCartaCom(0, cartaTavolo.getMazzoRis().getCMazzo().get(0).getIdCarta());
				this.Turni();
				break;
			case 1:
				CRis carta1 = (CRis) cartaTavolo.pesca(TipoCarta.CRis,0);
				giocatoreAttuale.pescaC(carta1);
				game.piazzaCartaCom(0, cartaTavolo.getMazzoRis().getCMazzo().get(0).getIdCarta());
				this.Turni();
				break;
			case 2:
				CRis carta2 = (CRis) cartaTavolo.pesca(TipoCarta.CRis,1);
				giocatoreAttuale.pescaC(carta2);
				game.piazzaCartaCom(0, cartaTavolo.getMazzoRis().getCMazzo().get(0).getIdCarta());
				this.Turni();
				break;
			case 4:
				COro carta4 = (COro) cartaTavolo.pesca(TipoCarta.COro);
				giocatoreAttuale.pescaC(carta4);
				game.piazzaCartaCom(4, cartaTavolo.getMazzoOro().getCMazzo().get(0).getIdCarta());
				this.Turni();
				break;
			case 5:
				COro carta5 = (COro) cartaTavolo.pesca(TipoCarta.COro,0);
				giocatoreAttuale.pescaC(carta5);
				game.piazzaCartaCom(4, cartaTavolo.getMazzoOro().getCMazzo().get(0).getIdCarta());
				this.Turni();
				break;
			case 6:
				COro carta6 = (COro) cartaTavolo.pesca(TipoCarta.COro,1);
				giocatoreAttuale.pescaC(carta6);
				game.piazzaCartaCom(4, cartaTavolo.getMazzoOro().getCMazzo().get(0).getIdCarta());
				this.Turni();
				break;
		}
		
	}

	@Override
	public void AddPuntiObb() {
		
		ArrayList<CObb> cObb = cartaTavolo.getcObbScp();
		
		for(int i=0; i<LogicaGiocoGrafica.NUMGIOCATORI; i++) {			
			cObb.get(0).calcolaObb(tracciato.getGiocatore(i));
			cObb.get(1).calcolaObb(tracciato.getGiocatore(i));
			CObb cObbPers = tracciato.getGiocatore(i).getCObbPer();
			cObbPers.calcolaObb(tracciato.getGiocatore(i));
			game.getScoreTrackPane().movePawn(LogicaGiocoGrafica.GIOCATOREATTUALE, giocatoreAttuale.getPunteggio());
		}
		
		Vincitore();
		
	}

	@Override
	public void Vincitore() {
		ImageIcon logo = new ImageIcon("images/codex_logo.png");
		ImageIcon sfondo = new ImageIcon("images/sfondi/sfondoBianco.jpg");
		//sets title, dimension of the JFrame
		frame.setIconImage(logo.getImage());
		frame.setTitle("Codex Naturalis - Vincitori");
		frame.setPreferredSize(new Dimension(500,500));
		
		//frame.setMinimumSize(new Dimension(sfondo.getIconWidth()+16, sfondo.getIconHeight()+39));
		//sets the window not resizable by the users
		frame.setResizable(false);
		//gets the size of the screen
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		//sets the window position to the center of the screen
		frame.setLocation((screenSize.width/2)-(frame.getWidth()/2), (screenSize.height/2)-(frame.getHeight()/2));
		//exit out of application
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		 
		//titolo
		JLabel titleLabel = new JLabel();
		titleLabel.setText("VINCITORI");
		titleLabel.setFont(new Font("Serif", Font.BOLD | Font.ITALIC, 30));
		titleLabel.setForeground(Color.BLACK);
		titleLabel.setOpaque(false);
		
		
		//buttons to add to the infoPanel
		closeButton = new JButton("Close");
		closeButton.setFocusPainted(false);
		closeButton.addActionListener(this);				
		//panel with info components
		JPanel infoPanel = new JPanel();
		infoPanel.setPreferredSize(new Dimension(300, 300));
	    infoPanel.setLayout(new GridBagLayout());
		infoPanel.setOpaque(false);
		
		//needed to set a gap between ifnoPanel and homeButton
		JPanel gapPanel = new JPanel();
		gapPanel.setPreferredSize(new Dimension(100, 100));
		gapPanel.setOpaque(false);
		JPanel gapPanel2 = new JPanel();
		gapPanel2.setPreferredSize(new Dimension(100, 100));
		gapPanel2.setOpaque(false);
		
		
		
		//add components to infoPanel
		GridBagConstraints gbc = new GridBagConstraints();
		int y=0;
		gbc.gridx=0;
		gbc.gridy=0;
		infoPanel.add(titleLabel,gbc);
		
		
		int maxPunti=tracciato.getGiocatore(0).getPunteggio();
		ArrayList<String> giocatore = new ArrayList<String>();
		giocatore.add(tracciato.getGiocatore(0).getSoprannome());
		
		for(int i=1; i<LogicaGiocoGrafica.NUMGIOCATORI; i++) {
			int punti = tracciato.getGiocatore(i).getPunteggio();
			if(punti > maxPunti) {
				giocatore.clear();
				giocatore.add(tracciato.getGiocatore(i).getSoprannome());
				maxPunti = punti;
			}else if(punti == maxPunti) {
				giocatore.add(tracciato.getGiocatore(i).getSoprannome());
			}
		}//aggiungere vari JOptionPane per comunicare il vincitore
		if(giocatore.size()==1) {
			JOptionPane.showMessageDialog(null, "Ha vinto un solo giocatore!","Title",JOptionPane.INFORMATION_MESSAGE);
			System.out.println("Ha vinto solo un giocatore:\n");
		}else {
			JOptionPane.showMessageDialog(null, "Hanno vinto "+giocatore.size()+" giocatori","Title",JOptionPane.INFORMATION_MESSAGE);
			System.out.println("Hanno vinto "+giocatore.size()+" giocatori:\n");
		}
		for(int i=0;i<giocatore.size();i++) {
			JLabel vincitore=new JLabel(giocatore.get(i));
			
			gbc.gridx=0;
			gbc.gridy=y+2;
			infoPanel.add(vincitore, gbc);
			gbc.gridx=0;
			gbc.gridy=y+3;
			infoPanel.add(gapPanel, gbc);
			y+=2;
			System.out.println("Congratulazioni "+giocatore.get(i)+" hai vinto!\n");
		}
		gbc.gridx=0;
		gbc.gridy=y+1;
		infoPanel.add(closeButton, gbc);
		JLabel sfondoLabel = new JLabel();
		sfondoLabel.setIcon(sfondo);
		
		//panel with titleLabel and selectGamePanel
		JPanel selectGamePanel = new JPanel();
		selectGamePanel.setLayout(new GridBagLayout());
		
		//add components to rowPanel
		gbc.gridx=0;
		gbc.gridy=0;
		selectGamePanel.add(infoPanel, gbc); 
		selectGamePanel.add(sfondoLabel, gbc);
		
		//add homePanel to window
		frame.add(selectGamePanel);
		//set window's dimension based on components
		frame.pack();
		//makes frame visible
		frame.setVisible(true);		
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==closeButton) {
			frame.dispose();
			new Home();
		}
		
	}

}
