package Grafica;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class CarteComuniPanel extends JPanel {
	
	JPanel[] sottoPanel;
	JLabel[] opacoLabelCComuni;
	
	public CarteComuniPanel() {
		
		this.setPreferredSize(new Dimension(200, 200));
		this.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		this.setLayout(new GridLayout(2,1));
		this.setOpaque(false);
		
		FlowLayout layout=new FlowLayout();
    	layout.setHgap(190);
      	layout.setVgap(16);
		
      	sottoPanel = new JPanel[2];
      	
		//sotto pannello contenente le carte
      	for(int i=0; i<sottoPanel.length; i++) {
      		sottoPanel[i] = new JPanel();
      		sottoPanel[i].setPreferredSize(new Dimension(200, 200));
      		sottoPanel[i].setBorder(BorderFactory.createLineBorder(Color.BLACK));
      		sottoPanel[i].setLayout(layout);
	      	sottoPanel[i].setOpaque(false);
      	}
      	
      	opacoLabelCComuni = new JLabel[8];
		for(int i=0; i<opacoLabelCComuni.length; i++) {
			opacoLabelCComuni[i] = new JLabel();
			opacoLabelCComuni[i].setBackground(new Color(170, 170, 170, 80));
			opacoLabelCComuni[i].setOpaque(true);
			opacoLabelCComuni[i].setPreferredSize(new Dimension(163, 113));
			opacoLabelCComuni[i].setVisible(true);
		}
		
		for(int i=0; i<4; i++) {
			//sotto pannello contenente le carte
	      	sottoPanel[0].add(opacoLabelCComuni[i]);
	      	sottoPanel[1].add(opacoLabelCComuni[i+4]);
		}
		
		this.add(sottoPanel[0]);
    	this.add(sottoPanel[1]);
		
      	
	}
	
}
