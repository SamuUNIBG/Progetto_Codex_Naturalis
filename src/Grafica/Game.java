package Grafica;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JScrollPane;

//utilizzare JTabbedPane. Guardare https://www.edatlas.it/scarica/informatica/info_java/Inserto3/5ScrollPaneTabbedPane.pdf

public class Game extends JFrame implements ActionListener{
	
	//HashMap<Integer, String> cardImage = new HashMap<Integer, String>();

	public Game(ArrayList<String> username, ArrayList<String> userColor) {
		
		/*createHashMap();
		
		System.out.println(username.get(0));
		System.out.println(username.get(1));
		System.out.println(username.get(2));
		System.out.println(username.get(3));
		System.out.println(userColor.get(0));
		System.out.println(userColor.get(1));
		System.out.println(userColor.get(2));
		System.out.println(userColor.get(3));
		
		PlayingField playingField = new PlayingField();
		JScrollPane scrollPlayingField = new JScrollPane(playingField);
		scrollPlayingField.getViewport().setPreferredSize(new Dimension(1600, 700));
		playingField.setVisible(true);
		scrollPlayingField.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);  
		scrollPlayingField.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		
		this.getContentPane().add(scrollPlayingField);  
        this.setVisible(true);
		
		scrollPlayingField.getHorizontalScrollBar().setValue((12500-204)/2);
		scrollPlayingField.getVerticalScrollBar().setValue((5000-142)/2);
		
	}
	
	private void createHashMap() {
		//front
		//add resource card to HashMap
		cardImage.put(0, "images/cards_front/blue_resource_card_front_1.jpg");
		cardImage.put(1, "images/cards_front/blue_resource_card_front_2.jpg");
		cardImage.put(2, "images/cards_front/blue_resource_card_front_3.jpg");
		cardImage.put(3, "images/cards_front/blue_resource_card_front_4.jpg");
		cardImage.put(4, "images/cards_front/blue_resource_card_front_5.jpg");
		cardImage.put(5, "images/cards_front/blue_resource_card_front_6.jpg");
		cardImage.put(6, "images/cards_front/blue_resource_card_front_7.jpg");
		cardImage.put(7, "images/cards_front/blue_resource_card_front_8.jpg");
		cardImage.put(8, "images/cards_front/blue_resource_card_front_9.jpg");
		cardImage.put(9, "images/cards_front/blue_resource_card_front_10.jpg");
		cardImage.put(10, "images/cards_front/green_resource_card_front_1.jpg");
		cardImage.put(11, "images/cards_front/green_resource_card_front_2.jpg");
		cardImage.put(12, "images/cards_front/green_resource_card_front_3.jpg");
		cardImage.put(13, "images/cards_front/green_resource_card_front_4.jpg");
		cardImage.put(14, "images/cards_front/green_resource_card_front_5.jpg");
		cardImage.put(15, "images/cards_front/green_resource_card_front_6.jpg");
		cardImage.put(16, "images/cards_front/green_resource_card_front_7.jpg");
		cardImage.put(17, "images/cards_front/green_resource_card_front_8.jpg");
		cardImage.put(18, "images/cards_front/green_resource_card_front_9.jpg");
		cardImage.put(19, "images/cards_front/green_resource_card_front_10.jpg");
		cardImage.put(20, "images/cards_front/purple_resource_card_front_1.jpg");
		cardImage.put(21, "images/cards_front/purple_resource_card_front_2.jpg");
		cardImage.put(22, "images/cards_front/purple_resource_card_front_3.jpg");
		cardImage.put(23, "images/cards_front/purple_resource_card_front_4.jpg");
		cardImage.put(24, "images/cards_front/purple_resource_card_front_5.jpg");
		cardImage.put(25, "images/cards_front/purple_resource_card_front_6.jpg");
		cardImage.put(26, "images/cards_front/purple_resource_card_front_7.jpg");
		cardImage.put(27, "images/cards_front/purple_resource_card_front_8.jpg");
		cardImage.put(28, "images/cards_front/purple_resource_card_front_9.jpg");
		cardImage.put(29, "images/cards_front/purple_resource_card_front_10.jpg");
		cardImage.put(30, "images/cards_front/red_resource_card_front_1.jpg");
		cardImage.put(31, "images/cards_front/red_resource_card_front_2.jpg");
		cardImage.put(32, "images/cards_front/red_resource_card_front_3.jpg");
		cardImage.put(33, "images/cards_front/red_resource_card_front_4.jpg");
		cardImage.put(34, "images/cards_front/red_resource_card_front_5.jpg");
		cardImage.put(35, "images/cards_front/red_resource_card_front_6.jpg");
		cardImage.put(36, "images/cards_front/red_resource_card_front_7.jpg");
		cardImage.put(37, "images/cards_front/red_resource_card_front_8.jpg");
		cardImage.put(38, "images/cards_front/red_resource_card_front_9.jpg");
		cardImage.put(39, "images/cards_front/red_resource_card_front_10.jpg");
		//add gold card to HashMap
		cardImage.put(40, "images/cards_front/blue_gold_card_front_1.jpg");
		cardImage.put(41, "images/cards_front/blue_gold_card_front_2.jpg");
		cardImage.put(42, "images/cards_front/blue_gold_card_front_3.jpg");
		cardImage.put(43, "images/cards_front/blue_gold_card_front_4.jpg");
		cardImage.put(44, "images/cards_front/blue_gold_card_front_5.jpg");
		cardImage.put(45, "images/cards_front/blue_gold_card_front_6.jpg");
		cardImage.put(46, "images/cards_front/blue_gold_card_front_7.jpg");
		cardImage.put(47, "images/cards_front/blue_gold_card_front_8.jpg");
		cardImage.put(48, "images/cards_front/blue_gold_card_front_9.jpg");
		cardImage.put(49, "images/cards_front/blue_gold_card_front_10.jpg");
		cardImage.put(50, "images/cards_front/green_gold_card_front_1.jpg");
		cardImage.put(51, "images/cards_front/green_gold_card_front_2.jpg");
		cardImage.put(52, "images/cards_front/green_gold_card_front_3.jpg");
		cardImage.put(53, "images/cards_front/green_gold_card_front_4.jpg");
		cardImage.put(54, "images/cards_front/green_gold_card_front_5.jpg");
		cardImage.put(55, "images/cards_front/green_gold_card_front_6.jpg");
		cardImage.put(56, "images/cards_front/green_gold_card_front_7.jpg");
		cardImage.put(57, "images/cards_front/green_gold_card_front_8.jpg");
		cardImage.put(58, "images/cards_front/green_gold_card_front_9.jpg");
		cardImage.put(59, "images/cards_front/green_gold_card_front_10.jpg");
		cardImage.put(60, "images/cards_front/purple_gold_card_front_1.jpg");
		cardImage.put(61, "images/cards_front/purple_gold_card_front_2.jpg");
		cardImage.put(62, "images/cards_front/purple_gold_card_front_3.jpg");
		cardImage.put(63, "images/cards_front/purple_gold_card_front_4.jpg");
		cardImage.put(64, "images/cards_front/purple_gold_card_front_5.jpg");
		cardImage.put(65, "images/cards_front/purple_gold_card_front_6.jpg");
		cardImage.put(66, "images/cards_front/purple_gold_card_front_7.jpg");
		cardImage.put(67, "images/cards_front/purple_gold_card_front_8.jpg");
		cardImage.put(68, "images/cards_front/purple_gold_card_front_9.jpg");
		cardImage.put(69, "images/cards_front/purple_gold_card_front_10.jpg");
		cardImage.put(70, "images/cards_front/red_gold_card_front_1.jpg");
		cardImage.put(71, "images/cards_front/red_gold_card_front_2.jpg");
		cardImage.put(72, "images/cards_front/red_gold_card_front_3.jpg");
		cardImage.put(73, "images/cards_front/red_gold_card_front_4.jpg");
		cardImage.put(74, "images/cards_front/red_gold_card_front_5.jpg");
		cardImage.put(75, "images/cards_front/red_gold_card_front_6.jpg");
		cardImage.put(76, "images/cards_front/red_gold_card_front_7.jpg");
		cardImage.put(77, "images/cards_front/red_gold_card_front_8.jpg");
		cardImage.put(78, "images/cards_front/red_gold_card_front_9.jpg");
		cardImage.put(79, "images/cards_front/red_gold_card_front_10.jpg");
		//add start card to HashMap
		cardImage.put(80, "images/cards_front/start_card_front_1.jpg");
		cardImage.put(81, "images/cards_front/start_card_front_2.jpg");
		cardImage.put(82, "images/cards_front/start_card_front_3.jpg");
		cardImage.put(83, "images/cards_front/start_card_front_4.jpg");
		cardImage.put(84, "images/cards_front/start_card_front_5.jpg");
		cardImage.put(85, "images/cards_front/start_card_front_6.jpg");
		//add objective card to HashMap
		cardImage.put(86, "images/cards_front/stair_goal_card_01.jpg");
		cardImage.put(87, "images/cards_front/stair_goal_card_02.jpg");
		cardImage.put(88, "images/cards_front/stair_goal_card_03.jpg");
		cardImage.put(89, "images/cards_front/stair_goal_card_04.jpg");
		cardImage.put(90, "images/cards_front/l_goal_card_14.jpg");
		cardImage.put(91, "images/cards_front/l_goal_card_14.jpg");
		cardImage.put(92, "images/cards_front/l_goal_card_14.jpg");
		cardImage.put(93, "images/cards_front/l_goal_card_14.jpg");
		cardImage.put(94, "images/cards_front/resourse_goal_card_21.jpg");
		cardImage.put(95, "images/cards_front/resourse_goal_card_22.jpg");
		cardImage.put(96, "images/cards_front/resourse_goal_card_23.jpg");
		cardImage.put(97, "images/cards_front/resourse_goal_card_24.jpg");
		cardImage.put(98, "images/cards_front/object_goal_card_31.jpg");
		cardImage.put(99, "images/cards_front/object_goal_card_32.jpg");
		cardImage.put(100, "images/cards_front/object_goal_card_33.jpg");
		cardImage.put(101, "images/cards_front/object_goal_card_34.jpg");
		
		//back
		//add resource card to HashMap
		cardImage.put(102, "images/cards_front/blue_resource_card_front_3.jpg");
		cardImage.put(103, "images/cards_front/blue_resource_card_front_4.jpg");
		cardImage.put(104, "images/cards_front/blue_resource_card_front_5.jpg");
		cardImage.put(105, "images/cards_front/blue_resource_card_front_6.jpg");
		//add gold card to HashMap
		cardImage.put(106, "images/cards_front/blue_resource_card_front_7.jpg");
		cardImage.put(107, "images/cards_front/blue_resource_card_front_8.jpg");
		cardImage.put(108, "images/cards_front/blue_resource_card_front_9.jpg");
		cardImage.put(109, "images/cards_front/blue_resource_card_front_10.jpg");
		//add start card to HashMap
		cardImage.put(110, "images/cards_back/start_card_back_1.jpg");
		cardImage.put(111, "images/cards_back/start_card_back_2.jpg");
		cardImage.put(112, "images/cards_back/start_card_back_3.jpg");
		cardImage.put(113, "images/cards_back/start_card_back_4.jpg");
		cardImage.put(114, "images/cards_back/start_card_back_5.jpg");
		cardImage.put(115, "images/cards_back/start_card_back_6.jpg");
		//add objective card to HashMap
		cardImage.put(116, "images/cards_back/objective_card_back.jpg");*/
				
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

}
