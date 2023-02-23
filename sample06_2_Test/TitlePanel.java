package sample06_2_Test;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.Border;

//タイトルパネル用クラス
public class TitlePanel extends JPanel {
	
	
	//シリアライズナンバー
	private static final long serialVersionUID = 1L;
	
	//コーポネント
	JLabel title;
	JLabel start;
	JLabel exit;
	JLabel select;
	JLabel message;
	Menu checkMenu = Menu.START;
	Border border = BorderFactory.createLineBorder( Color.BLACK , 2 );
	MyKeyListener myKeyListener;
	
	
	//列挙型
	public enum Menu{
		START,
		EXIT,
	}
	
	
	
	//コンストラクタ
	//外部パッケージからのインスタンス化を制限
	TitlePanel() {
		
		//パネルサイズと貼り付け位置の設定は不要（CardLayoutが自動で画面サイズに調整）
		this.setLayout( null );							//レイアウトの設定
		this.setBackground( Color.cyan );				//背景の色
		
	}
	
	//コンストラクタが呼ばれた後、手動で呼び出す。
	public void prepareComponents() {
		
		//コンポーネントに関する命令
		
		//タイトルロゴ
		title = new JLabel();
		
		
		ImageIcon titleLogo = new ImageIcon( getClass().getClassLoader().getResource( "yukuefumei_pet_cat.png" ) );
		title.setIcon(titleLogo);
		title.setHorizontalAlignment( SwingConstants.CENTER );
		title.setVerticalAlignment( SwingConstants.BOTTOM );
		title.setText( "Created by TETSU" );	
		title.setHorizontalTextPosition( JLabel.CENTER );
		title.setVerticalTextPosition( SwingConstants.BOTTOM );
		title.setBounds( 90 , 0 , 600 , 350 );	
		title.setBorder( border );
		
								
		
		//選択肢
		start = new JLabel();
		start.setText("START");
		start.setFont( new Font( "MV boli" , Font.BOLD , 40 ) );
		start.setHorizontalTextPosition( JLabel.CENTER );
		start.setVerticalTextPosition( JLabel.BOTTOM );
		start.setBounds( 330 , 400 , 150 , 40 );
		start.setBorder( border );
		
		exit = new JLabel();
		exit.setText( "EXIT" );
		exit.setFont( new Font( "MV boli" , Font.BOLD , 40 ) );
		exit.setHorizontalTextPosition( JLabel.CENTER );
		exit.setVerticalTextPosition( JLabel.BOTTOM );
		exit.setBounds( 350 , 450 , 110 , 40 );
		exit.setBorder( border );
		
		//選択用アイコン
		select = new JLabel();
		
		select.setBackground(Color.BLUE);
		select.setOpaque( true );	//透明の切り替え
		select.setBounds( 280 , 400 , 40 , 40 );
		select.setBorder( border );
		
		
		//説明
		message = new JLabel();
		message.setHorizontalAlignment( SwingConstants.CENTER );
		message.setText( "選択：↑,↓    決定：SPACE");
		message.setHorizontalTextPosition( JLabel.CENTER );
		message.setVerticalTextPosition( JLabel.BOTTOM );
		message.setBounds( 249 , 517 , 300 , 30 );
		message.setBorder( border );
		
		//配置
		this.setLayout( null );
		this.add( title );
		this.add( start );
		this.add( exit );
		this.add( select );
		this.add( message );
		
		
		//リスナーの設定
		myKeyListener = new MyKeyListener( this );
		
	}
	
	//内部クラス
	private class MyKeyListener implements KeyListener{
		
		//貼り付け先を保持
		TitlePanel panel;
		
		//コンストラクタ
		MyKeyListener ( TitlePanel  p ){
			super();
			panel = p;
			panel.addKeyListener( this );
		}
		
		@Override
		public void keyTyped( KeyEvent e ) {
			
		}
		
		@Override
		public void keyReleased( KeyEvent e ) {
			
		}
		
		@Override
		public void keyPressed( KeyEvent e ) {
			
		
			switch( e.getKeyCode() ) {
			
			
				case KeyEvent.VK_DOWN:			//下を押した時の動作を制御
					if( checkMenu == Menu.START ) {
						select.setLocation( select.getX() , select.getY() + 50 );
						checkMenu = Menu.EXIT;
					}
					break;
				
				case KeyEvent.VK_UP:			//上を押した時の動作を制御
					if( checkMenu == Menu.EXIT ) {
						select.setLocation( select.getX() , select.getY() - 50 );
						checkMenu = Menu.START;
					}
					break;
			
				case KeyEvent.VK_SPACE:			//スペースキーを押した時の動作を制御
					if( checkMenu == Menu.START ) {
						//開始
						CatCatcher.mainWindow.setFrontScreenAndFocus( ScreenMode.GAME );
						
						
					}else if( checkMenu == Menu.EXIT ){
					
						//終了
					System.exit(0);
					}	
					break;
			}
		}
	}
}
