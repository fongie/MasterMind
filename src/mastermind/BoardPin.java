package mastermind;

import java.awt.event.*;

	//de pins som sitter på spelbrädet
	public class BoardPin extends GraphicPin {
		
		/**
		 * eclipse generated
		 */
		private static final long serialVersionUID = -461087310816774901L;

		public BoardPin(Spel spel, char color, int place) {
			super(color);
			this.locx = 75;
			this.locy = 250;
			
			//vad knappen gör
			this.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					//debug
					//System.out.println("HI " + color + place);
					spel.gui.bytaPin(place);
					}
				});
			}
	}