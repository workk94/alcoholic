package web.register;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;

import web.model.UserService;

@WebServlet("/idcheck")
public class IdCheckServlet extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id = req.getParameter("id");

        UserService service = new UserService();
        boolean result = service.isUserExist(id);

        // JSON 객체 생성
        JSONObject jsonResponse = new JSONObject();
        jsonResponse.put("result", result);  
        
        // JSON 반환
        resp.setContentType("application/json");
        resp.setCharacterEncoding("UTF-8");
        resp.getWriter().write(jsonResponse.toString()); 
	}
}
