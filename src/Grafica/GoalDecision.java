package Grafica;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Toolkit;
import java.util.ArrayList;
import java.awt.event.*;

import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;

import Carta.CObb;
import Logica.LogicaGiocoGrafica;
/**
 * classe per la scelta della carta obiettivo segreta di ogni giocatore
 */
public class GoalDecision implements MouseListener {
	
	private JLabel[] cObbScelLabel;
	private JDialog dialog;
	private Game game;
	private LogicaGiocoGrafica logica;
	
	public GoalDecision(ImageIcon[] urlImage, String nome, Game game, LogicaGiocoGrafica logica){
		this.game = game;
		this.logica = logica;
		cObbScelLabel = new JLabel[2];
		dialog = new JDialog(game, "", true);
		dialog.setSize(360,160);
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		//sets the window position to the center of the screen
		dialog.setLocation((screenSize.width/2)-(dialog.getWidth()/2), (screenSize.height/2)-(dialog.getHeight()/2));
		dialog.setLayout(new FlowLayout());
		dialog.setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
		dialog.setTitle(nome + " - Seleziona la carta obbiettivo che preferisci");
		for(int i=0; i<2; i++) {
			cObbScelLabel[i] = new JLabel();
			cObbScelLabel[i].setIcon(urlImage[i]);
			cObbScelLabel[i].addMouseListener(this);
			dialog.add(cObbScelLabel[i]);
		}
		dialog.setVisible(true);
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		if(e.getSource()==cObbScelLabel[0]) {
			logica.pescaCObb(LogicaGiocoGrafica.GIOCATOREATTUALE, 0);
			dialog.dispose();
			
		}else if(e.getSource()==cObbScelLabel[1]) {
			logica.pescaCObb(LogicaGiocoGrafica.GIOCATOREATTUALE, 1);
			dialog.dispose();
		}
		
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
