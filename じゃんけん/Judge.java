package janken;


//じゃんけんの判定を行うクラス
 final class Judge {
	

	//外部パッケージからのインスタンス化を抑制
	Judge(){}
	
	
	public int judgeHand( int p , int c ) {
		int PNum = p;
		int CNum = c;
	
		int result = ( PNum - CNum + 3 ) % 3;
		
		return result;
	}
	
}
