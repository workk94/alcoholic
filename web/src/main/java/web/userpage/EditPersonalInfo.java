package web.userpage;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import web.model.User;
import web.model.UserDAO;

@WebServlet("/editPersonalInfo")
public class EditPersonalInfo extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 세션에서 로그인된 사용자 확인
        HttpSession session = req.getSession(false);
        
        if (session != null && session.getAttribute("currentUser") != null) {
            // 사용자가 로그인되어 있으면 수정 페이지로 이동
            req.getRequestDispatcher("/WEB-INF/views/editPersonalInfo.jsp").forward(req, resp);
        } else {
            // 세션에 로그인 정보가 없으면 로그인 페이지로 리다이렉트
            resp.sendRedirect("/web/login");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession( );

        
        
        //
        if  ( session.getAttribute("currentUser") != null) {
            User currentUser = (User) session.getAttribute("currentUser");
            
            // 폼에서 입력된 수정된 개인정보를 가져옴
            String newPassword = req.getParameter("pw");
            String newPhone = req.getParameter("phone");
            String newAddr = req.getParameter("addr");
            
            String id = req.getParameter("id");
            System.out.println(newPassword);
            System.out.println(newPhone);
            System.out.println(newAddr);
            
            
         
            
            // DAO를 사용하여 데이터베이스 업데이트
            UserDAO dao = new UserDAO();
            dao.update(currentUser);
            
            
            
            
            // User 객체의 정보 수정
            currentUser.setPw(newPassword);
            currentUser.setPhone(newPhone);
            currentUser.setAddr(newAddr);
            currentUser.setId(id);
            
            
            
            
            // 업데이트가 완료된 후 마이페이지로 리다이렉트
            resp.sendRedirect("/web/mypagemain");
        } else {
            resp.sendRedirect("/web/login");
        }
    }
}

