package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.GameDao;
import model.GameRank;

/**
 * Servlet implementation class CodeBreakerServlet
 */
@WebServlet("/GameRuleServlet")
public class GameRuleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public GameRuleServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();
		GameRank gr = (GameRank) session.getAttribute("gr");
		String name = gr.getName();
		request.setAttribute("gr", gr);
		GameDao dao = new GameDao();
		dao.gameReset(name);
		// String name=usr.getName();
		// HttpSession session = request.getSession();
		// GameDao dao = new GameDao();
		// dao.gameReset(name);
		// int count =Integer.parseInt(request.getParameter("count"));
		// session.setAttribute("count",count);
		// for(int i= 0; i< answer.length;i++) {
		// boolean flag=false;
//			answer[i]=(int)(Math.random() * widthOfRandom + 1);
//			do {
//				flag=false;
//				for(int j = i - 1; j >= 0; j--) {
//					if(answer[i] == answer[j]) {
//						flag=true;
//						answer[i]=(int)(Math.random()*widthOfRandom + 1);
//					}
//				}
//			}while(flag ==true);
		// for(int ans : answer) {
		// System.out.println("codebreaker ans:"+ans);
		// }
		// }
//	request.setAttribute("numA",numA);
//	request.setAttribute("numB",numB);
//	request.setAttribute("numC",numC);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/gameRule.jsp");
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}
}
