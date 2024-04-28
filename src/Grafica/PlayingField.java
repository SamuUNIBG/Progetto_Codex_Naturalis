package Grafica;

import java.awt.*;

import javax.swing.*;

public class PlayingField extends JPanel {
	
	JLabel label1

	public PlayingField(){
		
		this.setPreferredSize(new Dimension(1000, 1000));
		this.setLayout(null);
		
		JLabel label1 = new JLabel();
		label1.setOpaque(true);
		label1.setBackground(Color.RED);
		label1.setBounds(50, 50, 200, 200);
		
		JLabel label2 = new JLabel();
		label2.setOpaque(true);
		label2.setBackground(Color.GREEN);
		label2.setBounds(60, 60, 200, 200);
		
		JLabel label3 = new JLabel();
		label3.setOpaque(true);
		label3.setBackground(Color.BLUE);
		label3.setBounds(70, 70, 200, 200);
		
		JLabel label4 = new JLabel();
		label4.setOpaque(true);
		label4.setBackground(Color.YELLOW);
		label4.setBounds(80, 80, 200, 200);
		
		JLabel label5 = new JLabel();
		label5.setOpaque(true);
		label5.setBackground(Color.CYAN);
		label5.setBounds(90, 90, 200, 200);
		
		JLabel label6 = new JLabel();
		label6.setOpaque(true);
		label6.setBackground(Color.DARK_GRAY);
		label6.setBounds(100, 100, 200, 200);
		
		JLabel label7 = new JLabel();
		label7.setOpaque(true);
		label7.setBackground(Color.LIGHT_GRAY);
		label7.setBounds(110, 110, 200, 200);
		
		JLabel label8 = new JLabel();
		label8.setOpaque(true);
		label8.setBackground(Color.MAGENTA);
		label8.setBounds(120, 120, 200, 200);
		
		JLayeredPane layeredPane = new JLayeredPane();
		layeredPane.setBounds(0, 0, 500, 500);
		
		layeredPane.add(label1, Integer.valueOf(0));	//JLayeredPane.DEFAULT_LAYER
		layeredPane.add(label2, Integer.valueOf(1));
		layeredPane.add(label3, Integer.valueOf(2));
		layeredPane.add(label4, Integer.valueOf(3));
		layeredPane.add(label5, Integer.valueOf(4));
		layeredPane.add(label6, Integer.valueOf(5));
		layeredPane.add(label7, Integer.valueOf(6));
		layeredPane.add(label8, Integer.valueOf(7));
		
		JFrame frame = new JFrame();
		frame.setSize(500, 500);	//set the x-dimension, and y-dimension of frame
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	//exit out of application
		frame.setLayout(null);
		
		frame.add(layeredPane);
		
		frame.setVisible(true);
	
	}
	
}
