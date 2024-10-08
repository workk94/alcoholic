package web.login;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/login")
public class LoginServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("WEB-INF/views/login.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		
		String user_id = req.getParameter("user_id");
		String user_pw = req.getParameter("user_pw");
		
		UserService service = new UserService();
		User user = service.userLogin(user_id, user_pw);
		
		if(user != null) {
			HttpSession session = req.getSession();
			session.setAttribute("currentUser", user);
			resp.sendRedirect(req.getContextPath() + "/main");
		} else {
			System.out.println("로그인 실패");
			req.getRequestDispatcher("WEB-INF/views/login.jsp").forward(req, resp);
		}	
	}
}
