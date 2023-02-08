package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.GameDao;
import dao.GameRankDao;
import model.Game;
import model.GameRank;

/**
 * Servlet implementation class GameServlet
 */
@WebServlet("/GameServlet")
public class GameServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public GameServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();
		GameRank gr = (GameRank) session.getAttribute("gr");
		String name = gr.getName();
		String ran2num6 = request.getParameter("ran2num6");
		String ran3num3 = request.getParameter("ran3num3");
		String ran3num6 = request.getParameter("ran3num6");
		String ran3num9 = request.getParameter("ran3num9");
		int id = 0;
		// id=Integer.parseInt(request.getParameter("id"));
		System.out.println("servletid:" + id);
		int count = 0;
		// count = (int) session.getAttribute("count");
		int hit = 0;
		int blow = 0;
		int one = Integer.parseInt(request.getParameter("one"));
		int two = Integer.parseInt(request.getParameter("two"));
		int three = 0;
		int win = 0;
		int point = 0;
		int nowPoint = 0;
		GameRankDao grDao = new GameRankDao();
		GameRank myRank = grDao.selectGameRank(name);
		win = myRank.getWin();
		point = myRank.getPoint();

		GameDao dao = new GameDao();
		Game nowCount = dao.selectCount(name);
		count = nowCount.getCount();
		int[] input = { one, two, three }; // 入力した数字が入る
		if (ran2num6 != null) {
			int answerLength = 2;
			int[] ranNum = (int[]) session.getAttribute("random");
			session.setAttribute("ranNum", ranNum);
			// System.out.println("servletcount:" + count);
			System.out.println("gameservlet:inp:" + input[0] + input[1]);
			System.out.println("gameservlet:ans:" + ranNum[0] + ranNum[1]);
			int numA = ranNum[0];
			int numB = ranNum[1];
			// int numC = ranNum[2];
			// コンピュータと入力値の完全一致
			if (numA == one) {
				hit++;
			}
			if (numB == two) {
				hit++;
			}
			if (numB == one) {
				blow++;
			}
			if (numA == two) {
				blow++;
			}
			count++;
			// Game g = new Game();
			dao.insert_gameRan2(count, numA, numB, one, two, hit, blow, name);
			List<Game> gameList = dao.gameList(name);
			request.setAttribute("gameList", gameList);
			System.out.println("gameservletcount:" + count);
			request.setAttribute("count", count);
			if (hit == answerLength) {
				Game ans = dao.selectGameList(count, name);
				request.setAttribute("ans", ans);
				request.setAttribute("ran2num6", ran2num6);
				if (count <= 5) {
					win++;
					point += 2;
					nowPoint += 2;
					grDao.updateGameRankWin(win, point, name);
				} else {
					point += 1;
					nowPoint += 1;
					grDao.updateGameRankWin(win, point, name);
				}
				request.setAttribute("count", count);
				request.setAttribute("nowPoint", nowPoint);
				List<GameRank> gameRankList = grDao.gameRankList();
				request.setAttribute("gameRankList", gameRankList);
				RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/gameClear.jsp");
				dispatcher.forward(request, response);
			} else {
				request.setAttribute("ran2num6", ran2num6);
				RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/gameRetry.jsp");
				dispatcher.forward(request, response);
			}
		}
		if (ran3num3 != null) {
			int answerLength = 3;
			three = Integer.parseInt(request.getParameter("three"));
			int[] ranNum = (int[]) session.getAttribute("random");
			session.setAttribute("ranNum", ranNum);
			// System.out.println("servletcount:" + count);
			System.out.println("gameservlet:inp:" + input[0] + input[1] + input[2]);
			System.out.println("gameservlet:ans:" + ranNum[0] + ranNum[1] + ranNum[2]);
			int numA = ranNum[0];
			int numB = ranNum[1];
			int numC = ranNum[2];
			// コンピュータと入力値の完全一致
			if (numA == one) {
				hit++;
			}
			if (numB == two) {
				hit++;
			}
			if (numC == three) {
				hit++;
			}
			if (numB == one) {
				blow++;
			}
			if (numC == one) {
				blow++;
			}
			if (numA == two) {
				blow++;
			}
			if (numC == two) {
				blow++;
			}
			if (numA == three) {
				blow++;
			}
			if (numB == three) {
				blow++;
			}
			count++;
			dao.insert_gameRan3(count, numA, numB, numC, one, two, three, hit, blow, name);
			List<Game> gameList = dao.gameList(name);
			request.setAttribute("gameList", gameList);
			System.out.println("gameservletcount:" + count);
			if (hit == answerLength) {
				Game ans = dao.selectGameList(count, name);
				request.setAttribute("ans", ans);
				request.setAttribute("run3num3", ran3num3);
				// 正解した時のイベント表示
				if (count <= 5) {
					win++;
					point += 2;
					nowPoint += 2;
					grDao.updateGameRankWin(win, point, name);
				} else {
					point += 1;
					nowPoint += 1;
					grDao.updateGameRankWin(win, point, name);
				}
				request.setAttribute("count", count);
				request.setAttribute("nowPoint", nowPoint);
				List<GameRank> gameRankList = grDao.gameRankList();
				request.setAttribute("gameRankList", gameRankList);
				RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/gameClear.jsp");
				dispatcher.forward(request, response);
			} else {
				request.setAttribute("count", count);
				request.setAttribute("run3num3", ran3num3);
				RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/gameRetry.jsp");
				dispatcher.forward(request, response);
			}
		} else if (ran3num6 != null) {
			int answerLength = 3;
			three = Integer.parseInt(request.getParameter("three"));
			int[] ranNum = (int[]) session.getAttribute("random");
			session.setAttribute("ranNum", ranNum);
			// System.out.println("servletcount:" + count);
			System.out.println("gameservlet:inp:" + input[0] + input[1] + input[2]);
			System.out.println("gameservlet:ans:" + ranNum[0] + ranNum[1] + ranNum[2]);
			int numA = ranNum[0];
			int numB = ranNum[1];
			int numC = ranNum[2];
			// コンピュータと入力値の完全一致
			if (numA == one) {
				hit++;
			}
			if (numB == two) {
				hit++;
			}
			if (numC == three) {
				hit++;
			}
			if (numB == one) {
				blow++;
			}
			if (numC == one) {
				blow++;
			}
			if (numA == two) {
				blow++;
			}
			if (numC == two) {
				blow++;
			}
			if (numA == three) {
				blow++;
			}
			if (numB == three) {
				blow++;
			}
			count++;
			dao.insert_gameRan3(count, numA, numB, numC, one, two, three, hit, blow, name);
			List<Game> gameList = dao.gameList(name);
			request.setAttribute("gameList", gameList);
			// session.setAttribute("count", count);
			System.out.println("gameservletcount:" + count);
			if (hit == answerLength) {
				Game ans = dao.selectGameList(count, name);
				request.setAttribute("ans", ans);
				request.setAttribute("ran3num6", ran3num6);
				if (count <= 5) {
					win++;
					point += 3;
					nowPoint += 3;
					grDao.updateGameRankWin(win, point, name);
				} else {
					point += 1;
					nowPoint += 1;
					grDao.updateGameRankWin(win, point, name);
				}
				request.setAttribute("count", count);
				request.setAttribute("nowPoint", nowPoint);
				List<GameRank> gameRankList = grDao.gameRankList();
				request.setAttribute("gameRankList", gameRankList);
				RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/gameClear.jsp");
				dispatcher.forward(request, response);

			} else {
				request.setAttribute("count", count);
				request.setAttribute("ran3num6", ran3num6);
				RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/gameRetry.jsp");
				dispatcher.forward(request, response);
			}
		} else if (ran3num9 != null) {
			int answerLength = 3;
			three = Integer.parseInt(request.getParameter("three"));
			int[] ranNum = (int[]) session.getAttribute("random");
			session.setAttribute("ranNum", ranNum);
			// System.out.println("servletcount:" + count);
			System.out.println("gameservlet:inp:" + input[0] + input[1] + input[2]);
			System.out.println("gameservlet:ans:" + ranNum[0] + ranNum[1] + ranNum[2]);
			int numA = ranNum[0];
			int numB = ranNum[1];
			int numC = ranNum[2];
			// コンピュータと入力値の完全一致
			if (numA == one) {
				hit++;
			}
			if (numB == two) {
				hit++;
			}
			if (numC == three) {
				hit++;
			}
			if (numB == one) {
				blow++;
			}
			if (numC == one) {
				blow++;
			}
			if (numA == two) {
				blow++;
			}
			if (numC == two) {
				blow++;
			}
			if (numA == three) {
				blow++;
			}
			if (numB == three) {
				blow++;
			}
			count++;
			dao.insert_gameRan3(count, numA, numB, numC, one, two, three, hit, blow, name);
			List<Game> gameList = dao.gameList(name);
			request.setAttribute("gameList", gameList);
			// request.setAttribute("count",count);
			System.out.println("gameservletcount:" + count);
			if (hit == answerLength) {
				Game ans = dao.selectGameList(count, name);
				request.setAttribute("ans", ans);
				request.setAttribute("ran3num9", ran3num9);
				// 正解した時のイベント表示
				if (count <= 5) {
					win++;
					point += 4;
					nowPoint += 4;
					grDao.updateGameRankWin(win, point, name);
				} else {
					point += 1;
					nowPoint += 1;
					grDao.updateGameRankWin(win, point, name);
				}
				request.setAttribute("count", count);
				request.setAttribute("nowPoint", nowPoint);
				List<GameRank> gameRankList = grDao.gameRankList();
				request.setAttribute("gameRankList", gameRankList);
				RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/gameClear.jsp");
				dispatcher.forward(request, response);
			} else {
				request.setAttribute("count", count);
				request.setAttribute("ran3num9", ran3num9);
				RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/gameRetry.jsp");
				dispatcher.forward(request, response);
			}
		}
	}
}
