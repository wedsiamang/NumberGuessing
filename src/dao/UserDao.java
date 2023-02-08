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

import model.UserName;
	
	public class UserDao {
	
	
		ResourceBundle rb = ResourceBundle.getBundle("heroku");
//		Utility u = new Utility();
//		ResourceBundle rb = u.DbConnect();
		

		public void insertName(String createName) {

			UserName game = new UserName();
			String sql = "INSERT INTO userName (name) values(?)";
			try {
				Class.forName("org.postgresql.Driver");
			} catch (Exception e) {
				e.printStackTrace();
			}
			try (Connection conn = DriverManager.getConnection(rb.getString("jdbc_url"), rb.getString("db_user"),
					rb.getString("db_pass"));
			
					PreparedStatement st = conn.prepareStatement(sql);) {
				// st.setInt(1, id);
				st.setString(1,createName);
				
				st.executeUpdate();

				// conn.commit();
				
			} catch (SQLException e) {
				System.out.println("SQLの例外が発生しました");
				e.printStackTrace();
			} catch (MissingResourceException e) {
				e.printStackTrace();
			}
		}

		public List<UserName> nameList() {

			// conn = null;
			// st = null;
			ResultSet rs = null;

			List<UserName> nameList = new ArrayList<UserName>();
			UserName n = new UserName();
			// start、endタイム表記が出力用YYYY-MM-DD HH:MI
			String sql = "SELECT name FROM userName ";

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

					
					String name = rs.getString("name");
					
					System.out.println("daoname:" + name);
					n = new UserName(name);
					// conn.commit();
					nameList.add(n);

				}
				return nameList;
			} catch (SQLException e) {
				System.out.println("SQLの例外が発生しました");
				e.printStackTrace();
			} catch (MissingResourceException e) {
			}
			return nameList;
		}
		
		public UserName  selectName(String inputName) {

			// conn = null;
			// st = null;
			ResultSet rs = null;

		//	List<Game> gameList = new ArrayList<Game>();
			UserName n = new UserName();
			// start、endタイム表記が出力用YYYY-MM-DD HH:MI
			String sql = "SELECT* FROM userName where name=?";

			try {
				Class.forName("org.postgresql.Driver");
			} catch (Exception e) {
				e.printStackTrace();
			}
			try (Connection conn = DriverManager.getConnection(rb.getString("jdbc_url"), rb.getString("db_user"),
					rb.getString("db_pass"));
		
					PreparedStatement st = conn.prepareStatement(sql);) {

				st.setString(1, inputName);

				// properties.load(s);

				// conn.setAutoCommit(false);

				// SELECT文を実行
				rs = st.executeQuery();

				// SELECT文の結果をARRAYLIST に格納
				while (rs.next()) {

					int id = rs.getInt("id");
					String name = rs.getString("name");
					
					System.out.println("daoname:" + name);
					n = new UserName(id, name);
					// conn.commit();
			//		gameList.add(g);

				}
				return n;
			} catch (SQLException e) {
				System.out.println("SQLの例外が発生しました");
				e.printStackTrace();
			} catch (MissingResourceException e) {
			}
			return n;
		}
		
	}

