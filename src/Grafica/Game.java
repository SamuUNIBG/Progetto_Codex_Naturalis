package Grafica;

import javax.swing.*;

import java.awt.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import java.util.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

//utilizzare JTabbedPane. Guardare https://www.edatlas.it/scarica/informatica/info_java/Inserto3/5ScrollPaneTabbedPane.pdf

public class Game extends JFrame implements ActionListener{
	
	HashMap<Integer, String> cardImageMap;
	ArrayList<ImageIcon> cardImageArr;

	public Game(ArrayList<String> username, ArrayList<String> userColor) {
		
		cardImageMap = new HashMap<Integer, String>();
		cardImageArr = new ArrayList<ImageIcon>();
		ImageIcon logo = new ImageIcon("images/codex_logo.png");
		
		this.setIconImage(logo.getImage());
		this.setTitle("Codex Naturalis - Partita");
		//sets the window resizable by the users
		this.setResizable(true);
		//gets the size of the screen
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		this.setSize(screenSize);
		this.setExtendedState(JFrame.MAXIMIZED_BOTH);
		//sets the window position to the center of the screen
		this.setLocation((screenSize.width/2)-(this.getWidth()/2), (screenSize.height/2)-(this.getHeight()/2));
		//exit out of application
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		this.createHashMap();
		this.istantiateCardImage();
		
		
		//per test
		/*System.out.println(username.get(0));
		System.out.println(username.get(1));
		System.out.println(username.get(2));
		System.out.println(username.get(3));
		System.out.println(userColor.get(0));
		System.out.println(userColor.get(1));
		System.out.println(userColor.get(2));
		System.out.println(userColor.get(3));*/
		
		FlowLayout layout=new FlowLayout();
    	layout.setHgap(190);
      	layout.setVgap(16);
		
		//sotto pannello contenente le carte
      	JPanel sottoPanel=new JPanel();
      	sottoPanel.setPreferredSize(new Dimension(200, 200));
      	sottoPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
      	sottoPanel.setLayout(layout);
      	sottoPanel.setOpaque(false);
      	
      	//sotto pannello contenente le carte
      	JPanel sottoPanel2=new JPanel();
      	sottoPanel2.setPreferredSize(new Dimension(200, 200));
      	sottoPanel2.setBorder(BorderFactory.createLineBorder(Color.BLACK));
      	sottoPanel2.setLayout(layout);
      	sottoPanel2.setOpaque(false);
		        
		JLabel[] opacoLabelCComuni = new JLabel[8];
		for(int i=0; i<opacoLabelCComuni.length; i++) {
			opacoLabelCComuni[i] = new JLabel();
			opacoLabelCComuni[i].setBackground(new Color(170, 170, 170, 80));
			opacoLabelCComuni[i].setOpaque(true);
			opacoLabelCComuni[i].setPreferredSize(new Dimension(163, 113));
			opacoLabelCComuni[i].setVisible(true);
		}
		
		//sotto pannello contenente le carte
      	sottoPanel.add(opacoLabelCComuni[0]);
      	sottoPanel.add(opacoLabelCComuni[1]);
      	sottoPanel.add(opacoLabelCComuni[2]);
      	sottoPanel.add(opacoLabelCComuni[3]);
		//sotto pannello contenente le carte
      	sottoPanel2.add(opacoLabelCComuni[4]);
      	sottoPanel2.add(opacoLabelCComuni[5]);
      	sottoPanel2.add(opacoLabelCComuni[6]);
      	sottoPanel2.add(opacoLabelCComuni[7]);
      	
      	//finistre campo gioco giocatori
        JTabbedPane tabbedPane = new JTabbedPane();
        tabbedPane.setTabPlacement(JTabbedPane.TOP);
      	
      	//contenitori carte personali
		ArrayList<JPanel> contenitore = new ArrayList<JPanel>(4);
		for(int i=0; i<username.size(); i++) {
			contenitore.add(new JPanel());
			contenitore.get(i).setBorder(BorderFactory.createLineBorder(Color.BLACK));
			contenitore.get(i).setLayout(new GridBagLayout());
			contenitore.get(i).setOpaque(false);
			contenitore.get(i).setMinimumSize(new Dimension(screenSize.width-330, screenSize.height-345));
		}
		
		//creo scrollPlayingField e playingField in base al numero di giocatori
		ArrayList<JScrollPane> scrollPlayingField = new ArrayList<JScrollPane>();
		ArrayList<PlayingField> playingField = new ArrayList<PlayingField>();
		for(int i=0; i<username.size(); i++) {
			playingField.add(new PlayingField());
			scrollPlayingField.add(new JScrollPane(playingField.get(i)));
			scrollPlayingField.get(i).getViewport().setMinimumSize(new Dimension(screenSize.width-330, screenSize.height-545));
			playingField.get(i).setVisible(true);
			scrollPlayingField.get(i).setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);  
			scrollPlayingField.get(i).setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
			scrollPlayingField.get(i).getHorizontalScrollBar().setMinimum(0);
			scrollPlayingField.get(i).getHorizontalScrollBar().setMaximum(10000);
			scrollPlayingField.get(i).getHorizontalScrollBar().setValue(((10000-163)/2-(screenSize.width-330-163)/2));
			scrollPlayingField.get(i).getVerticalScrollBar().setMinimum(0);
			scrollPlayingField.get(i).getVerticalScrollBar().setMaximum(5500);
			scrollPlayingField.get(i).getVerticalScrollBar().setValue((5500-113)/2-(screenSize.height-545-113)/2);
			
		}
		
		FlowLayout CPlayout=new FlowLayout();
		CPlayout.setHgap(190);
	    CPlayout.setVgap(16);
	    
		//Pannelli carte personali
		ArrayList<JPanel> cartePersonaliPanel = new ArrayList<JPanel>();
		for(int i=0; i<username.size(); i++) {
			cartePersonaliPanel.add(new JPanel());
			cartePersonaliPanel.get(i).setMinimumSize(new Dimension(screenSize.width-313,145));
			cartePersonaliPanel.get(i).setLayout(CPlayout);
			cartePersonaliPanel.get(i).setOpaque(true);
		}
      	
		JLabel[] opacoLabelCPersonali = new JLabel[16];
		for(int i=0; i<opacoLabelCPersonali.length; i++) {
			opacoLabelCPersonali[i] = new JLabel();
			opacoLabelCPersonali[i].setBackground(new Color(170, 170, 170, 80));
			opacoLabelCPersonali[i].setOpaque(true);
			opacoLabelCPersonali[i].setPreferredSize(new Dimension(163, 113));
			opacoLabelCPersonali[i].setVisible(true);
		}
		
    	//needed for second for cycle
	    int j=0, fine=4;
	    
		for(int i=0; i<username.size(); i++) {
			for(; j<fine; j++) {
				cartePersonaliPanel.get(i).add(opacoLabelCPersonali[j]);
			}
			j=fine;
			fine+=4;
		}
		
		for(int i=0; i<username.size(); i++) {
			GridBagConstraints gbc = new GridBagConstraints();
			gbc.gridx=0;
			gbc.gridy=0;
			contenitore.get(i).add(scrollPlayingField.get(i),gbc);
			gbc.gridx=0;
			gbc.gridy=1;
			contenitore.get(i).add(cartePersonaliPanel.get(i),gbc);
		}
		
        //finistre campo gioco giocatori
        for(int i=0; i<username.size(); i++) {
        	tabbedPane.add(username.get(i),contenitore.get(i));
        }
        
        //pannello contenente le carte
      	JPanel cartePanel=new JPanel();
      	cartePanel.setPreferredSize(new Dimension(200, 200));
      	cartePanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
      	cartePanel.setLayout(new GridLayout(2,1));
    	cartePanel.setOpaque(false);
    	
      	cartePanel.add(sottoPanel);
    	cartePanel.add(sottoPanel2);
		
		
		//contenitore carte e username
        JPanel contenitoreUC=new JPanel();
        contenitoreUC.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        contenitoreUC.setLayout(new BorderLayout());
        contenitoreUC.setOpaque(false);
        contenitoreUC.setVisible(true);
        
        //pannello contenente nomi utente
        UserPanel userPanel = new UserPanel(username, userColor);
        
        contenitoreUC.add(userPanel,BorderLayout.WEST);
        contenitoreUC.add(cartePanel,BorderLayout.CENTER);
        
        
        ScoreTrack scoreTrackPane = new ScoreTrack(userColor);
        
        //test
        //scoreTrackPane.movePawn(1, 15);
        
        //test
       /* ArrayList<String> str = new ArrayList<String>(5);
        str.add("40,40");
        str.add("39,39");
        str.add("39,41");
        str.add("41,41");
        str.add("41,39");
        ArrayList<String> str2 = new ArrayList<String>(2);
        str2.add("41,41");
        str2.add("42,42");
        ArrayList<String> str3 = new ArrayList<String>(2);
        str3.add("42,42");
        str3.add("41,43");
        str3.add("43,41");
        playingField.get(0).addLabel(str);
        playingField.get(0).addLabel(str);
        playingField.get(0).addLabel(str2);
        playingField.get(0).addLabel(str3);*/
      
			
      	//add component to window
        this.add(tabbedPane,BorderLayout.CENTER);
        this.add(contenitoreUC,BorderLayout.NORTH);
      	//frame.add(userPanel,BorderLayout.WEST);
        this.add(scoreTrackPane,BorderLayout.WEST);
      	//makes frame visible
        this.setVisible(true);				
	}
	
	private void createHashMap() {
		
		//add all card's URL to HashMap
		try {
			Scanner sc = new Scanner(new FileInputStream(new File("file/cards_URL.csv")));
	        
	        while (sc.hasNextLine()) {
	            String frase = sc.nextLine();
	            
	            String[] splittedString = frase.split(",");
	    		int id = Integer.parseInt(splittedString[0]);
	    		String url = (splittedString[1]);
	    		
	    		cardImageMap.put(id, url);
	        }
	        sc.close();
	    } 
	    catch (FileNotFoundException e) {
	        e.printStackTrace();
	    }
				
	}
	
	private void istantiateCardImage() {
		
		for(int i=0; i<cardImageMap.size(); i++) {
			cardImageArr.add(new ImageIcon(cardImageMap.get(i)));
		}
		
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

	

}
