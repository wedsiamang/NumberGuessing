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
import model.GameRank;

/**
 * Servlet implementation class GameClearServlet
 */
@WebServlet("/GameClearServlet")
public class GameClearServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public GameClearServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session = request.getSession();
		GameRank gr = (GameRank) session.getAttribute("gr");
		String name = gr.getName();
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/gameClear.jsp");
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();
		GameRank gr = (GameRank) session.getAttribute("gr");
		String name = gr.getName();
		String again = request.getParameter("again");
		String rank = request.getParameter("rank");
		// String name =request.getParameter("name");
		System.out.println("clearservletname:" + name);
		GameDao dao = new GameDao();
		GameRankDao grDao = new GameRankDao();
		if (again != null) {
			request.setAttribute("gr", gr);
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/gameRule.jsp");
			dispatcher.forward(request, response);
		} else if (rank != null) {
			List<GameRank> gameRankList = grDao.gameRankList();
			request.setAttribute("gameRankList", gameRankList);
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/gameRank.jsp");
			dispatcher.forward(request, response);
		}
	}
}
