package test;

public class Sample_BL {
	
	Sample_DTO dto = null;
	Sample_DAO dao = null;
	
	Sample_BL( int id ){
		dto = new Sample_DTO(id);
	}
	
	public Sample_DTO select() {
		
	dao = new Sample_DAO();
	dao.selectMember(dto);
	return dto;
	}
	
}
