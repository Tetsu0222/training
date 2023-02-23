package sample06_2_Test;

import javax.swing.ImageIcon;

public class Cat_Normal extends Animal{
	
	private static final long serialVersionUID = 1L;
	
	
	//設定
	protected void prepareImageAndScoreAndVoice() {
		super.image = new ImageIcon( getClass().getClassLoader().getResource( "run_cat_smile.png" )).getImage();
		super.score = 5;
		super.voiceKey = "ニャー";
	}

}
