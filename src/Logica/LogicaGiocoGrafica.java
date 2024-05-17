package Logica;

import java.util.ArrayList;

import javax.swing.*;
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
import Grafica.StartDecision;

import Tavolo.CartaTavolo;
import Tavolo.Giocatore;
import Tavolo.Tracciato;

public class LogicaGiocoGrafica implements InterfacciaLogica, MouseListener {

	private Game game;
	
	private CartaTavolo cartaTavolo;
	
	private Tracciato tracciato;
	private int numGiocatori;
	
	private ArrayList<CObb> cObb;
	private ImageIcon[] URLObb;
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
		numGiocatori = tracciato.getNumGiocatori();
		URLObb = new ImageIcon[2];
		
		
		for(int i=0; i<numGiocatori; i++) {
			LogicaGiocoGrafica.GIOCATOREATTUALE = i;
			cObb = new ArrayList<CObb>();
			
			for(int j=0; j<2; j++) {
				CRis carta = (CRis) cartaTavolo.pesca(TipoCarta.CRis);
				tracciato.getGiocatore(i).pescaC(carta);
				this.pescaCPers(i, j, Game.getImage(carta.getIdCarta()));
				
				cObb.add((CObb)cartaTavolo.pesca(TipoCarta.CObb));
				URLObb[j]=(ImageIcon) Game.getImage(cObb.get(j).getIdCarta());
			}
			
			COro cartaOro = (COro) cartaTavolo.pesca(TipoCarta.COro);
			tracciato.getGiocatore(i).pescaC(cartaOro);
			this.pescaCPers(i, 2, Game.getImage(cartaOro.getIdCarta()));
			
			//L'utente sceglie la carta obbiettivo da tenere
			GoalDecision decisioneObb = new GoalDecision(URLObb, username.get(i), game, this);
			
			CIniz cartaIniz = (CIniz) cartaTavolo.pesca(TipoCarta.CIniz);
			tracciato.getGiocatore(i).pescaC(cartaIniz);
			
			//L'utente sceglie da che lato giocare la carta iniziale
			StartDecision decisioneIniz = new StartDecision(Game.getImage(cartaIniz.getIdCarta()), username.get(i), game, this);
		}
		
		idCCom.add(cartaTavolo.getMazzoRis().getCMazzo().get(0).getIdCarta());
		System.out.println(cartaTavolo.getMazzoRis().getCMazzo().get(0).toString());
		idCCom.add(cartaTavolo.getcRisScp().get(0).getIdCarta());
		idCCom.add(cartaTavolo.getcRisScp().get(1).getIdCarta());
		idCCom.add(cartaTavolo.getcObbScp().get(0).getIdCarta());
		
		idCCom.add(cartaTavolo.getMazzoOro().getCMazzo().get(0).getIdCarta());
		idCCom.add(cartaTavolo.getcOroScp().get(0).getIdCarta());
		idCCom.add(cartaTavolo.getcOroScp().get(1).getIdCarta());
		idCCom.add(cartaTavolo.getcObbScp().get(1).getIdCarta());
		
		this.piazzaCCom(idCCom);
		
		LogicaGiocoGrafica.GIOCATOREATTUALE=-1;
		punti20=false;
		ultimoGiro=false;
		counterUltimoGiro = numGiocatori;
		
		Turni();
			
	}
	
	public void pescaCPers(int giocatore, int pos, Icon image) {
		game.piazzaCartaPers(giocatore, pos, image);
	}
	
	public void pescaCObb(int giocatore, int carta) {
		tracciato.getGiocatore(giocatore).pescaC(cObb.get(carta));
		game.piazzaCartaPers(giocatore, 3, URLObb[carta]);
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
				System.out.println("-------------------------------" + numGiocatori);
		if(LogicaGiocoGrafica.GIOCATOREATTUALE==numGiocatori-1){
			LogicaGiocoGrafica.GIOCATOREATTUALE=0;
			if(punti20)
				ultimoGiro = true;
		}else
			LogicaGiocoGrafica.GIOCATOREATTUALE++;
			System.out.println(LogicaGiocoGrafica.GIOCATOREATTUALE);
		if(ultimoGiro)
			counterUltimoGiro--;
		
		if(counterUltimoGiro>=0) {	
			giocatoreAttuale = tracciato.getGiocatore(LogicaGiocoGrafica.GIOCATOREATTUALE);
			game.getUserPlayGround(LogicaGiocoGrafica.GIOCATOREATTUALE).mouseListenerEnable(true);
		}else	//ovvero counterUltimoGiro == -1
			AddPuntiObb();		
		
		//da gestire nel mouse listener del Playing Field
				//if(!ultimoGiro)
					//pescaCarta(giocatoreAttuale);
		
	} 
	
	public boolean giocaCIniz(boolean retro) {
		giocatoreAttuale = tracciato.getGiocatore(LogicaGiocoGrafica.GIOCATOREATTUALE);
		CIniz cInizAttuale=giocatoreAttuale.getCInizPer();
		
		//se la carta e' stata giocata sul retro si setta l'attributo fronte=false
		if(retro) {
			cInizAttuale.retro();
		}
		
		giocatoreAttuale.getCPiazzate().put(cInizAttuale.getIdCarta(), cInizAttuale.toStringBreve());
		giocatoreAttuale.piazzaC(giocatoreAttuale.getCPiazzate(), "40,40", cInizAttuale);
		
		if(!retro) {
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
	
	public boolean giocaC(int idCarta, boolean retro, String posCarta) {
		
		//Giocatore giocatoreAttuale = tracciato.getGiocatore(LogicaGiocoGrafica.GIOCATOREATTUALE);
		System.out.println("giocatore: " + LogicaGiocoGrafica.GIOCATOREATTUALE + " idCarta: " + idCarta + " retro: " + retro + " posCarta: " + posCarta);
		
		int numCarta=-1;
		ArrayList<CGiocabiliSpeciali> cManoAttuale=giocatoreAttuale.getCMano();
		System.out.println(cManoAttuale);
		for(int i=0; i<cManoAttuale.size(); i++) {
			if(cManoAttuale.get(i).getIdCarta()==idCarta)
				numCarta=i;
		}
		CGiocabiliSpeciali carta = cManoAttuale.get(numCarta);
		cManoAttuale.remove(numCarta);
		
		//controllo da fare in carte personali panel
		//controllo giocabilit e' carta oro
		if(carta instanceof COro && !retro)
			((COro)carta).VerificaPrerequisito(giocatoreAttuale.getRisPossedute());
		
		//se la carta e' stata giocata sul retro si crea una nuova carta
		if(retro) {
			if(carta instanceof CRis) {
				CRis cartaRetro= new CRis(((CRis)carta).getSimbolo(), ((CRis)carta).getColore(), ((CRis)carta).getIdCarta());
				cManoAttuale.set(numCarta, cartaRetro);
			}else if(carta instanceof COro) {
				COro cartaRetro= new COro(((CRis)carta).getSimbolo(), ((CRis)carta).getColore(), ((CRis)carta).getIdCarta());
				cManoAttuale.set(numCarta, cartaRetro);
			}
		}else {
			int puntiCarta = carta.getPunti();
			if(carta instanceof COro)
				puntiCarta = ((COro)carta).calcolaMiniObb(posCarta, giocatoreAttuale);
			giocatoreAttuale.addPunteggio(puntiCarta);
			game.getScoreTrackPane().movePawn(LogicaGiocoGrafica.GIOCATOREATTUALE, giocatoreAttuale.getPunteggio());
		}
		
		giocatoreAttuale.getCPiazzate().put(carta.getIdCarta(), carta.toStringBreve());
		giocatoreAttuale.piazzaC(giocatoreAttuale.getCPiazzate(), posCarta, carta);
		
		game.getUserPanel().getUser(LogicaGiocoGrafica.GIOCATOREATTUALE).aggiornaResource(giocatoreAttuale.getRisPossedute());
		game.getUserPanel().getUser(LogicaGiocoGrafica.GIOCATOREATTUALE).aggiornaObjects(giocatoreAttuale.getOggPosseduti());
		
		game.getUserPlayGround(LogicaGiocoGrafica.GIOCATOREATTUALE).getPlayingField().addLabel(giocatoreAttuale.getCampoG().getPosReturn());
		
		return true;
	}
	
	public void pescaCarta(int pos) {
		
		if(giocatoreAttuale.getPunteggio() > 19 || (cartaTavolo.getMazzoOro().getCRimaste()==0 && cartaTavolo.getMazzoRis().getCRimaste()==0)) {
			punti20 = true;
		}
		System.out.println("possssssssssssss"+pos);
		switch(pos) {
			case 0:
				CRis carta = (CRis) cartaTavolo.pesca(TipoCarta.CRis);
				giocatoreAttuale.pescaC(carta);
				game.piazzaCartaCom(0, cartaTavolo.getMazzoRis().getCMazzo().get(0).getIdCarta());
				this.Turni();
//				return carta.getIdCarta();
			case 1:
				CRis carta1 = (CRis) cartaTavolo.pesca(TipoCarta.CRis,0);
				giocatoreAttuale.pescaC(carta1);
				game.piazzaCartaCom(0, cartaTavolo.getMazzoRis().getCMazzo().get(0).getIdCarta());
//				game.piazzaNuovaCartaCom(pos);
				this.Turni();
//				return carta1.getIdCarta();
			case 2:
				CRis carta2 = (CRis) cartaTavolo.pesca(TipoCarta.CRis,1);
				giocatoreAttuale.pescaC(carta2);
				game.piazzaCartaCom(0, cartaTavolo.getMazzoRis().getCMazzo().get(0).getIdCarta());
//				game.piazzaNuovaCartaCom(pos);
				this.Turni();
//				return carta2.getIdCarta();
			case 4:
				COro carta4 = (COro) cartaTavolo.pesca(TipoCarta.COro);
				giocatoreAttuale.pescaC(carta4);
				game.piazzaCartaCom(4, cartaTavolo.getMazzoOro().getCMazzo().get(0).getIdCarta());
				this.Turni();
//				return carta4.getIdCarta();
			case 5:
				COro carta5 = (COro) cartaTavolo.pesca(TipoCarta.COro,0);
				giocatoreAttuale.pescaC(carta5);
				game.piazzaCartaCom(4, cartaTavolo.getMazzoOro().getCMazzo().get(0).getIdCarta());
//				game.piazzaNuovaCartaCom(pos);
				this.Turni();
//				return carta5.getIdCarta();
			case 6:
				COro carta6 = (COro) cartaTavolo.pesca(TipoCarta.COro,1);
				giocatoreAttuale.pescaC(carta6);
				game.piazzaCartaCom(4, cartaTavolo.getMazzoOro().getCMazzo().get(0).getIdCarta());
//				game.piazzaNuovaCartaCom(pos);
				this.Turni();
//				return carta6.getIdCarta();
		}
		
		//return 999;
		
	}

	@Override
	public void AddPuntiObb() {
		
		ArrayList<CObb> cObb = cartaTavolo.getcObbScp();
		
		for(int i=0; i<numGiocatori; i++) {			
			cObb.get(0).calcolaObb(tracciato.getGiocatore(i));
			cObb.get(1).calcolaObb(tracciato.getGiocatore(i));
			CObb cObbPers = tracciato.getGiocatore(i).getCObbPer();
			cObbPers.calcolaObb(tracciato.getGiocatore(i));
		}
		
		Vincitore();
		
	}

	@Override
	public void Vincitore() {
		
		int maxPunti=tracciato.getGiocatore(0).getPunteggio();
		ArrayList<String> giocatore = new ArrayList<String>();
		giocatore.add(tracciato.getGiocatore(0).getSoprannome());
		
		for(int i=1; i<numGiocatori; i++) {
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
			JOptionPane vincitore = new JOptionPane();
			System.out.println("Ha vinto solo un giocatore:\n");
		}else {
			System.out.println("Hanno vinto "+giocatore.size()+" giocatori:\n");
		}
		for(int i=0;i<giocatore.size();i++) {
			System.out.println("Congratulazioni "+giocatore.get(i)+" hai vinto!\n");
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
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

}
