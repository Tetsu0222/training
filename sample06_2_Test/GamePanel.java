package sample06_2_Test;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JPanel;

public class GamePanel extends JPanel {
	
	//シリアライズナンバー
	private static final long serialVersionUID = 1L;
	
	int score;
	
	//レイアウト
	BorderLayout layout = new BorderLayout();
	
	//コンポーネント
	MenuBar menuBar;
	FieldPanel fieldPanel;
	
	//リスナー
	MyKeyListener myKeyListener;
	
	//コンストラクタ
	GamePanel(){
		
		this.setLayout( layout );
		this.setBackground( Color.yellow );
		
		//パネルの生成と設置
		menuBar = new MenuBar();
		fieldPanel = new FieldPanel();
		this.add( menuBar , BorderLayout.NORTH );
		this.add( fieldPanel , BorderLayout.CENTER);
	}
		
	//コンストラクタが呼ばれた後、手動で呼び出す。
	public void prepareComponents() {
		
		//コーポネントに関する命令
		menuBar.prepareComponents();
		fieldPanel.prepareComponents();
		
		//リスナーを設置
		myKeyListener = new MyKeyListener( this );
	
	}
	
	//内部クラス
	private class MyKeyListener implements KeyListener{
		
		//貼り付け先を保持
		JPanel panel;
		
		//コンストラクタ
		MyKeyListener( JPanel p ){
			super();
			panel = p;
			panel.addKeyListener(this);
		}
		
		@Override
		public void keyTyped( KeyEvent e ) {
			
		}
		
		@Override
		public void keyReleased( KeyEvent e ) {
			
		}
		
		@Override
		public void keyPressed( KeyEvent e) {
			switch( e.getKeyCode() ) {
			case KeyEvent.VK_H :
				CatCatcher.mainWindow.setFrontScreenAndFocus( ScreenMode.TITLE );
				break;
			}
		}
	}
}
