package Logica;

import java.util.ArrayList;

import java.util.Scanner;

import java.awt.*;
import javax.swing.*;

import java.awt.event.*;

import Carta.CIniz;
import Carta.CObb;
import Carta.COro;
import Carta.CRis;
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
	String[] URL;
	
	public LogicaGiocoGrafica(ArrayList<String> username, ArrayList<String> userColor, Game game) {
		
		this.game = game;
		
		cartaTavolo = new CartaTavolo();
		tracciato = new Tracciato(username, userColor);
		numGiocatori = tracciato.getNumGiocatori();
		URL = new String[2];/*{"images/cards_back/start_card_back_6.jpg", "images/cards_back/start_card_back_4.jpg"}*/;
		for(int i=0; i<numGiocatori; i++) {
			cObb = new ArrayList<CObb>();
			
			for(int j=0; j<2; j++) {
				CRis carta = (CRis) cartaTavolo.pesca(TipoCarta.CRis);
				tracciato.getGiocatore(i).pescaC(carta);
				this.pescaCPers(i, j, game.getURLImage(carta.getIdCarta()));
				
				cObb.add((CObb)cartaTavolo.pesca(TipoCarta.CObb));
				URL[j]=game.getURLImage(cObb.get(j).getIdCarta());
			}
			
			COro cartaOro = (COro) cartaTavolo.pesca(TipoCarta.COro);
			tracciato.getGiocatore(i).pescaC(cartaOro);
			this.pescaCPers(i, 2, game.getURLImage(cartaOro.getIdCarta()));
			
			//L'utente sceglie la carta obbiettivo da tenere
			GoalDecision decisioneObb = new GoalDecision(URL, username.get(i), game, this, i);
			
			CIniz cartaIniz = (CIniz) cartaTavolo.pesca(TipoCarta.CIniz);
			tracciato.getGiocatore(i).pescaC(cartaIniz);
			
			//L'utente sceglie da che lato giocare la carta iniziale
			StartDecision decisioneIniz = new StartDecision(game.getURLImage(cartaIniz.getIdCarta()), username.get(i), game, this, i);
		}
		
		Turni();
			
	}
	
	public void pescaCPers(int giocatore, int pos, String url) {
		game.piazzaCartaPers(giocatore, pos, url);
	}
	
	public void pescaCObb(int giocatore, int carta) {
		tracciato.getGiocatore(giocatore).pescaC(cObb.get(carta));
		game.piazzaCartaPers(giocatore, 3, URL[carta]);
	}
	
	public void pescaCIniz(int giocatore, String url) {
		game.piazzaCartaIniz(giocatore, url);
	}
	
	@Override
	public void pescaCarta(Giocatore giocatoreAttuale) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void Turni() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void AddPuntiObb() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void Vincitore() {
		// TODO Auto-generated method stub
		
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
