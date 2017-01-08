package mastermind;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Ellipse2D;

public class MiniPin extends GraphicPin {
	
	private int pluppID;
	
	public MiniPin(Spel spel, char color, int pluppID) {
		super(color);
		this.pluppID = pluppID;
		
		
		//klickar man här sätter man igång att huvudpluppen byts ut..
		this.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				spel.getUserBoard().bytaUt(pluppID,color);
				spel.gui.bytaUt(pluppID, color);
			}
		});
	}
	
	public void paintComponent(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;

		g2.setColor(color); // sätter färgen som initieras i constructor
		
		Ellipse2D.Double elli = new Ellipse2D.Double(100, 25, 50, 50);
		g2.fill(elli);
	}
	
}