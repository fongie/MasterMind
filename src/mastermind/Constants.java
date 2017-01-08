package mastermind;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.ImageIcon;

// alla färger för mastermindspelet, används i andra GUI klasser
public class Constants {
	
	//j-storlekar
	public static final Dimension WINDOW = new Dimension(1200,800);
	public static final Dimension MINIPIN_BOXSIZE = new Dimension(800,170);
	
	//pluppfärger
	public static final Color RED = new Color(178,0,0);
	public static final Color BLACK = new Color(0,0,0);
	public static final Color YELLOW = new Color(230,204,81);
	public static final Color BLUE = new Color(0,0,153);
	
	//textconstants
	public static final int STATUSSIZE = 25;
	public static final int BUTTONTEXTSIZE = 35;
	public static final String BUTTONTEXT ="<html><body><p style ='font-size:" + BUTTONTEXTSIZE + "'>HAR JAG RÄTT?";
	public static final String GREETTEXT ="<html><body><p style='font-size:50px;'>Hej Ida!</p></body></html>";
	public static final String GRATSTEXT = "<html><body><p style='font-size:" + STATUSSIZE + "'> GRATTIS DET VAR RÄTT, HIGH PAW!!";
	
	//pluppstorlekar
	public static final double BOARDPINSIZE = 100;
	public static final double MINIPINSIZE = 70;
	
	//images
	public static final ImageIcon WINIMAGE = new ImageIcon("img/win.jpeg", "cat!");
	
}
