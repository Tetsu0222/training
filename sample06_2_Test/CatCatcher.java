package sample06_2_Test;


public class CatCatcher {

	static MainWindow mainWindow;
	
	
	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ
		
		mainWindow = new MainWindow();
		mainWindow.preparePanels();
		mainWindow.prepareComponents();
		
		
		mainWindow.setFrontScreenAndFocus(
				
				ScreenMode.TITLE
				
				);
		
		
		mainWindow.setVisible( true );
	}

}

