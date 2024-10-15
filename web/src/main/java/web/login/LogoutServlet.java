package web.login;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.websocket.Session;


@WebServlet("/logout")
public class LogoutServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String type = req.getParameter("type");
		
		HttpSession session = req.getSession();
		
		if (type.equals("user")) {
			session.removeAttribute("currentUser");
		} else if (type.equals("admin")) {
			session.removeAttribute("currentAdmin");
		}
		
		resp.sendRedirect(req.getContextPath() +"/main");
	}
}
