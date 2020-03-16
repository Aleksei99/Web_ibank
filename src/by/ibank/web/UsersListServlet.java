package by.ibank.web;

import by.ibank.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/users-list")
public class UsersListServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("users", UserService.getInstance().getAllUsers());
        req.getRequestDispatcher("/WEB-INF/jsp/users-list.jsp").forward(req,resp);
    }
}
