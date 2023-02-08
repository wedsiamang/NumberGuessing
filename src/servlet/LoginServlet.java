package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.GameRankDao;
import model.GameRank;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public LoginServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		RequestDispatcher dispatcher = request.getRequestDispatcher("/index.jsp");
		dispatcher.forward(request, response);

	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		String inputName = request.getParameter("inputName");
		GameRankDao dao = new GameRankDao();
		GameRank dbName = dao.nameList(inputName);
		if (inputName.equals(dbName.getName())) {
			GameRank gr = new GameRank(inputName);
			HttpSession session = request.getSession();
			session.setAttribute("gr", gr);
			request.setAttribute("gr", gr);
			System.out.println("loginServlet dbname:" + dbName);
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/gameRule.jsp");
			dispatcher.forward(request, response);
		} else {
			RequestDispatcher dispatcher = request.getRequestDispatcher("/index.jsp");
			dispatcher.forward(request, response);
		}
	}
}