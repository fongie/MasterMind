package mastermind;

import java.util.Random;

public class Spel implements Runnable {
	
	private final Random 	rand = new Random();
	private char[] 			colors;
	private int				numberofPins;
	private Board			correctBoard;
	private Board			userBoard;
	public MMGui			gui;
		
		//constructor
	public Spel() {
		
		char[] c = {'g','b','s','r'};
		colors = c;
		numberofPins = 5;
		correctBoard = new Board(numberofPins);
		userBoard = new Board(numberofPins);
	}
		
		//slumpa ut pinsen och sätt igång grafiken
	public void run() {
		
		this.gui = new MMGui(this);
		correctBoard.slumpa();		
		userBoard.slumpa();
		gui.drawGui();
	}
	
		//kolla efter vinst och stäng ner om det vanns
	public boolean win() {
		if (userBoard.equals(correctBoard)) {return true;}
		else {return false;}
	}
	
	public String checkStatus() {
		int antalRatt = 0;
		int antalFarg = 0;
		
		boolean[] indexRatt = new boolean[userBoard.length()];
		for (int x = 0; x < indexRatt.length; x++) {
			indexRatt[x] = false;
		}
		
		boolean[] indexFarg = new boolean[userBoard.length()];
		
		
		//loop hitta de som sitter helt rätt och sätt deras index till skip
		for (int i = 0; i < userBoard.length(); i++) {
			if (userBoard.getPin(i).equals(correctBoard.getPin(i))) {
				antalRatt += 1;
				indexRatt[i] = true;
			}
		}
		
		for (int s = 0; s < userBoard.length(); s++) {
			
			// om denna redan stämmer, hoppar över detta
			if (indexRatt[s]) {
				continue;
			} else {

				//skapa indexFarglistan och sätt alla till false
				for (int x = 0; x < indexFarg.length; x++) {
					indexFarg[x] = false;
				}
			
				for (int r = 0; r < userBoard.length(); r++) {
					
					if (indexRatt[r]) {
						continue;
					}
					if (indexFarg[s]) {
						continue;
					}
					
					if (correctBoard.getPin(s).equals(userBoard.getPin(r))){
						antalFarg += 1;
						indexFarg[s] = true;
					}
				}
			}
		}
		
		String str = antalRatt + " pluppar sitter helt rätt nu, medan " + 
					antalFarg + " pluppar är rätt färg men på fel ställe.";
		gui.checkStatus(str);
		return str;
	}

	// inre klass för skapade bräden
	public class Board {
		
		private Pin[]		pinlist;
		
		//constructor empty board
		public Board(int numberofPins) {
			
			Pin[] v = new Pin[numberofPins];
			this.pinlist = v;
		}
		
		public void bytaUt(int p, char color) {

			gui.bytaUt(p,color);
			Pin ny = new Pin(color);
			this.pinlist[p-1] = ny;
		}
		
		//slumpa ut pins på ett bräde, för att göra svarsbrädet t.ex
		public void slumpa() {
			
			Pin[] v = new Pin[numberofPins];
			for (int i = 0; i < v.length; i++) {
				int r = rand.nextInt(colors.length);
				char col = colors[r];
				v[i] = new Pin(col);
				gui.bytaUt((i+1), col);
			}
			this.pinlist = v;
		}
		
		public int length() {
			return pinlist.length;
		}
		
		public boolean equals(Board b) {
			for (int i = 0; i < pinlist.length; i++) {
				if (!(pinlist[i].equals(b.getPin(i)))) {
					return false;
				}
			}
			return true;
		}
		
		@Override
		public String toString() {
			String str = "";
			for (int i = 0; i < pinlist.length; i++) {
				str += pinlist[i] + " ";
			}
			return str;
		}
		
		public Pin getPin(int p) {
			return this.pinlist[p];
		}
		
	}
	
		// inre klass pins, för de pins som sitter i brädet
	public class Pin {
		
		private char color;
	
		
		//constructor for known pin
		public Pin(char color) {
			this.color = color;
		}
		
		public boolean equals(Pin q) {
			if (this.color == q.color) {
				return true;
			} else {
				return false;
			}
		}
		
		@Override
		public String toString() {
			String col = "";
			
			//TODO use colors[] and colString[] for other difficulties
			switch (color) {
			case 'g': col = "GUL";
					break;
			case 'b': col = "BLÅ";
					break;
			case 's': col = "SVART";
					break;
			case 'r': col = "RÖD";
					break;
			}
		
			return col;
		}
	}
	
	public String toString() {
		String str = "\nBrädet ser ut som följer:\n" + userBoard + "\n\n";
		
		//DEBUG
		str +="\nRätt är " + correctBoard;
		return str;
	}
	
	
	// getters
	public int getNumberofPins() {
		return this.numberofPins;
	}
	
	public Board getUserBoard() {
		return this.userBoard;
	}
	
	public Board getCorrectBoard() {
		return this.correctBoard;
	}
	
	/*
	//debug toString
	public String toString() {
		String str = "";
		
		str = difficulty + "\n" + userBoard + "\n" + correctBoard + "\n";
		
		return str;
	}*/
	
}
