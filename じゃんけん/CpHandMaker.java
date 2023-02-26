package janken;

import java.util.Arrays;
import java.util.List;
import java.util.Random;


//コンピューターの手を設定するクラス
public final class CpHandMaker {
	
	
	//コンピューターの手のリソース
	List <String> list = Arrays.asList("グー" , "チョキ" , "パー");
	
	//乱数生成
	Random rand  = new Random()    ;
	private int CNum     = rand.nextInt(3) ;
	
	//外部パッケージからのインスタンス化を抑制
	CpHandMaker(){}
	
	
	//コンピューターの手を決定するメソッド
	public String getCpHand() {
		String CHand = list.get( CNum );
		return CHand;					       
	}
	
}
