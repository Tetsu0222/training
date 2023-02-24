package j4_01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public final class Sample_DAO {

	private final String jdbcUrl    = "jdbc:mysql://localhost/test_db?characterEncoding=UTF-8&useSSL=false";
	private String userId;
	private String userPass;
	private String serectDDL = " SELECT id , name , gender , age , course  FROM  test_member WHERE id = ? ";
	private String id;
	Sample_DTO dto = null;
	List <String> list = null;
	List<Sample_DTO> dtoList = null;
	
	
	//インスタンス化と同時に各種定数を設定
	Sample_DAO( List <String> list ){
		this.list     = list;
		this.userId   = list.get(0);
		this.userPass = list.get(1);
		dto           = new Sample_DTO();
	}

	//SQLへのアクセスと結果取得
	public List< Sample_DTO > selectMemberInfoAll(){

		dtoList = new ArrayList< Sample_DTO >();
		dto = new Sample_DTO();
		
		try (Connection        connection  = DriverManager.getConnection(jdbcUrl, userId, userPass);
			 PreparedStatement ps          = connection.prepareStatement(serectDDL);
			){

			for( int i = 2 ; i < list.size() ; i++ ) {
				id = list.get(i);
				ps.setString( 1 , id );
				ResultSet rs = ps.executeQuery();
				
				while( rs.next() ){
					dto.setId    ( rs.getString( "id"     ) );
					dto.setName  ( rs.getString( "name"   ) );
					dto.setGender( rs.getString( "gender" ) );
					dto.setAge   ( rs.getInt   ( "age"    ) );
					dto.setCourse( rs.getString( "course" ) );
					dtoList.add(dto);
				}
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return dtoList;
		
	}
}