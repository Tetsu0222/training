package janken;

import java.io.Console;
import java.io.PrintWriter;

public final class Announcer {
	
	Announcer(){}
	
	//Console con = System.console();
	//PrintWriter pw = con.writer();

	public void St() {
		System.out.println("最初は!!");
	}
	
	public void St2() {
		System.out.println("グー!");
	}
	
	public void St3() {
		System.out.println("じゃんけん・・・");
	}
	
	/*
	public String readHand() {
		
	String PHand = con.readLine();
	return PHand;
	
	}
	*/
	
	public void Result( int result , String PHand , String CpHand , Console con ) {
		
		PrintWriter pw = con.writer();
		
		//あいこの場合のアナウンス
		if( result == 0 ){
			pw.append( "あなたの手は" + PHand + '\n' + "私の手は" + CpHand + '\n' );
			pw.append( "あいこです" + '\n' );
			pw.flush();
		
		//プレイヤーの負け
		}else if( result == 1 ){
			pw.append( "あなたの手は" + PHand + '\n' + "私の手は" + CpHand + '\n' );
			pw.append( "あなたの負けです。" + '\n' );
			pw.flush();
			
		//プレイヤーの勝ち
		}else if( result == 2 ){
			pw.append( "あなたの手は" + PHand + '\n' + "私の手は" + CpHand + '\n' );
			pw.append( "あなたの勝ちです。" + '\n' );
			pw.flush();
		}
		
	}
}