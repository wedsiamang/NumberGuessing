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

import model.Game;

public class GameDao {

	ResourceBundle rb = ResourceBundle.getBundle("heroku");
//	Utility u = new Utility();
//	ResourceBundle rb = u.DbConnect();

	public void gameReset(String name) {

		String sql = "Delete From game where name=?";
		try {
			Class.forName("org.postgresql.Driver");
		} catch (Exception e) {
			e.printStackTrace();
		}
		try (Connection conn = DriverManager.getConnection(rb.getString("jdbc_url"), rb.getString("db_user"),
				rb.getString("db_pass")); PreparedStatement st = conn.prepareStatement(sql);) {
			st.setString(1, name);

			st.executeUpdate();
			// conn.commit();
		} catch (SQLException e) {
			System.out.println("SQLの例外が発生しました");
			e.printStackTrace();
		} catch (MissingResourceException e) {
			e.printStackTrace();
		}
	}

	public void insert_gameRan2(int count, int numA, int numB, int one, int two,  int hit, int blow,
			String name) {

		Game game = new Game();
		String sql = "INSERT INTO game (try_count,num_a,num_b,one,two,hit,blow,name) values(?,?,?,?,?,?,?,?)";
		try {
			Class.forName("org.postgresql.Driver");
		} catch (Exception e) {
			e.printStackTrace();
		}
		try (Connection conn = DriverManager.getConnection(rb.getString("jdbc_url"), rb.getString("db_user"),
				rb.getString("db_pass"));

				PreparedStatement st = conn.prepareStatement(sql);) {
			// st.setInt(1, id);
			st.setInt(1, count);
			st.setInt(2, numA);
			st.setInt(3, numB);
			st.setInt(4, one);
			st.setInt(5, two);
			st.setInt(6, hit);
			st.setInt(7, blow);
			st.setString(8, name);
			st.executeUpdate();

			// conn.commit();
			System.out.println("first:" + one);
			System.out.println("two:" + two);
			System.out.println("hit:" + hit);
			System.out.println("blow:" + blow);
		} catch (SQLException e) {
			System.out.println("SQLの例外が発生しました");
			e.printStackTrace();
		} catch (MissingResourceException e) {
			e.printStackTrace();
		}
	}
	
	public void insert_gameRan3(int count, int numA, int numB, int numC, int one, int two, int three, int hit, int blow,
			String name) {

		Game game = new Game();
		String sql = "INSERT INTO game (try_count,num_a,num_b,num_c,one,two,three,hit,blow,name) values(?,?,?,?,?,?,?,?,?,?)";
		try {
			Class.forName("org.postgresql.Driver");
		} catch (Exception e) {
			e.printStackTrace();
		}
		try (Connection conn = DriverManager.getConnection(rb.getString("jdbc_url"), rb.getString("db_user"),
				rb.getString("db_pass"));

				PreparedStatement st = conn.prepareStatement(sql);) {
			// st.setInt(1, id);
			st.setInt(1, count);
			st.setInt(2, numA);
			st.setInt(3, numB);
			st.setInt(4, numC);
			st.setInt(5, one);
			st.setInt(6, two);
			st.setInt(7, three);
			st.setInt(8, hit);
			st.setInt(9, blow);
			st.setString(10, name);
			st.executeUpdate();

			// conn.commit();
			System.out.println("first:" + one);
			System.out.println("two:" + two);
			System.out.println("hit:" + hit);
			System.out.println("blow:" + blow);
		} catch (SQLException e) {
			System.out.println("SQLの例外が発生しました");
			e.printStackTrace();
		} catch (MissingResourceException e) {
			e.printStackTrace();
		}
	}


	public List<Game> gameList(String name) {

		// conn = null;
		// st = null;
		ResultSet rs = null;

		List<Game> gameList = new ArrayList<Game>();
		Game g = new Game();
		// start、endタイム表記が出力用YYYY-MM-DD HH:MI
		String sql = "SELECT* FROM game where name=?";

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
				int count = rs.getInt("try_count");
				int numA = rs.getInt("num_a");
				int numB = rs.getInt("num_b");
				int numC = rs.getInt("num_c");
				int one = rs.getInt("one");
				int two = rs.getInt("two");
				int three = rs.getInt("three");
				int hit = rs.getInt("hit");
				int blow = rs.getInt("blow");
				name = rs.getString("name");
				System.out.println("daocount:" + count);
				g = new Game(id, count, numA, numB, numC, one, two, three, hit, blow, name);
				// conn.commit();
				gameList.add(g);

			}
			return gameList;
		} catch (SQLException e) {
			System.out.println("SQLの例外が発生しました");
			e.printStackTrace();
		} catch (MissingResourceException e) {
		}
		return gameList;
	}

	public Game selectGameList(int count, String name) {

		// conn = null;
		// st = null;
		ResultSet rs = null;

		// List<Game> gameList = new ArrayList<Game>();
		Game g = new Game();
		// start、endタイム表記が出力用YYYY-MM-DD HH:MI
		String sql = "SELECT* FROM game where try_count=? and name=?";

		try {
			Class.forName("org.postgresql.Driver");
		} catch (Exception e) {
			e.printStackTrace();
		}
		try (Connection conn = DriverManager.getConnection(rb.getString("jdbc_url"), rb.getString("db_user"),
				rb.getString("db_pass"));

				PreparedStatement st = conn.prepareStatement(sql);) {

			st.setInt(1, count);
			st.setString(2, name);

			// properties.load(s);

			// conn.setAutoCommit(false);

			// SELECT文を実行
			rs = st.executeQuery();

			// SELECT文の結果をARRAYLIST に格納
			while (rs.next()) {

				int id = rs.getInt("id");
				count = rs.getInt("try_count");
				int numA = rs.getInt("num_a");
				int numB = rs.getInt("num_b");
				int numC = rs.getInt("num_c");
				int one = rs.getInt("one");
				int two = rs.getInt("two");
				int three = rs.getInt("three");
				int hit = rs.getInt("hit");
				int blow = rs.getInt("blow");
				name = rs.getString("name");
				System.out.println("daoselectcount:" + count);
				g = new Game(id, count, numA, numB, numC, one, two, three, hit, blow, name);
				// conn.commit();
				// gameList.add(g);

			}
			return g;
		} catch (SQLException e) {
			System.out.println("SQLの例外が発生しました");
			e.printStackTrace();
		} catch (MissingResourceException e) {
		}
		return g;
	}
	public Game selectCount( String name) {

		// conn = null;
		// st = null;
		ResultSet rs = null;

		// List<Game> gameList = new ArrayList<Game>();
		Game g = new Game();
		// start、endタイム表記が出力用YYYY-MM-DD HH:MI
		String sql = "SELECT try_count FROM game where name=?";

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

				int count = rs.getInt("try_count");
				
				System.out.println("daoselectcount:" + count);
				g = new Game(count);
				// conn.commit();
				// gameList.add(g);

			}
			return g;
		} catch (SQLException e) {
			System.out.println("SQLの例外が発生しました");
			e.printStackTrace();
		} catch (MissingResourceException e) {
		}
		return g;
	}


}
