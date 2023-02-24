package j4_01;

public class Sample_DTO {

	//---フィールド---
	private String userID ;
	private String Pass   ;
	private String id     ;  //ID
	private String name   ;  //名前
	private String gender ;  //性別（男：M／女：F）
	private int    age    ;  //年齢
	private String course ;  //コース

	
	//---getter/setter---
	
	////getter/setter（対象フィールド：userID）
	public String getUserID() {return userID;}
	public void setUserID(String userID) {this.userID = userID;}
	
	//getter/setter（対象フィールド：Pass）
	public String getPass() {return Pass;}
	public void setPass(String pass) {Pass = pass;}
	
	
	//getter/setter（対象フィールド：id）
	public String getId() {return id;}
	public void setId(String id) {this.id = id;}

	//getter/setter（対象フィールド：name）
	public String getName() {return name;}
	public void setName(String name) {this.name = name;}

	//getter/setter（対象フィールド：gender）
	public  String getGender() {return gender;}
	public void setGender(String gender) {this.gender = gender;}

	//getter/setter（対象フィールド：age）
	public int getAge() {return age;}
	public void setAge(int age) {this.age = age;}

	//getter/setter（対象フィールド：course）
	public String getCourse() {return course;}
	public void setCourse(String course) {this.course = course;}
}