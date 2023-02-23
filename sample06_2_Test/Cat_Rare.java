package sample06_2_Test;

import javax.swing.ImageIcon;


public class Cat_Rare extends Animal {

	
	private static final long serialVersionUID = 1L;
	
	//設定
	protected void prepareImageAndScoreAndVoice() {
		super.image = new ImageIcon( getClass().getClassLoader().getResource( "cat_fish_run.png" )).getImage();
		super.score = 15;
		super.voiceKey = "ニャー";
	}

}

