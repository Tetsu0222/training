package test;

import java.util.stream.Stream;

public class Sample_DTO {
	
	private int    id     ;  //会員番号
	private String name   ;  //名前
	private String gender ;  //性別
	private int    age    ;  //年齢
	private String course ;  //コース
	private boolean success;

	
	//コンストラクタ
	Sample_DTO( int id ){
		this.id = id;
	}
	
	
	//ゲッターとセッター
	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getGender() {
		return gender;
	}


	public void setGender(String gender) {
		this.gender = gender;
	}


	public int getAge() {
		return age;
	}


	public void setAge(int age) {
		this.age = age;
	}


	public String getCourse() {
		return course;
	}


	public void setCourse(String course) {
		this.course = course;
	}
	
	public boolean isSuccess() {
		return success;
	}


	public void setSuccess(boolean success) {
		this.success = success;
	}
	
	
	//データの加工
	public String Result() {
	StringBuffer buf = new StringBuffer();
	Stream.of( "id" , "name" , "gender" , "age" , "course")
	.peek( s -> buf.append(s) )
	.forEach( s -> buf.append(","));
	return buf.toString();
	
	}

}
