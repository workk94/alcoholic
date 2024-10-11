package web.userpage;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/editPersonalInfo")
public class EditPersonalInfo extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession(false);
        
        // 세션에서 로그인된 사용자 정보 확인
//        if (session != null && session.getAttribute("loginUser") != null) {
            // 로그인된 사용자가 있으면 개인정보 수정 페이지로 이동
            req.getRequestDispatcher("/WEB-INF/views/editPersonalInfo.jsp").forward(req, resp);
//        } else {
            // 세션에 로그인 정보가 없으면 로그인 페이지로 리다이렉트
//            resp.sendRedirect("/web/login");
//        }
    }
}
