package sample06_2_Test;

import javax.swing.ImageIcon;

public class Cat_Dog extends Animal{
	
	private static final long serialVersionUID = 1L;
	
	
	//設定
	protected void prepareImageAndScoreAndVoice() {
		super.image = new ImageIcon( getClass().getClassLoader().getResource( "run_dog.png" )).getImage();
		super.score = 200;
		super.voiceKey = "ワン";
		super.escapeTime = 100;
	}

}