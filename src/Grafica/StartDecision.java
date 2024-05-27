package Grafica;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Toolkit;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JLabel;

import Logica.LogicaGiocoGrafica;
/**
 * classe x la gestione della carta iniziale di ogni giocatore e 
 * il relativo piazzamento
 */
public class StartDecision implements MouseListener {
	
	private JLabel cInizScelLabel;
	private JDialog dialog;
	private LogicaGiocoGrafica logica;
	private Icon urlImage;
	private Icon imgEnteredC;
	
	public StartDecision(Icon urlImage, String nome, Game game, LogicaGiocoGrafica logica) {
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
		cInizScelLabel.setIcon(urlImage);
		cInizScelLabel.addMouseListener(this);
		dialog.add(cInizScelLabel);
		dialog.setVisible(true);
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {
		if(e.getSource()==cInizScelLabel) {
			if(e.getButton()==MouseEvent.BUTTON1) {
				logica.pescaCIniz(urlImage);
				logica.giocaCIniz(true);
				dialog.dispose();
			}else if(e.getButton()==MouseEvent.BUTTON3) {
				logica.pescaCIniz(Game.getImage(calcolaNewId(Integer.parseInt(((ImageIcon)urlImage).getDescription()))));
				logica.giocaCIniz(false);
				dialog.dispose();
			}
			
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
	/**
	 * gestisce il fatto che quando un giocatore si posiziona
	 * col cursore del mouse sulla carta, gli viene mostrato il retro
	 */
	public void mouseEntered(MouseEvent e) {
		if(e.getSource()==cInizScelLabel) {
			imgEnteredC = cInizScelLabel.getIcon();
			cInizScelLabel.setIcon(Game.getImage(calcolaNewId(Integer.parseInt(((ImageIcon)imgEnteredC).getDescription()))));
		}
		
	}

	private int calcolaNewId(int id) {
		switch(id){
			case 80:
				return 110;
			case 81:
				return 111;
			case 82:
				return 112;
			case 83:
				return 113;
			case 84:
				return 114;
			case 85:
				return 115;
		
		}
		return 999;
	}

	@Override
	/**
	 * mostra il fronte della carta quando il gicoatore sposta
	 * il cursore del mouse dalla carta
	 */
	public void mouseExited(MouseEvent e) {
		if(e.getSource()==cInizScelLabel) {
			cInizScelLabel.setIcon(imgEnteredC);
		}
		
	}

}
