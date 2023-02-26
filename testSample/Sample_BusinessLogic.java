package testSample;

public class Sample_BusinessLogic {

	//DBとのアクセス制御
	public boolean executeInsert ( Sample_DTO sdto ) {
		
		//DAOをインスタンス化
		Sample_DAO dao = new Sample_DAO();
		
		//DAOの結果取得
		boolean su = dao.selectMemberInfoAll( sdto );
		
		
		if( su ){

		}else{
			return false;
		}
		return true;
	}
}