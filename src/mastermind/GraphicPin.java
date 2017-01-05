package mastermind;

import java.awt.*;
import java.awt.geom.Ellipse2D;

import javax.swing.*;


//klass för grafiska pins. ska vara både de på brädet, de man kan välja mellan, och de som visar rätt/fel
public abstract class GraphicPin extends JComponent {
	
	protected Color color;
	protected int locx; //x-koordinat för placering
	protected int locy; //y-koordinat för placering
	
	//constructor, den ska ha en färg
	public GraphicPin(char color) {
		// vilken färg har den?
		switch (color) {
		case 'g': this.color = Colors.YELLOW;
			break;
		case 'b': this.color = Colors.BLUE;
			break;
		case 's': this.color = Colors.BLACK;
			break;
		case 'r': this.color = Colors.RED;
			break;
		}
		
	}
	
	public void paintComponent(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;
		
		g2.setColor(color); // sätter färgen som initieras i constructor
		
		Ellipse2D.Double elli = new Ellipse2D.Double(locx, locy, 100, 100);
		g2.fill(elli);
	}
	
}
