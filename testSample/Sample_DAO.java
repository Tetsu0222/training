package testSample;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public final class Sample_DAO {

	private final String jdbcUrl    = "jdbc:mysql://localhost/test_db?characterEncoding=UTF-8&useSSL=false";
	private String userId =
	private String userPass =
	private String serectDDL = " SELECT id , name , gender , age , course  FROM  test_member WHERE id = ? ";
	private String id;
	
	
	//インスタンス化と同時に各種定数を設定
	Sample_DAO(){

	}

	//SQLへのアクセスと結果取得
	public boolean selectMemberInfoAll( Sample_DTO sdto ){

		try (Connection        connection  = DriverManager.getConnection(jdbcUrl, userId, userPass);
			 PreparedStatement ps          = connection.prepareStatement(serectDDL);
			){
				id = sdto.getId();
				ps.setString( 1 , id );
				ResultSet rs = ps.executeQuery();
				
				while( rs.next() ){
					sdto.setId    ( rs.getString( "id"     ) );
					sdto.setName  ( rs.getString( "name"   ) );
					sdto.setGender( rs.getString( "gender" ) );
					sdto.setAge   ( rs.getInt   ( "age"    ) );
					sdto.setCourse( rs.getString( "course" ) );
				}
			
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

}