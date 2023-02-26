package test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public final class Sample_DAO {

	private final String jdbcUrl    = "jdbc:mysql://localhost/test_db?characterEncoding=UTF-8&useSSL=false";
	private String userId           = ""
	private String userPass         = "";
	private String serectDDL        = " SELECT id , name , gender , age , course  FROM  test_member WHERE id = ? ";
	private int id;
	boolean result;
	
	//インスタンス化と同時に各種定数を設定
	Sample_DAO(){

	}

	//SQLへのアクセスと結果取得
	public void selectMember( Sample_DTO dto ){

		try (Connection        connection  = DriverManager.getConnection(jdbcUrl, userId, userPass);
			 PreparedStatement ps          = connection.prepareStatement(serectDDL);
			){
				id = dto.getId();
				ps.setInt( 1 , id );
				dto.setSuccess( ps.execute() );
				ResultSet rs = ps.executeQuery();
				
				while( rs.next() ){
					dto.setId    ( rs.getInt   ( "id"     ) );
					dto.setName  ( rs.getString( "name"   ) );
					dto.setGender( rs.getString( "gender" ) );
					dto.setAge   ( rs.getInt   ( "age"    ) );
					dto.setCourse( rs.getString( "course" ) );
				}
			
		} catch (SQLException e) {
			e.printStackTrace();
			dto.setSuccess(false);	
		}
	}
}