package mastermind;

import javax.swing.*;
import java.awt.*;


//TODO 5/1/2017
//text eller bilder som visar hur många som är rätt, rätt färg fel plats, och fel
//göra det möjligt att med musklick ändra plupparna
//lägg till knapp för "testa rätt/fel"


public class MMGui {
	
	private JFrame window;
	private JPanel container;
	
	//paneler för brädplupparna
	private JPanel plupp1;
	private JPanel plupp2;
	private JPanel plupp3;
	private JPanel plupp4;
	private JPanel plupp5;

	
	//constructor
	public MMGui()	{
		
	window = new JFrame();
	window.setSize(1200, 600);
	window.setTitle("MasterMindIDA");
	window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	
	// denna har boxlayout för att plupparna ska hamna bredvid varandra. plupp1-5 sätts in här
	container = new JPanel();
	container.setLayout(new BoxLayout(container, BoxLayout.X_AXIS));
	
	//brädlayout
	plupp1 = new JPanel(new BorderLayout());
	plupp2 = new JPanel(new BorderLayout());
	plupp3 = new JPanel(new BorderLayout());
	plupp4 = new JPanel(new BorderLayout());
	plupp5 = new JPanel(new BorderLayout());
	
	container.add(plupp1);
	container.add(plupp2);
	container.add(plupp3);
	container.add(plupp4);
	container.add(plupp5);
	//sätt stora containern till framet
	window.add(container);
	}
	
	//uppdaterar bilden - finns bättre sätt?
	public void drawGui() {
		//window.add(container);
		window.setVisible(true);
	}
	
	//byt ut vad en panel (plupp) visar. tar input ifrån Spel.Board.bytaUt().
	public void bytaUt(int plupp, char color) {
		switch (plupp) {
		case 1: 
			plupp1.removeAll();
			plupp1.add(new BoardPin(color));
			break;
		case 2: 
			plupp2.removeAll();
			plupp2.add(new BoardPin(color));
			break;
		case 3: 
			plupp3.removeAll();
			plupp3.add(new BoardPin(color));
			break;
		case 4: 
			plupp4.removeAll();
			plupp4.add(new BoardPin(color));
			break;
		case 5: 
			plupp5.removeAll();
			plupp5.add(new BoardPin(color));
			break;
		}
		
		drawGui();
	}
	
}
