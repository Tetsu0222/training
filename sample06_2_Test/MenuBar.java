package sample06_2_Test;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class MenuBar extends JPanel {
	private static final long serialVersionUID = 1L;
	
	//コンポーネント
	JButton homeButton;
	JLabel homeLabel;
	HomeButtonListener homeButtonListener;
	JLabel scoreLabel;
	
	//コンストラクタ
	public MenuBar() {
		//パネルサイズと貼り付け位置の設定は不要
		//自動調整
		this.setPreferredSize( new Dimension(100,40) );	//幅は自動調整されるがこちらは必要
		this.setBackground( Color.red );
		this.setLayout(null);
	}
	
	public void prepareComponents() {
		//ホームボタン
		homeButton = new JButton();
		homeButton.setBounds( 5 , 5 , 80 , 30 );
		
		//ImageIcon backIcon =  new ImageIcon( getClass().getClassLoader().getResource( "" ) );
		//homeButton.setIcon( backIcon );
		homeButton.setText("HOME");
		homeButton.setFocusable(false);
		homeButtonListener = new HomeButtonListener();
		homeButton.addActionListener(homeButtonListener);
		
		//ラベル
		homeLabel = new JLabel( "←click this button or press 'H' to home " );
		homeLabel.setBounds( 100 , 5 , 250 , 30 );
		homeLabel.setBorder( BorderFactory.createEtchedBorder( 3 , Color.black , Color.white ));
		
		scoreLabel = new JLabel();
		scoreLabel.setBounds( 600 , 5 , 150 , 30 );
		scoreLabel.setBorder( BorderFactory.createEtchedBorder( 3 , Color.black , Color.white ));
		
		//設置
		this.add(homeButton);
		this.add(homeLabel);
		this.add(scoreLabel);
		
	}
	
	
	//内部クラス
	private class HomeButtonListener implements ActionListener {
		
		@Override
		public void actionPerformed( ActionEvent e ) {
			//タイトル画面に戻る
			CatCatcher.mainWindow.setFrontScreenAndFocus( ScreenMode.TITLE );
		}
	}
	
}
