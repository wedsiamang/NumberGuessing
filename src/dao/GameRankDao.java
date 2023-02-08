package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.MissingResourceException;
import java.util.ResourceBundle;

import model.GameRank;

public class GameRankDao {

	ResourceBundle rb = ResourceBundle.getBundle("heroku");
	
	public void insertGameName( String createName) {

	
		String sql = "INSERT INTO gameRank (name) values(?)";
		try {
			Class.forName("org.postgresql.Driver");
		} catch (Exception e) {
			e.printStackTrace();
		}
		try (Connection conn = DriverManager.getConnection(rb.getString("jdbc_url"), rb.getString("db_user"),
				rb.getString("db_pass"));

				PreparedStatement st = conn.prepareStatement(sql);) {
			// st.setInt(1, id);
			st.setString(1, createName);
			
			
			st.executeUpdate();

			// conn.commit();
		
		} catch (SQLException e) {
			System.out.println("SQLの例外が発生しました");
			e.printStackTrace();
		} catch (MissingResourceException e) {
			e.printStackTrace();
		}
	}
	public void updateGameCount(int gameCount,String name) {

		GameRank gameRank = new GameRank();
		String sql = "UPDATE gameRank SET gameCount=? where name=? ";

		try {
			Class.forName("org.postgresql.Driver");
		} catch (Exception e) {
			e.printStackTrace();
		}
		try (Connection conn = DriverManager.getConnection(rb.getString("jdbc_url"), rb.getString("db_user"),
				rb.getString("db_pass"));

				PreparedStatement st = conn.prepareStatement(sql);) {

			st.setInt(1, gameCount);
			st.setString(2, name);

			st.executeUpdate();

			// conn.commit();
			System.out.println("daoupdategamecount:"+gameCount);

		} catch (SQLException e) {
			System.out.println("SQLの例外が発生しました");
			e.printStackTrace();
		} catch (MissingResourceException e) {
			e.printStackTrace();
		}
	}
	public GameRank nameList(String inputName) {

		// conn = null;
		// st = null;
		ResultSet rs = null;

		//List<GameRank> nameList = new ArrayList<GameRank>();
		GameRank gr = new GameRank();
		// start、endタイム表記が出力用YYYY-MM-DD HH:MI
		String sql = "SELECT name FROM gameRank where name=?";

		try {
			Class.forName("org.postgresql.Driver");
		} catch (Exception e) {
			e.printStackTrace();
		}
		try (Connection conn = DriverManager.getConnection(rb.getString("jdbc_url"), rb.getString("db_user"),
				rb.getString("db_pass"));
	
				PreparedStatement st = conn.prepareStatement(sql);) {

			st.setString(1,inputName);

			// properties.load(s);

			// conn.setAutoCommit(false);

			// SELECT文を実行
			rs = st.executeQuery();

			// SELECT文の結果をARRAYLIST に格納
			while (rs.next()) {

				
				String name = rs.getString("name");
				
				System.out.println("daoname:" + name);
				gr = new GameRank(name);
				// conn.commit();
				

			}
			return gr;
		} catch (SQLException e) {
			System.out.println("SQLの例外が発生しました");
			e.printStackTrace();
		} catch (MissingResourceException e) {
		}
		return gr;
	}
	
	public void updateGameRankWin(int win,int point,String name) {

		GameRank gameRank = new GameRank();
		String sql = "UPDATE gameRank SET win=?,point=? where name=? ";

		try {
			Class.forName("org.postgresql.Driver");
		} catch (Exception e) {
			e.printStackTrace();
		}
		try (Connection conn = DriverManager.getConnection(rb.getString("jdbc_url"), rb.getString("db_user"),
				rb.getString("db_pass"));

				PreparedStatement st = conn.prepareStatement(sql);) {

			st.setInt(1, win);
			st.setInt(2, point);
			st.setString(3, name);

			st.executeUpdate();

			// conn.commit();
			System.out.println("win:"+win);

		} catch (SQLException e) {
			System.out.println("SQLの例外が発生しました");
			e.printStackTrace();
		} catch (MissingResourceException e) {
			e.printStackTrace();
		}
	}
	
	public List<GameRank> gameRankList() {

		// conn = null;
		// st = null;
		ResultSet rs = null;

		List<GameRank> gameRankList = new ArrayList<GameRank>();
		GameRank gr = new GameRank();
		// start、endタイム表記が出力用YYYY-MM-DD HH:MI
		String sql = "SELECT id,gameCount,name,win,rate,point,RANK() OVER(ORDER BY coalesce(point,0) DESC)rankNum FROM gameRank;";

		try {
			Class.forName("org.postgresql.Driver");
		} catch (Exception e) {
			e.printStackTrace();
		}
		try (Connection conn = DriverManager.getConnection(rb.getString("jdbc_url"), rb.getString("db_user"),
				rb.getString("db_pass"));

				PreparedStatement st = conn.prepareStatement(sql);) {

			
			// properties.load(s);

			// conn.setAutoCommit(false);

			// SELECT文を実行
			rs = st.executeQuery();

			// SELECT文の結果をARRAYLIST に格納
			while (rs.next()) {

				int id = rs.getInt("id");
				int gameCount = rs.getInt("gameCount");
				String name= rs.getString("name");
				int win = rs.getInt("win");
				
				int rate = rs.getInt("rate");
				int point = rs.getInt("point");
				int rankNum = rs.getInt("rankNum");			
				gr = new GameRank(id, gameCount, name, win, rate, point,rankNum);
				// conn.commit();
				gameRankList.add(gr);

			}
			return gameRankList;
		} catch (SQLException e) {
			System.out.println("SQLの例外が発生しました");
			e.printStackTrace();
		} catch (MissingResourceException e) {
		}
		return gameRankList;
	}
	public GameRank selectGameRank(String name) {

		// conn = null;
		// st = null;
		ResultSet rs = null;

		// List<Game> gameList = new ArrayList<Game>();
		GameRank  gr= new GameRank();
		// start、endタイム表記が出力用YYYY-MM-DD HH:MI
		String sql = "SELECT id,gameCount,name,win,rate,point,RANK() OVER(ORDER BY point DESC)rankNum FROM gameRank where name=?";

		try {
			Class.forName("org.postgresql.Driver");
		} catch (Exception e) {
			e.printStackTrace();
		}
		try (Connection conn = DriverManager.getConnection(rb.getString("jdbc_url"), rb.getString("db_user"),
				rb.getString("db_pass"));
				PreparedStatement st = conn.prepareStatement(sql);) {		
			st.setString(1, name);
			// properties.load(s);
			// conn.setAutoCommit(false);
			// SELECT文を実行
			rs = st.executeQuery();
			// SELECT文の結果をARRAYLIST に格納
			while (rs.next()) {
				int id = rs.getInt("id");
				int gameCount = rs.getInt("gameCount");
				name = rs.getString("name");
				int win = rs.getInt("win");
			//	int lose = rs.getInt("lose");
				int rate = rs.getInt("rate");
				int point = rs.getInt("point");
				int rankNum = rs.getInt("rankNum");			
				System.out.println("daocount:" + gameCount);
				gr = new GameRank(id, gameCount, name, win, rate, point,rankNum);
				// conn.commit();
				// gameList.add(g);
			}
			return gr;
		} catch (SQLException e) {
			System.out.println("SQLの例外が発生しました");
			e.printStackTrace();
		} catch (MissingResourceException e) {
		}
		return gr;
	}
}
