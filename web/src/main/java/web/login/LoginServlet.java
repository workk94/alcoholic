package web.login;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import web.model.User;
import web.model.UserService;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		
		//새로고침했을때 실패메시지가 다시 뜨는것을 방지
		String msg = (String) session.getAttribute("msg");

		if (msg != null) {
			req.setAttribute("msg", msg);
			session.removeAttribute("msg");
		}

		req.getRequestDispatcher("WEB-INF/views/login.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		HttpSession session = req.getSession();
		
		String user_id = req.getParameter("user_id");
		String user_pw = req.getParameter("user_pw");

		UserService service = new UserService();
		User admin = service.userLogin(user_id, user_pw);

		if (admin != null) {
			session.setAttribute("currentUser", admin);
			resp.sendRedirect(req.getContextPath() + "/main");
		} else {
			String msg = "로그인 실패";
			session.setAttribute("msg", msg);
			resp.sendRedirect(req.getContextPath() + "/login");
		}
	}
}
