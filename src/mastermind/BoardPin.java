package mastermind;

//de pins som sitter på spelbrädet
	public class BoardPin extends GraphicPin {
	
		public BoardPin(char color) {
			super(color);
			this.locx = 50;
			this.locy = 200;
			}
	}