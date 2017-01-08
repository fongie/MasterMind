package mastermind;

import javax.swing.*;


import java.awt.*;
import java.awt.event.*;


// TODO checkStatus i GUI ska ha kolla win() och om man vinner gör rolig vinstgrej
//just nu kommer det inte ens nån text när checkstatus går vidare
public class MMGui extends Spel {
	
	private Spel spel;
	
	//main frame and container
	private JFrame window;
	private JPanel container;
	
	//paneler för layout i container
	private JPanel centerPanel;
	private JPanel northPanel;
	private JPanel southPanel;
	
	//paneler för brädplupparna
	private JPanel plupp1;
	private JPanel plupp2;
	private JPanel plupp3;
	private JPanel plupp4;
	private JPanel plupp5;
	
	// textdelen med status
	private JLabel statusText;
	
	// knappar
	private JButton testBtn;

	
	//constructor
	public MMGui(Spel spel)	{
		
	//länka spelet med GUIt så det kan ändras härifrån
	this.spel = spel;
	
		
	window = new JFrame();
	window.setSize(1200, 600);
	window.setTitle("MasterMindIDA");
	window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	
	//container för allting som ska till framet sen
	container = new JPanel();
	container.setLayout(new BorderLayout());

	// denna har boxlayout för att plupparna ska hamna bredvid varandra. plupp1-5 sätts in här
	//brädlayout
	centerPanel = new JPanel();
	centerPanel.setLayout(new BoxLayout(centerPanel, BoxLayout.X_AXIS));

	//plupp1 = new JPanel();
	//plupp1.setLayout(new BoxLayout(plupp1, BoxLayout.Y_AXIS));
	plupp1 = new JPanel(new BorderLayout());
	plupp2 = new JPanel(new BorderLayout());
	plupp3 = new JPanel(new BorderLayout());
	plupp4 = new JPanel(new BorderLayout());
	plupp5 = new JPanel(new BorderLayout());
		
	centerPanel.add(plupp1, BorderLayout.CENTER);
	centerPanel.add(plupp2, BorderLayout.CENTER);
	centerPanel.add(plupp3, BorderLayout.CENTER);
	centerPanel.add(plupp4, BorderLayout.CENTER);
	centerPanel.add(plupp5, BorderLayout.CENTER);
	
	container.add(centerPanel, BorderLayout.CENTER);
	
	//textruta
	northPanel = new JPanel();
	statusText = new JLabel("<html><body><p style='font-size:50px;'>Hej Ida!</p></body></html>");
	northPanel.add(statusText);
	container.add(northPanel, BorderLayout.NORTH);
	
	//testknapp
	southPanel = new JPanel();
	testBtn = new JButton("<html><body><p style ='font-size:" + Constants.buttonTextSize + "'>HAR JAG RÄTT?");
	testBtn.addActionListener(new ActionListener()
	{
		public void actionPerformed(ActionEvent e) {
			spel.checkStatus();
		}
	}
	);
	southPanel.add(testBtn, BorderLayout.CENTER);
	container.add(southPanel, BorderLayout.SOUTH);
	
	//sätt stora containern till framet
	window.add(container);
	}
	
	//uppdaterar bilden - finns bättre sätt?
	public void drawGui() {
		window.setVisible(true);
	}
	
	//sätter ut texten om hur många som är rätt osv
	public void checkStatus(String string) {
		spel.win();
		String html = "<html><body><p style='font-size:" + Constants.statusSize + "'>";
		statusText.setText(html + string);
	}
	
	public void win() {
		System.out.println("woopwoop");
		String html = "<html><body><p style='font-size:" + Constants.statusSize + "'>";
		statusText.setText(html + "GRATTIS");
		
	}
	
	//generera en rad med minipins i alla färger att klicka på
	public JPanel miniRad(int pluppID) {
		
		JPanel rad = new JPanel();
		rad.setLayout(new BoxLayout(rad, BoxLayout.Y_AXIS));
		//rad.setLayout(new FlowLayout());
		
		MiniPin svart = new MiniPin(this.spel, 's', pluppID);
		MiniPin bla = new MiniPin(this.spel, 'b', pluppID);
		MiniPin gul = new MiniPin(this.spel, 'g', pluppID);
		MiniPin red = new MiniPin(this.spel, 'r', pluppID);
		
		int w = 800;
		int h = 100;
		svart.setMaximumSize(new Dimension(w,h));
		bla.setMaximumSize(new Dimension(w,h));
		gul.setMaximumSize(new Dimension(w,h));
		red.setMaximumSize(new Dimension(w,h));
		
		rad.add(svart);
		rad.add(bla);
		rad.add(gul);
		rad.add(red);
		
		return rad;
	}
	
	public void bytaPin(int place) {
		switch (place) {
		case 1:
			plupp1.removeAll();
			plupp1.add(miniRad(1), BorderLayout.CENTER);
			break;
		case 2:
			plupp2.removeAll();
			plupp2.add(miniRad(2), BorderLayout.CENTER);
			break;
		case 3:
			plupp3.removeAll();
			plupp3.add(miniRad(3), BorderLayout.CENTER);
			break;
		case 4:
			plupp4.removeAll();
			plupp4.add(miniRad(4), BorderLayout.CENTER);
			break;
		case 5:
			plupp5.removeAll();
			plupp5.add(miniRad(5), BorderLayout.CENTER);
			break;
		}
		drawGui();
		
	}
	
	//byt ut vad en panel (plupp) visar. tar input ifrån Spel.Board.bytaUt().
	public void bytaUt(int plupp, char color) {
		switch (plupp) {
		case 1: 
			plupp1.removeAll();
			plupp1.add(new BoardPin(spel, color, 1), BorderLayout.CENTER);
			break;
		case 2: 
			plupp2.removeAll();
			plupp2.add(new BoardPin(spel, color, 2), BorderLayout.CENTER);
			break;
		case 3: 
			plupp3.removeAll();
			plupp3.add(new BoardPin(spel, color, 3), BorderLayout.CENTER);
			break;
		case 4: 
			plupp4.removeAll();
			plupp4.add(new BoardPin(spel, color, 4), BorderLayout.CENTER);
			break;
		case 5: 
			plupp5.removeAll();
			plupp5.add(new BoardPin(spel, color, 5), BorderLayout.CENTER);
			break;
		}
		drawGui();
	}
	
}
