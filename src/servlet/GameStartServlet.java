package servlet;

import java.io.IOException;
import java.util.Random;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.GameDao;
import dao.GameRankDao;
import model.GameRank;

/**
 * Servlet implementation class GameStartServlet
 */
@WebServlet("/GameStartServlet")
public class GameStartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public GameStartServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();
		// GameRank gr = (GameRank) session.getAttribute("gr");
		String name = (String) session.getAttribute("gr");
		// String name=gr.getName();
		int count = 0;
		int numberOfAnswers = 3;
//		Audio audio = new Audio();
		// try{
		// audio.audio();
		// } catch (InterruptedException e) {
		// e.printStackTrace();
		// }
		// ランダム変数の生成
		Random r = new Random();
		int numA = 0;
		int numB = 0;
		int numC = 0;
		int[] numsA = { 1, 2, 3 };
		int[] numsB = { 1, 2, 3 };
		int[] numsC = { 1, 2, 3 };
		// Game g = new Game();
		// GameDao dao = new GameDao();
		// dao.insert_random(numA, numB, numC);
		int[] random = { numA, numB, numC };
		// numA,numB,numCが重複がある限りランダム生成を繰り返す
		while (random[0] == random[1] || random[0] == random[2] || random[1] == random[2]) {
			numA = numsA[r.nextInt(3)];
			numB = numsB[r.nextInt(3)];
			numC = numsC[r.nextInt(3)];
			random[0] = numA;
			random[1] = numB;
			random[2] = numC;
		}
		;

		session.setAttribute("random", random);
		session.setAttribute("count", count);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/gameStart.jsp");
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		GameRank gr = (GameRank) session.getAttribute("gr");
		String name = gr.getName();
		String ran2num6 = request.getParameter("ran2num6");
		String ran3num3 = request.getParameter("ran3num3");
		String ran3num6 = request.getParameter("ran3num6");
		String ran3num9 = request.getParameter("ran3num9");
		int count = 0;
		int numA = 0;
		int numB = 0;
		int numC = 0;
		int gameCount = 0;
		GameDao dao = new GameDao();
		dao.gameReset(name);
		GameRankDao grDao = new GameRankDao();
//		Audio audio = new Audio();
//		try{
//		 audio.audioGame();
//		 } catch (InterruptedException e) {
//		 e.printStackTrace();
//		 }
		if (ran2num6 != null) {
			// ランダム変数の生成
			Random r = new Random();
			int[] numsA = { 1, 2, 3, 4, 5, 6 };
			int[] numsB = { 1, 2, 3, 4, 5, 6 };
			int[] random = { numA, numB };
			while (random[0] == random[1]) {
				random[0] = numsA[r.nextInt(6)];
				random[1] = numsB[r.nextInt(6)];
			}
			;
			session.setAttribute("random", random);
			session.setAttribute("count", count);
			session.setAttribute("ran2num6", ran2num6);
			GameRank myRank = grDao.selectGameRank(name);
			gameCount = myRank.getGameCount();
			gameCount++;
			System.out.println("start;" + gameCount);
			grDao.updateGameCount(gameCount, name);
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/gameStart.jsp");
			dispatcher.forward(request, response);
		} else if (ran3num3 != null) {
//ランダム変数の生成
			Random r = new Random();
			int[] numsA = { 1, 2, 3 };
			int[] numsB = { 1, 2, 3 };
			int[] numsC = { 1, 2, 3 };
			int[] random = { numA, numB, numC };
			while (random[0] == random[1] || random[0] == random[2] || random[1] == random[2]) {
				numA = numsA[r.nextInt(3)];
				numB = numsB[r.nextInt(3)];
				numC = numsC[r.nextInt(3)];
				random[0] = numA;
				random[1] = numB;
				random[2] = numC;
			}
			;
			session.setAttribute("random", random);
			session.setAttribute("count", count);
			session.setAttribute("ran3num3", ran3num3);
			GameRank myRank = grDao.selectGameRank(name);
			gameCount = myRank.getGameCount();
			gameCount++;
			System.out.println("start;" + gameCount);
			grDao.updateGameCount(gameCount, name);
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/gameStart.jsp");
			dispatcher.forward(request, response);
		} else if (ran3num6 != null) {
			// ランダム変数の生成
			Random r = new Random();
			int[] numsA = { 1, 2, 3, 4, 5, 6 };
			int[] numsB = { 1, 2, 3, 4, 5, 6 };
			int[] numsC = { 1, 2, 3, 4, 5, 6 };
			int[] random = { numA, numB, numC };
			while (random[0] == random[1] || random[0] == random[2] || random[1] == random[2]) {
				numA = numsA[r.nextInt(6)];
				numB = numsB[r.nextInt(6)];
				numC = numsC[r.nextInt(6)];
				random[0] = numA;
				random[1] = numB;
				random[2] = numC;
			}
			;
			session.setAttribute("random", random);
			session.setAttribute("count", count);
			session.setAttribute("ran3num6", ran3num6);
			GameRank myRank = grDao.selectGameRank(name);
			gameCount = myRank.getGameCount();
			gameCount++;
			System.out.println("start;" + gameCount);
			grDao.updateGameCount(gameCount, name);
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/gameStart.jsp");
			dispatcher.forward(request, response);
		} else if (ran3num9 != null) {
			// ランダム変数の生成
			Random r = new Random();
			int[] numsA = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
			int[] numsB = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
			int[] numsC = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
			int[] random = { numA, numB, numC };
			while (random[0] == random[1] || random[0] == random[2] || random[1] == random[2]) {
				numA = numsA[r.nextInt(9)];
				numB = numsB[r.nextInt(9)];
				numC = numsC[r.nextInt(9)];
				random[0] = numA;
				random[1] = numB;
				random[2] = numC;
			}
			;
			session.setAttribute("random", random);
			session.setAttribute("count", count);
			session.setAttribute("ran3num9", ran3num9);
			GameRank myRank = grDao.selectGameRank(name);
			gameCount = myRank.getGameCount();
			gameCount++;
			System.out.println("start;" + gameCount);
			grDao.updateGameCount(gameCount, name);
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/gameStart.jsp");
			dispatcher.forward(request, response);
		}
	}
}