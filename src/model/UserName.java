package model;

import java.io.Serializable;

public class UserName implements Serializable{

		private int id;
		private String name;
		private int age;
		private String introduction;
	
	public UserName() {}
	public UserName(String name) {}
	public UserName(int id,String name) {}
	public UserName(int id,String name,int age,String introduction) {
		this.id=id;
		this.name=name;;
		this.age=age;
		this.introduction=introduction;	
	}
	public int getId() {return id;}
	public String getName() {return name;}
	public int getAge() {return age;}
	public String getIntroduction() {return introduction;}
	public void setName(String name) {this.name=name;}
}





	


