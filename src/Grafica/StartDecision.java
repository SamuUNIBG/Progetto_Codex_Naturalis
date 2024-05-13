package Grafica;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Toolkit;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JLabel;

import Logica.LogicaGiocoGrafica;

public class StartDecision implements MouseListener {
	
	private JLabel cInizScelLabel;
	private JDialog dialog;
	private int giocatore;
	private Game game;
	private LogicaGiocoGrafica logica;
	private String urlImage;
	
	public StartDecision(String urlImage, String nome, Game game, LogicaGiocoGrafica logica, int giocatore) {
		this.giocatore = giocatore;
		this.game = game;
		this.logica = logica;
		this.urlImage = urlImage;
		
		dialog = new JDialog(game, "", true);
		dialog.setSize(360,160);
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		//sets the window position to the center of the screen
		dialog.setLocation((screenSize.width/2)-(dialog.getWidth()/2), (screenSize.height/2)-(dialog.getHeight()/2));
		dialog.setLayout(new FlowLayout());
		dialog.setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
		dialog.setTitle(nome + " - Come vuoi giocare la carta?");
		cInizScelLabel = new JLabel();
		cInizScelLabel.setIcon(new ImageIcon(urlImage));
		cInizScelLabel.addMouseListener(this);
		dialog.add(cInizScelLabel);
		dialog.setVisible(true);
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {
		if(e.getSource()==cInizScelLabel) {
			logica.pescaCIniz(giocatore, urlImage);
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
