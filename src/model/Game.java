package model;

import java.io.Serializable;

public class Game implements Serializable {

	private int id;
	private int count;
	private int numA;
	private int numB;
	private int numC;
	private int one;
	private int two;
	private int three;
	private int hit;
	private int blow;
	private String name;
	
	public Game() {
		
	}
	public Game(int count) {
		this.count=count;
			
		}
	public Game( int id,int numA,int numB,int numC) {
		
			this.id=id;	
			this.numA=numA;
			this.numB=numB;
			this.numC=numC;
					
		}
	
	public Game(int id,int count, int numA,int numB,int numC, int one,int two,int three,int hit,int blow,String name) {
		
		this.id=id;
		this.count=count;
		this.numA=numA;
		this.numB=numB;
		this.numC=numC;
		this.one=one;
		this.two=two;
		this.three=three;
		this.hit=hit;
		this.blow=blow;
		this.name=name;
		
	}
	public int getId() {return id;}
	public int getCount() {return count;}
	public int getNumA() {return numA;}
	public int getNumB() {return numB;}
	public int getNumC() {return numC;}
	public int getOne() {return one;}
	public int getTwo() {return two;}
	public int getThree() {return three;}
	public int getHit() {return hit;}
	public int getBlow() {return blow;}
	public String getName() {return name;}
	
	public void setCount(int count) {this.count=count;}
	public void setOne(int one) {this.one=one;}
	public void setTwo(int two) {this.two=two;}
	public void setThree(int three) {this.three=three;}
	public void setNumA(int numA) {this.numA=numA;}
	public void setNumB(int numB) {this.numB=numB;}
	public void setNumC(int numC) {this.numC=numC;}
	public void setHit(int hit) {this.hit=hit;}
	public void setBlow(int blow) {this.blow=blow;}
}
