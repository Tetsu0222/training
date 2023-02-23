package j4_01;

import java.io.Console;
import java.text.Normalizer;
import java.text.Normalizer.Form;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class InspectionConsole {

	
	String msg;
	Console con = null;
	
	InspectionConsole(){
		con = System.console();
	}
	
	String inspectionID() {
		while( true ) {
			msg = con.readLine( "ID : " );
			msg = Normalizer.normalize(msg, Form.NFKC);
			Pattern pattern = Pattern.compile("[<>]");
			Matcher matcher = pattern.matcher(msg);
			
				if( matcher.find() ) {
					System.out.println("入力値が正しくありません。");
					System.out.println("もう一度入力してください");
				}else{
					break;
				}		
		}
		return msg;
	}
	
	String inspectionPass() {
		
		msg = null;
		
		while( true ) {
			msg = con.readLine( "Pass : " );
			msg = Normalizer.normalize(msg, Form.NFKC);
			Pattern pattern = Pattern.compile("[<>]");
			Matcher matcher = pattern.matcher(msg);
			
				if( matcher.find() ) {
					System.out.println("入力値が正しくありません。");
					System.out.println("もう一度入力してください");
				}else{
					break;
				}		
		}
		return msg;
	}
	
	
	String inspectionNo() {
		
		msg = null;
		
		while( true ) {
			msg = con.readLine( "検索したい番号を入力してください " );
			msg = Normalizer.normalize(msg, Form.NFKC);
			Pattern pattern = Pattern.compile("^[0-9]{3}-[0-9]{4}$");
			Matcher matcher = pattern.matcher(msg);
			
				if( matcher.find() ) {
					System.out.println("入力値が正しくありません。");
					System.out.println("もう一度入力してください");
				}else{
					break;
				}		
		}
		return msg;
	}
	
	boolean finish() {
		
		msg = null;
		System.out.println("続けて入力しますか？ 続行：y , 終了：n ");
		msg = con.readLine();
		
			if( msg.equals("y") ) {
				return false;
			}else{
				return true;
			}
	}
	
}