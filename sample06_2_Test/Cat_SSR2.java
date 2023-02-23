package sample06_2_Test;

import javax.swing.ImageIcon;

public class Cat_SSR2 extends Animal{

	private static final long serialVersionUID = 1L;
	
	
	//コンストラクタのオーバーライド
	Cat_SSR2(){
		super();
		super.xVelocity = 10;
		super.yVelocity = 10;
	}
	
	//設定
	protected void prepareImageAndScoreAndVoice() {
		super.image = new ImageIcon( getClass().getClassLoader().getResource( "animal_basilisk.png" )).getImage();
		super.score = 100;
		super.voiceKey = "うわー";
		super.escapeTime = 100;
	}

}
