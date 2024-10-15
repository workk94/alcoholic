package web.pages;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import web.model.PageHandler;
import web.model.ShopService;

@WebServlet("/main")
public class MainServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    	int currentPage = 1;
        if (req.getParameter("p") != null) {
            currentPage = Integer.parseInt(req.getParameter("p"));
        }

        ShopService service = new ShopService();
        int pageSize = 6;  // 페이지당 6개의 상품
        int totRecords = service.getTotal();

        ArrayList<ProductDTO> list = service.getProducts(currentPage, pageSize);
        PageHandler handler = new PageHandler(currentPage, totRecords);
        
        req.setAttribute("list", list);
        req.setAttribute("paging", handler);
        req.getRequestDispatcher("WEB-INF/views/main.jsp").forward(req, resp);
    }
}

