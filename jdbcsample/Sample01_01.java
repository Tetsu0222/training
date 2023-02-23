package j4_01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Sample01_01 {

	public static void main(String[] args) {
		String jdbcUrl    = "jdbc:mysql://localhost/test_db?characterEncoding=UTF-8&useSSL=false";
		String userId;
		String userPass;
		String serectDDL = " SELECT id , name , gender , age , course  FROM  test_member WHERE id = ? ";
		String No;

		InspectionConsole test = new InspectionConsole();
		userId   = test.inspectionID();
		userPass = test.inspectionPass();
		
		
		try (
			Connection  con      = DriverManager.getConnection(jdbcUrl, userId, userPass);
			PreparedStatement ps = con.prepareStatement(serectDDL);
			){
				
				while( true ) {
					No = test.inspectionNo();
					ps.setString( 1 , No );
					ResultSet rs = ps.executeQuery();
			
					rs.next();
					StringBuffer rsbuf = new StringBuffer();
					for( int i = 1 ; i < 6 ; i++ ) {
						rsbuf.append( rs.getString(i) + " " );
						rsbuf.append( "," );
					}
					
					System.out.println( rsbuf.toString() );
						
						
					if( test.finish()) {
						break;
					}
					
				}
				
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
}
