package mastermind;

import javax.swing.SwingUtilities;

public class Mastermind {

	public static void main(String[] args) {

		//System.out.println("Välkommen till MastermindIda!");
		//skapa nytt spel
		
		Spel spel = new Spel();
		
		SwingUtilities.invokeLater(spel);
		
		
	}
}
