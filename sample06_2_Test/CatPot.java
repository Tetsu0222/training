package sample06_2_Test;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class CatPot extends JLabel{

	private static final long serialVersionUID = 1L;
	
	ImageIcon image;
	String str = "donabe.png";
	
	
	//コンストラクタ
	public CatPot() {

	image = new ImageIcon( getClass().getClassLoader().getResource( str ));
	this.setSize(150,150);
	this.setIcon(image);
	this.setText("DROP HERE");
	this.setHorizontalTextPosition(CENTER);
	this.setVerticalTextPosition(TOP);
	}
	
}
