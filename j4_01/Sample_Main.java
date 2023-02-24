package j4_01;


public class Sample_Main {

	public static void main(String[] args) {
		
		//ビジネスロジックを生成
		Sample_BusinessLogic bl = new Sample_BusinessLogic();
		
		//ユーザー入力開始
		bl.input();
		
		//ユーザー入力結果を取得（標準化、検査後）
		bl.getConsle();
		
		//SQLアクセス開始と結果表示
		bl.extractAll();
	}

}
