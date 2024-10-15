package web.pages;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import web.userpage.Product;
import web.userpage.ProductDAO;

@WebServlet("/shop")
public class ShopServlet extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
    	String productNo = req.getParameter("product_no");

        ProductDAO dao = new ProductDAO();
        Product product = dao.selectOne(productNo);

        req.setCharacterEncoding("utf-8");
        req.setAttribute("product", product);

        req.getRequestDispatcher("WEB-INF/views/shop.jsp").forward(req, resp);
    }
}
