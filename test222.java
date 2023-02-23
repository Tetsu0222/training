package janken;

import java.io.Console;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class test222 {

	public static void main(String[] args) {
	
	
	
		//ScheduledExecutorService service = null;
		CpHandMaker cphand = new CpHandMaker();
		Judge judge = new Judge();
		Announcer announcer = new Announcer();
		Console con = System.console();
		
		Runnable task1 = () -> announcer.St();
		Runnable task2 = () -> announcer.St2();
		Runnable task3 = () -> announcer.St3();
		
		ScheduledExecutorService service = null;
		
		try {
			service = Executors.newSingleThreadScheduledExecutor();
			
			
			service.schedule( task1 , 0 , TimeUnit.SECONDS);
			service.schedule( task2 , 1 , TimeUnit.SECONDS);
			service.schedule( task3 , 1 , TimeUnit.SECONDS);
		
		}catch( Exception e ) {
			e.printStackTrace();
			
		}finally {
			service.shutdown();
		}
		

		
		while( true ) {
			List <String> list = Arrays.asList( "グー" , "チョキ" , "パー" );
			
			
			//プレイヤーの手を取得
			//String PHand = announcer.readHand();
			String PHand = con.readLine();
			int PNum = list.indexOf(PHand);
					
			//プレイヤーの手をチェック
			if( PNum == -1 ) {
				System.out.println("入力が不正です。");
				continue;
			}
					
			//コンピューターの手を取得
			String CpHand = cphand.getCpHand();
			int CNum = list.indexOf(CpHand);
					
			int result = judge.judgeHand( PNum , CNum );
					
			announcer.Result(result, PHand ,CpHand , con );
					
					
			if(result != 0) {
				break;
			}
		
		}
		
	}
}
	
