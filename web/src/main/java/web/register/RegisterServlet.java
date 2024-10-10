package web.register;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import web.login.*;

@WebServlet("/register")
public class RegisterServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("WEB-INF/views/register.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		User newUser = getUserFormRequest(req);
		
		System.out.println(newUser);
		
		UserService service = new UserService();
		int result = service.userReg(newUser);
		
		
		if(result > 0) {
			System.out.println("등록완료");
			System.out.println(newUser);
			resp.sendRedirect(req.getContextPath() + "/main");
		} else {
			System.out.println("등록실패");
			req.getRequestDispatcher("WEB-INF/views/register.jsp").forward(req, resp);
		}
	}
	
	private User getUserFormRequest(HttpServletRequest req) throws IOException {
		req.setCharacterEncoding("utf-8");
		
		String id = req.getParameter("id");
		String pw = req.getParameter("pw");
		String name = req.getParameter("name");
		String ssn = req.getParameter("ssn");
		String phone = req.getParameter("phone");
		String addr = req.getParameter("addr");
		
		return new User(id, pw, name, ssn, phone, addr);
	}
}
