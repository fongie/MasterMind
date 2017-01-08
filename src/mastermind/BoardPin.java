package mastermind;

import java.awt.event.*;

import javax.swing.*;

	//de pins som sitter på spelbrädet
	public class BoardPin extends GraphicPin {
		
		private int place;

		
		public BoardPin(Spel spel, char color, int place) {
			super(color);
			this.locx = 75;
			this.locy = 250;
			this.place = place;
			
			//vad knappen gör
			this.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					System.out.println("HI " + color + place);
					spel.gui.bytaPin(place);
					}
				});
			}
	}