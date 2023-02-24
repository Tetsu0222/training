package j4_01;

import java.util.List;

public class Sample_BusinessLogic {

	
	InspectionConsole inspection = null;
	List<String> list = null;
	
	//コンソールからの入力と正規表現と検証
	public void input() {
		inspection = new InspectionConsole();
	}
	
	//ユーザーの入力値を取得
	public void getConsle() {
		list = inspection.getList();
	}


	//DBとのアクセス制御
	public void extractAll () {
		
		//DAOをインスタンス化
		Sample_DAO dao = new Sample_DAO( list );
		
		//DAOの結果取得
		List<Sample_DTO> extractedDtoList = dao.selectMemberInfoAll();
		
		
		if(extractedDtoList != null){
			for(int i = 0 ; i < extractedDtoList.size() ; i++){
				StringBuffer rsbuf = new StringBuffer();
				rsbuf.append(extractedDtoList.get(i).getId());
				rsbuf.append(",");
				rsbuf.append(extractedDtoList.get(i).getName());
				rsbuf.append(",");
				rsbuf.append(extractedDtoList.get(i).getGender());
				rsbuf.append(",");
				rsbuf.append(extractedDtoList.get(i).getAge());
				rsbuf.append(",");
				rsbuf.append(extractedDtoList.get(i).getCourse());

				//1レコード分のデータを表示
				System.out.println(rsbuf.toString());

			}
			
		} else {
			System.out.println("該当のユーザー情報を取得できませんでした" ) ;
		}
	}
}