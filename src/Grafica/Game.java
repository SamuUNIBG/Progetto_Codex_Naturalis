package Grafica;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JFrame;

public class Game extends JFrame implements ActionListener{

	public Game(ArrayList<String> username, ArrayList<String> userColor) {
		System.out.println(username.get(0));
		/*System.out.println(username.get(1));
		System.out.println(username.get(2));
		System.out.println(username.get(3));*/
		System.out.println(userColor.get(0));
		System.out.println(userColor.get(1));
		System.out.println(userColor.get(2));
		System.out.println(userColor.get(3));
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

}
