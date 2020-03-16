package by.ibank.web;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/main_paige")
public class MainPaigeServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("user",req.getSession().getAttribute("currentUser"));
        req.getRequestDispatcher("/WEB-INF/jsp/main_paige.jsp").forward(req,resp);
    }
}
