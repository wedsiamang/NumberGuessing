package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.GameRankDao;
import model.GameRank;

/**
 * Servlet implementation class CreateAccountServlet
 */
@WebServlet("/CreateAccountServlet")
public class CreateAccountServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public CreateAccountServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/createAccount.jsp");
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String createName = request.getParameter("createName");
		// String password = request.getParameter("password");
		String errMsg = "";
		GameRankDao dao = new GameRankDao();
		GameRank nameList = dao.nameList(createName);
		if (createName.equals(nameList.getName())) {
			errMsg += "誰かがその名前で登録しているみたい。違う名前を入れてね";
			request.setAttribute("errMsg", errMsg);
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/createAccount.jsp");
			dispatcher.forward(request, response);
		} else if (createName.equals("")) {
			errMsg += "空っぽだよ。名前を入れてね。";
			request.setAttribute("errMsg", errMsg);
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/createAccount.jsp");
			dispatcher.forward(request, response);
		} else {
			dao.insertGameName(createName);
			RequestDispatcher dispatcher = request.getRequestDispatcher("/index.jsp");
			dispatcher.forward(request, response);
		}
	}
}
