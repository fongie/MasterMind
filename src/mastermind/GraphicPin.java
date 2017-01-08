package mastermind;

import java.awt.*;
import java.awt.geom.Ellipse2D;
import javax.swing.*;
import javax.swing.border.Border;


//klass för grafiska pins. ska vara både de på brädet, de man kan välja mellan, och de som visar rätt/fel
//dessa ska vara knappar typ alltid? så vi extendar jbutton

public abstract class GraphicPin extends JButton {
	
	/**
	 * eclipse generated
	 */
	private static final long serialVersionUID = -6264678060045280488L;
	protected Color color;
	protected int locx; //x-koordinat för placering
	protected int locy; //y-koordinat för placering	

	//constructor, den ska ha en färg
	protected GraphicPin(char color) {
		
		//emptyborder..
		Border emptyBorder = BorderFactory.createEmptyBorder();
		this.setBorder(emptyBorder);
		
		// vilken färg har den?
		switch (color) {
		case 'g': this.color = Constants.YELLOW;
			break;
		case 'b': this.color = Constants.BLUE;
			break;
		case 's': this.color = Constants.BLACK;
			break;
		case 'r': this.color = Constants.RED;
			break;
		}
	}
	
	protected void paintComponent(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;
		super.paintComponent(g);
		g2.setColor(color); // sätter färgen som initieras i constructor
		Ellipse2D.Double elli = new Ellipse2D.Double(locx, locy, Constants.BOARDPINSIZE, Constants.BOARDPINSIZE);
		g2.fill(elli);
	}
	
}
