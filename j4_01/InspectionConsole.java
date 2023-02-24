package j4_01;

import java.io.Console;
import java.text.Normalizer;
import java.text.Normalizer.Form;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class InspectionConsole {

	//---フィールド---
	private String no;
	private String id;
	private String pass;
	private String yn;
	Console con = null;
	List<String> list = new ArrayList<>();
	
	//インスタンス化と同時に各種メソット起動
	InspectionConsole(){
		con = System.console();
		this.inspectionID();
		this.inspectionPass();
		this.inspectionNo();
	}
	
	//IDの入力と検証
	private void inspectionID() {
		while( true ) {
			id = con.readLine( "ID : " );
			id = Normalizer.normalize(id, Form.NFKC);
			Pattern pattern = Pattern.compile("[<>]");
			Matcher matcher = pattern.matcher(id);
			
				if( matcher.find() ) {
					id = null;
					System.out.println("入力値が正しくありません。");
					System.out.println("もう一度入力してください");
				}else{
					break;
				}
			list.add(id);
		}
	}
	
	//パスワードの入力と検証
	private void inspectionPass() {
		while( true ) {
			pass = con.readLine( "Pass : " );
			pass = Normalizer.normalize(pass, Form.NFKC);
			Pattern pattern = Pattern.compile("[<>]");
			Matcher matcher = pattern.matcher(pass);
			
				if( matcher.find() ) {
					pass = null;
					System.out.println("入力値が正しくありません。");
					System.out.println("もう一度入力してください");
				}else{
					break;
				}
		list.add(pass);		
		}
		
	}

	//検索するIDを検証とリスト化
	private void inspectionNo() {
		while( true ) {
			
			//入力と検証
			no = con.readLine( "検索したい番号を入力してください " );
			no = Normalizer.normalize(no, Form.NFKC);
			Pattern pattern = Pattern.compile("^[0-9]{3}-[0-9]{4}$");
			Matcher matcher = pattern.matcher(no);
				if( matcher.find() ) {
					System.out.println("入力値が正しくありません。");
					System.out.println("もう一度入力してください");
				}else{
					list.add(no);
					
					//入力を続けるか確認
					System.out.println("続けて入力しますか？ 続行：y , 検索開始：s ");
					yn = con.readLine();
						if( yn.equals("y") ) {
							}else if( yn.equals("s") ){
								System.out.println("検索を開始します。");
								break;
							}else {
								System.out.println("入力に誤りがあります");
							}
				}				
		}
	}
	
	//ゲッター
	List<String> getList(){
		return list;
	}
	
}