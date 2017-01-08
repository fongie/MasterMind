package mastermind;

import java.util.*;

public class Mastermind {

	public static void main(String[] args) {

		System.out.println("Välkommen till MastermindIda!");
		/*
		System.out.println("Välj svårighetsgrad: Normal, Svår, Mardröm eller TOOORMENT");
		System.out.println("Skriv 1 för normal, 2 för svår, 3 för mardröm, 4 för torment: ");
		*/
		
		//skapa nytt spel
		Spel spel = new Spel();
		
		//initialisera brädet
		spel.init();
		
		while (true) {
			//Scanner in = new Scanner(System.in);
			//in.useLocale(Locale.US);
			
			//System.out.println(spel);
			
			spel.win();

			//detta gör nu GUI när man trycker på HAR JAG RÄTT?
			//System.out.println(spel.checkStatus());
			
			//detta gör nu GUI när man trycker på en knapp
			//spel.bytaPin();
		}
	}
}
