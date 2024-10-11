package web.userpage;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/mypagemain")
public class MyPageMain extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 로그인 여부를 확인
       HttpSession session = req.getSession();
        if (session.getAttribute("currentUser") == null) {
           // 로그인 상태가 아니면 로그인 페이지로 이동
           resp.sendRedirect("/web/login");
          
        } else {
        	
        	req.getRequestDispatcher("/WEB-INF/views/mypagemain.jsp").forward(req, resp);
        }
        
//         MyPage 화면을 표시 (mypagemain.jsp로 이동)
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        String pw = req.getParameter("pw");
        String ssn = req.getParameter("ssn");
        String phone = req.getParameter("phone");
        String addr = req.getParameter("addr");

        MyPageService mypageservice = new MyPageService();
        mypageservice.modifyMember(id, pw, ssn, phone, addr);

        // 수정 후 다시 MyPage 화면으로 리다이렉트
        resp.sendRedirect("/web/mypagemain");
    }
}
