package sample06_2_Test;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;

import javax.swing.JLabel;
import javax.swing.Timer;

public abstract class Animal extends JLabel{

	private static final long serialVersionUID = 1L;
	
	//フィールド
	Image image;
	int score;
	String voiceKey;
	Timer timer = null;
	int escapeTime = 500;
	
	//座標と速度
	int x;
	int y;
	int xVelocity;
	int yVelocity;
	
	//コンストラクタ
	public Animal() {
		x = new java.util.Random().nextInt( 680 );
		y = new java.util.Random().nextInt( 300 );
		do {
			xVelocity = -5 + new java.util.Random().nextInt( 10 );
			yVelocity = -5 + new java.util.Random().nextInt( 10 );
		}while( xVelocity == 0 || yVelocity == 0 );
		this.prepareImageAndScoreAndVoice();
		this.setBounds( x , y , image.getWidth(null) , image.getHeight(null) );
	}
	
	//子クラスで必ず設定
	protected abstract void prepareImageAndScoreAndVoice();
	
	//画像の描画
	public void paint( Graphics g ) {
		super.paint(g);
		Graphics2D g2D = (Graphics2D) g;
		if( xVelocity >= 0 ) {
			g2D.drawImage( image , 0 , 0 , image.getWidth(null) , image.getHeight(null) , null );
		}else {
			g2D.drawImage( image , image.getWidth(null) , 0 , -image.getHeight(null) , image.getWidth(null) , null );
		}
	}
	
	
	
}
