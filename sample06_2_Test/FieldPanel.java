package sample06_2_Test;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.IntStream;

import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.Timer;




public class FieldPanel extends JPanel {

	private static final long serialVersionUID = 1L;
	
	JLayeredPane layeredPane;
	JLabel gameLabel;
	CatPot catPot;
	
	Set <Animal> set = new HashSet<Animal>();
	
	//コンストラクタ
	public FieldPanel() {
		//サイズは自動調整
		this.setBackground(Color.orange);
		this.setLayout(null);
	}
	
	//猫のオブジェクト生成
	public void createCat( int i ) {
		
		if( i < 7) {
			set.add( new Cat_Normal() );
			
		}else if( i == 7) {
			set.add( new Cat_SSR2() );
			
		}else if( i > 7 && i < 12) {
			set.add( new Cat_Rare() );
			
		}else if( i == 12 ) {
			set.add( new Cat_SSR() );
			
		}else if( i > 12 ) {
			set.add( new Cat_Dog() );
		}
	}
	
	//コンストラクタが呼ばれた後、手動で呼び出す。
	public void prepareComponents() {
		
		layeredPane = new JLayeredPane();
		
		//猫のオブジェクト生成ロジック
		IntStream.iterate( new java.util.Random().nextInt(15) , n -> new java.util.Random().nextInt(15) )   //0から15のいずれかを要素として持つストリームを生成
		.limit( 5 + new java.util.Random().nextInt(4) )														 //最低要素数5個に0～4の個数を追加した猫オブジェクトを生成
		.forEach( s -> this.createCat( s ) );																 //要素の数値に応じた種類の猫オブジェクトを生成しセットへ格納
		
		
		set.stream()																						//セットから猫オブジェクトをストリーム化
		.peek( s -> this.layeredPane.add( s , JLayeredPane.DRAG_LAYER ))									//レイヤードの設定
		.forEach( s -> vitalizeCat(s) );																	//猫オブジェクトへリスナーを設定
		
		
		//レイヤードペインの追加
		layeredPane.setBounds( 0 , 0 , 150 , 100 );
		this.add( layeredPane );
		
		
		//猫鍋を配置
		catPot = new CatPot();
		catPot.setLocation( 320 , 380 );
		this.layeredPane.add( catPot , JLayeredPane.DEFAULT_LAYER );
		this.add(catPot);
	}
	
	
	//ネコにリスナーをつけてからパネルに貼るメソッド
	public void vitalizeCat( Animal c ) {
		//リスナー
		CatActionListener catActionListener = new CatActionListener (c);
		new DDListener(c);
		c.timer = new Timer( 10 , catActionListener );			//10ミリ秒毎にActionEventを発行するタイマーオブジェクトを生成
		this.add(c);
		c.timer.start();										//タイマーオブジェクトを呼び出しアクションリスナーを起動
	}
	
	
	//内部クラスでネコの動きを制御する。
	private class CatActionListener implements ActionListener{
			
		//貼り付け先を保持
		private Animal cat;
		
		public CatActionListener( Animal c ) {
			cat = c;
		}
		
		@Override
		public void actionPerformed( ActionEvent e ) {
			if( cat.x > CatCatcher.mainWindow.gamePanel.getWidth() - cat.getWidth() || cat.x < 0 ) {
				cat.xVelocity = cat.xVelocity*(-1);
			}
			cat.x = cat.x + cat.xVelocity;
		
			if( cat.y > CatCatcher.mainWindow.gamePanel.getHeight() - cat.getHeight() || cat.y < 0 ) {
				cat.yVelocity = cat.yVelocity*(-1);
			}
			cat.y = cat.y + cat.yVelocity;
			
			cat.setLocation(cat.x, cat.y);
			cat.repaint();
		}
	}				
				
			
	//内部クラスでネコの動きを制御する。
		private class DDListener extends MouseAdapter{
				
			private int dx;
			private int dy;
			private Animal cat;
			
			DDListener( Animal c ){
				cat = c;
				cat.addMouseListener(this);				//マウスのクリックの動きに反応
				cat.addMouseMotionListener(this);		//マウスの動きに反応
			}
			
			public void mousePressed( MouseEvent e) {
				//押さえたところからラベルの左腕の差を取っていく。
				dx = e.getXOnScreen() - cat.getX();
				dy = e.getYOnScreen() - cat.getY();
			}
					
			public void mouseDragged( MouseEvent e) {
				//マウスの座標からラベルの左上の座標を取得する。
				int x = e.getXOnScreen() - dx;
				int y = e.getYOnScreen() - dy;
				
				if( x < CatCatcher.mainWindow.gamePanel.getWidth() - cat.getWidth() - 5 && x > 5 ) {
					cat.x = x;
				}
				
				if( y < CatCatcher.mainWindow.gamePanel.getHeight() - cat.getHeight() - 5 && y > 5 ) {
					cat.y = y;
				}
				cat.setLocation ( cat.x , cat.y );
			}
			
			
			
			public void mouseReleased( MouseEvent e) {
				
				
				int x = e.getXOnScreen();
				int y = e.getYOnScreen();
				int px = (int)catPot.getLocationOnScreen().getX();
				int py = (int)catPot.getLocationOnScreen().getY();
				int ph = catPot.getHeight();
				int pw = catPot.getWidth();
				
				if( ( px < x) && ( x < px + pw ) && ( py < y ) && ( y < py + ph) ){
					
					//鳴き声を再生
					//MySpeaker.playSE( animal.voiceKey );
					
					//スコアの計算と不可視化処理
					CatCatcher.mainWindow.gamePanel.score += cat.score;
					String str = "SCORE:" + CatCatcher.mainWindow.gamePanel.score;
					CatCatcher.mainWindow.gamePanel.menuBar.scoreLabel.setText( str );
					cat.setVisible(false);
					
					//追加
					//generateAnimal();
					
				}else {
					cat.timer.start();
				}
				
				
				
			}
			
			public void mouseClicked( MouseEvent e ) {
		
			}
			
			
		}
}
