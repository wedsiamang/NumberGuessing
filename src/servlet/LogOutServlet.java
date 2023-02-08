package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.GameDao;
import model.GameRank;

/**
 * Servlet implementation class LogOutServlet
 */
@WebServlet("/LogOutServlet")
public class LogOutServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public LogOutServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		GameRank gr = (GameRank) session.getAttribute("gr");
		String name = gr.getName();
		GameDao gDao = new GameDao();
		// １ゲームのデータの破棄
		gDao.gameReset(name);
		// ログインセッションの破棄
		session.removeAttribute("gr");
		// TOP画面へ
		response.sendRedirect("/");
	}
}
