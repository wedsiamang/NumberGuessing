package model;

import java.io.Serializable;

public class GameRank implements Serializable   {
	
	private int id;
	private int gameCount;
	private String name;
	private int win;
	private int lose;
	private int rate;
	private int point;
	private int rankNum;
		
	public GameRank() {
		
	}
public GameRank(String name) {
	this.name=name;
		
	}
	public GameRank(int id,int gameCount, String name,int win,int rate,int point,int rankNum) {	
		this.id=id;
		this.gameCount=gameCount;
		this.name=name;
		this.win=win;
		this.rate=rate;
		this.point=point;
		this.rankNum=rankNum;
	}
	public int getId() {return id;}
	public int getGameCount() {return gameCount;}
	public String getName() {return name;}
	public int getWin() {return win;}
	public int getRate() {return rate;}
	public int getPoint() {return point;}
	public int getRankNum() {return rankNum;}
	public void setGameCount(int gameCount) {this.gameCount=gameCount;}
	public void setName(String name) {this.name=name;}
	public void setWin(int win) {this.win=win;}
	public void setRate(int rate) {this.rate=rate;}
	public void setPoint(int point) {this.point=point;}
}